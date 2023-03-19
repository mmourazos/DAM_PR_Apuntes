# Ejercicios Tema 2: Programación estructurada, arrays y cadenas

Los ejercicios de este tema se centrarán en la manipulación de arrays y cadenas utilizando sus métodos así como los elementos (bifurcación condicional y bucles) de la programación estructurada.

## Ejercicio 1

Escribe un programa que pida al usuario dos palabras por consola e indique si son iguales o disntintas.

*[Solución ejercicio 1](Soluciones%20-%20extra/Ejercicio1.java).*

## Ejercicio 2

Tomando como base el código del ejercicio anterior, haz que el programa nos indique que palabra está antes lexicográficamente.

*[Solución ejercicio 2](Soluciones/Ejercicio2.java).*

## Ejercicio 3

Haz ahora que el programa permita introducir hasta 10 palabras y las almacene en un array de cadenas. El usuario podrá interrumpir la introducción de cadenas si pulsa ENTER sin escribir nada (cadena vacía).

Una vez terminada la introducción de cadenas muestra al usuario la lista de palabras introducidas.

*[Solución ejercicio 3](Soluciones/Ejercicio3.java).*

## Ejercicio 4

Modifica el programa anterior para que ordene las palabras introducidas previamente por el usuario.
*(Pista: `java.util.Arrays.sort()`).*

*[Solución ejercicio 4](Soluciones/Ejercicio4.java).*

## Ejercicio 5

Haz que el programa ponga el mayúsculas la primera letra de cada palabra.

*[Solución ejercicio 5](Soluciones/Ejercicio5.java).*

## Ejercicio 6

Crea un método (estático) que reciba un array de palabras como entrada y devuelva una copia del array con las palabras ordenadas.

### EXTRA

Ejercicio opcional.

Escribe en  programa que permita al usuario introducir una lista de palabras (sin límite predefinido).

Una vez haya terminado (cuando inserte una palabra *vacía*).

Se le mostrará la lista de palabras y se le perdirá que la ordene.

Para ello se le pedirán dos números que indicarán al programa las posiciones de dos palabras de la lista que ha de intercambiar.

Esto se repetirá hasta que la lista esté ordenada.

El programa ha de:

* Comprobar que el usuario introduce palabras simples (sin espacios o mayúsculas).
* Comprobar que los índices son válidos (el usuario no intenta acceder a índices fuera del array).
* Verificar si el array ordenado por el usuario está correctamente ordeando.

***Pistas:***

* [`ArrayList`](https://www.w3schools.com/java/java_arraylist.asp).
* [`ArrayList.sort(null)`](https://www.programiz.com/java-programming/library/arraylist/sort).
