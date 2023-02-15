# Tema 7.3: Listas

## `List`

El interfaz `List` indica que una colección de elementos se encuentra agrupado en forma de lista (existe un orden en el almacenamiento). En una lista podremos acceder a cada elemento indicando su índice o posición dentro de la lista (empezando a contar en cero).

A diferencia de un conjunto, una lista admite elementos duplicados.

Además de los métodos requeridos por el interfaz `Collection`, el interfaz `List` requiere que se implementen los siguientes métodos:

* `T get(int index)`: Nos devolverá el elemento (de tipo T :arrow_right: genéricos) que se encuentra en la posición `index` de la lista (la primera posición de la lista será 0).
* `T set(int index, T element)`: Coloca el valor `element` en la posición `index` de la lista y devuelve el elemento que se encontraba antes en dicha posición.
* `void add(int index, T element)`: Añade o inserta el elemento `element` en la posición `index` de la lista.
* `T remove(int index)`: Elimina el elemento que se encuentra en la posición `index` de la lista y lo devuelve como resultado.
* `int indexOf(Object o)`: Devuelve la posición de la primera aparición del elemento `o` de la lista.
* `int lastIndexOf(Object o)`: Devuelve la posición d
* e la última aparición del elemento `o` en la lista.
* `ListIterator<T> listIterator()`: Devuelve un tipo especial de iterador `ListIterator`.
* `ListIterator<T> listIterator(int index)`: Devuelve un tipo especial de iterador `ListIterator` _apuntando_ a la posición `index` de la lista.
* `List<T> subList(int fromIndex, int toIndex)`: Devuelve una lista conteniendo los elementos desde la posición `fromIndex` (incluyéndola) hasta la posición `toIndex` (excluyéndola).

## `ArrayList`

La clase `ArrayList` implementa una lista de elementos que internamente se almacenan en un **array**. Esta clase es muy eficiente para acceder a sus elementos de ya que se puede acceder a ellos indicando su posición (índice) y no es necesario recorrer la lista para encontrarlos (pues estamos trabajando por debajo con un array).

A diferencia de un array, el tamaño de un `ArrayList` puede crecer o decrecer dinámicamente. Los elementos de un `ArrayList` pueden ser de cualquier tipo (genéricos).

Puesto que un `ArrayList` guarda internamente los datos en un array tendrá problemas cuando al crecer de tamaño. Si va creciendo llegará un momento en que se quede sin espacio en el array interno. Para poder almacenar más valores cuando ya esté lleno se verá obligado a crear un array con más espacio libre y copiar los valores del array viejo al nuevo. Esta operación llevará bastante tiempo.

### Ejemplo de uso

```java
ArrayList<String> lista = new ArrayList<>();

lista.add("Hola");
lista.add("Mundo");
lista.add("Cruel");
lista.add("!");

// Para mostrar el contenido de la lista podemos usar un bucle for-each:
for (String s : lista) {
    System.out.println(s);
}

// O directamente el método toString() de la lista:
System.out.println(lista);

// Podemos acceder a los elementos de la lista indicando su posición:
for (int i = 0; i < lista.size(); i++) {
    System.out.printf("Elemento número %d: %s.%n", i, lista.get(i));
}
```

## `LinkedList`

El funcionamiento de una `LinkedList` es similar al de un `ArrayList` pero internamente no se almacenan los elementos en un array sino en una [**lista enlazada**](https://es.wikipedia.org/wiki/Lista_enlazada). Esto hace que **la inserción y eliminación de elementos** sea más eficiente que en un `ArrayList` pero el acceso a un elemento concreto es, en general, más lento.

Si necesitamos guardar una _lista_ de datos que no va a cambiar mucho a lo largo del tiempo pero a la que vamos a acceder con frecuencia, es mejor usar un `ArrayList`. Si, por el contrario, vamos a modificar la lista con más frecuencia de la que vamos a acceder a ella es mejor usar un `LinkedList`.

## `ArrayList` vs `LinkedList`

Resumiendo, el acceso a una posición es _instantánea_ en un `ArrayList` pero dependerá de la posición en un `LinkedList`. La inserción y eliminación de elementos es _lenta_ (algunas veces habrá que cambia rel tamaño) en un `ArrayList` pero _instantánea_ en un `LinkedList`.