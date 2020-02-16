from scipy import misc
import cv2
import numpy as np

img = cv2.imread('pt1.jpg', 0)
img = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY)[1]  # ensure binary
ret, labels = cv2.connectedComponents(img)

def imshow_components(labels):
    # Map de umbral con degradacion segun metodo otsu
    label_hue = np.uint8(179*labels/np.max(labels))
    blank_ch = 255*np.ones_like(label_hue)
    labeled_img = cv2.merge([label_hue, blank_ch, blank_ch])

    # cvt a BGR para mostrar
    labeled_img = cv2.cvtColor(labeled_img, cv2.COLOR_HSV2BGR)

    # recorte en la zona del seno 
    labeled_img[label_hue==0] = 0
    print(cv2.merge([label_hue, blank_ch, blank_ch]))
    cv2.imwrite('labeled1.png', labeled_img)
imshow_components(labels)
face = misc.imread('labeled.png')