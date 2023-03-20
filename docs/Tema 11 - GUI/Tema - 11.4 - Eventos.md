# Tema 11.4: Eventos

Los eventos son acciones que se producen en la interfaz de usuario y que pueden ser detectadas por el código de la aplicación.

En el caso de WPF los eventos se generan cuando se produce una acción sobre un elemento de la interfaz de usuario. Por ejemplo cuando se pulsa un botón, cuando se selecciona un elemento de una lista, cuando se mueve el ratón sobre un elemento, etc.

El mecanismo que utiliza WPF para manejar los eventos se denomina `Routed events`.

## Routed events

Un evento enrutado es un tipo de evento que puede activar _handlers_ (manejadores) en múltiples _listeners_ del árbol de elementos y no solo en el elemento que lo genera. Un _event listener_ (escuchador de eventos) es aquel elemento donde tenemos un manejador de eventos y sobre el cual es invocado. Una fuente de eventos es el elemento u objeto que originalmente lazó el evento.

Las aplicaciones WPF normalmente contienen muchos elementos, que se declaran en XAML o se instancian en código. Los elementos de una aplicación existen dentro de su árbol de elementos. Dependiendo de cómo se defina un evento enrutado, cuando se genera un evento en un elemento fuente:

- _Burbujea_ (bubbles) a través del árbol de elementos desde el elemento fuente hasta la raíz, que suele ser una página o una ventana.
- _Tunelea_ (tunnels) a través del árbol de elementos desde la raíz hasta el elemento fuente.
- No viaja a través del árbol de elementos y solo ocurre en el elemento fuente.

Una vez generado un evento (imaginemos un click en un botón) este evento se propaga por el árbol de elementos de la interfaz de usuario hasta que es detectado por algún elemento. Podríamos decir que el evento sigue una ruta.

Según dónde se traten los eventos se pueden distinguir tres tipos:

### Eventos directamente enrutados (directly routed events)

Son los eventos que se detectan y tratan en el elemento que los genera. Por ejemplo cuando se pulsa un botón el evento se detecta y trata en el botón (el método _handler_ del botón `Button_Click`).

### Eventos que burbujean (bubbling routed events)

Este _burbujeo_ de eventos se produce cuando el elemento dónde se origina el evento no lo trata y _lo deja pasar_. Por lo que _burbujea_ hasta el siguiente elemento contenedor de la jerarquía. Si este elemento tampoco lo trata _burbujea_ hasta el siguiente elemento contenedor y así sucesivamente hasta que el evento es tratado o hasta que llega al elemento raíz de la interfaz de usuario.

### Eventos que _tunelean_ (Tunneling events)

Este es el caso **opuesto** al anterior. En este caso el evento _tunelea_ hasta el elemento raíz de la interfaz de usuario que se considera su origen. Los nombres de estos eventos comienzan por `Preview` como en el caso de `PreviewMouseLeftButtonDown`. Podremos capturarlos en su _viaje_ hacia el botón (o el elemento que corresponda) para realizar alguna acción antes de que el evento llegue al botón o para evitar completamente que el evento llegue al mismo.

## Añadir comportamiento a un botón

Para que un botón tenga comportamiento debemos añadirle un evento.

``` xml
<Grid>
    <Button Width="150" Height="100" Content="Click me!" FontSize="24" Click="Button_Click"/>
</Grid>
```

Se a continuación vamos al código fuente generado en el archivo **MainWindow.xaml.cs** podremos ver el siguiente código:

``` C#
/// <summary>
/// Lógica de interacción para MainWindow.xaml
/// </summary>
public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
    }

    private void Button_Click(object sender, RoutedEventArgs e)
    {

    }
}
```

Es dentro del método `Button_Click()` donde debemos añadir el código que queremos que se ejecute cuando se pulse el botón.

En primer lugar podemos ver que el método recibe dos parámetros:

- `sender`: es el objeto que ha generado el evento (nuestro botón).
- `e`: es el objeto que contiene información sobre el evento.

Si queremos que se ejecute algún código cuando pulsemos el botón hemos de introducir código dentro del método `Button_Click()`. Por ejemplo podremos incluir el siguiente:

``` C#
 MessageBox.Show("Button was clicked!");
 ```
