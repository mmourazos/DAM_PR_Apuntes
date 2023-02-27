# Tema 9.2: Clases

Las clases en C# cumplen la misma función que en Java.

## Declaración de una clase

```c#
class MiClase
{

}
```

## Variables de clase e instancia

```c#
public class Persona
{
    private static int num_personas = 0; // Variable de clase.
    private DateTime fecha_nacimiento; // Variable de instancia.
}
```

## Propiedades

Las propiedades son un mecanismo para acceder (indirectamente) a las variables privadas de una clase u objeto.

```c#
public class Persona
{
    private string nombre;
    private string apellidos;
    private static int num_personas = 0; // Variable de clase.
    private DateTime fecha_nacimiento; // Variable de instancia.

    // Propiedades
    public string Nombre {
        get;
        set;
    }
}

```

## Métodos

## Herencia

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
