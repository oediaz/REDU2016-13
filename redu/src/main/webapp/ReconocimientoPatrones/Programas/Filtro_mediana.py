import cv2
import argparse
class Filtro_mediana:
    def __init__(self,x):
        self.image = x
    def aplicar(self )
        # creando el analizador cv
        ap = argparse.ArgumentParser()
        ap.add_argument('-i', '--image', required = True, help = 'Path to the input image')
        args = vars(ap.parse_args()) 
        # aplicando filtro por matrices de 3x3
        processed_image = cv2.medianBlur(self.image, 3)
        # mostrando resultado
        cv2.imshow('Filtro procesado', processed_image)
        # guardando imagen
        cv2.imwrite('processed_image.png', processed_image)
        # esperando tecla para seguir
        cv2.waitKey(0)