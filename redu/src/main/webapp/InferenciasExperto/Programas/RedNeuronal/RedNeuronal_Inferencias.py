"""
PROYECTO REDU - ESPE
Autor: Ponce John
Fecha: 23 de Diciembre del 2019
Inferencias del Experto
"""
#librerías
import random
from pymongo import MongoClient
from keras.models import Sequential
from keras.layers import Dense
import csv
import numpy

#------PROCESO----
#obtener un dato                              h
#jalar datos de mongo
#comparar datos con los de mongo 
#correr red neuronal
#dar respuesta
#almacenar respuesta


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

def toDBCollection (morfologia,distribucion,lateralidad,otros,porcentaje,birads):
    Mongo_Uri ='mongodb://localhost'
    client=MongoClient(Mongo_Uri)
    db=client['Mamografia1']
    collection = db['Calcificacion']
    colecion= {
            "morfologia":morfologia,
            "distribucion":distribucion,
            "lateralidad": lateralidad,
            "otros":otros,
            "porcentaje":porcentaje,
            "birads":birads,
            "guardado":'Red neuronal'
        }
    collection.insert_one(colecion)


#Busqueda en mongo si ya existe el dato, o de lo contrario , se entrenaria
def busqueda(morfologia,distribucion,lateralidad,otros):   
    Mongo_Uri ='mongodb://localhost'
    client=MongoClient(Mongo_Uri)
    db=client['Mamografia1']
    collection = db['Calcificacion']
    myquery = { "morfologia":{"$in":[morfologia]},"distribucion":{"$in":[distribucion]},"lateralidad":{"$in":[lateralidad]},"otros":{"$in":[otros]} }
    cursor = collection.find(myquery)
    for cal in cursor:
        resultado=[cal['porcentaje'],cal['birads']]

    num=cursor.count()
    if(num!=0):
        return resultado
    else:
        resultado=algoritmo(morfologia,distribucion,lateralidad,otros)
        toDBCollection(morfologia,distribucion,"no Bilateral",otros,int(resultado[0]*100),resultado[1])
        return resultado

def switch_(argumento):
    switcher = {
        #morfologia
        "cutánea": 1,
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
        #distribucion
        "difusa": 48,
        "regional": 51,
        "agrupada": 45,
        "lineal": 49,
        "segmentaria": 53
    }
    return switcher.get(argumento, 100
    )
  
def obtenerDatoDelDataset(morfologia,distribucion,lateralidad,otros):
    vector_datos=numpy.zeros(54)
    num=switch_(morfologia)
    if(num<100):
        vector_datos[num]=1
    num=switch_(distribucion)
    if(num<100):
        vector_datos[num]=1
    return vector_datos



#
def algoritmo(morfologia,distribucion,lateralidad,otros):
    dataset = numpy.loadtxt("file.csv", delimiter=",")
    X = dataset[:,2:]
    Y = dataset[:,1]
    # crea el modelo
    model = Sequential()
    model.add(Dense(30, input_dim=54, activation='relu'))
    model.add(Dense(50, activation='relu'))
    model.add(Dense(1, activation='sigmoid'))
    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
    model.fit(X, Y, epochs=100, batch_size=10)
    vector_datos=obtenerDatoDelDataset(morfologia,distribucion,lateralidad,otros)
    vector_datos=vector_datos.reshape(1,54)
    prediccion = model.predict(vector_datos)
    birads=clasificarporbirads(prediccion)
    resultado=[prediccion,birads]
    return resultado


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
                
#dato=Calcificacion("sutura","","","")
resultado=busqueda("sutura","difusa","","")

print(resultado)