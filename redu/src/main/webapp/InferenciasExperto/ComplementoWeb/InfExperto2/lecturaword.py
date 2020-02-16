"""
PROYECTO REDU - ESPE
Autor: Ponce John
Fecha: 23 de Diciembre del 2019
Inferencias del Experto
"""
import docx2txt #Lbreria para leer word y escribirlo
import nltk #libreria para tokenizar
nltk.download('punkt')
from nltk.corpus import stopwords 
nltk.download('stopwords')
from nltk.tokenize import word_tokenize 



#Partiendo las oraciones en lineas
def divLineas(texto):
    content = []
    for line in texto.splitlines():
        if line != '':
            content.append(line)
    return content



#excepcion de algunas stopwords
def rediseñoStopWords(stop_words):
    #Si tiene estas letras no les tome en cuenta como Stop words
    #Hacemos esto , porque en inferencias estas letras son importantes
    imp_words=['y','o',',','no']
    for i in imp_words:
        if i in stop_words:
            stop_words.remove(i)
    return stop_words

#filtracion de stopwords
#Aqui sacamos toda palabra inecesaria
def filtrarOraciones(oracion):
    example_sent = oracion
    stop_words = set(stopwords.words('spanish')) 
    stop_words=rediseñoStopWords(stop_words)
    word_tokens = word_tokenize(example_sent) 
    filtered_sentence = [w for w in word_tokens if not w in stop_words] 
    filtered_sentence = [] 

    for w in word_tokens: 
        if w not in stop_words: 
            filtered_sentence.append(w) 

    return filtered_sentence


#clase calcificacion
class Calcificacion:
    def __init__(self):
        self.morfologia = ""
        self.distribucion = ""
        self.lateralidad = ""
        self.otros = ""
        self.porcentaje = ""
        self.birads=""
        #Colocamos guardado como texto , para saber de donde se obtuvo de la inferencia, en este caso es por lectura de texto
        self.guardado="texto"
    
    def toDBCollection (self):
        return {
            "morfologia":self.morfologia,
            "distribucion":self.distribucion,
            "lateralidad": self.lateralidad,
            "otros":self.otros,
            "porcentaje":self.porcentaje,
            "birads":self.birads,
            "guardado":self.guardado
        }
    
    def cambiar_morfologia(self, morfologia):
        self.morfologia=morfologia
    def cambiar_distribucion(self, distribucion):
        self.distribucion=distribucion
    def cambiar_lateralidad(self, lateralidad):
        self.lateralidad=lateralidad
    def cambiar_otros(self, otros):
        self.otros=otros
    def cambiar_porcentaje(self, porcentaje):
        self.porcentaje=porcentaje
    def cambiar_birads(self, birads):
        self.birads=birads



#Separamos una oracion por comas
def separar_por_comas(frase):
    m=[]
    n=[]
    for i in frase:
        #Si tiene ',', 'y' o 'o' separar en otro array
        #Ejemplo: frio,caliente omedio templado
        #[[frio],[caliente],[[medio],[templado]]]
        if i==',' or i=='y':
            m.append(n)
            n=[]
        else:
            #El o cuenta como palabra para saber si esta parte de la inferencia se refiere a una conjuncion
            if  i=='o' :
                m.append([i])
                m.append(n)
                n=[]       
            else:
                n.append(i)
    m.append(n)
    temp=""
    l=[]
    #Unimos palabras con el ejemplo anterior uniriamos de esta forma mediotemplado
    for i in m:
        for j in i:
            temp=temp+str(j)
        l.append(temp)
        temp=""
    m=l
    return m

#Sentencia switch que permite obtener un numero de acuerdo a la caracteristica
def switch_diferenciador(argumento):
    switcher = {
        "morfología": 1,
        "morfologia": 1,
        "otros": 2,
        "distribución": 3,
        "distribucion": 3,
        "llega": 4,
        "sospecha": 4,
        "grado": 4,
        "porcentaje": 6,
        "probabilidad": 6,
        "Bilateral":7,
        "bilateral":7
    }
    return switcher.get(argumento, 100
    )

#Separamos por caracteristicas
def tokenizar_oracion(oracion):
    a_morf=[]
    a_distri=[]
    a_late=[]
    a_resul=[]
    a_porcen=[]
    a_otros=[]
    band=0
    for i in oracion:
        num=switch_diferenciador(i)
        if num<100:
            band=num
        else:
            if band==2:
                a_otros.append(i)
            if band==3 : 
                a_distri.append(i)    
            if band==1: 
                a_morf.append(i) 
            if band==4 : 
                a_resul.append(i) 
            if band==6 : 
                a_porcen.append(i) 
            if band==7:
                a_late.append("bilateral")
    array_caracteristicas=[a_resul,a_distri,a_late,a_morf,a_otros,a_porcen]
    return array_caracteristicas


#Una vez tokenizado revisamos cualquier falta
def procesar_tokens(a_resul,a_distri,a_late,a_morf,a_otros,a_porcen):
 # si no es bilateral es no bilateral
    if len(a_late)==0:
        a_late.append("no bilateral")
    #Si no tenemos porcentaje pero si birads calculamos porcentaje
    if len(a_porcen)==0 and len(a_resul)!=0:
        a_resul=separar_por_comas(a_resul)
        a_porcen.append(clasificarPorResultado(a_resul[0]))
    #Si no tenemos birads pero si porcentaje calculamos birads
    if len(a_porcen)!=0 and len(a_resul)==0:
        a_porcen=separar_por_comas(a_porcen)
        a_resul.append(clasificarPorPorcentaje(a_porcen[0]))

    #Separamos por comas y unimos las ideas separadas por comas  
    a_morf=separar_por_comas(a_morf)
    a_distri=separar_por_comas(a_distri)
    a_resul=separar_por_comas(a_resul)
    a_otros=separar_por_comas(a_otros)
    a_porcen=separar_por_comas(a_porcen)
  
  #Quitamos arrays inecesarios , si solo hay un dato en un array colocamos el dato en vez del array con dato
    if(len(a_resul)==1):
        a_resul=a_resul[0]
    if(len(a_porcen)==1):
        a_porcen=a_porcen[0]
    if(len(a_late)==1):
        a_late=a_late[0]
    array_caracteristicas=[a_resul,a_distri,a_late,a_morf,a_otros,a_porcen]
    return array_caracteristicas

#Funcion para guardar en una clase las caracteristicas
def guardar_en_clase(a_resul,a_distri,a_late,a_morf,a_otros,a_porcen):
    calci=Calcificacion()
    calci.cambiar_birads(a_resul)
    calci.cambiar_distribucion(a_distri)
    calci.cambiar_lateralidad(a_late)
    calci.cambiar_morfologia(a_morf)
    calci.cambiar_otros(a_otros)
    calci.cambiar_porcentaje(a_porcen)
    return calci

#Si se tiene el porcentaje calcula la categorizacion birads
def clasificarPorPorcentaje(palabra):
    num=""
    #Revisa si el argumento es numero , o busca un numero 
    for i in palabra:
        if i.isdigit():
            num=num+i
    #Si existe lo categoriza
    if num!="":
        palabra=num
        if palabra=='0':
            return 'birads2'
        else:
            if int(palabra)<=2:
                return 'birads3'
            else:
                if int(palabra)<=10:
                    return'birads4a'
                else:
                    if int(palabra)<=50:
                        return'birads4b'
                    else:
                        if int(palabra)<=95:
                            return 'birads4c'
                        else:
                            if int(palabra)<=100:
                                return 'birads5'

#De acuerdo al birads , categoriza el porcentaje de probabilidad de malignidad                
def clasificarPorResultado(palabra):
        buscar='birads'
        if palabra.find(buscar+'2')!=-1:
            return '0'
        if palabra.find(buscar+'3')!=-1:
                return '<2' 
        if palabra.find(buscar+'4a')!=-1:
            return'2-10'
        if palabra.find(buscar+'4b')!=-1:
            return '10-50'
        if palabra.find(buscar+'4c')!=-1:
            return '51-95'
        if palabra.find(buscar+'5')!=-1:
            return '>95'
        return palabra   
       






#Conexion con mongo
from pymongo import MongoClient # libreria de mongo

#insercion de datos a la base

def insertCal(temp):
    Mongo_Uri ='mongodb://localhost'
    client=MongoClient(Mongo_Uri)
    db=client['Mamografia1']
    collection = db['Calcificacion']
    for calci in temp:
        if(busqueda(calci.morfologia,calci.distribucion,calci.lateralidad,calci.otros)):
            collection.insert_one(calci.toDBCollection())

#Busqueda si ya exite la inferencia, para no reescribirlo
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
        return False
    else:
        return True

#REcoge el word de la ubicacion  y lo procesa hasta guardar el dato
def proceso_gruardar_word(ubicacion):
    #Selecciona word
    my_text=docx2txt.process(ubicacion)
    #Lo divide en lineas
    content=divLineas(my_text)
    #recoleccion de oraciones filtradas de stopwords
    oracionesfiltradas=[]
    for i in content:
        #filtra stopwords o palabras inservibles
        oracionesfiltradas.append(filtrarOraciones(i))
    temp=[]
   #tokeniza y guarda un una clase
    for i in oracionesfiltradas:
        arr=tokenizar_oracion(i)
        arr=procesar_tokens(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5])
        temp.append(guardar_en_clase(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]))
    #Guarda la clase
    insertCal(temp)
