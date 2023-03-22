# Tema 11.6: Delegados y eventos

Para poder entender cómo funciona el enlazado de datos es necesario conocer algunos conceptos previos: delegados y eventos. Estos dos elementos se utilizan cuando realizamos _binding_ (o enlazado de datos) entre las vistas y los _view-models_ para _informar_ a los componentes de las vistas de los cambios en las propiedades el modelo y viceversa.

## Delegados

Un delegado es un elemento de C# que permite encapsular una o más referencias a métodos y funciones. El delegado también ofrece un mecanismo para invocar a los métodos encapsulados.

### Declaración de un tipo delegado

Para declarar un **tipo** delegado (acción análoga a la definición de una clase) hemos de usar la palabra reservada `delegate`, seguida de la firma (tipo de retorno y parámetros) de los métodos que podrá encapsular

```csharp
delegate int MiDelegado(string mensaje);
```

### Declaración de un delegado

Para declarar una variable de tipo delegado simplemente antepondremos al nombre de la variable el tipo delegado que previamente hemos definido.

```csharp
MiDelegado delegado;
```

**Nótese que no hay que instanciar nada.**

### Encapsular funciones en un delegado

Para encapsular una función en un delegado debemos asignarle la referencia a la función. Para ello usaremos el operador `=`.

```csharp
// Supongamos que tenemos un método estático que acepta un string y devuelve un int.
// No es necesario que sea estático, pero para simplificar el ejemplo lo haremos así.

private static int MiFuncion(string mensaje)
{
    Console.WriteLine(mensaje);
    return 0;
}

private static int MiOtraFuncion(string cadena) {
    return cadena.Length;
}

// Si queremos encapsular la función en el delegado lo haremos de la siguiente forma:
delegado = MiFuncion;

// O de forma equivalente:
delegado = new MiDelegado(MiFuncion);
```

De esta forma tendremos encapsulada la función `MiFuncion` en el delegado `delegado`.

Si queremos **añadir** más funciones o métodos al delegado usaremos el operador `+=` para ir _sumándolas_ al mismo.

```csharp
delegado = MiFuncion;
delegado += MiOtraFuncion;
delegado += x => x.Length;
```

#### Invocar a un delegado

Invocar a un delegado supone llamar a todas las funciones o métodos que contiene. Para ello usaremos el operador `()` o el método `Invoke()` (son equivalentes).

```csharp
delegado("Hola"); // Equivalente a delegado.Invoke("Hola");
```

Hay que tener en cuenta que si **no se ha asignado** ninguna función al delegado, al invocarlo se producirá un error `System.NullReferenceException`.

Para evitar esto se ha de hacer una comprobación antes de invocar al delegado.

```csharp
if (delegado != null)
{
    delegado("Hola");
}
```

Desde C# 6.0 se ha introducido la posibilidad de hacer esta comprobación de forma más sencilla mediante el operador `?.`[^1]:

```csharp
delegado?.Invoke("Hola");
```

[^1]: El _null conditional operator_ accederá al elemento (método, propiedad, etc.) si el objeto no es `null`. Si el objeto es `null` no se producirá ningún error y **devolverá** `null`.

## Eventos

Un evento es un elemento de C# que, al igual que los delegados, encapsula una o más referencias a métodos y funciones. Los eventos son tan similares a los delegados que es necesario utilizar un delegado para definir un evento.

### Declaración de un evento

Para declarar un **tipo** evento hemos de usar la palabra reservada `event` seguida del nombre del tipo delegado que encapsulará.

```csharp
delegate int MiDelegado(string mensaje);
event MiDelegado MiEvento;
```

En el ejemplo anterior `MiEvento` podrá encapsular las mismas funciones o métodos que acepte el delegado `MiDelegad`, `string` y devuelvan un `int` en este caso.

Sin embargo, los eventos son **privados**. Esto significa que sólo la clase que contiene el evento puede invocarlo. Los eventos se utilizan para **notificar** a los suscriptores de que ha ocurrido un evento.

(cuando usar delegados o eventos)

Un evento comparte muchas propiedades con una variable de tipo delegado. La principal consideración que hemos de tener en cuenta a la hora de elegir entre uno u otro es si es **necesario** que deba existir un suscriptor conectado o no. Si es necesario que exista un suscriptor conectado, debemos usar un diseño basado en delegados. Si no es necesario, debemos usar un diseño basado en eventos.

Consideremos, por ejemplo, el caso de `List.Sort()`. A este método debemos pasarle una función o método que nos permita comparar dos elementos de la lista. Por lo tanto, por detrás, habrá delegados que puedan determinar qué elementos ha de devolver.

Por otro lado tenemos el caso de un evento que indique el estado de progreso de una tarea. Si un componente "barra de progreso" se _subscribe_ a este evento irá siendo notificada cada vez que cambie el estado de progreso. De este modo podremos ver cómo va avanzando la tarea. Si no se _subscribe_ ninguna barra de progreso, la tarea seguirá avanzando igualmente (y el evento seguirá lanzándose).

#### Valores de retorno requieren usar delegados

Otra consideración a tener en cuenta es si el método encapsulado que se va a invocar debe devolver un valor. Si sucede esto debemos usar delegados, ya que todos los eventos (por convenio) no pueden devolver ningún valor. Si no es necesario que devuelva un valor, podemos usar eventos.

#### Los eventos se invocan de manera _privada_

**No confundir esto con que se declaren de manera privada.** Los eventos han de ser declarados de manera pública para que los posibles subscriptores puedan subscribirse, pero sólo la clase que contiene el evento puede invocarlo.

Las clases externas a aquella que contiene el evento sólo podrán subscribirse o de-subscribirse a dicho evento. La clase que contiene el evento es la única que puede invocarlo, es decir, es la única que puede _disparar_ el evento.
