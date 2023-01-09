# Tema X: `Collections`

Para hablar de las estructura de datos avanzadas de Java hemos de tener claros varios conceptos.

Necesitamos entender en qué consiste el interfaz `Iterable` y, para ello, hemos de tener claro el concepto de interface.

## Interfaces en Java

Para entender el funcionamiento de las _colecciones_ en java hemos de tener claro el funcionamiento de los **interfaces** (ya que `Collection` es un interfaz).

La jerarquía de interfaces y clases que veremos en este tema es el siguiente:

![Interfaces y objetos relacionados con colecciones](C:\Users\asinc\Documents\Trabajo\IES Armando Cotarelo Valledor\DAM - Prog\DAM_PR_Apuntes\docs\Tema 7\Imagenes\estructura.svg)

En primer lugar vemos que todos los elementos que vamos a ver son **iterables** ya que todos heredan de **Collection** y éste a su vez de **Iterable**.

**List**, **Set** y **Queue** son _sub-interfaces_ de **Collection** así que tendrán todas las capacidades de una colección y además cada una de ellas añadirán cualidades propias (las listas tendrán asignadas posiciones a sus elementos, etc.)

## El interfaz `Iterable`

Este interfaz se utiliza para indicar que un objeto puede ser _recorrido_, o lo que es lo mismo, se puede **iterar** sobre él. Las clases que **implementan** el interfaz `Iterable` han de tener un método que permita obtener un objeto `Iterator` que, a su vez, ha de permitir determinar si hemos llegado al final de la _lista_ (`hasNext()`) y obtener un elemento de la _lista_ y avanzar al siguiente (`next()`).

El interfaz `Iterable` utiliza **genéricos** de modo que el iterador podrá aplicarse sobre cualquier tipo de datos (clase) que deseemos.

## El interfaz `Collection`

`Collection` hereda del interfaz `Iterable`. Esto implica que toda clase que implemente `Collection` también ha de implementar los métodos que exige el interfaz `Iterable` (`iterator()`) y, a su vez, hemos de crear una clase que implemente el interfaz `Iterator` que funcione para nuestra _colección_.

Además del método anterior, `Collection`, también exige que se implementen los siguientes métodos:

* `size()`: Indicará el número de elementos que contiene la colección.
* `isEmpty()`: Indicará si la colección está o no vacía.
* `contains(Object o)`: Permite determinar si el objeto `o` se encuentra dentro de la colección.
* `containsAll(Collection c)`: Determina si una colección contiene todos los elementos de la colección `c`. 
* `add(Object o)`: Añade un elemento nuevo `o` a la colección  <b style="color:green">(opcional).</b>
* `addAll(Collection c)`: Igual al anterior pero para una colección de elementos  <b style="color:green">(opcional).</b>
* `remove(Object o)`: Elimina un objeto `o` de la colección  <b style="color:green">(opcional).</b>
* `removeAll(Collection c)`: Igual al anterior pero para una colección de elementos  <b style="color:green">(opcional).</b>
* `clear()`: Elimina todos los elementos de la colección <b style="color:green">(opcional).</b>
* `retainAll(Collection c)`: Mantendrá en la colección únicamente los elementos que también se encuentran en la colección `c` (intersección)  <b style="color:green">(opcional).</b>
* `toArray()`: Devolverá un array conteniendo todos los elementos e la colección.
* `toArray(T[] a)`:  Devolverá un array conteniendo todos los elementos de la colección; el tipo del array devuelto ha de ser el mismo del del array indicado `T`.

En una colección **no hay posiciones**. Sólo podremos añadir o eliminar elementos pero no podremos ni insertar un valor en una posición ni obtener el contenido de una posición. Podríamos decir que una `Collection` es ignorante respecto a **índice** de sus elementos.

## `List`

### `ArrayList`

### `LinkedList`

## `Queue`

### `PriorityQueue`

## `Set`

### `HashSet`

## `HashMap`

Añadimos por su utilidad este objeto aunque no sea un miembro de esta jerarquía ya que proviene del interfaz `Map`.

Un mapa será una estructura de datos que almacena los mismos en pares **clave** - **valor**. Tanto clave como valor serán objetos cuyos tipos decidimos en el momento de crear nuestro mapa.

Así, si queremos crear un mapa usando como clave valores enteros para almacenar cadenas de textos crearíamos un `HashMap` como:

```java
HashMap<Integer, String> palabras = new HashMap<>();
```





