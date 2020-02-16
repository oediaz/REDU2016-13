import os
import shutil
dir=os.getcwd()
dir= dir + '/01_Pruebapaciente1'
os.mkdir(dir)
direc= dir + '/ImagenesBWJPG'
os.mkdir(direc)
direc= dir + '/ImagenesFuente'
os.mkdir(direc)
direc= dir + '/ImagenesPreprocesadas'
os.mkdir(direc)
direc= dir + '/ImagenesSalyPimienta'
os.mkdir(direc)
direc= dir + '/ImagenesTiff'
os.mkdir(direc)
direc= dir + '/PatronesCaracterizados'
os.mkdir(direc)
direc= dir + '/PatronesExtraidos'
os.mkdir(direc)
direc= dir + '/ImagenesJPG'
os.mkdir(direc)
shutil.move("mmizq.dcm", "01_Pruebapaciente1/ImagenesTiff/mmizq.dcm")
#C:\Users\Administrador\Documents\GitHub\redu\redu\src\main\webapp\ReconocimientoPatrones\Datos\Imagenes
