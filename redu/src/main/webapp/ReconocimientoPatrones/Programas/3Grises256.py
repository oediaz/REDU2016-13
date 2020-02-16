from PIL import Image
import matplotlib.pyplot as plt
def escala_de_grises():
    #Abrimos la Imagen
    im = Image.open('01_Pruebapaciente1/ImagenesJPG/img.jpg')
    #Obtenemos sus dimensiones
    x = im.size[0]
    y = im.size[1]
    #Creamos una nueva imagen con las dimensiones de la imagen anterior
    im2 = Image.new('RGB', (x, y))
    i = 0
    while i < x:
        j = 0
        while j < y:
            #Obtenemos el valor RGB de cada pixel
            r, g, b = im.getpixel((i,j))
            #Obtenemos su equivalente en la escala de gris
            p = (r * 0.3 + g * 0.59 + b * 0.11)
            #Ese valor lo convertimos a entero
            gris = int(p)
            pixel = tuple([gris, gris, gris])
            im2.putpixel((i,j), pixel)
            j += 1
        i += 1
    #Guardamos la imagen
    im2.save('01_Pruebapaciente1/ImagenesBWJPG/Imagen_Gris.jpg')
    im2.save('01_Pruebapaciente1/ImagenesBWJPG/Imagen_Gris.png')
escala_de_grises()