# Tema 7.2: `Collections`

Para hablar de las estructura de datos avanzadas de Java hemos de tener claros varios conceptos.

Necesitamos entender en qué consiste el interfaz `Iterable` y, para ello, hemos de tener claro el concepto de interface.

## Interfaces en Java

Para entender el funcionamiento de las _colecciones_ en java hemos de tener claro el funcionamiento de los **interfaces** (ya que `Collection` es un interfaz que implementan todas las estructura de datos de java).

### Función de un interfaz

Un interfaz define total o parcialmente una serie de métodos. Los métodos son, conceptualmente, la forma en que podemos interactuar con un objeto. De este modo podemos decir que cada interfaz define **una forma de interactuar con un objeto**. El objeto **implementa los métodos necesarios para realizar dicha interacción**.

Estas interacciones en la práctica se concretan en una funcionalidad. Es decir, los métodos que se definen en el interfaz permiten que los objetos que lo implementen sean capaces de realizar una serie de operaciones.

Por ejemplo, los objetos cuya clase implemente el interfaz **iterable** podrán ser **iterados empleando el bucle `for-each`**. Los objetos cuya clase implemente el interfaz **Comparable** podrán ser _ordenados_ usando las funciones de ordenación. etc.

## Interfaces y clases de las colecciones

La jerarquía de interfaces y clases que veremos en este tema es el siguiente:

![Interfaces y objetos relacionados con colecciones](./Imagenes/estructura.svg)

En primer lugar vemos que todos los elementos que vamos a ver son **iterables** ya que todos heredan de **Collection** y éste a su vez de **Iterable**.

**List**, **Set** y **Queue** son _sub-interfaces_ de **Collection** así que tendrán todas las capacidades de una colección y además cada una de ellas añadirán cualidades propias (las listas tendrán asignadas posiciones a sus elementos, etc.)

## El interfaz `Iterable`

Este interfaz se utiliza para indicar que un objeto puede ser _recorrido_, o lo que es lo mismo, se puede **iterar** sobre él. Las clases que **implementan** el interfaz `Iterable` han de implementar un método (`iterator()`) que permita obtener un objeto `Iterator` que, a su vez, ha de permitir determinar si hemos llegado al final de la _lista_ (`hasNext()`) y obtener un elemento de la _lista_ y avanzar al siguiente (`next()`).

El interfaz `Iterable` utiliza **genéricos** de modo que el iterador podrá aplicarse sobre cualquier tipo de dato (clase) que deseemos.

### El interfaz `Iterator`

Como acabamos de ver el interfaz `Iterable` exige que se implemente un método (`iterator()`) que devuelva un objeto `Iterator`. Este objeto `Iterator` es el que se encarga de recorrer la _lista_ y de devolver los elementos de la misma.

Al igual que el interfaz `Iterable`, el interfaz `Iterator` utiliza **genéricos** de modo que el iterador podrá aplicarse sobre cualquier tipo de dato que deseemos. El tipo de dato que se utilice en el interfaz `Iterator` ha de ser el mismo que se utilice en el interfaz `Iterable`.

Por último `Iterator` exige que se implementen los siguientes métodos:

* `hasNext()`: Devuelve `true` si quedan elementos por recorrer y `false` en caso contrario.
* `next()`: Devuelve el siguiente elemento de la _lista_ y avanza el iterador al siguiente elemento.

De este modo podemos recorrer una _lista_ usando un bucle while:

```java
// Creemos primero un iterable como por ejemplo una lista de cadenas:
Lista<String> lista = new ArrayList<String>();
lista.add("Hola");
lista.add("Mundo");
lista.add("!");

// Ahora podremos acceder a su iterador:
Iterator<String> iterador = lista.iterator();

// Y recorrerla usando un bucle while:
while (iterador.hasNext()) {
    System.out.println(iterador.next());
}

// o usando un bucle for:
for (Iterator<String> iterador = lista.iterator(); iterador.hasNext(); ) {
    System.out.println(iterador.next());
}

// o usando un bucle for-each (lo más sencillo en el caso de un iterable):
for (String elemento : lista) {
    System.out.println(elemento);
}
```

Puesto que el **iterador** estará muy ligado a la **colección** que estamos recorriendo, es habitual que se implemente como una **clase interna** de la **colección**.

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
