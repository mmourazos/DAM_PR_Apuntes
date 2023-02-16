# Tema 9.2: Estructuras de datos

En este tema veremos de manera resumida las estructuras más comunes que se utilizan en C#.

Empezaremos por las más sencillas como son arrays y tuplas, y continuaremos con las que hacen uso de genéricos como lista, pila, cola y diccionario.

## Arrays

Los arrays en C# son idénticos a los de Java.

### Declaración de un array

Al igual que en Java se declaran indicando:

```c#
// tipo seguido de [ y ] y el nombre de la variable.
int[] arrayDeEnteros;

// Opcionalmente se puede crear el array don un tamaño.
int[] arrayDe5Enteros = new int[5];

// O también se pueden asignar directamente valores.
int[] arrayConValores = {1, 2, 3};
```

### Acceso a sus elementos

Para acceder a un elemento concreto del array indicaremos al lado de la variable, entre corchetes, la posición o índice del elemento. Recordemos que el primer elemento tendrá índice 0:

```c#
int[] intArr = {1, 2, 3};
int[1] = int[1] * 10;
// Ahora el array será [1, 20, 3]
```

Para recorrer los elementos de un array se empleará la estructura `foreach`:

```c#
foreach (int i in intArr) {
    //...
}
```

### Longitud de un array

Para ver la longitud de un array hemos de acceder a la propiedad `Length` o `LongLength`.

### Funciones de arrays (y colecciones en general)

Hay tres funciones que se suele aplicar sobre las estructura tipo colección como son los arrays o las listas. Estas funciones son generalmente conocidas como _map_, _reduce_ y _filter_:

1. **_Map_**: Permite transformar una lista aplicando una función a cada uno de sus elementos.
2. **_Reduce_**: Permite... permite hacerle de todo a los elementos de una lista.
3. **_Filter_**: Como su nombre indica permite filtrar los elementos de una lista aplicándo una condición (en forma de función).

_Map_ se denominará `Select` en C#, _reduce_ será `Aggregate` y _filter_ pasará a denominarse `Where`.

Veamos un ejemplo con cada una.

#### _Map_ / `Select`

Escribamos una función que eleve al cuadrado todos los elementos de un array de enteros:

```c#
int[] intArr = {1, 2, 3};
intArr = intArr.Select(elem => elem * elem).ToArray<int>();

// Ahora los valores de intArr serán [1, 4, 9].
```

#### _Reduce_ / `Aggregate`

```c#
```

### _Map_, _reduce_ y _filter

Para 


## Tuplas

## Genéricos

### Declaración de genéricos

## Listas

## Pilas

## Colas

## Mapas
