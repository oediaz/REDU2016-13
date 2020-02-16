from django.shortcuts import render
from django.http import HttpResponse, Http404
from BaseDelConocimiento.Apps.Calcificacion.models import Calcificacion
from django.shortcuts import get_object_or_404, render_to_response
from BaseDelConocimiento.analisis import AnalisisDatos
from django.core.files.storage import FileSystemStorage
from BaseDelConocimiento import analisis 
# Create your views here.

def index(request):
    calcificaciones=Calcificacion.objects.all()
    return render_to_response('calcificacion/index.html', 
    {'calcificaciones':calcificaciones})
    
def upload(request):
    if request.method == 'POST':
        archivo=request.FILES['archivo']
        fs=FileSystemStorage()
        fs.save(archivo.name, archivo)
        path="C:/Users/Administrador/Documents/GitHub/redu/redu/src/main/webapp/BaseConocimiento/BaseDelConocimiento/Json/{0}"
        AnalisisDatos.cargarJson(path.format(archivo.name))
    return render(request, 'calcificacion/upload.html')