import dicom
import os
import numpy
import Image
import PIL.ImageOps
import pylab
from matplotlib import pyplot, cm

class Lectura:
    def conversion_tiff(x):
        for key in x.image.dir():      
        if type(value) is dicom.UID.UID or key == "PixelData":
        continue
        pylab.imsave('mmizq.tiff',x.pixel_array,cmap=pylab.cm.bone)

        