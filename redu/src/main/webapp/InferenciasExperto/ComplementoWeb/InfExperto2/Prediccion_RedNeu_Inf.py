"""
PROYECTO REDU - ESPE
Autor: Ponce John
Fecha: 23 de Diciembre del 2019
Inferencias del Experto
"""
#librerías
import random
from pymongo import MongoClient
import numpy
from keras.models import model_from_json


"""
Este codigo permite reutilizar el modelo de red neuronal ya antes entrenado 
ademas de distinguir si ya existe la inferencia , de lo contrario el modelo lo calcula y lo guarda 
"""


#Clase calcificacion 
class Calcificacion:
    def __init__(self,m,d,l,o):
        self.morfologia = m
        self.distribucion = d
        self.lateralidad = l
        self.otros = o
        self.porcentaje = ""
        self.birads=""
    
    def toDBCollection (self):
        return {
            "morfologia":self.morfologia,
            "distribucion":self.distribucion,
            "lateralidad": self.lateralidad,
            "otros":self.otros,
            "porcentaje":self.porcentaje,
            "birads":self.birads
        }
    def cambiar_porcentaje(self, porcentaje):
        self.porcentaje=porcentaje
    def cambiar_birads(self, birads):
        self.birads=birads

#Guarda los datos calculados en la base
def toDBCollection (morfologia,distribucion,lateralidad,otros,porcentaje,birads):
    #Conexion con la base
    Mongo_Uri ='mongodb://localhost'
    client=MongoClient(Mongo_Uri)
    db=client['Mamografia1']
    collection = db['Calcificacion']
    #Creacion de un diccionario 
    colecion= {
            "morfologia":morfologia,
            "distribucion":distribucion,
            "lateralidad": lateralidad,
            "otros":otros,
            "porcentaje":porcentaje,
            "birads":birads,
            "guardado":'Red neuronal'
        }
    #Se guarda el diccionario
    collection.insert_one(colecion)


#Busqueda en mongo si ya existe la inferencia para obtener el resulatado, o de lo contrario se utiliza el modelo
def busqueda(morfologia,distribucion,lateralidad,otros):   
    #Conexion con la base
    Mongo_Uri ='mongodb://localhost'
    client=MongoClient(Mongo_Uri)
    db=client['Mamografia1']
    collection = db['Calcificacion']
    #Cuery para buscar en la base
    myquery = { "morfologia":{"$in":[morfologia]},"distribucion":{"$in":[distribucion]},"lateralidad":{"$in":[lateralidad]},"otros":{"$in":[otros]} }
    cursor = collection.find(myquery)
    for cal in cursor:
        resultado=[cal['porcentaje'],cal['birads']]
    #Cuenta cuantos resultados encontro
    num=cursor.count()
    #Si existe resultados  devuelve la respuesta de la inferencia , pero si no calcula por el modelo de la red neuronal
    if(num!=0):
        return resultado
    else:
        #Obtiene el resultado por el modelo
        resultado=algoritmo(morfologia,distribucion,lateralidad,otros)
        #Se guarda el resultado en la base
        toDBCollection(morfologia,distribucion,"no bilateral",otros,int(resultado[0]*100),resultado[1])
        return resultado

#Sentencia Switch para obtener el numero de columna en el excel , o el numero en el array
def switch_(argumento):
    switcher = {
        #morfologia
        "cutánea": 1,
        "cutanea": 1,
        "vascular": 41,
        "palomitamaíz": 3,
        "lineal": 12,
        "redondeada": 2,
        "puntiforme": 21,
        "distrófica": 9,
        "lecheCalcio": 17,
        "sutura": 37,
        "amorfa": 0,
        "grosera": 3,
        "finas": 18,
        "linealesfinas":19,
        "linealesfinasramificadas":11,
        #distribucion
        "difusa": 48,
        "regional": 51,
        "agrupada": 45,
        "lineal": 49,
        "segmentaria": 53
    }
    return switcher.get(argumento, 100
    )
  
#Crea un vector de 1 y ceros donde el 1 representa que si tiene esa caracteristica , el cero dice que no posee esa caracterirstica
#Se hace de esta forma ya que son variables categoricas , con este vector podemos mandar al modelo y predecir el resultado
def crearVector(morfologia,distribucion,lateralidad,otros):
    #Se crea un vector lleno de ceros
    vector_datos=numpy.zeros(54)
    #Se busca si la morfologia de la inferencia coincide con los datos del dataset o excel
    for i in morfologia:
        num=switch_(i)
        #Si lo encuentra llena esa casilla con 1
        if(num<100):
            vector_datos[num]=1
    #Lo mismo se hace para distribucion
    for i in distribucion:        
        num=switch_(i)
        if(num<100):
            vector_datos[num]=1

    #No se toma en cuenta la lateralidad debido a que en el dataset no existe ese dato , ni tampoco los otras caracteristicas
    return vector_datos



# Carga el modelo de la red neuronal
def algoritmo(morfologia,distribucion,lateralidad,otros):
    json_file = open('model.json', 'r')
    loaded_model_json = json_file.read()
    json_file.close()
    loaded_model = model_from_json(loaded_model_json)
    # cargar pesos al nuevo modelo
    loaded_model.load_weights("model.h5")
    print("Cargado modelo desde disco.")
    
    # Compilar modelo cargado y listo para usar.
    loaded_model.compile(loss='mean_squared_error', optimizer='adam', metrics=['binary_accuracy'])
    #Crea el vector de 1 y ceros
    vector_datos=crearVector(morfologia,distribucion,lateralidad,otros)
    #Se rediseña el vector columna a fila
    vector_datos=vector_datos.reshape(1,54)
    #Se predice
    prediccion = loaded_model.predict(vector_datos)
    #La probabilidad calculada se lo cambia por la categorizacion birads
    birads=clasificarporbirads(prediccion)
    #Se guarda la prediccion y el resultado por categorizacion birads
    resultado=[prediccion,birads]
    return resultado


#Se clasefica la probabilidad de malignidad de acuerdo a la categoría Birads
def clasificarporbirads(valor):

    if valor<=0.009:
        return 'birads2'
    else:
        if valor<=0.02:
            return 'birads3'
        else:
            if valor<=0.1:
                return'birads4a'
            else:
                if valor<=0.5:
                    return'birads4b'
                else:
                    if valor<=0.95:
                        return 'birads4c'
                    else:
                        if int(valor)<=1:
                            return 'birads5'
                

#Sentencia switch que permite diferenciar si una caracteristica pertenece a la morfologia ,distribucion o lateralidad
def switch_diferenciador(argumento):
    switcher = {
        #morfologia
        "cutánea": 1,
        "cutanea": 1,
        "vascular": 1,
        "palomitamaíz": 1,
        "lineal": 1,
        "redondeada": 1,
        "puntiforme": 1,
        "distrófica": 1,
        "lecheCalcio": 1,
        "sutura": 1,
        "amorfa": 1,
        "grosera": 1,
        "finas": 1,
        "linealesfinas":1,
        "linealesfinasramificada":1,
        #distribucion
        "difusa": 2,
        "regional": 2,
        "agrupada": 2,
        "lineal": 2,
        "segmentaria": 2,
        #Lateralidad
        "Bilateral":3,
        "bilateral":3
    }
    return switcher.get(argumento, 100
    )

#Crea un array  con las caracteristicas de morfologia , desitribucion , lateralidad debidamente agrupadas cada una en un vector
#En otra palabras agrupa las caracteristicas por morfologia , desitribucion o lateralidad
def dividir(lista):
    morfologia=[]
    distribucion=[]
    lateralidad="no bilateral"
    for i in lista:
        num=switch_diferenciador(i)
        if(num==1):
            morfologia.append(i)
        if(num==2):
            distribucion.append(i)
        if(num==3):
            lateralidad=i 
    #Si no tiene caracteristicas de morfologia o distribucion , se debe llenar el dato con un vacio("")
    if len(morfologia)==0:
        morfologia=""
    if len(distribucion)==0:
        distribucion=""
    
    return [morfologia,distribucion,lateralidad]

    
