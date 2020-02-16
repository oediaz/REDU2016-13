#librerias para leer word y tokenizar respectivamente
import docx2txt
import nltk
nltk.download('punkt')
my_text=docx2txt.process("Calcificaciones.docx")

#Partiendo las oraciones en lineas
content = []
for line in my_text.splitlines():
    if line != '':
        content.append(line)
from nltk.corpus import stopwords
nltk.download('stopwords')

#excepcion de algunas stopwords
def rediseñoStopWords(stop_words):
    imp_words=['y','o',',','no']
    for i in imp_words:
        if i in stop_words:
            stop_words.remove(i)
    return stop_words

#filtracion de stopwords
from nltk.tokenize import word_tokenize 
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

    #print(word_tokens) 
    #print(filtered_sentence) 
    return filtered_sentence

#recoleccion de oraciones filtradas
oracionesfiltradas=[]
for i in content:
    oracionesfiltradas.append(filtrarOraciones(i))

#clase 
class Calcificacion:
    def __init__(self):
        self.morfologia = ""
        self.distribucion = ""
        self.lateralidad = ""
        self.otros = ""
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



def identificacionPalabras(posicion,tam_oracion,filtered_sentence,param):
    comas=True
    temp=[]
    palabrasStop=['llega','puede','probabilidad','malignidad']
    for  j in range(posicion,tam_oracion):
        if comas==True:
            if j==posicion:
                if filtered_sentence[j+2]=='o' and filtered_sentence[j+1]!=',':
                    temp.append(filtered_sentence[posicion]+filtered_sentence[posicion+1])
                else:
                    if filtered_sentence[j+3]=='o' and filtered_sentence[j+1]!=',' and filtered_sentence[j+2]!=',':
                        temp.append(filtered_sentence[posicion]+filtered_sentence[posicion+1]+filtered_sentence[posicon+2])
                    else:
                        temp.append(filtered_sentence[posicion])
            if filtered_sentence[j]==',':
                if filtered_sentence[j+2]!=',' and (filtered_sentence[j+3]==',' or filtered_sentence[j+3]=='o') :
                    temp.append(filtered_sentence[j+1]+filtered_sentence[j+2]+'')
                else:
                    if filtered_sentence[j+2]!=',' and filtered_sentence[j+3]!=',' and (filtered_sentence[j+4]==',' or filtered_sentence[j+4]=='o') :
                        temp.append(filtered_sentence[j+1]+filtered_sentence[j+2]+filtered_sentence[j+3])
                    else:
                        temp.append(filtered_sentence[j+1])
            if filtered_sentence[j]=='o':
                if filtered_sentence[j+2]!=',' and filtered_sentence[j+3]!=',' and filtered_sentence[j+2] not in palabrasStop and filtered_sentence[j+3] not in palabrasStop   :
                        temp.append(filtered_sentence[j+1]+filtered_sentence[j+2]+filtered_sentence[j+3])
                else:
                    if filtered_sentence[j+2]!=',' and filtered_sentence[j+2] not in palabrasStop  :
                        temp.append(filtered_sentence[j+1]+filtered_sentence[j+2])
                    else:
                        temp.append(filtered_sentence[j+1])
                comas=False
            if j+2<tam_oracion:
                if filtered_sentence[j+2] in param:
                    #print(filtered_sentence[j+1])
                    comas=False
                    return temp
                
    return temp


def clasificarporbirads(palabra):
    if palabra.find("birads") >-1:
            return palabra
    else:
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
                
def clasificarPorPorcentaje(palabra):
        if palabra=='birads2':
            return '0'
        if palabra=='birads3':
                return '<2' 
        if palabra=='birads4a':
            return'2-10'
        if palabra=='birads4b':
            return '10-50'
        if palabra=='birads4c':
            return '51-95'
        if palabra=='birads5':
            return '>95'
        return palabra   

#algoritmo para obtener palabras importantes
def creacionclase(filtered_sentence):
    calci=Calcificacion()
    tam_oracion=len(filtered_sentence)
    a=range(tam_oracion)
    temp=[]
    param=['morfología','distribución','malignidad','bilateral']
    for i in a:
        
        if filtered_sentence[i]=='morfología':
            s=i+1
            if filtered_sentence[i] in param:
                param.remove(filtered_sentence[i])
            #print(param)
            temp=identificacionPalabras(s,tam_oracion,filtered_sentence,param)
            calci.cambiar_morfologia(temp)
        if filtered_sentence[i]=='distribución':
            s=i+1
            if filtered_sentence[i] in param:
                param.remove(filtered_sentence[i])
            temp=identificacionPalabras(s,tam_oracion,filtered_sentence,param)
            calci.cambiar_distribucion(temp)
        
        if filtered_sentence[i]=='malignidad' or filtered_sentence[i]=='sospecha':
            #if(filtered_sentence[i+1]=='birads')
            #if >-1:
            birads=clasificarporbirads(filtered_sentence[i+1])
            porcentaje=clasificarPorPorcentaje(filtered_sentence[i+1])
            #print(birads)   
            calci.cambiar_birads(birads)
            calci.cambiar_porcentaje(porcentaje)
        if filtered_sentence[i]=='bilateral':
            if filtered_sentence[i-1]=='no' or filtered_sentence[i-2]=='no' :
                calci.cambiar_lateralidad('noBilateral')
            else:
                calci.cambiar_lateralidad('Bilateral')
                
    return calci

temp=[]
for i in oracionesfiltradas:
    #print(i)
    temp.append(creacionclase(i))
#print(len(temp))
i=0


#Conexion con mongo
from pymongo import MongoClient # libreria de mongo
Mongo_Uri ='mongodb://localhost'
client=MongoClient(Mongo_Uri)

db=client['Mamografia1']
collection = db['Calcificacion']


#insercion de datos a la base
for clase in temp:
    collection.insert_one(clase.toDBCollection())