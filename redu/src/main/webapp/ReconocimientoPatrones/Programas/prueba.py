import cv2
import numpy as np
import pydicom
import os
from skimage.measure import label, regionprops
import sys
import _1lectura,_2enmascarada,_3regionRoi
dcm_path = "01_Pruebapaciente1/ImagenesFuente/"
# Esta linea genera la lista de nombres de imagenes contenidas en la carpeta mammogram images
# input_mammograms = os.listdir(images_path)
input_dcm = "mmizq.dcm"
# input_dcm = "cbisddsm.dcm"
img = _1lectura.read_dicom_image(path2dcm=dcm_path, dcm_name=input_dcm)
img_bin = _2enmascarada.morph_oper(img, kernel_size=18)
minr, minc, maxr, maxc, max_area, min_area = _3regionRoi.get_roi_rect(img_bin)
img_roi = img[minr:maxr, minc:maxc]
label_image = label(img_bin)
max_row_img, max_col_img = np.shape(img)
img_no_roi = img_bin[0:max_row_img, maxc:max_col_img]
cv2.imwrite('1.jpg',img_no_roi)