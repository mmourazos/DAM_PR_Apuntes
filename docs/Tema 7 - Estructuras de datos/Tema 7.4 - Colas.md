# Tema 7.4: Colas, interfaz `Queue`

Las colas de Java funcionan como las colas _en el mundo real_. Los elementos se añaden al final de la cola y se extraen del principio: primero en entrar, primero en salir (FIFO: _First In, First Out_).

Las clases que implementen esta interfaz emularán el comportamiento de una cola utilizando los siguientes métodos:

* `boolean add(E e)`: Añade el elemento `e` al final de la cola. Devuelve `true` si se ha podido añadir y **lanzará una excepción** `IllegalStateException` si no hay espacio disponible.
* `boolean offer(E e)`: Inserta el elemento `e` al final de la cola. Devuelve `true` si se ha podido añadir y `false` si no hay espacio disponible.
* `E element()`: Devuelve el primer elemento de la cola. **Lanzará una excepción** `NoSuchElementException` si la cola está vacía. **Sin eliminar el elemento de la cola**.
* `E peek()`: Devuelve el primer elemento de la cola. Devuelve **`null` si la cola está vacía**. **Sin eliminar el elemento de la cola**.
* `E poll()`: Devuelve el primer elemento de la cola. **Devuelve `null` si la cola está vacía**. **Eliminando el elemento de la cola**.
* `E remove()`: Devuelve el primer elemento de la cola. **Lanzará una excepción** `NoSuchElementException` si la cola está vacía. **Eliminando el elemento de la cola**.

Como podemos ver hay dos métodos para cada operación, uno de ellos lanza una excepción si no se puede realizar la operación y el otro devuelve un valor especial para indicar que no se ha podido realizar la operación:

* Inserción de un elemento al final de la cola: `add` lanza una excepción (`IllegalStateException`) si no hay espacio libre (colas con límite de tamaño) y `offer` devolverá falso si no pudo insertar.
* Leer el elemento cabeza de la cola sin sacarlo: `element` lanza una excepción (`NoSuchElementoException`) si la cola está vacía y `peek` devuelve `null` si la cola está vacía.
* Extraer el elemento cabeza de la cola: `remove` lanza una excepción (`NoSuchElementException`) si la cola está vacía y `poll` devuelve `null` si la cola está vacía.

## `PriorityQueue`

La clase `PriorityQueue` implementa el interfaz `Queue`. Además los elementos de la cola se _ordenan_ según su _prioridad_, que se define mediante un objeto `Comparator` que se pasa al constructor de la cola. Si no se pasa ningún `Comparator` se usará el orden natural de los elementos.

Esto **no significa** que los elementos se ordenen automáticamente cuando se añaden a la cola. Los elementos se obtendrán ordenados cuando se extraigan de la cola.

### Comparadores

Un comparador será un objeto que implemente la interfaz `Comparator`. Ésta exige que se implemente el método `compare` que recibe dos objetos y devuelve un entero que indica si el primer objeto es menor (menor que 0), igual (0) o mayor que el segundo (mayor que 0).

```java
public class ComparadorInverso implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}
```

```java
public class Main {
    public static void main() {
        PriorityQueue<Integer> cola = new PriorityQueue<>(new ComparadorInverso());
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);
        cola.add(6);
        cola.add(7);
        cola.add(8);
        cola.add(9);
        cola.add(10);
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }
}
```

### Interfaz `Comparator`

Este interfaz le concede a un objeto la capacidad de establecer un orden sobre un tipo de objetos. Para ello, el objeto debe implementar el método `compare` que recibe dos objetos del tipo que se quiere ordenar y devuelve un entero que indica si el primer objeto es menor (menor que 0), igual (0) o mayor que el segundo (mayor que 0).

```java
// Si queremos establecer una cola de prioridad para personas en las que se priorice la edad de menor a mayor:
public class MiComparador implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getEdad() - p2.getEdad();
    }
}
```
