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

## Operadores

No aprecio diferencia en los operadores respecto a Java.
