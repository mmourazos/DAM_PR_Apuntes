# Tema 11: Introducción a las clases en Python

## Clase como tipo

TODO: Usar type para ver ejemplos de los tipos de clases y objetos / variables.

## Declaración de una clase

```python
class MiClase:
    # Código de la clase.
```
### Creación de una instancia u objeto

```python
mi_objeto = MiClase()
```

### Propiedades de la clase

Las propiedades de la clase son variables que se declaran justo después de la declaración con el nombre de la clase.

```python
class MiClase:
    mi_variable = 0
```

Para acceder a una propiedad de la clase podremos:

* Indicar el nombre de la clase que la contiene seguido de punto y el nombre de la variable: `MiClase.mi_variable`.
* Indicar el nombre de un objeto de la clase seguido de punto y el nombre de la variable.

#### Propiedades _privadas_ u _ocultas_

Para _ocultar_ una propiedad y de este modo hacerla _privada_ hemos de precederla por `__`:

```python
class MiClase:
    mi_variable = 0
    __variable_oculta = 10
```

Si intentamos acceder a esta variable como:

```python
MiClase.__variable_oculta = 100
```

##### ¿Por qué _privada_ u _oculta_?

A diferencia de otros lenguajes de programación como Java que realmente ocultan sus atributos privados, los atributos privados de una clase de Python siguen siendo accesibles.

Para acceder a una variable privada **Cosa que NO DEBEMOS HACER** hemos de escribir lo siguiente:

```python
[nombre de la clase / objeto]._[nombre de la clase]__[nombre de la variable]
```

Obtendremos un error `AttributeError`

### El método Constructor

Cuando declaremos un método perteneciente a una clase **siempre** hemos de declarar un primer atributo que hace referencia al objeto.
Este argumento, aunque puede llevar cualquier nombre, por convenio se nombra como `self`

```python
class MiClase:
    def __init__(self):
        pass
```

### Variables de instancia u objeto

Para declarar una variable propia del objeto hemos de hacerlo dentro del constructor:

```python
class Punto:
    instancias = 0

    def __init__(self, x: float, y: float) -> None:
        self.x = x
        self.y = y
        instancias += 1
```