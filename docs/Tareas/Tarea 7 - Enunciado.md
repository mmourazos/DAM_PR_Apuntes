# Tema 8 - Tarea1: Lectura y escritura

Crea una clase `Main` y dentro de ella los métodos **estáticos** que se indican en los siguientes apartados.

## Ejercicio 1: Escribe texto a un fichero

Crea un método con la siguiente firma `public static void writeTextToFile(String fn, String txt)` donde `fn` será el nombre de un fichero y `txt` un texto. Este método escribirá el text `txt` dentro del fichero de nombre `fn`.

## Ejercicio 2: Añadir texto a un fichero

Escribe un método con la siguiente firma `public static void appendTextToFile(String fn, String txt)` de modo que **añada** el texto `txt` al fichero de nombre `fn`.

## Ejercicio 3: Añadir varias líneas a un fichero

Escribe un método con la siguiente declaración `public static void appendLinesToFile(String fn, List<String> lines)` de modo que añada las cadenas de la lista al fichero.

## Ejercicio 4: Leer texto de un fichero

Escribe un método con la forma `public static List<String> readLinesFromFile(String fn)` que devuelva en una lista las líneas del fichero de nombre `fn`.

## Ejecución

En el método `public static void main(String[] args)` de nuestra clase `Main` se escribirá el código necesario para probar el correcto funcionamiento de los ejercicios:

1. Ejercicios 1: Se pedirá el nombre de un fichero donde escribir texto . Se pedrirá también texto para escribir en el fichero.
2. Ejer

