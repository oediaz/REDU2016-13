import cv2
import numpy as np
from matplotlib import pyplot as plt

img = cv2.imread('01_Pruebapaciente1/ImagenesBWJPG/Imagen_Gris.jpg')
im2 = cv2.medianBlur(img,5)
cv2.imwrite('01_Pruebapaciente1/ImagenesSalyPimienta/mediana.jpg', im2)