#import cv2
import math
import matplotlib.pyplot as plt 
plt.rcParams['image.cmap'] = 'gray'
from skimage import io
from pylab import *
from PIL import Image             # funciones para cargar y manipular imagenes
import numpy as np                # funciones numéricas (arrays, matrices, etc.) 
import sys
import tkinter as tk
from tkinter import ttk
from PyQt5.QtGui import QIcon
from PyQt5.QtWidgets import QApplication, QMainWindow, QAction, QMessageBox, QDialog
from PyQt5 import uic
from tkinter.filedialog import askopenfilename
from tkinter import Tk
from pymongo import MongoClient 

############################

# Inicialización de variables

range1=50
range2=50
dim1=256
dim2=256
matProbabilidad=[np.zeros((range1,range2))]
matcoocurrencia=[np.zeros((range1,range2))]
matcoocurrenciatranspuesta=[np.zeros((range1,range2))]
matResultado=[np.zeros((range1,range2))]
matPesos=[np.zeros((range1,range2))]
busqueda=[]

#uri="C:/Users/ALCI/Desktop/lena.png"
uri="C:/Users/Administrador/Documents/GitHub/redu/redu/src/main/webapp/ReconocimientoPatrones/Datos/PatronesReconocidos/Mamografias/Calsificaciones/nivel 0.jpg"

im = Image.open(uri).convert("L")
im.show()

bir=""

image=io.imread(uri)/255.0 # imread lee las imagenes con los pixeles codificados como enteros 
print("- Dimensiones de la imagen:")
print(image.shape)
pixels = list(im.getdata())
listu=[]
print(type(image.shape))
#for xz in pixels:
    #asd=list(xz)
    #print("pixel: ",asd)
  #  listu.append(asd)
#myarray=np.asarray(pixels)
print("QQQQQ")
#print(listu)
#print(len(myarray))
#print(pixels)
pix=np.array(pixels).reshape(image.shape)
print("Pixeles")
#print(pix)
############
a=0
m=512
n=512
####################

#________FUNCIÓN HARALICKS_________


def Haralicks():

    #_____CÁLCULO DE HOMOGENEIDAD______

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

    #_____CÁLCULO DE CONTRASTE______

    #Contraste
    for i in range(range1):
        for j in range(range2):
            if j<range2:
             matProbabilidad[0][i][j]=(matPesos[0][i][j])*pow((i-j),2)
            sumaContraste=sumaContraste+matProbabilidad[0][i][j]
    print("Contraste")
    listaHaralicks.append("Contraste: "+str(sumaContraste))
    print(sumaContraste)

    #_____CÁLCULO DE DISIMILARIDAD______

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

    #_____CÁLCULO DE ENTROPIA______

    sumaEntropia=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                if matPesos[0][i][j]==0:
                    matProbabilidad[0][i][j]
                matProbabilidad[0][i][j]=-(matPesos[0][i][j])*math.log1p(matPesos[0][i][j])
            sumaEntropia=sumaEntropia+matProbabilidad[0][i][j]

    print("Entropia: ")
    listaHaralicks.append("Entropia"+str(sumaEntropia))
    print(sumaEntropia)

    #_____CÁLCULO DE ENERGIA______

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
    
    #_____CÁLCULO DE MEDIA______
    
    sumaMedia=0
    for i in range(range1):
        for j in range(range2):
            if j<range2:
                matProbabilidad[0][i][j]=i*matPesos[0][i][j]
            sumaMedia=sumaMedia=matProbabilidad[0][i][j]

    print("Media:")
    print(sumaMedia)

    #var.predicate.diccionario['nombre']='Calcificacion'
    #var.predicate.diccionario['haralick1']=sumaContraste
    #var.predicate.diccionario['haralick2']=sumaDisimilaridad
    #var.predicate.diccionario['haralick3']=sumaEnergia  
    #var.predicate.diccionario['haralick4']=sumaEntropia
    #var.predicate.diccionario['haralick5']=sumaHomogeneidad
    #var.predicate.diccionario['haralick6']=sumaMedia
    #print("Contraste::::")
   # print(var1, type(predicate))
    #insertarDB(sumaHomogeneidad,sumaContraste,sumaDisimilaridad,sumaEntropia,sumaEnergia,sumaMedia)
    return(listaHaralicks)

#INSERTAR COLEXION EN DB

def insertarDB(homo,contra,disimi,entro,ener,medi):
    Homogeneidad = homo
    Contraste = contra
    Disimilaridad = disimi
    Entropia = entro
    Energia = ener
    Media = medi

    mongoClient = MongoClient('localhost',27017)
    db = mongoClient.CoeficientesDB
    db.ListaCoeficiente.insert(
        {
            "Calcificacion" : "BI-RADS ",
            "Homogeneidad" : Homogeneidad,
            "Contraste:" : Contraste,
            "Disimilaridad" : Disimilaridad,
            "Entropia" : Entropia,
            "Energia" : Energia,
            "Media" : Media
        }
    )

def insertarDBpadre():
    mongoClient = MongoClient('localhost',27017)
    db = mongoClient.RangosDB
    db.RangosCoeficientes.insert(
        {
            "Tipo" : "BI-RADS ",
            "RangoHomin" : 0,
            "RangoHomax" : 0,
            "RangoComin" : 0,
            "RangoComax" : 0,
            "RangoDimin" : 0,
            "RangoDimax" : 0,
            "RangoEntmin" : 0,
            "RangoEntmax" : 0,
            "RangoEnmin" : 0,
            "RangoEmmax" : 0,
            "RangoMemin" : 0,
            "RangoMemax" : 0
        }
    )

def BorrarRangos():
    mongoClient1 = MongoClient('localhost',27017)
    db1 = mongoClient1.RangosDB
    db1.RangosCoeficientes.delete_many({})

def GeneraRangos():

    BorrarRangos()

    listaHomogeneidad=[]
    listaContraste=[]
    listaDisimilaridad=[]
    listaEntropia=[]
    listaEnergia=[]
    listaMedia=[]

    def vaciar():
        while len(listaHomogeneidad) > 0 : listaHomogeneidad.pop()
        while len(listaContraste) > 0 : listaContraste.pop()
        while len(listaDisimilaridad) > 0 : listaDisimilaridad.pop()
        while len(listaEntropia) > 0 : listaEntropia.pop()
        while len(listaEnergia) > 0 : listaEnergia.pop()
        while len(listaMedia) > 0 : listaMedia.pop()
        
    #, 3, 4, 5, 6

    for i in [0, 1, 2]:
        mongoClient = MongoClient('localhost',27017)
        db = mongoClient.CoeficientesDB
        vaciar()
        print("BI-RADS "+ str(i))
        miCursor = db.ListaCoeficiente.find({"Calcificacion":"BI-RADS "+str(i)})
        vaciar()
        for aux in miCursor:
            print ("%s - %f - %f - %f - %f- %f - %f" %(aux['Calcificacion'], aux['Homogeneidad'], aux['Contraste:'], aux['Disimilaridad'], aux['Entropia'], aux['Energia'], aux['Media']))
            listaHomogeneidad.append(aux['Homogeneidad'])
            listaContraste.append(aux['Contraste:'])
            listaDisimilaridad.append(aux['Disimilaridad'])
            listaEntropia.append(aux['Entropia'])
            listaEnergia.append(aux['Energia'])
            listaMedia.append(aux['Media'])

        mongoClient1 = MongoClient('localhost',27017)
        db1 = mongoClient1.RangosDB
        db1.RangosCoeficientes.insert(
            {
                "Tipo" : "BI-RADS "+str(i),
                "RangoHomin" : min(listaHomogeneidad),
                "RangoHomax" : max(listaHomogeneidad),
                "RangoComin" : min(listaContraste),
                "RangoComax" : max(listaContraste),
                "RangoDimin" : min(listaDisimilaridad),
                "RangoDimax" : max(listaDisimilaridad),
                "RangoEntmin" : min(listaEntropia),
                "RangoEntmax" : max(listaEntropia),
                "RangoEnmin" : min(listaEnergia),
                "RangoEmmax" : max(listaEnergia),
                "RangoMemin" : min(listaMedia),
                "RangoMemax" : max(listaMedia)
            }
        )
        vaciar()

def PruebaRangos():
    #CargarImagen()
    #Coocurrencia()
    #Haralicks()
    ComparaRangos()

def ComparaRangos():
    listaHomogeneidad=[]
    listaContraste=[]
    listaDisimilaridad=[]
    listaEntropia=[]
    listaEnergia=[]
    listaMedia=[]
    lstipo=[]
    lsminhomo=[]
    lsmaxhomo=[]
    lsmincontra=[]
    lsmaxcontra=[]
    lsmindisi=[]
    lsmaxdisi=[]
    lsminentro=[]
    lsmaxentro=[]
    lsminener=[]
    lsmaxener=[]
    lsminmedi=[]
    lsmaxmedi=[]

    def vaciar():
        while len(listaHomogeneidad) > 0 : listaHomogeneidad.pop()
        while len(listaContraste) > 0 : listaContraste.pop()
        while len(listaDisimilaridad) > 0 : listaDisimilaridad.pop()
        while len(listaEntropia) > 0 : listaEntropia.pop()
        while len(listaEnergia) > 0 : listaEnergia.pop()
        while len(listaMedia) > 0 : listaMedia.pop()
        while len(lstipo) > 0 : lstipo.pop()
        while len(lsminhomo) > 0 : lsminhomo.pop()
        while len(lsmaxhomo) > 0 : lsmaxhomo.pop()
        while len(lsmincontra) > 0 : lsmincontra.pop()
        while len(lsmaxcontra) > 0 : lsmaxcontra.pop()
        while len(lsmindisi) > 0 : lsmindisi.pop()
        while len(lsmaxdisi) > 0 : lsmaxdisi.pop()
        while len(lsminentro) > 0 : lsminentro.pop()
        while len(lsmaxentro) > 0 : lsmaxentro.pop()
        while len(lsminener) > 0 : lsminener.pop()
        while len(lsmaxener) > 0 : lsmaxener.pop()
        while len(lsminmedi) > 0 : lsminmedi.pop()
        while len(lsmaxmedi) > 0 : lsmaxmedi.pop()


    mongoClient = MongoClient('localhost',27017)
    db = mongoClient.CoeficientesDB
    miCursor = db.ListaCoeficiente.find({}).sort([("_id",-1)])
    vaciar()
    for aux in miCursor:
        print ("%s - %f - %f - %f - %f- %f - %f" %(aux['Calcificacion'], aux['Homogeneidad'], aux['Contraste:'], aux['Disimilaridad'], aux['Entropia'], aux['Energia'], aux['Media']))
        listaHomogeneidad.append(aux['Homogeneidad'])
        listaContraste.append(aux['Contraste:'])
        listaDisimilaridad.append(aux['Disimilaridad'])
        listaEntropia.append(aux['Entropia'])
        listaEnergia.append(aux['Energia'])
        listaMedia.append(aux['Media'])
        break
    print(listaHomogeneidad)
    print(listaContraste)
    print(listaDisimilaridad)
    print(listaEntropia)
    print(listaEnergia)
    print(listaMedia)

    mongoClient1 = MongoClient('localhost',27017)
    db1 = mongoClient1.RangosDB
    cursor = db1.RangosCoeficientes.find({})
    for aux1 in cursor:
        print ("%s - %f - %f - %f - %f- %f - %f - %f - %f - %f - %f- %f - %f" %(aux1['Tipo'], aux1['RangoHomin'], aux1['RangoHomax'], aux1['RangoComin'], aux1['RangoComax'], aux1['RangoDimin'], aux1['RangoDimax'],aux1['RangoEntmin'], aux1['RangoEntmax'], aux1['RangoEnmin'], aux1['RangoEmmax'], aux1['RangoMemin'], aux1['RangoMemax']))
        lsminhomo.append(aux1["RangoHomin"])
        lsmaxhomo.append(aux1["RangoHomax"])
        lsmincontra.append(aux1["RangoComin"])
        lsmaxcontra.append(aux1["RangoComax"])
        lsmindisi.append(aux1["RangoDimin"])
        lsmaxdisi.append(aux1["RangoDimax"])
        lsminentro.append(aux1["RangoEntmin"])
        lsmaxentro.append(aux1["RangoEntmax"])
        lsminener.append(aux1["RangoEnmin"])
        lsmaxener.append(aux1["RangoEmmax"])
        lsminmedi.append(aux1["RangoMemin"])
        lsmaxmedi.append(aux1["RangoMemax"])

        if(listaHomogeneidad[0] >= lsminhomo and listaHomogeneidad[0] <= lsmaxhomo and listaContraste[0] >= lsmincontra and listaContraste[0] <= lsmaxcontra and listaDisimilaridad[0] >= lsmindisi and listaDisimilaridad[0] <= lsmaxdisi and listaEntropia[0] >= lsminentro and listaEntropia[0] <= lsmaxentro and listaEnergia[0] >= lsminener and listaEnergia[0] <= lsmaxener and listaMedia[0] >= lsminmedi and listaMedia[0] <= lsmaxmedi):
            print("Este patron corresponde a una CALCIFICACION CON "+ str(lstipo))
        else:
            print("no pertenece a ningun patron conocido")


def show_dialog(self,a9,a8):
    QMessageBox.about(self, a9,a8)
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
    #print(var1, type(predicate))


def Coocurrencia():
    lista=[]
    im = Image.open(uri).convert("L")
    pixels = list(im.getdata())
    #obtener matriz de grises
    pix=np.array(pixels).reshape(dim1,dim2)
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

    probabilidad = ((range1-1)*range2)
    for i in range(range1):
        for i in range(range2):
            matPesos[0][i][j]=matResultado[0][i][j]/probabilidad

    print("Matriz de coocurrencia: ")
    print(matcoocurrenciatranspuesta)
    print("Matriz de coocurrencia: ")
    print(matcoocurrencia)
    print("Matriz resultado")
    print(matResultado)
    print()
    
#def symmetrize(a): return a + a.T - np.diag(a.diagonal())

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

def ImagenAleatoria():
    size=(20,30)
    imagen_negra=np.zeros(size)
    print("Comienzo")
    ComparaRangos()
    imagen_gris_oscuro = np.ones(size)*0.2 
    imagen_aleatoria = np.random.rand(size[0],size[1])
    plt.imshow(imagen_aleatoria,vmin=0,vmax=1)
    show()

def CargarImagen():
    matProbabilidad=[np.zeros((range1,range2))]
    matcoocurrencia=[np.zeros((range1,range2))]
    matcoocurrenciatranspuesta=[np.zeros((range1,range2))]
    matResultado=[np.zeros((range1,range2))]
    matPesos=[np.zeros((range1,range2))]

    Tk().withdraw()
    uri = askopenfilename()
    print(uri)
    image=io.imread(uri)/255.0 # imread lee las imagenes con los pixeles codificados como enteros 
    print("- Dimensiones de la imagen:")
    print(image.shape)
    plt.imshow(image,vmin=0,vmax=1)
    I = Image.open(uri).convert("L")
    plt.imshow(np.asarray(I))
    plt.show()
    

class Dialog(QDialog):
    def __init__(self, *args, **kwargs):
        super(Dialog, self).__init__(*args, **kwargs)
        self.setWindowTitle("Matriz de coocurrencia")
        self.setFixedSize(200, 100)
class Window(QMainWindow):

 def __init__(self):
  QMainWindow.__init__(self)
  w = QMainWindow()
  #w.setStyleSheet("QMainWindow{background-image:url(C:/Users/ALCI/Desktop/lena.png)}")
  w.setStyleSheet("QMainWindow{background-image:url(C:/Users/Administrador/Documents/GitHub/redu/redu/src/main/webapp/ReconocimientoPatrones/Datos/PatronesReconocidos/Mamografias/Calsificaciones/nivel 0.jpg)}")

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

  #Coocurrencia
  menu_archivo_cooc = QAction(QIcon(), "&Coocurrencia", self)
  menu_archivo_cooc.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_cooc.setStatusTip("Haralicks") #Mensaje en la barra de estado
  menu_archivo_cooc.triggered.connect(self.menuArchivoCooc) #Lanzador
  menu_archivo.addAction(menu_archivo_cooc)

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

  #Generar Rangos
  menu_archivo_print = QAction(QIcon(), "&GenerarRangos", self)
  menu_archivo_print.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_print.setStatusTip("Generar Rangos") #Mensaje en la barra de estado
  menu_archivo_print.triggered.connect(self.menuGeneraRangos) #Lanzador
  menu_archivo.addAction(menu_archivo_print)

  #PruebaRangos
  menu_archivo_print = QAction(QIcon(), "&PruebaRangos", self)
  menu_archivo_print.setShortcut("Ctrl+o") #Atajo de teclado
  menu_archivo_print.setStatusTip("Prueba Rangos") #Mensaje en la barra de estado
  menu_archivo_print.triggered.connect(self.menuPruebaRangos) #Lanzador
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
  ImagenAleatoria()
 def menuArchivoCargar(self):
  CargarImagen()
 def menuArchivoDibujar(self):
    Dibujar()
    show_dialog(self,"Matriz de Coocurrencia","Las matrices son iguales")
 def menuArchivoprint(self):
    show_dialog(self,"Haralicks","Haralicks")
    printing()
 def menuArchivohara(self):
    listM=Haralicks()
    show_dialog(self,"Matriz de Coocurrencia",str(listM))
 def menuArchivoCooc(self):
    Coocurrencia()
    show_dialog(self,"Matriz de Coocurrencia",str(matcoocurrencia))
 def menuGeneraRangos(self):
    GeneraRangos()
 def menuPruebaRangos(self):
    PruebaRangos()
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