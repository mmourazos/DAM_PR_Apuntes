# Tema 9.2: Clases

Las clases en C# cumplen la misma función que en Java.

## Declaración de una clase

```c#
class MiClase
{

}
```

## Variables de clase e instancia

Las variables de clase e instancia se declaran igual que en Java con dos salvedades: las constantes y las variables de solo lectura.

```c#
public class Persona
{
    private static int num_personas = 0; // Variable de clase.
    private DateTime fecha_nacimiento; // Variable de instancia.
}
```

### Constantes

Si en Java declarábamos una constante de la siguiente forma:

```Java
public class Clase {
    public static final int VALOR = 123;
}
```

en C# tendremos que usar la palabra reservada `constant` que substituiría a `public final` pues se considera que todas las constantes son automáticamente estáticas.

```C#
public class Clase
{
    public const int VALOR = 123;
}
```

### Readonly

Si no conocemos el valor de nuestra constante antes de ejecutar el código pero no vamos a permitir cambiarla una vez asignada usaremos la palabra reservada `readonly`.

Lo que en Java sería:

```Java
public static final int[] VALORES = {1, 2, 3};
```

En C# será:

```C#
public static readonly int[] VALORES = {1, 2, 3};
```

**NOTA:** Aunque no podamos cambiar la asignación de `VALORES` al array en memoria siempre podremos cambiar su contenido `VALORES[0] = 10`.

## Propiedades

Las propiedades son un mecanismo para acceder (indirectamente) a las variables privadas de una clase u objeto.

```c#
public class Persona
{
    private static int _num_personas = 0; // Variable de clase.
    private DateTime _fecha_nacimiento; // Variable de instancia.

    // Propiedades
    public string Nombre { get; set; }
    public string Apellidos { get; set; }
}

```

En el ejemplo anterior hemos declarado dos propiedades. Puesto que no hacemos nada especial en el `get` ni en el `set` no hace falta indicar ningún código.

En casos en los que haya que una variable interna (o varias) respaldando a la propiedad añadiremos el código que sea necesario a `get` y `set`:

```C#
public class Persona
{
    private static int _num_personas = 0; // Variable de clase.
    private DateTime _fecha_nacimiento; // Variable de instancia.

    // Propiedades
    public string Nombre { get; set; }
    public string Apellidos { get; set; }
    public string FechaDeNacimiento
    {
        get
        {
            return _fecha_nacimiento.ToString()
        }

        // El el argumento que se pasa en la asignación ' FechaDeNacimiento = "1999, 5, 16" '
        // se recibe en bloque set como el parámetro "value".
        set
        {
            _fecha_nacimiento = DateTime.Parse(value)
        }
    }
}
```

Se recomienda el uso de propiedades frente a variables públicas por dos motivos. El primero es que más adelante se podrá modificar el funcionamiento de su `get` y `set` para, por ejemplo, añadir validación. En segundo lugar, usando siempre propiedades se aumenta la consistencia y legibilidad del código.

## Métodos

Para declarar un método en una clase lo haremos, de nuevo, de una forma similar a Java:

```C#
class MiClase
{
    private Map<int, string> contenido;

    public void Guarda(int clave, string valor) 
    {
        contenido.
    }
}
```

### Constructor

### Sobrecarga de métodos

### Sobrescritura (`override`) de métodos

Si queremos cambiar el comportamiento de un método que heredamos de una superclase hemos de usar la palabra clave `override`:

```C#
public class Mascota
{
    string Tipo { get; set; }
    string Nombre { get; set; }
    string Edad {
        //...
    }
    
    // ...

    public override string ToString() {
        return $"Soy un {Tipo} de {Edad} años y me llamo {Nombre}.";
    }
}

// ...
Mascota mascota = new Mascota("Perro", "Churri", "2018");

Console.WriteLine(mascota);
```

## Herencia

En C# así como en Java tendremos que una clase puede heredar de **una única** clase padre o _superclase_. Convirtiéndose la heredera en _subclase_ de su _superclase_.

## Modificadores de acceso

Los modificadores de acceso son palabras clave que se usan para especificar la accesibilidad declarada de un miembro o un tipo (clase). En esta sección se presentan los cinco modificadores de acceso:

* public
* protected
* internal
* private
* file

Pueden especificarse los siguientes siete niveles de accesibilidad con los modificadores de acceso:

* `public`: el acceso no está restringido.
* `protected`: el acceso está limitado a la clase contenedora o a los tipos derivados de la clase contenedora.
* `internal`: el acceso está limitado al ensamblado actual.
* `protected internal`: El acceso está limitado al ensamblado actual o a los tipos derivados de la clase contenedora.
* `private`: el acceso está limitado al tipo contenedor.
* `private protected`: El acceso está limitado a la clase contenedora o a los tipos derivados de la clase contenedora que hay en el ensamblado actual.
* `file`: el tipo declarado solo es visible en el archivo de origen actual. Los tipos con ámbito de archivo se usan generalmente para los generadores de origen.

### Modificadores de acceso en un poco más de detalle

#### Modificador `private`

Éste es el modificador de acceso **más restrictivo**. Los miembros de una clase (variables, atributos, métodos, etc.) declarados como `private` sólo son accesibles desde **dentro de la clase donde fueron declarados**.

Cuando **marcamos una clase como `private`** ninguna clase podrá **heredar de la misma**.

**Nota:** Las variables declaradas como `private` se nombran por convenio empezando por `_`.

```C#
public class BankAccount
{
    private int _balance;
    public int GetBalance()
    {
        return _balance;
    }
    public void Deposit(int amount)
    {
        _balance += amount;
    }
    public void Withdraw(int amount)
    {
        if (_balance - amount >= 0)
        {
            _balance -= amount;
        }
    }
}
```

El modificador de acceso `private` se usa cuando un miembro de la clase está diseñado únicamente para uso interno y no debe ser accesible desde otras partes del programa. De este modo se nos permite ocultar los detalles de implementación de una clase y proteger a sus miembros de accesos o modificaciones involuntarias.

#### Modificador `public`

Éste modificador es el **más permisivo**. Los miembros declarados con este modificador podrán ser accedidos desde **cualquier otra parte del código**.

Si declaramos una clase como `public` cualquier otra clase podrá heredar de ella.

#### Modificador `protected`

El modificador `protected` implica que el objeto será accesible dentro de la clase donde se declaró y en **todas las clases derivada de ella**.

#### Modificador `internal`

Con `internal` especificamos que un objeto sólo será accesible dentro de su mismo [_ensamblado_](https://learn.microsoft.com/es-es/dotnet/standard/assembly/).

Los miembros declarados como `internal` no serán accesibles desde fuera del _ensamblado_ (proyecto).

Este es el **modificador que se aplica por defecto** cuando no se indica ningún otro para la clase o sus miembros.

##### ¿Que es un _ensamblado_?

Un ensamblado es una colección de tipos y recursos compilados para funcionar en conjunto y formar una unidad lógica de funcionalidad. Los ensamblados adoptan la forma de un archivo ejecutable (`.exe`) o de biblioteca de vínculos dinámicos ( `.dll`), y son los bloques de creación de las aplicaciones.

Comúnmente podemos identificar los ensamblados con los proyecto que creamos en Visual Studio.

#### Modificador `protected internal`

Esta combinación hace que el miembro sea accesible dentro de su propio ensamblado (proyecto) **y además** en las clases derivadas de su clase (aunque estén en otros ensamblados).

#### Modificador `private protected`

Al igual que en el caso anterior se combinan (suman) los niveles de acceso del modificador `private` y del modificador `protected`. Esto hace que el elemento al que se aplique la combinación sólo podrá ser accesible **desde la propia clase** (`private`) **y también desde las clases derivadas** (subclases) pero solo **dentro del mismo ensamblado**.
