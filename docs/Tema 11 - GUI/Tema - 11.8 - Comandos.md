# Tema 11.8: Comandos

Del mismo modo que escribimos una sentencia _Binding_ para enlazar datos a un componente, podremos enlazar también un comando.

Para enlazar un comando hemos de definir antes uno o más `ICommand` en la _view-model_ que corresponda.

```csharp
public class MainViewModel : INotifyPropertyChanged
{
    // ...

    public ICommand Salvar { get; }
    public ICommand Cancelar { get; }

    // ...

}
```

Haremos esto para que estos comandos estén disponibles para la vista. Ya que han de estar en el `DataContext` asociado a la vista.

Además de ello hemos de definir crear los objetos `ICommand` para que las propiedades `Salvar` y `Cancelar` puedan hagan realmente algo. Así, crearemos una carpeta con nombre `Commands` y dentro de ella crearemos dos clases `SalvarCommand` y `CancelarCommand` que implementen la interfaz `ICommand`.

```csharp
public class SalvarCommand : ICommand
{
    public event EventHandler CanExecuteChanged;

    public bool CanExecute(object parameter)
    {
        throw new NotImplementedException();
    }

    public void Execute(object parameter)
    {
        throw new NotImplementedException();
    }

}
```

Como podemos ver, la interfaz `ICommand` nos obliga a implementar dos métodos: `CanExecute` y `Execute`. El primero nos indica si el comando puede ejecutarse y el segundo es el que se ejecuta cuando se ejecuta el comando. En el constructor del comando `SalvarCommand` podremos pasarle una referencia al modelo para que pueda ejecutar las acciones que sean necesarias.

```csharp
public class SalvarCommand : ICommand
{
    private readonly Partida _partida;

    public event EventHandler CanExecuteChanged;

    public SalvarCommand(Partida partida)
    {
        _partida = partida;
    }

    public bool CanExecute(object parameter)
    {
        return true;
    }

    public void Execute(object parameter)
    {
        EstadoPartida estado = (EstadoPartida)parameter;
        _partida.Salvar(estado);
    }

}
```