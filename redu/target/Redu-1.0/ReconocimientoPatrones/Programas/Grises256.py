import numpy as np
import png
import pydicom
class Grises256:
    def __init__(self , x):
        self.imgpgm = x
        x.save('mmizq.pgm')
    def cambio_grises(self, x):
        # evitando perdidas flotantes
        image_2d = x.pixel_array.astype(float)
        image_2d_scaled = (np.maximum(image_2d,0) / image_2d.max()) * 255.0
        #cambio a unit8 de 256 tonos grises
        image_2d_scaled = np.uint8(image_2d_scaled)
        #guadar foto
        with open(destination, 'wb') as png_file:
        w = png.Writer(shape[1], shape[0], greyscale=True)
        w.write(png_file, image_2d_scaled)


    