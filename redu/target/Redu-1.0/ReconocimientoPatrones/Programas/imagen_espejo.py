from os.path import exists
from PIL import Image, ImageTk, ImageFilter

def flip(im):
    '''Flips a picutre horizontally, and returns a new image that is a mirror view of the original'''
    org=Image.open(im)
    new=Image.new("RGB",org.size)   
    a = org.size[0]-1
    for x in range(org.size[0]):
        for y in range(org.size[1]):
            pixel=org.getpixel((x,y))
            new.putpixel((a,y),pixel)
        a-=1
    new.save("new.bmp","bmp")