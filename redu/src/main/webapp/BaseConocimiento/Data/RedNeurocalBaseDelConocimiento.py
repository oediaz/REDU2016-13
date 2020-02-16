# -*- coding: utf-8 -*-
"""
PROYECTO REDU - ESPE
Autor: Enriquez Karla
Fecha: 09 de Noviembre del 2019
Base del Conocimiento 
"""

import random
from pymongo import MongoClient
from keras.models import Sequential
from keras.layers import Dense
import csv
import numpy
# Fija las semillas aleatorias para la reproducibilidad
numpy.random.seed(15)
# carga los datos
"""
1 Nombre de la Calcificación
Haralick: 
   2 Homogeneidad
   3 Contraste
   4 Disimilitud
   5 Entropia
   6 Energia
   7 Media
8 Agrupación
Ubicacion
    9 Lateralidad
    10 Profunidad
    11 DistanciaPezon
    12 DistanciaToracica
    13 DistanciaEsternon
14 Forma
15 Bordes
16 Area
17 Maligna o Benigna <- Este es el dato de resultado
"""

def logicaDifusa(homog,contraste,disimilitud,entropia,energia,media,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,bordes,area):

    ########################## HOMOGENEIDAD ##################################
    if homog ==1:
        hckHmg=random.uniform(0,0.32)
    else:
        if homog==2:
            hckHmg=random.uniform(0.33,0.65)
        else:
            hckHmg=random.uniform(0.66,1)
    ######################### CONTRASTE #####################################
    nivelGrises=255;
    mini=nivelGrises/3
    if contraste ==1:
        hckCntr=random.uniform(0,mini)
    else:
        if contraste==2:
            mini=mini+1
            limite=2*nivelGrises/3;
            hckCntr=random.uniform(mini,limite)
        else:
            hckCntr=random.uniform(limite, nivelGrises)
    ######################### Disimilaridad ####################################
    hckDismlt=1
    if disimilitud ==1:
        hckDismlt=random.uniform(0,2.99)
    else:
        if disimilitud==2:
            hckDismlt=random.uniform(3,5.99)
        else:
            hckDismlt=random.uniform(6, 9)
     
    ######################### Entropia ####################################### 
    if entropia ==1:
        hckEnt=random.uniform(0,0.32)
    else:
        if entropia==2:
            hckEnt=random.uniform(0.33,0.65)
        else:
            hckEnt=random.uniform(0.66,1)
    ######################## Energia ####################################### 
    if energia ==1:
        hckEng=random.uniform(0,0.32)
    else:
        if energia==2:
            hckEng=random.uniform(0.33,0.65)
        else:
            hckEng=random.uniform(0.66,1)
    ######################### Media  ####################################### 
    hckMedia=1.0

    
    prediccion(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,bordes,area)
def prediccion(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area):
    numpy
    Z=[hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area,0,0]
    with open(r'datosEntrenamiento.csv', 'a') as f:
        writer=csv.writer(f)
        writer.writerow(Z)
    dataset = numpy.loadtxt("datosEntrenamiento.csv", delimiter=",")
    # dividido en variables de entrada (X) y salida (Y)
    X = dataset[:,0:16]
    Y = dataset[:,16]
    # crea el modelo
    model = Sequential()
    model.add(Dense(12, input_dim=16, activation='relu'))
    model.add(Dense(8, activation='relu'))
    model.add(Dense(1, activation='sigmoid'))
    # Compila el modelo
    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
    # Ajusta el modelo
    model.fit(X, Y, epochs=150, batch_size=10)
    predictions = model.predict(X)
    maligna = [round(x[0]) for x in predictions]
    mlg=maligna[-1]
    if mlg == 1:
        print("Es una calcificación maligna")
    else:
         print ("No es una calcificacion maligna")
    print(mlg)
    almacenarEnMongoDB(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area,mlg)
def almacenarEnMongoDB(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,borde,area,maligna):
    ################### Almacenamiento en la BD ##############################
    almacenamiento={"Haralick":{"Homogeneidad":float(hckHmg),"Contraste":float(hckCntr),"Disimilitud":float(hckDismlt),
                    "Entropia":float(hckEnt),"Energia":float(hckEng)},"Agrupacion":int(agrupacion),
                    "Ubicación":{"Lateralidad":float(lateralidad),
                    "Profundidad":float(profundidad),"DistanciaPezon":float(distanciaPezon),"DistanciaToracica":float(distanciaToracica),
                    "DistanciaExternon":float(distanciaEsternon)},"Forma:":float(forma),
                    "Bordes:":float(borde),"Area":float(area),"Maligna":int(maligna)}
    mongoClient = MongoClient("mongodb://localhost:27017/")
    mydb=mongoClient["Calcificacion"]
    mycol=mydb["Calcificacion"]
    x=mycol.insert_one(almacenamiento)
    print(x.inserted_id)
    
logicaDifusa(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)