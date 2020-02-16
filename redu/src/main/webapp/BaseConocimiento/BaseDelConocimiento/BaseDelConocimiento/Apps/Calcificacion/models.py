from django.db import models
from mongoengine import *
# Create your models here.
class Calcificacion(models.Model):
    Homogeneidad=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Contraste=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Disimilitud=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Entropia=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Energia=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Media=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Agrupacion=models.IntegerField(null=True)
    Lateralidad=models.IntegerField(null=True)
    Profundidad=models.IntegerField(null=True)
    DistanciaPezon=models.DecimalField(max_digits=20, null=True ,decimal_places=5)
    DistanciaToracica=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    DistanciaExternon=models.DecimalField(max_digits=20, null=True, decimal_places=5)
    Forma=models.IntegerField(null=True)
    Bordes=models.IntegerField(null=True)
    Area=models.DecimalField(max_digits=20, null=True ,decimal_places=5)
    Maligna=models.IntegerField(null=True)
    nombreCalcif=models.CharField(max_length=30, help_text="Nombre de la Calcificación",null=True)
    birads=models.CharField(max_length=30, help_text="BI-RADS",null=True)


    def tipoCalf(self):
        if self.Maligna == 0:
            cadena="Calcificación Benigna. Homogeneidad: {0}, Contraste: {1}, Disimilitud: {2}, Entropía: {3}, Energía: {4}"
        else:
            cadena= "Calcificación Maligna. Homogeneidad: {0}, Contraste: {1}, Disimilitud: {2}, Entropía: {3}, Energía: {4}"
        return cadena.format(self.Homogeneidad, self.Contraste, self.Disimilitud, self.Entropia, self.Energia)

    def __str__(self):
        return self.tipoCalf()

        