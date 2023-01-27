# Tema 7 - tarea 4: Calculo tiempos

Se han de crear dos listas: `ArrayList` y `LinkedList`.

Se pedirá por pantalla un tamaño para ambas listas.

Se pedirá también el número de veces que se han de repetir las pruebas.

Se calculará y mostrará el resultado medio para cada tipo de prueba realizado.

Se realizarán las siguientes operaciones con cada lista:

1. Se insertará en cada una de las listas tantos elementos (números enteros) como su tamaño.
2. Recorreremos cada lista desde el final al principio.
3. Comprobar (`contains()`) que contiene todos los elementos.
4. Eliminar los elementos de la lista:
   * Comenzando por el principio.
   * Comenzando por el final.

Mediremos el tiempo que se tarda en realizar cada operación (para todos los elementos).

**Nota:** Para medir tiempos se recomienda usar `LocalTime`.

```java
// Apunto el tiempo en este instante: t0
long t0 = System.nanoTime();
// Ejecuto lo que quiero medir

// Apunto el tiempo en este instante: t1
long t1 = System.nanoTime();

// Calculo el tiempo pasado entre t0 y t1: t1 - t0.
long tiempoTranscurrido = t1 - t0;
```
