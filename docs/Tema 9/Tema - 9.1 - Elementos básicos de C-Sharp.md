# Tema 9.1: Elementos básicos de C Sharp

En este tema veremos los elementos básicos del lenguaje: variables, operadores y estructuras de control.

Haremos esto mediante comparaciones con el lenguaje Java siempre que sea posible.

## Creación y ejecución de una aplicación

Veremos antes como crear, ejecutar y compilar una aplicación de C#.

### Creación de un proyecto

Para crear un proyecto o aplicación C# ha de usarse la aplicación `dotnet` con la opción `new` y alguna de las _plantillas_ disponibles. Para ver un listado de todas las plantillas se puede usar el comando `dotnet new list`.

Para crear una aplicación básica de consola usaremos el comando `dotnet new console`.

También es interesante usar la opción `-o` para indicar el directorio dentro del que queremos crear nuestra aplicación. Si no se indica se realizará en el directorio actual.

### Ejecución de un proyecto

Para ejecutar la aplicación C# se usará la opción `run` del comando `dotnet` dentro del directorio de la aplicación:

```bash
dotnet run
```

### Compilación del proyecto

A diferencia de Java en C# se puede generar un archivo ejecutable (`.exe`) a partir del código fuente de la aplicación.

Para ello usaremos el comando `dotnet build`. Este comando **compilará** el código fuente de la aplicación y dará como resultado un archivo ejecutable Windows (`.exe`).

El resultado de la compilación se guardará en el directorio `bin` (binarios) del proyecto.

## Variables

Las principales diferencias entre las variables de C# y Java es que en el primero las variables _primitivas_ podrán pasarse **por valor** o **por referencia**. La segunda diferencia es que en lugar de disponer de **tipos envoltorio**, como Java, para trabajar con variables _sencillas_ (los tipos primitivos de Java) se utiliza un nuevo tipo de datos `struct` para realizar una función similar. Los _tipos primitivos_ de C# serán todos `struct`s, una especie de clases limitadas con valores y métodos.

### Situación en Java

En Java tenemos dos tipos de datos o variables: variables primitivas (int, short, long, double, float, boolean, byte y char) y clases.

Los tipos primitivos son variables que se pasan **por valor**. Esto quiere decir que cuando le pasamos una variable int como argumento a un método, este **no puede modificarla**. Veámoslo con un ejemplo:

```java
public class Main {
    public static void metodoValor(int x, int y, int z) {
        z = x + y;
        System.out.printf("(método:) x = %d, y = %d. y z = %d.%n", x, y, z);
    }
    
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = 0;
        
        System.out.printf("x = %d, y = %d y z = %d.%n", x, y, z);
        
        metodoValor(x, y, z);
        
        System.out.printf("x = %d, y = %d y z = %d.%n", x, y, z);
    }
}
```

La ejecución del código anterior devolverá la siguiente salida:

```bash
x = 5, y = 10 y z = 0.
(método:) x = 5, y = 10. y z = 15.
x = 5, y = 10 y z = 0.
```

Como podemos observar la variable `z` toma el valor de la suma **dentro del método** pero su valor en el exterior no se ve modificado.

Esto se debe a que las variables que se pasan **por valor** únicamente transmiten **una copia** de su valor al método y no una **referencia** a la variable.

Una variable de tipo array es, por el contrario una variables que se pasa **por referencia**. Esto es, se pasa la referencia a la variable y puede ser alterada:

```java
import java.util.Arrays;

public class Main {
   
    public static void metodoReferencia(int[] arr) {
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        
        System.out.printf("Antes: s = %s.%n", Arrays.toString(arr));
        
        metodoReferencia(arr);
        
        System.out.printf("Después: s = %s.%n", Arrays.toString(arr));
    }
}
```

La salida de la ejecución de este código es:

```bash
s = [1, 2, 3].
s = [0, 0, 0].
```

### Situación en C Sharp

Las variables en C# pueden ser también por valor y por referencia. Las variables tipo `struct` en C# son **por defecto** por valor (similares a los tipos primitivos de Java) mientras que las clases son, igual que en Java, por referencia.

Pero las `struct` no son tan básicas como los tipos primitivos si no que se acercan más a las clases. Las `struct` almacenan valores y métodos al igual que las clases. Pueden definirse como clases muy sencillas con un comportamiento especial.

También, a diferencia de Java, en C# podremos crear nuestras propias `struct`s.

Ejemplos de `struct` predefinidas del lenguaje son: shot, int, long, float, double, decimal, bool, char.

Si se las pasamos a un método como argumentos tendremos el mismo comportamiento que en Java:

```c#
static void metodoValor(int x, int y, int z) {
    z = x + y;
    System.Console.WriteLine($"En el método: x = {x}, y = {y} y z = {z}");
}

int x = 5;
int y = 10;
int z = 0;

metodoValor(x, y, z);
System.Console.WriteLine($"Fuera del método: x = {x}, y = {y} y z = {z}");

```

La ejecución de este código dará como resultado:

```bash
En el método: x = 5, y = 10 y z = 15
Fuera del método: x = 5, y = 10 y z = 0
```

En C#, a diferencia de Java, existe la opción de pasar estas variables **por referencia** como veremos en le siguiente apartado.

#### Variables por referencia

Para pasar las variable _primitivas_ por referencia hemos de usar las palabras reservadas `ref` o `out`. Veamos un ejemplo:

```c#
static void metodoReferencia(int x, int y, ref int z) {
    z = x + y;
    System.Console.WriteLine($"En el método: x = {x}, y = {y} y z = {z}");
}

int x = 5;
int y = 10;
int z = 0;

metodoReferencia(x, y, ref z);
System.Console.WriteLine($"Fuera del método: x = {x}, y = {y} y z = {z}");
```

Ahora la salida del programa será:

```bash
En el método: x = 5, y = 10 y z = 15
Fuera del método: x = 5, y = 10 y z = 15
```

La otra opción con `out` se similar. Con esta opción **no se exige** que se le de un valor inicial a la variable que guardará la salida:

```c#
static void metodoReferencia(int x, int y, out int z) {
    z = x + y;
    System.Console.WriteLine($"En el método: x = {x}, y = {y} y z = {z}");
}

int x = 5;
int y = 10;
int z; // No hace falta inicializar z cuando es "out".

metodoReferencia(x, y, out z);
System.Console.WriteLine($"Fuera del método: x = {x}, y = {y} y z = {z}");
```

## Operadores

No aprecio diferencia en los operadores respecto a Java.

## Estructuras de control

Las estructuras de control son similares a las de Java con diferencias menores.

### `if-else`

Esta estructura no tiene ninguna diferencia en funcionamiento o sintaxis a Java.

### `switch`

### `for`

Esta estructura presenta alguna diferencia. En la sección _inicial_ y _final_ se pueden incluir más instrucciones de las de inicialización e incremento:

```c#
int i, j; // Importante declaración externa.
for (System.Console.WriteLine("Sección de inicialización."), i = 0, j = 10; i < j; ++i, --j, System.Console.WriteLine($"Sección de incremento i = {i} y j = {j}.")) {
    System.Console.WriteLine($"Dentro del bucle iteración {i}.");
}
```

```bash
Sección de inicialización.
Dentro del bucle iteración 0.
Sección de incremento i = 1 y j = 9.
Dentro del bucle iteración 1.
Sección de incremento i = 2 y j = 8.
Dentro del bucle iteración 2.
Sección de incremento i = 3 y j = 7.
Dentro del bucle iteración 3.
Sección de incremento i = 4 y j = 6.
Dentro del bucle iteración 4.
Sección de incremento i = 5 y j = 5.
```

### `for-each`

Las diferencias en el bucle `for-each` son también (al menos externamente) muy pequeñas:

```c#
List<int> listInt = new List<int>();
```

### `while`

### `do-while`
