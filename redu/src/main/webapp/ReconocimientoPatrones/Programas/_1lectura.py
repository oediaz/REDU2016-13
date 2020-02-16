import cv2
import numpy as np
import matplotlib.pyplot as plt
import pydicom
import os
import sys
from pydicom.data import get_testdata_files
from pydicom import dcmread, dcmwrite
from skimage.io import imread, imshow
from skimage.color import rgb2gray
from skimage import img_as_ubyte
def read_dicom_image(path2dcm, dcm_name):
    dataset = dcmread(os.path.join(path2dcm, dcm_name))
    print("Filename........:", dcm_name)
    print("Modality........:", dataset.Modality)
    print("Study Date........:", dataset.StudyDate)
    img = dataset.pixel_array
    print("Mammogram Dimensions........:", np.shape(img))
    max_pixel = np.max(img)
    
    if max_pixel > 255:
        # convert image from uint16 to uint8
        print('pixel max value of %5d \nconverting to uint8'%(max_pixel))
        img_1 = img_as_ubyte(img)
    else:
        img_1 = img
    if len(np.shape(img_1))==3:
        img_gray = rgb2gray(img_1)
    else:
        img_gray = img_1    
    return img_gray