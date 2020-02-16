
#import pydicom
#import cv2 
#import os 
#from PIL.Image import fromarray

#im=cv2.imread('Mamografia 1.dcm') 
#cv2.imwrite('pr1.jpg', im) 
#pylab.imsave('mmizq.tiff',x.pixel_array,cmap=pylab.cm.bone)
#import pydicom
#from PIL.Image import fromarray

#import pydicom
#import PIL
#from matplotlib import pyplot as plt
#filename = "mmizq.dcm"
#ds = pydicom.dcmread(filename)
#ds.pixel_array
#ds.save_as("afterpre.jpeg")

#filename = "Mamografia 1.dcm"
#ds = pydicom.dcmread(filename)
#im = fromarray(ds.pixel_array)
#im.convert('I').save('im_convert.tif')
#C:/Users/Administrador/Documents/GitHub/redu/redu/src/main/webapp/ReconocimientoPatrones/Programas/01_Pruebapaciente1/ImagenesFuente
import matplotlib.pyplot as plt
import pydicom
from PIL import Image
from PIL.Image import fromarray
from pydicom.data import get_testdata_files

print(__doc__)

filename = '01_Pruebapaciente1/ImagenesFuente/mmizq.dcm'
dataset = pydicom.dcmread(filename)

# Normal mode:
print()
print("Filename.........:", filename)
print("Storage type.....:", dataset.SOPClassUID)
print()

pat_name = dataset.PatientName
display_name = pat_name.family_name + ", " + pat_name.given_name
print("Patient's name...:", display_name)
print("Patient id.......:", dataset.PatientID)
print("Modality.........:", dataset.Modality)
print("Study Date.......:", dataset.StudyDate)

if 'PixelData' in dataset:
    rows = int(dataset.Rows)
    cols = int(dataset.Columns)
    print("Image size.......: {rows:d} x {cols:d}, {size:d} bytes".format(
        rows=rows, cols=cols, size=len(dataset.PixelData)))
    if 'PixelSpacing' in dataset:
        print("Pixel spacing....:", dataset.PixelSpacing)

# use .get() if not sure the item exists, and want a default value if missing
print("Slice location...:", dataset.get('SliceLocation', "(missing)"))

# plot the image using matplotlib
im = fromarray(dataset.pixel_array)
im = im.convert('I').save('01_Pruebapaciente1/ImagenesTiff/im.tiff')
plt.imsave('01_Pruebapaciente1/ImagenesJPG/img.jpg',dataset.pixel_array,cmap=plt.cm.bone)
