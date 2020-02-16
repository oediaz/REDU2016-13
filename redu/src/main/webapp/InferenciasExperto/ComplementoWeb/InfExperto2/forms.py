from wtforms import Form
from wtforms import StringField,TextField,SelectMultipleField,widgets,TextAreaField
from wtforms.fields.html5 import EmailField


class CommentForm(Form):
    textinf=TextAreaField('textinf')


class MultiCheckboxField(SelectMultipleField):
    widget = widgets.ListWidget(prefix_label=False)
    option_widget = widgets.CheckboxInput()