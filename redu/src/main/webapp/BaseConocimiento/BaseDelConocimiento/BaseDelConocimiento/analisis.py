# -*- coding: utf-8 -*-
"""
PROYECTO REDU - ESPE
Autor: Enriquez Karla
Fecha: 09 de Noviembre del 2019
Base del Conocimiento 
"""

import random
from django import forms
from pymongo import MongoClient
from keras.models import Sequential
from keras.layers import Dense

import numpy
import random
import csv
import json
numpy.random.seed(7)
class AnalisisDatos:

    # carga los datos
    """
    1 Nombre de la Calcificación - Nivel Birads
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
    def cargarJson(path):
        with open(path) as file:
            data=json.load(file)
            area=data['Area']
            brd=data['Bordes']
            hmg=data['homogeneidad']
            cntr=data['Contraste']
            dsml=data['disimilaridad']
            entrp=data['entropia']
            enrg=data['energia']
            md=data['contraste']

            grup=random.choice((1, 2, 3, 4))
            latrl=random.choice((1, 2))
            prfnd=random.choice((1, 2, 3))
            frm=random.choice((1, 2, 3, 4))
            distP=random.uniform(2,100)
            distT=random.uniform(2,100)
            distE=random.uniform(2,100)

          #  grup=data['Agrupacion']
          #  latrl=data['Lateralidad']
          #  prfnd=data['Profundidad']
          #  distP=data['DistanciaPezon']
          #  distT=data['DistanciaToracica']
          #  distE=data['DistanciaExternon']
          #  frm=data['Forma']
            
            
        logicaDifusa(hmg,cntr,dsml,entrp,enrg,md,grup,latrl,prfnd,distP,distT,distE,frm,brd,area)

def logicaDifusa(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,bordes,area):
    ####################################AGRUPACION######################################
    if str(agrupacion) == True:
        if agrupacion =='Agrupada' or agrupacion =='agrupada':
            agrupacion=1
        elif agrupacion =='Lineal' or agrupacion =='lineal':
            agrupacion=2
        elif agrupacion =='Segmentaria' or agrupacion =='segmentaria':
            agrupacion=3
        elif agrupacion =='Regional' or agrupacion =='regional':
            agrupacion=4
        else: 
            agrupacion=0
    ####################################FORMA######################################
    if str(forma) == True:
        if forma =='Ovalada' or forma =='ovalada':
            forma=1
        elif forma =='Redonda' or forma =='redonda':
            forma=2
        elif forma =='Circular' or forma =='circular':
            forma=3
        elif forma =='Irregular' or forma =='irregular':
            forma=4
        else: 
            forma=0
    ####################################LATERALIDAD######################################
    if str(lateralidad) == True:
        if lateralidad =='Derecha' or lateralidad =='derecha':
            lateralidad=1
        elif lateralidad =='Izquierda' or lateralidad =='izquierda':
            lateralidad=2
        elif lateralidad =='Bilateral' or lateralidad =='bilateral':
            lateralidad=3
        else: 
            profundidad=0
    ####################################PROFUNDIDAD######################################
    if str(profundidad) == True:
        if profundidad =='Anterior' or profundidad =='anterior':
            profundidad=1
        elif profundidad =='Medio' or profundidad =='medio':
            profundidad=2
        elif profundidad =='Posterior' or profundidad =='Posterior':
            profundidad=3
        else: 
            profundidad=0
    
    prediccion(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,bordes,area)
def prediccion(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area):
    numpy
    Z=[hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area,0,0]
    with open(r'datosEntrenamiento.csv', 'a') as f:
        writer = csv.writer(f)
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
    
    if mlg == 1: #Maligna
        if forma ==4:
            if agrupacion==3 or agrupacion ==1 or agrupacion ==2 :
                nombre="Amorfa (Morfologia Sospechosa)"
                birad="Posible BI-RADS 4B"
        elif area > 0.5 and area < 1 and agrupacion ==1: 
            if lateralidad ==3:
                nombre="Grosera Heterogenea (Morfologia Sospechosa)"
                birad="Posiblemente Benigna"
            else:
                nombre="Grosera Heterogenea (Morfologia Sospechosa)"
                birad="Posible BI-RADS 4B"
        elif forma ==4 and area<0.1964:
            nombre="Finas Pleomorfas (Morfologia Sospechosa)"
            birad="Posible BI-RADS 4B"
        elif agrupacion ==4 and area>20:
            nombre="Calcificacion Regional"
            birad="Posiblemente Benigna"
        else:
            nombre: "No identificado"
            birad="No identificado"
    else: #Benigna
        nombre="Benigna"
        birads="N/A"     
    almacenarEnMongoDB(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaExternon,forma,borde,area,mlg, nombre, birads)
def almacenarEnMongoDB(hckHmg,hckCntr,hckDismlt,hckEnt,hckEng,hckMedia,agrupacion,lateralidad,profundidad,distanciaPezon,distanciaToracica,distanciaEsternon,forma,borde,area,maligna,nombre, birads):
        ################### Almacenamiento en la BD ##############################
    idR=random.uniform(0,1000000000000000000)
    almacenamiento={"id":int(idR),"Homogeneidad":float(hckHmg),"Contraste":float(hckCntr),"Disimilitud":float(hckDismlt),
                        "Entropia":float(hckEnt),"Energia":float(hckEng),"Media":float(hckMedia),"Agrupacion":int(agrupacion),
                        "Lateralidad":int(lateralidad),
                        "Profundidad":float(profundidad),"DistanciaPezon":float(distanciaPezon),"DistanciaToracica":float(distanciaToracica),
                        "DistanciaExternon":float(distanciaEsternon),"Forma":int(forma),
                        "Bordes":float(borde),"Area":float(area),"Maligna":float(maligna),
                        "nombreCalcif":nombre, "birads": birads}
    mongoClient = MongoClient("mongodb://localhost:27017/")
    mydb=mongoClient["Calcificacion"]
    mycol=mydb["Calcificacion_calcificacion"]
    mycol.insert_one(almacenamiento)