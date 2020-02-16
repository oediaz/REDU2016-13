import json
datos = {
    'Patron nro:' : '',
    'Area'   :  '',
    'Forma'  : '',
    'Bordes' : '',
    'Contraste' : ''
}

for i in range(3):
    patron= 'datos'
    patron = patron + str(i) + '.json'
    with open(patron, 'w') as file:
        json.dump(datos, file)