# Tema 9.4: Clases

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

Las propiedades son un mecanismo para acceder al estado de un objeto. Las propiedades pueden almacenar un valor (como una variable pública), pueden limitar la modificación o la lectura (incluyendo sólo `get` o `set` como veremos más adelante) o pueden no hacer referencia a un valor concreto si no que se obtengan como combinación de varios.

Supongamos que tenemos una clase caja con largo, alto, ancho y volumen.

```c#
public class Caja
{
    public float largo;
    public float alto;
    public float ancho;
    public float volumen;

    public override string ToString()
    {
        return $"Largo: {largo}\nAlto: {alto}\nAncho: {ancho}\n\tVolumen: {volumen}";
    }
}
```

Esta implementación presenta cierta inseguridad porque se podrían modificar dichos valores eliminando la consistencia.

Es posible que deseemos que la longitud de la caja sea fija. O que no se pueda modificar una vez establecida. O simplemente evitar que se establezcan valores negativos.

Para ello comenzaremos por hacer las variables privadas (no olvidemos añadir `_` al comienzo de las variables como buena práctica):

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;
    private float _volumen;

      public override string ToString()
    {
        return $"Largo: {_largo}\nAlto: {_alto}\nAncho: {_ancho}\n\tVolumen: {_volumen}";
    }
}
```

Para poder acceder a las mismas crearemos las propiedades que sean necesarias.

Para crear una propiedad escribiremos un modificador de acceso (o ninguno si queremos usar el por defecto `internal`) seguido del tipo de dato de la propiedad (`float` en nuestro caso) y a continuación el nombre de la propiedad (usando pascal case). A continuación abrimos un bloque de código (`{ }`) y dentro del mismo tendremos la opción de incluir dos secciones `get` y `set` de las que podremos omitir una dependiendo de nuestras necesidades.

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;
    private float _volumen;

    public float Largo {
        get 
        {
            return _largo;
        }

        set 
        {
            _largo = value;
        }
    }

    // Y así para las demás propiedades.

      public override string ToString()
    {
        return $"Largo: {Largo}\nAlto: {Alto}\nAncho: {Ancho}\n\tVolumen: {Volumen}";
    }

}
```

El parámetro `value` que usamos dentro del `set` se establece por defecto y se le asignará el valor que escribamos después del `=` cuando queramos asignarle un valor a nuestra propiedad:

```c#
Caja miCaja = new Caja();

miCaja.Largo = 10.5f;

// Dentro del bloque set, value valdrá 10.5f.
```

Ahora podremos controlar que sólo se le asignen valores positivos a nuestra propiedad:

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;
    private float _volumen;

    public float Largo {
        get 
        {
            return _largo;
        }

        set 
        {
            if (value <= 0)
            {
                throw new Exception("La longitud ha de ser mayor que 0.");
            }
            _largo = value;
        }
    }

    // ...
}
```

Con respecto a la variable volumen, puesto que su valor se obtiene a partir de las demás, no tiene sentido almacenarla. Podremos crear una propiedad que la calcule a partir de los valores de largo, alto y ancho de la caja:

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;
    private float _volumen;

    // ...

    public float Volumen {
        get {
            _volume  = _largo * _alto * _ancho;
            return _volumen;
        }

        set {
            _volumen = value;
        }
    }
}
```

Pero el código anterior no tiene mucho sentido ya que:

* No tiene sentido usar la variable `_volumen` pues habría que recalcularla cada vez que se acceda a ella pues largo, alto o ancho podrían haber variado.
* No tiene sentido que se pueda asignar el volumen directamente pues éste depende de las dimensiones de la caja.

Así que podríamos eliminar `_volumen` y el bloque `set` convirtiendo a `Volumen` en una propiedad calculada de solo lectura¨:

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;

    // ...

    public float Volumen {
        get {
            return _largo * _alto * _ancho;
        }
    }
}
```

Si le queremos añadir la propiedad nombre a nuestra caja pero sin ningún código especial que lo limite no tendremos porque crear una variable privada interna ni código para los bloques `get` y `set`:

```c#
public class Caja
{
    private float _largo;
    private float _alto;
    private float _ancho;
    private float _volumen;

    public string Nombre { get; set; }

    // ...
}

```

Se recomienda el uso de propiedades frente a variables públicas por dos motivos.

* El primero es que más adelante se podrá modificar el funcionamiento de su `get` y `set` para, por ejemplo, añadir validación.
* En segundo lugar, usando siempre propiedades se aumenta la consistencia y legibilidad del código.

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

El constructor es idéntico y funciona de la misma forma que en Java.

### Destructor

También dispondremos de un método **que ha de ser único** y no admite argumentos que se invocará cuando se destruya (por el Recolector de basura o al fin del programa) nuestra clase.

Su sintaxis será la siguiente:

```C#
clase MiClase
{
    // ... 

    ~MiClase
    {
        // Código a ejecutar cuando destruyamos la clase.
    }
}
```

### Sobrecarga de métodos

Las sobrecarga de métodos es similar a la de Java. Consiste en crear varios métodos con el mismo nombre pero distinto número o tipo de argumentos:

```c#
class MiClase
{
    public void MetodoSobrecargado() 
    {
        // ...
    }

    public void MetodoSobrecargado(int x, int y)
    {
        // ...
    }

    public void MetodoSobrecargado(float x, float y)
    {
        // ...

    }
}

```

### Métodos co número variable de argumentos

#### Solución en Java

Para indicar que un método acepta un numero variable de argumentos en Java hemos de indicarlo en la declaración del método poniendo primero el tipo del parámetro (como siempre) **seguido de `...`** y el nombre del parámetro.

```Java
public class Main{

    public static int varArgsMethod(int... integers) {
        int total = 0;

        for (int i : integers) {
            total += i;
        }

        return total;
    }

    public static void main(String[] args) {

    }
}
```

#### Solución en C Sharp

Para declarar un método con un número variable de argumentos en C# hemos de usar la palabra clase `params` seguido de la declaración del array que contendrá los argumentos que deseemos que admita el método:

```c#
class MiClase
{
    public static int Total(params int[] valores) 
    {
        int total = 0;

        foreach (int v in valores)
        {
            total += valor;
        }

        return total;
    }
}
```

**Nota:** Antes del parámetro que acepta múltiples argumentos podremos indicar otros parámetros. Pero el que acepte varios **ha de ser siempre el último y solo puede haber uno.**

```c#
 public static int TotalMultiplicado(int multiplicador, params int[] valores) 
 {
    int total = 0;

    foreach (int v in valores)
    {
        total += valor;
    }

    return multiplicador * total;
}
```

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

**A continuación veremos los modificadores con un poco más de detalle.**

### Modificador `private`

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

### Modificador `public`

Éste modificador es el **más permisivo**. Los miembros declarados con este modificador podrán ser accedidos desde **cualquier otra parte del código**.

Si declaramos una clase como `public` cualquier otra clase podrá heredar de ella.

### Modificador `protected`

El modificador `protected` implica que el objeto será accesible dentro de la clase donde se declaró y en **todas las clases derivada de ella**.

### Modificador `internal`

Con `internal` especificamos que un objeto sólo será accesible dentro de su mismo [_ensamblado_](https://learn.microsoft.com/es-es/dotnet/standard/assembly/).

Los miembros declarados como `internal` no serán accesibles desde fuera del _ensamblado_ (proyecto).

Este es el **modificador que se aplica por defecto** cuando no se indica ningún otro para la clase o sus miembros.

#### ¿Que es un _ensamblado_?

Un ensamblado es una colección de tipos y recursos compilados para funcionar en conjunto y formar una unidad lógica de funcionalidad. Los ensamblados adoptan la forma de un archivo ejecutable (`.exe`) o de biblioteca de vínculos dinámicos ( `.dll`), y son los bloques de creación de las aplicaciones.

Comúnmente podemos identificar los ensamblados con los proyecto que creamos en Visual Studio.

### Modificador `protected internal`

Esta combinación hace que el miembro sea accesible dentro de su propio ensamblado (proyecto) **y además** en las clases derivadas de su clase (aunque estén en otros ensamblados).

### Modificador `private protected`

Al igual que en el caso anterior se combinan (suman) los niveles de acceso del modificador `private` y del modificador `protected`. Esto hace que el elemento al que se aplique la combinación sólo podrá ser accesible **desde la propia clase** (`private`) **y también desde las clases derivadas** (subclases) pero solo **dentro del mismo ensamblado**.
