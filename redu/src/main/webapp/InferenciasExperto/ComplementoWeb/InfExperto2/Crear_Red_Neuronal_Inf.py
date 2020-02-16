"""
PROYECTO REDU - ESPE
Autor: Ponce John
Fecha: 23 de Diciembre del 2019
Inferencias del Experto
"""
from keras.models import Sequential
from keras.layers import Dense
import csv
import numpy
import json
import os

#Crea el modelo de red neuronal, lo entrena y lo guarda
def crearmodelo():
    dataset = numpy.loadtxt("datasetPreprocesado.csv", delimiter=",")
    X = dataset[:,2:]
    Y = dataset[:,1]
    # crea el modelo
    model = Sequential()
    model.add(Dense(30, input_dim=54, activation='relu'))
    model.add(Dense(50, activation='relu'))
    model.add(Dense(1, activation='sigmoid'))
    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
    model.fit(X, Y, epochs=100, batch_size=10)
    model_json = model.to_json()
    with open("model.json", "w") as json_file:
        json_file.write(model_json)
    # serializar los pesos a HDF5
    model.save_weights("model.h5")
    print("Modelo Guardado!")


crearmodelo()