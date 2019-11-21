
import pydicom
import pylab
import matplotlib.pyplot as plt
in_path = 'mmizq.dcm'
ds = pydicom.read_file (in_path) # read the file .dcm
pylab.imsave('mmizq.tiff',ds.pixel_array,cmap=pylab.cm.bone)