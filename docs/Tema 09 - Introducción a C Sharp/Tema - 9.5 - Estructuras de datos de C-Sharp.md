# Tema 9.5: Estructuras de datos

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
3. **_Filter_**: Como su nombre indica permite filtrar los elementos de una lista aplicando una condición (en forma de función).

_Map_ se denominará `Select` en C#, _reduce_ será `Aggregate` y _filter_ pasará a denominarse `Where`.

Veamos un ejemplo con cada una.

#### _Map_ / [`Select`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.enumerable.select?view=net-7.0)

Escribamos una función que eleve al cuadrado todos los elementos de un array de enteros:

```c#
int[] intArr = {1, 2, 3};
intArr = intArr.Select(elem => elem * elem).ToArray<int>();

// Ahora los valores de intArr serán [1, 4, 9].
```

#### _Reduce_ / [`Aggregate`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.enumerable.aggregate?view=net-7.0)

Esta es quizá una de las funciones más complicadas de entender de las que se pueden aplicar a listas de elementos. Esta función permite procesar una lista iterando elemento a elemento y a la vez calculando _algo_ paso a paso.

Para poder realizar este _cálculo_ es necesario que una variable _acumulador_ se pueda ir pasando a la función que se aplicará a cada elemento de la _lista_ de elementos.

```c#
int[] intArr = {1, 2, 3};

int total = intArr.Aggregate((acc, e) => acc += e);
```

El código anterior aplica la función lambda `(acc, e) => acc + e` a cada elemento de la lista teniendo en cuenta que:

1. El parámetro `e` irá tomando el valor de cada elemento del array (Enumerable) (1, 2 y 3 sucesivamente en nuestro ejemplo).
2. El parámetro `acc` es, por defecto, del mismo tipo que el contenido del Enumerable sobre el que se ejecuta.
3. El valor inicial de `acc` será 0, cadena vacía, etc. si no se le indica un valor explícitamente.
4. El valor de `acc` para cada elemento después del primero será el resultado de la función lambda.

Así, en nuestro ejemplo:

1. Primera invocación: la función se invocaría con los argumentos `(0, 1)` y retornaría `0 + 1`, es decir, `1`.
2. Segunda invocación: la función se invocaría con los argumentos `(1, 2)` y retornaría `1 + 2`, `3`.
3. Tercera invocación: la función se invocaría con los argumentos `(3, 3)` y retornaría `3 + 3`, `6`.

Para darle un valor inicial distinto de `0` al acumulador le pasaremos un argumento más a `Aggregate`:

```c#
int[] intArr = {1, 2, 3};

int total = intArr.Aggregate(100, (acc, e) => acc += e);
```

Ahora el primer valor de `acc` será `100` y el resultado final `106`.

### _Filter_ / [`Where`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.enumerable.where?view=net-7.0)

El método `Where` de los objetos que implementan `IEnumerable` (con es el caso de `Array` o `List`) permite seleccionar algunos elementos del enumerable en función del resultado (verdadero o falso) que devuelva una función lambda que se le pasa al método.

Veámoslo con un ejemplo:

```c#
int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

intArr.Where(e => e % 2 == 0).ToList().ForEach(e => System.Console.WriteLine(e));
```

El código anterior mostrará por consola el texto:

```bash
2
4
6
8
10
```

## Tuplas

Una tupla es un tipo de datos similar a un array o a una lista pero pensados para tamaños más pequeños.

Una tupla puede contener distintos tipos de datos.

Una tupa puede asignar un _nombre_ a cada uno de sus elementos.

Una tupla es parecida a un mapa de Java.

### Definición de una variable

Para declarar una variable tupla hemos de indicar el tipo de sus datos dentro de paréntesis:

```c#
(int, string, string) miTupla = (1, "uno", "one");
```

### Acceso a los elementos

Para acceder a los elementos de la tupla usaremos la palabra `ItemX` donde `X` tomará los valores 1, 2, ... para referirse al primer, segundo, etc. elemento de la misma.

```c#
(int, string, string) miTupla = (1, "uno", "one");

Console.WriteLine(miTupla.Item1 == 1);
```

### Nombrando elementos

Para evitar tener que utilizar `Item1`, `Item2`, etc. que tienen muy poco significado podemos darles nombres a los elementos de la tupla:

```c#
(Value: int, Spanish: string, English: string) = (1, "uno", "one");

Console.WriteLine($"valor: {miTupla.Value}, español: {miTupla.Spanish} e inglés: {miTupla.English}.");
```
