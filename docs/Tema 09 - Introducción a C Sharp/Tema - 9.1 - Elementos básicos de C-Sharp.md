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

### Operadores clásicos

Entiendo por operadores clásicos los aritméticos, de comparación, lógicos y de asignación. Así como también los operadores a nivel de bits y los de autoincremento y autodecremento.

No aprecio diferencia en los operadores clásicos respecto a Java.

### Operadores nuevos

#### Operador de nulidad `?`

El operador de nulidad `?` se usa para permitir que un tipo primitivo pueda tomar el valor nulo.

```csharp
int? a = null;
```

#### Operador `as`

Operador as que se usa para hacer un _cast_ de un tipo a otro.

La siguiente expresión:

```csharp
double? b = a as double;
```

Asignará el valor `double` de `a` a `b` si `a` es de tipo compatible con un cast a `double` o `null` si no lo es.


#### Operador `is`

Operador `is` que se usa para comprobar si un objeto es de un tipo determinado o no y si es así, se puede hacer un _cast_.

```csharp
Object a = 5;

// Se mostrará el mensaje si a es un entero positivo.
if (a is int x && x > 0) Console.WriteLine("Es un entero positivo");
```

El operador `is` también puede hacer otras cosas como se puede ver en la [página de documentación de Microsoft](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/operators/is).


### Sobrecarga de operadores

Otra característica de C# es la posibilidad de sobrecargar los operadores. Esto es, definir el comportamiento de los operadores para un tipo de dato determinado.

Para ello se usan los métodos `operator` y se definen los operadores que se quieren sobrecargar.

```csharp
public class Punto
{
    public int x, y;

    public Punto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static Punto operator +(Punto p1, Punto p2)
    {
        return new Punto(p1.x + p2.x, p1.y + p2.y);
    }

    public static bool operator ==(Punto p1, Punto p2) 
    {
        return p1.x == p2.x && p1.y == p2.y;
    }
}
```
