# Tema 9.6: Tipos avanzados de datos

Con tipos avanzados de datos me refiero a los tipos de datos que son más complejos que los arrays y las tuplas. Se tratará de tipos de datos que no tiene un tamaño predeterminado si no que pueden crecer a medida que se les añaden elementos (`ArrayList`, `List`, ...). También hay tipos que guardan sus elementos asociados a un valor o clave (`Hastable`, `Dictionary`, ...).

Estos tipos de datos atos tenemos que dividirlos en dos categorías **no-genéricos** y **genéricos**.

Los primeros son tipos que admiten **cualquier tipo de dato como contenido**. Es decir, contendrán elementos del tipo `Object`.

## Tipos no-genéricos

## Tipos genéricos

La forma de trabajar con genéricos en C# es básicamente idéntica a Java.

### Declaración de genéricos

```c#
class ContenedorGenerico<T>
{
    private T[] array;
    private int count;

    public ContenedorGenerico(int size)
    {
        array = new T[size];
        count = 0;
    }

    public void Add(T element)
    {
        if (count < array.Length)
        {
            array[count] = element;
            count++;
        }
    }

    public T Get(int index)
    {
        if (index < count)
        {
            return array[index];
        }
        else
        {
            throw new IndexOutOfRangeException();
        }
    }

    public void Set(int index, T element)
    {
        if (index < count)
        {
            array[index] = element;
        }
        else
        {
            throw new IndexOutOfRangeException();
        }
    }

    // Esta sería una propiedad de solo lectura.
    public int Count
    {
        get
        {
            return count;
        }
    }

    public T this[int index]
    {
        get
        {
            return Get(index);
        }
        set
        {
            Set(index, value);
        }
    }
}
```

## Listas

De nuevo las listas de C# son muy similares a las listas de Java, aunque en C# sólo hay un tipo de lista `List` en lugar de `ArrayList` y `LinkedList` de Java.

### Declarar una lista

Para declarar una lista en C# hemos de indicar el tipo de dato que va a contener la lista como con cualquier otra clase genérica:

```c#
List<string> listaCadenas = new List<String>();
```

#### Declarar e inicializar

También es posible declarar una lista y al mismo tiempo darle unos valores iniciales:

```c#
List<int> listaEnteros = new List<int>() {1, 2, 3, 4, 5};
```

### Añadir elementos

Para añadir elementos (al final de la lista) usaremos el método `Add`:

```c#
List<int> listaEnteros = new List<int>() {1, 2, 3, 4, 5};

listaEnteros.Add(6);

listaEnteros.ForEach(e => Console.Write(e + ", "));

// 1, 2, 3, 4, 5, 6, 
```

Y en caso de que deseemos insertar el valor en una posición determinada usaremos el método `Insert`:

```c#
List<int> listaEnteros = new List<int>() {1, 2, 3, 4, 5};

listaEnteros.Insert(2, 3);

for (int e in listaEnteros)
{
    Console.Write(e + ", ");
}

// 1, 2, 3, 3, 4, 5

## Pilas


## Colas


## Mapas
