from django import forms
class CalcificacionForm(forms.Form):
    asunto=forms.CharField(max_length=100, required=True)