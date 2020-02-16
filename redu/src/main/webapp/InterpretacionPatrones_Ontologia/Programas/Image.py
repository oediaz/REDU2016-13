import matplotlib.pyplot as plt
import cv2
plt.rcParams['image.cmap'] = 'gray'
import numpy as np
import numpy as np1
import argparse 
from skimage import io
from pylab import *
import easygui as eg
from PIL import Image 
from PIL.ExifTags import TAGS           # funciones para cargar y manipular imÃ¡genes              # funciones numéricas (arrays, matrices, etc.)
import sys
import tkinter as tk
from tkinter import Tk
from tkinter import ttk
import tkinter 
from PyQt5.QtWidgets import QApplication, QMainWindow, QAction, QMessageBox,QDialog
from PyQt5 import uic
from PyQt5.QtGui import QIcon
from tkinter.filedialog import askopenfilename
#import predicate
from PyQt5.QtWidgets import QApplication, QMainWindow, QAction, QMessageBox
from PyQt5 import uic
from PyQt5.QtGui import QIcon
from pymongo import MongoClient 
import json
from pathlib import WindowsPath
import os
from os.path import basename
import time
import collections
import shutil
import random
from sklearn.metrics import confusion_matrix

############################
#Variables iniciales tamaños, coefiucentes variables otras
dim1=100
dim2=100
range1=dim1-1
range2=dim2-1
matProbabilidad=[np.zeros((range1,range2))]
matGray=[np.zeros((range1,range2))]
matcoocurrencia=[np.zeros((range1,range2))]
matcoocurrenciatranspuesta=[np.zeros((range1,range2))]
matResultado=[np.zeros((range1,range2))]
matPesos=[np.zeros((range1,range2))]
matGricesIda=[np.zeros((range1,range2))]
matGricesVuelta=[np.zeros((range1,range2))]
matConfusion=[np.zeros((range1,range2))]
campos = ['Homogeneidad', 'Contraste','Disimilaridad','Entropia', 'Energia','Media']
namearchivo=""
uri1=""

bir=""


#image=io.imread(uri)/255.0 # imread lee las imagenes con los pixeles codificados como enteros 
print("- Dimensiones de la imagen:")
listu=[]

print("Pixeles")

a=0
m=512
n=512
####################
#Determina los 6 coeficientes Haralick
def Haralicks():
    listaHaralicks=[]
    #suma
    sumaHomogeneidad=0
    print("Test coocurrencia")
    print(matcoocurrencia)
    #Homogeneidad
    for p in range(range1):
        for q in range(range2):
            if q<range2:
                matProbabilidad[0][p][q]=(matPesos[0][p][q]/(1+pow((p-q),2)))
                sumaHomogeneidad=sumaHomogeneidad+matProbabilidad[0][p][q]
            

    #Suma de homogeneidad
    print("SUMA DE HOMOGENEIDAD")
    print(sumaHomogeneidad)
    ja="Homogeneidad: "
    ja=ja+str(sumaHomogeneidad)
    listaHaralicks.append(ja)
    print("Matriz de probabilidades")
    print(matProbabilidad)
    sumaContraste=0
    #Contraste
    for i in range(range1):
        for j in range(range2):
            if j<range2:
             matProbabilidad[0][i][j]=(matPesos[0][i][j])*pow((i-j),2)
            sumaContraste=sumaContraste+matProbabilidad[0][i][j]
    print("Contraste")
    listaHaralicks.append("Contraste: "+str(sumaContraste))
    print(sumaContraste)
    ######Disimilaridad
    sumaDisimilaridad=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                if (i-j)<0:
                    matProbabilidad[0][i][j]=(matPesos[0][i][i])*(j-i)
                else:
                    matProbabilidad[0][i][j]=(matPesos[0][i][i])*(i-j)

            sumaDisimilaridad=sumaDisimilaridad+matProbabilidad[0][i][j]
    print("Disimilaridad")
    listaHaralicks.append("Disimilaridad: "+str(sumaDisimilaridad))
    print(listaHaralicks)
    print(sumaDisimilaridad)
    ###Entropia
    sumaEntropia=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                if matResultado[0][i][j]==0:
                    matProbabilidad[0][i][j]
                matProbabilidad[0][i][j]=-(matPesos[0][i][j])*math.log1p(matPesos[0][i][j])
            sumaEntropia=sumaEntropia+matProbabilidad[0][i][j]

    print("Entropia: ")
    listaHaralicks.append("Entropia"+str(sumaEntropia))
    print(sumaEntropia)
    ########Energia
    sumaEnergia=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                matProbabilidad[0][i][j]=pow((matPesos[0][i][j]),2)
            sumaEnergia=sumaEnergia+matProbabilidad[0][i][j]

    print("Energia:")
    listaHaralicks.append("Energia: "+str(sumaEnergia))
    print(listaHaralicks)
    print(sumaEnergia)
    ####Media
    sumaMedia=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                matProbabilidad[0][i][j]=i*matPesos[0][i][j]
            sumaMedia=sumaMedia=matProbabilidad[0][i][j]

    print("Media:")
    print(sumaMedia)

   

    print("Contraste::::")
   
    #temp = os.path.splitext(uri)[0] 
    temp = os.path.splitext(namearchivo)[0] 
    
    ahora = time.strftime("%Y")+"."+time.strftime("%m")+"."+time.strftime("%d")+".HORA."+time.strftime("%H")+"."+time.strftime("%M")
    namefile= ahora+".json";  
    print(namefile)
    ##Guaradar los datos en un json concatenado con metadatos
    data = {}
    data['contraste'] = sumaContraste
    data['disimilaridad'] = sumaDisimilaridad
    data['energia'] = sumaEnergia  
    data['entropia'] = sumaEntropia
    data['homogeneidad'] = sumaHomogeneidad
    m=np.array(matGray).tolist()
    n=np.array(matGray).tolist()
    o=np.array(matProbabilidad).tolist()
    data1={}
    
    new_data = {} #creo un nuevo diccionario
 
    uri2=askopenfilename()
    with open(uri2,'r') as file:
        data1 = json.load(file) #cargo el archivo json
        file.close()
    #new_data[new['dolares']] = {0.30}
    print("###################")
  
    data1.update(data) #actualizo la información del archivo json con la nueva información
    with open(uri2, 'w') as file:
        json.dump(data1, file, sort_keys=True) #tiro la actualización de la info al archivo json
        file.close()
   
    print("JSON Final")
    #origen="C:\Haralicks\\"
    origen="C:\\Users\\"
    origen=origen+"Administrador\\"+"Documents\\"+"GitHub\\"
    origen=origen+"redu\\"+"redu\\"
    origen=origen+"src\main\webapp\InterpretacionPatrones_Ontologia\Datos\Ouput\\"
    nameFile="MatrizGrises"+basename(uri2)
    nameFilef=str(nameFile).replace(".json",".txt")
    
    destino=destino="C:\Haralicks\\"
    destino="C:\\Users\\"
    destino=destino+"Administrador\\"+"Documents\\"+"GitHub\\"
    destino=destino+"redu\\"+"redu\\"
    destino=destino+" src\main\webapp\InterpretacionPatrones_Ontologia\Datos\Input\\"
    print("Origen") 
    print(basename(uri2))
    origen1=origen
    origen=origen+basename(uri2)
    destino+destino+basename(uri2)
    print(origen)
    print(uri2)
    print(destino)
    shutil.copy(uri2, origen)
    archi1=open(origen1+nameFilef,"w") 
    matGricesIda=m
    archi1.write(str(m))
    archi1.close()
    print(data1)
    VerificarCaso(sumaHomogeneidad,sumaContraste,sumaDisimilaridad,sumaEntropia,sumaEnergia,sumaMedia,str(basename(uri2)),m)
    insertarDB(sumaHomogeneidad,sumaContraste,sumaDisimilaridad,sumaEntropia,sumaEnergia,sumaMedia,m)
    return(listaHaralicks)
##Comprueba el caso al cual pertenece y que probailidad de efectividad existe
def VerificarCaso(homo,contra,disimi,entro,ener,medi,nameFile,m):
    matGricesVuelta=m
    namefilecon=nameFile
    print("probando____")
    listaid=[]
    mongoClient = MongoClient('localhost',27017)
    db = mongoClient.Haralicks.Coeficientes
    #verificar la homogeneidad parecida
    myquery = { "homogeneidad": { "$gt": float(homo) } }
    x=db.find(myquery,limit=1).sort("homogeneidad",1)
    matDibujo=[]
    matDibujo1=[]
    myquery1 = { "homogeneidad": { "$lt": float(homo) } }
    y=db.find(myquery1,limit=1).sort("homogeneidad",-1)
    print(x)
    idc1=""
    idc2=""
    idc3=""
    idc4=""
    idc5=""
    idc6=""
    idcf1=""
    idcf2=""
    idcf3=""
    idcf4=""
    idcf5=""
    idcf6=""
    coe1=0.0
    coe2=0
    coe3=0
    coe4=0
    coe5=0
    coe6=0
    coef1=0.0
    coef2=0
    coef3=0
    coef4=0
    coef5=0
    coef6=0
    ##Calcular la media de proximidad con los diferentes coefientes de haralicks
    for document in x:
        coe1=float(document['homogeneidad'])-float(homo)
   
        matDibujo=document['Matriz']
        idc1=document['_id']
        listaid.append(idc1)

    for document in y:
        coef1=float(homo)-float(document['homogeneidad'])
  
        matDibujo1=document['Matriz']
        idcf1=document['_id']
        listaid.append(idcf1)
    for document in x:
        coe1=float(document['homogeneidad'])-float(homo)
        idc1=document['_id']
        listaid.append(idc1)
   
    ###################
    print("Homogeneidad")
    if coe1>coef1:       
        print(matDibujo)
    if(coef1>coe1):
        print(matDibujo)
        #################
    myquery = { "contraste": { "$lt": float(contra) } }
    x=db.find(myquery,limit=1).sort("contraste",1)
    myquery1 = { "contraste": { "$lt": float(contra) } }
    y=db.find(myquery1,limit=1).sort("contraste",-1)
    for document in x:
        coe2=float(document['contraste'])-float(contra)
        matDibujo=document['Matriz']
        idc2=document['_id']
        listaid.append(idc2)
    for document in y:
        coef2=float(contra)-float(document['contraste'])
        matDibujo1=document['Matriz']
        idcf2=document['_id']
        listaid.append(idcf2)
    ##############
    print("Contraste")
    if coe2>coef2:       
        print(matDibujo)
    if(coef2>coe2):
        print(matDibujo)
    #################

    myquery = { "disimilaridad": { "$lt": float(disimi) } }
    x=db.find(myquery,limit=1).sort("disimilaridad",1)
    myquery1 = { "disimilaridad": { "$lt": float(disimi) } }
    y=db.find(myquery1,limit=1).sort("disimilaridad",-1)
    for document in x:
        coe3=float(document['disimilaridad'])-float(disimi)
        matDibujo=document['Matriz']
        idc3=document['_id']
        listaid.append(idc3)
    for document in y:
        coef3=float(disimi)-float(document['disimilaridad'])
        matDibujo1=document['Matriz']
        idcf3=document['_id']
        listaid.append(idcf3)
    ##################
    ##############
    print("Disimilaridad")
    if coe3>coef3:       
        print(matDibujo)
    if(coef3>coe3):
        print(matDibujo)
    #################
    myquery = { "entropia": { "$lt": float(entro) } }
    x=db.find(myquery,limit=1).sort("entropia",1)
    myquery1 = { "entropia": { "$lt": float(entro) } }
    y=db.find(myquery1,limit=1).sort("entropia",-1)
    for document in x:
        coe4=float(document['entropia'])-float(entro)
        matDibujo=document['Matriz']
        idc4=document['_id']
        listaid.append(idc4)
    for document in y:
        coef4=float(entro)-float(document['entropia'])
        matDibujo1=document['Matriz']
        idcf4=document['_id']
        listaid.append(idcf4)
    ##################
##############
    print("Entropia")
    if coe4>coef4:       
        print(matDibujo)
    if(coef4>coe4):
        print(matDibujo)
    #################
    ##############3###
    myquery = { "energia": { "$lt": float(ener) } }
    x=db.find(myquery,limit=1).sort("energia",1)
    myquery1 = { "energia": { "$lt": float(ener) } }
    y=db.find(myquery1,limit=1).sort("energia",-1)
    for document in x:
        coe5=float(document['energia'])-float(ener)
        matDibujo=document['Matriz']
        idc5=document['_id']
        listaid.append(idc5)
    for document in y:
        coef5=float(ener)-float(document['energia'])
        matDibujo1=document['Matriz']
        idcf5=document['_id']
        listaid.append(idcf5)
    ##################
    ##############
    print("Energia")
    if coe5>coef5:       
        print(matDibujo)
    if(coef5>coe5):
        print(matDibujo)
    #################
    myquery = { "media": { "$lt": float(medi) } }
    x=db.find(myquery,limit=1).sort("media",1)
    myquery1 = { "media": { "$lt": float(medi) } }
    y=db.find(myquery1,limit=1).sort("media",-1)
    for document in x:
        coe6=float(document['media'])-float(medi)
        matDibujo=document['Matriz']
        idc6=document['_id']
        listaid.append(idc6)
    for document in y:
        coef6=float(medi)-float(document['media'])
        matDibujo1=document['Matriz']
        idcf6=document['_id']
        listaid.append(idcf6)
    print(listaid)
    print("Media")
    if coe6>coef6:       
        print(matDibujo)
    if(coef6>coe6):
        print(matDibujo)

    
    cuenta1 = collections.Counter(listaid)

    auxiliar=sorted(cuenta1)
    auxiliar1=cuenta1.values()
    
 
    listaux=list(sorted(auxiliar1))
    listaux=sorted(listaux)
    print(listaux[len(listaux)-1])
    myquery = { "_id": auxiliar[0] }
    x=db.find(myquery)
    for document in x:
        coe1=abs(float(document['homogeneidad'])-float(homo))
        coe2=abs(float(document['contraste:'])-float(contra))
        coe3=abs(float(document['disimilaridad'])-float(disimi))
        coe4=abs(float(document['entropia'])-float(entro))
        coe5=abs(float(document['energia'])-float(ener))
        coe6=abs(float(document['media'])-float(medi))
        matDibujo=document['Matriz']
    result=100-coe1-coe2-coe3-coe4-coe5-coe6
    nameFile="MatrizGrisesVuelta"+nameFile
    nameFilef=str(nameFile).replace(".json",".txt")
    namefilecon="MatrizConfusion"+namefilecon
    namefileconf=str(namefilecon).replace(".json",".txt")
    origen="C:\\Users\\"
    origen=origen+"Administrador\\"+"Documents\\"+"GitHub\\"
    origen=origen+"redu\\"+"redu\\"
    origen=origen+"src\main\webapp\InterpretacionPatrones_Ontologia\Datos\Ouput\\"
    archi1=open(origen+nameFilef,"w") 
    archi1.write(str(matGricesVuelta))
    archi1.close()
    
    print("_____________________________________________")
    matGricesIda=np.array(matGray).tolist()
        
    print("El porcentaje es: "+str(result)+" %")
    matConfusion=[np.zeros((range1,range2))]

    aleatoriosx1=[]
    aleatoriosy1=[]
    aleatoriosx=range(0,200)
    aleatoriosx1=random.sample(aleatoriosx,50)
    aleatoriosx1=sorted(aleatoriosx1)
    aleatoriosy=range(0,200)
    aleatoriosy1=random.sample(aleatoriosy,50)
    aleatoriosy1=sorted(aleatoriosy1)

    print("_____________________________________________")
    print(str(aleatoriosx1))
    print(str(aleatoriosy1))

    zz=0
    yy=0
    for i in range(range1):
        for j in range(range2):
            if matGricesIda[0][i][j]==matGricesVuelta[0][i][j]:
                matConfusion[0][i][j]=1
            else:
                matConfusion[0][i][j]=0
            if i==aleatoriosx1[zz] and j==aleatoriosy1[yy]:
                matConfusion[0][i][j]=0
                zz=zz+1
                yy=yy+1


    np.set_printoptions(threshold=sys.maxsize)


    archiconf=open(origen+namefileconf,"w")
    archiconf.write(str(matConfusion))
    archiconf.close()

    print("_____________________________________________")
    
    print(str(matConfusion))


    print("Dibujado")
    lista=[]
    listCoocurrencia=[]

    for elemento in matDibujo:
        lista.append(elemento)
   
    print("Iniciando")
    

    print("Matriz de imagen generada")
    numFallas=0
    #print(pix1)
    print("COMPARACION ENTRE LAS DOS MATRICES")
   
    eg.msgbox("El caso de efectividad es: "+ str(result)+" %" , 'multenterbox', ok_button='Visualizar Imagen')
    
    show()
    aux1=""
##Guarda los casos que se calculan dentro de la base de datos
def insertarDB(homo,contra,disimi,entro,ener,medi,matProb):
    Homogeneidad = homo
    Contraste = contra
    Disimilaridad = disimi
    Entropia = entro
    Energia = ener
    Media = medi
    matProbabil=matProb
    #matGrises=matGris
    #VerificarCaso(homo,contra,disimi,entro,ener,medi)
    #record = matProb.tolist()
    mongoClient = MongoClient('localhost',27017)
    db = mongoClient.Haralicks
    db.Coeficientes.insert_one(
        {
           # "Calcificacion" : "BI-RADS ",
            "homogeneidad" : Homogeneidad,
            "contraste:" : Contraste,
            "disimilaridad" : Disimilaridad,
            "entropia" : Entropia,
            "energia" : Energia,
            "media" : Media,          
            "Matriz":matProb
            
        }
    )

def show_dialog(self,a9,a8):
    QMessageBox.about(self, a9,a8)

##Graficar graficos de prueba en pixeles comprobando los niveles de grises dentro de una imagen
def printing():
    win = tk.Tk()  
    # Application Name  
    win.title("Ingrese los coeficientes de haralicks")  
    # Label  
    lbl = ttk.Label(win, text = "Enter the name:").grid(column = 0, row = 0)  
    lbl = ttk.Label(win, text = "Homogeneidad: ").grid(column = 0, row = 1)  
    lbl = ttk.Label(win, text = "Contraste:").grid(column = 0, row = 2)  
    lbl = ttk.Label(win, text = "Disimilaridad:").grid(column = 0, row = 3)  
    lbl = ttk.Label(win, text = "Entropia:").grid(column = 0, row = 4)
    lbl = ttk.Label(win, text = "Energía:").grid(column = 0, row = 5)
    # Click event  
    def click(): print("Hi," + name.get()+name1.get()+name2.get()+name3.get()+name4.get()+name5.get())  
    
    
    name = tk.StringVar()  
    name1=tk.StringVar()
    name2=tk.StringVar()
    name3=tk.StringVar()
    name4=tk.StringVar()
    name5=tk.StringVar()
    
    def imprim():
        var.predicate.diccionario['nombre']='Calcificacion'
        print("TEST")
        print(var.predicate.diccionario["haralick2"])
        if(var.predicate.diccionario["haralick1"]==0 and var.predicate.diccionario["haralick2"]==50):
            print("Es una calcificación de grado 2")
        print("No se encuentra un patrón con esos coeficientes")
        print(var1, type(predicate))
    nameEntered = ttk.Entry(win, width = 25, textvariable = name).grid(column = 1, row = 1)  
    nameEntered = ttk.Entry(win, width = 25, textvariable = name1).grid(column = 1, row = 2)  
    nameEntered = ttk.Entry(win, width = 25, textvariable = name2).grid(column = 1, row = 3)  
    nameEntered = ttk.Entry(win, width = 25, textvariable = name3).grid(column = 1, row = 4) 
    nameEntered = ttk.Entry(win, width = 25, textvariable = name4).grid(column = 1, row = 5) 
    button = ttk.Button(win, text = "submit", command = imprim).grid(column = 2, row = 3)  
    win.mainloop()  
###Se determina la matriz de coocurrencia a partir de la matriz de grises de peso y de probabilidades
class MatrizCoocurrenciaDef:
    def Coocurrencia(self,uri):
        lista=[]
        im = Image.open(uri).convert("L")
        pixels = list(im.getdata())
        #obtener matriz de grises
        pix=np.array(pixels).reshape(dim1,dim2)
        for i in range(range1):
            for j in range(range2):
                matGray[0][i][j]=pix[i][j]
       
        print(pix)
        listCoocurrencia=[]
        #sacar la matriz de coocurrencia
        a=0
        for i in range(range1):
            for j in range(range2):
                for k in range(range1):
                    for l in range(range2):
                        if(l<range2):
                            if i==pix[k][l]:
                                if j==pix[k][l+1]:
                                    matcoocurrencia[0][i][j]=matcoocurrencia[0][i][j]+1
                                matcoocurrencia[0][i][j]=matcoocurrencia[0][i][j]

        for i in range(range1):
            for j in range(range2):
                matcoocurrenciatranspuesta[0][i][j]=matcoocurrencia[0][j][i]
        for i in range(range1):
            for j in range(range2):
                matResultado[0][i][j]=matcoocurrencia[0][i][j]+matcoocurrenciatranspuesta[0][i][j]

        probabilidad=(range1-1)*range2
        for i in range(range1):
            for i in range(range2):
                matPesos[0][i][j]=matResultado[0][i][j]/probabilidad
        print("Matriz de pesos")
        print(matPesos)
        print("Matriz de coocurrencia: ")
        print(matcoocurrenciatranspuesta)
        print("Matriz de coocurrencia: ")
        print(matcoocurrencia)
        print("Matriz resultado")
        print(matResultado)
        print()

##Dibujar imagenes en pixeles 
def Dibujar():
    lista=[]
    listCoocurrencia=[]
    for elemento in pixels:
        lista.append(elemento/255.0)
    pix=np.array(lista).reshape(dim1,dim2)
    print("Iniciando")
    img=plt.imshow(pix,vmin=0,vmax=1)
    pixels1 = list(im.getdata())
    pix1=np.array(pixels1).reshape(dim1,dim2)
    print("Matriz de imagen generada")
    numFallas=0
    print(pix1)
    for i in range(32):
        for j in range(32):
            if(pix[i][j]==pix1[i][j]):
                numFallas+=1
    #Compara las dos matrices       
    print("COMPARACION ENTRE LAS DOS MATRICES")
    if numFallas==0:
        print("0 Errores")
    print(numFallas, " Errores")
    #Se muestra la matriz de grises en diferente escala
    print("Segunda matriz: ")
    print(pix)
    show()
    aux1=""


class Interfaces:
    def ImagenAleatoria(self):
        
        print("a")
        
####Carga de imagenes del directorio
class LoadImage:
    def CargarImagen(self):
        matProbabilidad=[np.zeros((range1,range2))]
        matcoocurrencia=[np.zeros((range1,range2))]
        matcoocurrenciatranspuesta=[np.zeros((range1,range2))]
        matResultado=[np.zeros((range1,range2))]
        matPesos=[np.zeros((range1,range2))]

        Tk().withdraw()
        uri = askopenfilename()
        
        img = Image.open(uri)
        exif = img._getexif()
        print("Results for "+uri)
        try:
            for (k, v) in exif.iteritems():
                print ('%s = %s'%(TAGS.get(k), v))
        except:
            print ("Metadata not found!")
        namearchivo=uri
        uri1=namearchivo
        print(namearchivo)

        image=io.imread(uri)/255.0 # imread lee las imagenes con los pixeles codificados como enteros 

        print("- Dimensiones de la imagen:")
        #print(image.shape)
        plt.imshow(image,vmin=0,vmax=1)
        I = Image.open(uri).convert("L")
        plt.imshow(np.asarray(I))
        
        interfaces=Interfaces()
        interfaces.ImagenAleatoria()
        return namearchivo
        
###    Interfaces grise
class Dialog(QDialog):
    def __init__(self, *args, **kwargs):
        super(Dialog, self).__init__(*args, **kwargs)
        self.setWindowTitle("Matriz de coocurrencia")
        self.setFixedSize(200, 100)
class Window(QMainWindow):

 def __init__(self):
  QMainWindow.__init__(self)
  w = QMainWindow()
  w.setStyleSheet("QMainWindow{background-image:url(C:/Users/ALCI/Desktop/lena.png)}")
  self.resize(800, 500) #Tamaño inicial de la ventana 800x500
  #Barra de estado
  
  self.statusBar().showMessage("Bienvenid@")
  self.font
  #Objeto menuBar
  menu = self.menuBar()
  #Menú padre
  menu_archivo = menu.addMenu("&Inicio")
  #Menú padre
  menu_editar = menu.addMenu("&Ayuda")
  
  #Agregar un elemento acción al menu_archivo
  menu_archivo_abrir = QAction(QIcon(), "&ImagenAleatoria", self)
  menu_archivo_abrir.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_abrir.setStatusTip("Imagen aleatoria") #Mensaje en la barra de estado
  menu_archivo_abrir.triggered.connect(self.menuArchivoAbrir) #Lanzador
  menu_archivo.addAction(menu_archivo_abrir)
  #Cargar Imagen
  menu_archivo_cargar = QAction(QIcon(), "&CargarImagen", self)
  menu_archivo_cargar.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_cargar.setStatusTip("Cargar Imagen") #Mensaje en la barra de estado
  menu_archivo_cargar.triggered.connect(self.menuArchivoCargar) #Lanzador
  menu_archivo.addAction(menu_archivo_cargar)
  #Dibujar nueva imagen
  menu_archivo_dibujar = QAction(QIcon(), "&DibujarImagen", self)
  menu_archivo_dibujar.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_dibujar.setStatusTip("Dibujar Imagen") #Mensaje en la barra de estado
  menu_archivo_dibujar.triggered.connect(self.menuArchivoDibujar) #Lanzador
  menu_archivo.addAction(menu_archivo_dibujar)
 
  #Haralicks
  menu_archivo_hara = QAction(QIcon(), "&SacarHaralicks", self)
  menu_archivo_hara.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_hara.setStatusTip("Haralicks") #Mensaje en la barra de estado
  menu_archivo_hara.triggered.connect(self.menuArchivohara) #Lanzador
  menu_archivo.addAction(menu_archivo_hara)
  #Imprimir diccionario
  menu_archivo_print = QAction(QIcon(), "&PrintDictionary", self)
  menu_archivo_print.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_print.setStatusTip("Imprimir") #Mensaje en la barra de estado
  menu_archivo_print.triggered.connect(self.menuArchivoprint) #Lanzador
  menu_archivo.addAction(menu_archivo_print)
  #Verificar ontología
  menu_archivo_print = QAction(QIcon(), "&Verificar", self)
  menu_archivo_print.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_print.setStatusTip("Verificar") #Mensaje en la barra de estado
  menu_archivo_print.triggered.connect(self.menuArchivoVerificar) #Lanzador
  menu_archivo.addAction(menu_archivo_print)
  #Agregar un elemento acción al menu_archivo
  menu_archivo_cerrar = QAction(QIcon(), "&Cerrar", self)
  menu_archivo_cerrar.setShortcut("Ctrl+w") #Atajo de teclado
  menu_archivo_cerrar.setStatusTip("Cerrar") #Mensaje en la barra de estado
  menu_archivo_cerrar.triggered.connect(self.menuArchivoCerrar) #Lanzador
  menu_archivo.addAction(menu_archivo_cerrar)
  
  #Agregar un submenú al menú menu_editar
  menu_editar_opciones = menu_editar.addMenu("&Opciones")
  menu_editar_opciones_buscar = QAction(QIcon(), "&Buscar", self)
  menu_editar_opciones_buscar.setShortcut("Ctrl+f") #Atajo de teclado
  menu_editar_opciones_buscar.setStatusTip("Buscar") #Mensaje en la barra de estado
  menu_editar_opciones_buscar.triggered.connect(self.menuEditarOpcionesBuscar)
  menu_editar_opciones.addAction(menu_editar_opciones_buscar)
  
 def menuArchivoAbrir(self):
     interface=Interfaces()
     interface.ImagenAleatoria()

 def menuArchivoCargar(self):
    
     a=LoadImage()
     uri1=a.CargarImagen()
     print("················")
     print(uri1)
     coc=MatrizCoocurrenciaDef()
     coc.Coocurrencia(uri1)
     show_dialog(self,"Matriz de Coocurrencia",str(matcoocurrencia))
  
 def menuArchivoDibujar(self):
    Dibujar()
    
    
 def menuArchivoprint(self):
    show_dialog(self,"Haralicks","Haralicks")
    printing()
 def menuArchivohara(self):
    listM=Haralicks()
    show_dialog(self,"Coeficientes de Haralicks",str(listM))

 def menuArchivoVerificar(self):
    datos = []
    listaHaralicks=[]
    datos = eg.multenterbox(msg='Ceficientes de Haralicks',
                            title='Verificación',
                            fields=campos, values=())
    cadena = ''
    i=0
    if datos != None:
        for cam, dat in zip(campos,datos):
            cadena = cadena + cam + ': ' + dat+ '\n'
            listaHaralicks.append(dat)
            i=i+1
            print("dato: "+dat)
            

    VerificarCaso(listaHaralicks[0],listaHaralicks[1],listaHaralicks[2],listaHaralicks[3],listaHaralicks[4],listaHaralicks[5])
    print("Probando el caso")
 def menuArchivoCooc(self):
    coc=MatrizCoocurrenciaDef()
    coc.Coocurrencia()
    show_dialog(self,"Matriz de Coocurrencia",str(matcoocurrencia))
 def menuArchivoCerrar(self):
  QMessageBox.information(self, "Cerrar", "Acción Cerrar", QMessageBox.Discard)

 def menuEditarOpcionesBuscar(self):
  QMessageBox.information(self, "Buscar", "Acción Buscar", QMessageBox.Discard)
 def show_dialog(self):
    dialog = Dialog(self)  # self hace referencia al padre
    dialog.show()
app = QApplication(sys.argv)
window = Window()
window.show()
app.exec_()
#############3



#Imprimir la matriz de tonos de grises


print("Finalizado")
