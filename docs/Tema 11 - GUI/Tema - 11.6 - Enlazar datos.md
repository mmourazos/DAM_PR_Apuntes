# Tema 11.6: Enlazar datos

Cuando creamos nuestras vistas lo más habitual es que queramos mostrar datos que provienen de una fuente de datos (el modelo). En este tema veremos cómo enlazar datos a nuestras vistas de manera que cuando el valor de los datos cambie, la vista se actualice automáticamente. Del mismo modo, cuando el usuario modifique los datos de la vista, estos se actualicen en la fuente de datos.

## Conceptos previos

Para poder entender cómo funciona el enlazado de datos es necesario conocer algunos conceptos previos: delegados y eventos. Estos dos elementos son utilizados para _informar_ a los componentes de la vista de los cambios en el modelo y viceversa.

### Delegados

Un delegado es un elemento de C# que permite encapsular una o más referencias a métodos y funciones. El delegado también ofrece un mecanismo para invocar a los métodos encapsulados.

#### Declaración de un tipo delegado

Para declarar un **tipo** delegado (acción análoga a la definición de una clase) hemos de usar la palabra reservada `delegate`, seguida de la firma (tipo de retorno y parámetros) de los métodos que podrá encapsular

```csharp
delegate int MiDelegado(string mensaje);
```

#### Declaración de un delegado

Para declarar una variable de tipo delegado simplemente antepondremos al nombre de la variable el tipo delegado que previamente hemos definido.

```csharp
MiDelegado delegado;
```

**Nótese que no hay que instanciar nada.**

#### Encapsular funciones en un delegado

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

### Eventos (cuando usar delegados o eventos)

Un evento comparte muchas propiedades con una variable de tipo delegado. La principal consideración que hemos de tener en cuenta a la hora de elegir entre uno u otro es si es **necesario** que deba existir un suscriptor conectado o no. Si es necesario que exista un suscriptor conectado, debemos usar un diseño basado en delegados. Si no es necesario, debemos usar un diseño basado en eventos.

Consideremos, por ejemplo, el caso de `List.Sort()`. A este método debemos pasarle una función o método que nos permita comparar dos elementos de la lista. Por lo tanto, por detrás, habrá delegados que puedan determinar qué elementos ha de devolver.

Por otro lado tenemos el caso de una evento que indique el estado de progreso de una tarea. Si se _subscribe_ una barra de progreso a este evento podremos ver cómo va avanzando la tarea. Si no se _subscribe_ ninguna barra de progreso, la tarea seguirá avanzando igualmente (y el evento seguirá lanzándose).

#### Valores de retorno requieren usar delegados

Otra consideración a tener en cuenta es si el método que se va a invocar debe devolver un valor. Si el método debe devolver un valor, debemos usar delegados. Si no es necesario que devuelva un valor, podemos usar eventos.

#### Los eventos se invocan de manera _privada_

Las clases externas a aquella que contiene el evento sólo podrán subscribirse o de-subscribirse a dicho evento. La clase que contiene el evento es la única que puede invocarlo. Esto es así porque los eventos son _privados_. Los eventos generalmente son miembros privados de una clase. En contraste, los delegados se pasan como parámetros y se almacenan como miembros privados, si se almacenan en absoluto.

## Enlazar datos

Enlazar datos o _data binding_ es la capacidad de enlazar una propiedad de un componente con una propiedad de un objeto. De esta forma, cuando el valor de la propiedad del objeto cambie, el componente se actualizará automáticamente. En este contexto hablaremos de fuente (source) y destino (target) donde el destino es el componente y la fuente es el objeto.

Hay cuatro tipos de enlazado de datos:

1. Enlazado de datos **unidireccional**: **De la fuente al destino**. El componente se actualiza cuando cambia el valor de la propiedad del objeto.
2. Enlazado de datos **bidireccional**: El componente se actualiza cuando cambia el valor de la propiedad del objeto y el objeto se actualiza cuando cambia el valor de la propiedad del componente.
3. Enlazado de datos **unidireccional a la fuente**: **Del destino a la fuente**. El objeto se actualiza cuando cambia el valor de la propiedad del componente.
4. Enlazado de datos de **una vez**: De la fuente al objeto pero que se realizará una sola vez en el constructor.

Hemos dicho que la fuente es el objeto y el destino es el componente. Pero el objeto no tiene porque ser obligatoriamente un objeto de nuestro modelo. Podemos enlazar datos a cualquier objeto como por ejemplo otro componente de la vista. Esto es lo que haremos en el siguiente ejemplo para ilustrar los diferentes tipos de _data binding_.

### Nuestro ejemplo

Crearemos una vista con dos componentes simples: un `TextBox` y un `Slider`. El `TextBox` será el _target_ y el `Slider` será la _source_. El objetivo es que cuando el usuario modifique el valor del `Slider` el valor del `TextBox` se actualice y viceversa.

```xml
<Grid>
    <Grid.RowDefinitions>
        <RowDefinition Height="Auto" />
        <RowDefinition Height="Auto" />
    </Grid.RowDefinitions>
    <Grid.ColumnDefinitions>
        <ColumnDefinition Width="Auto" />
        <ColumnDefinition Width="Auto" />
    </Grid.ColumnDefinitions>
    <TextBlock Grid.Row="0" Grid.Column="0" Text="Valor:" />
    <TextBox Grid.Row="0" Grid.Column="1" Text="0" />
    <Slider Grid.Row="1" Grid.Column="0" Grid.ColumnSpan="2" Minimum="0" Maximum="100" Value="0" />
</Grid>
```

### Enlazado de datos unidireccional (de la fuente al destino)

Para hacer que nuestro `TextBox` esté enlazado con el `Slider` debemos utilizar la propiedad `Text` del `TextBox` y enlazarla con la propiedad `Value` del `Slider`.
En primer lugar debemos darle nombre al `Slider` para poder referenciarlo en el `TextBox`. Para ello usaremos la propiedad `Name` del `Slider`: `Name="MiSlider"`.

```xml
<Slider Name="MiSlider" Grid.Row="1" Grid.Column="0" (...) />
```

A continuación substituiremos el valor de la propiedad `Text` del `TextBox` el siguiente valor:

```xml
<TextBox Grid.Row="0" Grid.Column="1" Text="{Binding ElementName=MiSlider, Path=Value, Mode=OneWay}" />
```

Ahora, cuando el usuario modifique el valor del `Slider` el valor del `TextBox` se actualizará automáticamente.

### Enlazado de datos bidireccional

Para hacer que la actualización del `TextBox` y el `Slider` se haga en ambos sentidos debemos cambiar el valor de la propiedad `Mode` a `TwoWay`.

```xml
<TextBox Grid.Row="0" Grid.Column="1" Text="{Binding ElementName=MiSlider, Path=Value, Mode=TwoWay}" />
```

### Enlazado de datos unidireccional a la fuente (del destino a la fuente)

Es este caso la actualización ser hará en el sentido inverso. Es decir, la fuente (el `Slider`) será el que modifique su valor cuando el target (el `TextBox`) modifique su valor (`Text`).

```xml
<TextBox Grid.Row="0" Grid.Column="1" Text="{Binding ElementName=MiSlider, Path=Value, Mode=OneWayToSource}" />
```

### Enlazado de datos de una vez (en el constructor)

En este caso no se vinculan permanentemente los dos componentes. Simplemente sirve para darle un valor inicial (el mismo) a ambos al inicio de la aplicación. Para ello cambiamos el valor de `Mode` a `OneTime` y, a continuación, en el código fuente de `MainWindow` debemos añadiremos las siguientes instrucciones:

```xml
<TextBox Grid.Row="0" Grid.Column="1" Text="{Binding ElementName=MiSlider, Path=Value, Mode=OneTime}" />
```

```csharp
public MainWindow() {
    InitializeComponent();
    // MiSlider es el nombre del componente. Le asignamos un valor inicial.
    MiSlider.Value = 0;
    // MiTextBox es el nombre del componente. Le asignamos un valor a partir del valor del Slider.
    MiTextBox.Text = MiSlider.Value.ToString();
}
```

### Cambio en _tiempo real_

Si queremos que los cambios se produzcan en tiempo real debemos añadir la propiedad `UpdateSourceTrigger` con el valor `PropertyChanged` a la etiqueta `Binding`.

```xml
<TextBox Grid.Row="0" Grid.Column="1" Text="{Binding ElementName=MiSlider, Path=Value, Mode=TwoWay, UpdateSourceTrigger=PropertyChanged}" />
```

Esto hará que se actualice el aspecto del componente cuando se produzca un cambio en el valor de la propiedad.

## Enlazado de datos al modelo

En un caso más real, en lugar de vincular propiedades de distintos componentes entre si, lo que nos interesará será vincular propiedades de los componentes a propiedades de nuestro modelo. Para ello usaremos el interfaz `INotifyPropertyChanged` que nos permite notificar a los componentes que se ha producido un cambio en una propiedad.

Para llevar esto a término hemos de seguir los siguientes pasos:

1. Crearemos la clase _base_ de todos nuestros _view-models_ (`ViewModelBase`) que implementará la interfaz `INotifyPropertyChanged`.
2. El interfaz `INotifyPropertyChanged` nos obliga a implementar el método `PropertyChanged` que será el que notifique a los componentes que se ha producido un cambio en una propiedad.
3. Para llevar a cabo esta función hemos de declarar un **evento** (`PropertyChanged`) que será el que notifique a los componentes que se ha producido un cambio en una propiedad.
 **Inciso:**
Recordemos que un **evento** es un tipo especial de **delegado**. Esto quiere decir que podremos _asociar_ a un evento varias funciones (métodos) que se ejecutarán cuando se produzca el evento. En este caso, cuando se produzca el evento `PropertyChanged` se ejecutarán todas las funciones asociadas a él. `PropertyChanged` es un evento del tipo `PropertyChangedEventHandler` que es un delegado que recibe dos parámetros: el objeto que ha producido el evento y un objeto de tipo `PropertyChangedEventArgs` que contiene información                                                           sobre el evento.
4. Crearemos también un método `OnPropertyChanged` que será el que se encargue de lanzar el evento `PropertyChanged` cuando se produzca un cambio en una propiedad. Este método recibirá como parámetro el nombre de la propiedad que ha cambiado.

Una vez hecho esto crearemos las clases _view-model_ que necesitemos para cada vista.

En cada vista _asignaremos_ un bloque `{Binding ... }` donde indicaremos el nombre de la propiedad del modelo que queremos enlazar con la propiedad del componente.

En nuestro ejemplo podremos poner `Text="{Binding Intentos}"` en el `TextBlock` que muestra el número de intentos.

```csharp
public class ViewModelBase : INotifyPropertyChanged
{
    public event PropertyChangedEventHandler PropertyChanged;

    protected void OnPropertyChanged(string propertyName) {
        if (PropertyChanged != null) {
            PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
```

Supongamos que en nuestro modelo tenemos la clase `Patida` una de cuyas propiedades es `Intentos` que refleja cuantos intentos ha realizar el jugador hasta el momento.

```csharp
public class Partida
{
    private readonly int _intentos;

    private readonly int _numero;

    public int Intentos { get { return _intentos} }

    public int Intento(int numero) {
        ++_intentos;
        return Math.Abs(numero - _numero);
    }
    // ...
}
```

En nuestra vista queremos mostrar el número de intentos que lleva el jugador. Para ello utilizaremos la etiqueta `<TextBlock>`.

```xml
<TextBlock Text="Intentos: 0" />    
```
