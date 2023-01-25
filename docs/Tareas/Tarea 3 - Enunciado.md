# Tema 7 - Tarea 1: Iterables

La tarea 1 estará dividida en tres partes:

1. Crea una clase Abecedario que implemente el interfaz Iterable y que permita iterar sobre las letras del abecedario.
2. Modifica la clase interna que implementa Iterator añadiendo dos nuevos métodos:
   1. `hasNextVocal()`: Que indicará si existe una nueva vocal.
   2. `nextVocal()`: Que devolverá la siguiente vocal.
3. Utiliza el iterador modificado para iterar sobre las vocales. Puedes realizar más modificaciones en la clase si lo estimas oportuno.
4. Crea una subclase Vocales de la clase Abecedario que permita iterar (utilizando el bucle for-each) sobre las vocales.

La entrega se realizará mediante un archivo comprimido con el código fuente.

Fecha de entrega límite: domingo 22 de enero a las 00:00.

## Ejemplos

La implementación de las clases ha de cumplir:

```java
Abecedario abc = new Abecedario();
   for (char x : abc) { System.out.println("caracter: " + x);
}
// La salida por consola debería ser:
// caracter: a
// caracter: b
// caracter: c
// caracter: d
// caracter: e
// ...

AbecedarioB abcb = new AbecedarioB();
AbecedarioB.VocIt iter = abcb.iterator();
while(iter.hasNextVocal()) {
   System.out.println("vocal: " + iter.nextVocal());
}
// La salida por consola debería ser:
// vocal: a
// vocal: e
// vocal: i
// ...

Vocales voc = new Vocales();
for (char x : voc) {
   System.out.println("Vocal: " + x);
}
// La salida por consola debería ser:
// Vocal: a
// Vocal: e
// Vocal: i
// ...
```
