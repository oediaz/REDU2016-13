import cv2
class Bordes:
    def __init__(self,x):
        self.image = x
    def top_Hat(self, x): #deteccion de borde introspectivo
        # estructurando
        kernel = cv2.getStructuringElement(cv2.MORPH_RECT,(25,25))
        # aplicando filtro
        tophat = cv2.morphologyEx(self.image, cv2.MORPH_TOPHAT, kernel)
        blackhat = cv2.morphologyEx(self.image, cv2.MORPH_BLACKHAT, kernel)