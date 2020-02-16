"""
PROYECTO REDU - ESPE
Autor: Ponce John
Fecha: 23 de Diciembre del 2019
Inferencias del Experto
"""
from flask import Flask
from flask import render_template
from flask import request
import forms
import Prediccion_RedNeu_Inf
from docx import Document
import lecturaword

app=Flask(__name__)

@app.route('/escribir',methods=['GET','POST' ])
def index1():
    comment_form=forms.CommentForm(request.form)
    if request.method=='POST':
        print (comment_form.textinf.data)
        document = Document('Calcificaciones.docx')
        document.add_paragraph(comment_form.textinf.data)
        document.save('Calcificaciones.docx')
        lecturaword.proceso_gruardar_word('Calcificaciones.docx')
    title='Inferencias Birads'
    return render_template('index.html',title=title,form=comment_form)

@app.route('/', methods=['GET', 'POST'])
def index2():
    if request.method == 'POST': 
        lista=request.form.getlist('mycheckbox')
        lista=Prediccion_RedNeu_Inf.dividir(lista)
        resultado=Prediccion_RedNeu_Inf.busqueda(lista[0],lista[1],lista[2],"")
        
        resultado=' Porcentaje: '+str(int(resultado[0]*100))+'%    '+',\n Division: '+str(resultado[1])
        print(resultado)
        return resultado
    return render_template('index2.html')

if __name__=='__main__':
    app.run(debug=True,port =8000)

    