# Tema 9.7: Tipos avanzados de datos

Con tipos avanzados de datos me refiero a los tipos de datos que son más complejos que los arrays y las tuplas. Se tratará de tipos de datos que no tiene un tamaño predeterminado si no que pueden crecer a medida que se les añaden elementos (`ArrayList`, `List`, ...). También hay tipos que guardan sus elementos asociados a un valor o clave (`Hastable`, `Dictionary`, ...).

Estos tipos de datos atos tenemos que dividirlos en dos categorías **no-genéricos** y **genéricos**.

Los primeros son tipos que admiten **cualquier tipo de dato como contenido**. Es decir, contendrán elementos del tipo `Object`.

## Tipos no-genéricos

Los tipos de datos no genéricos admiten datos de tipo `Object`. Para cada estructura de datos no genérica hay una equivalente genérica.

### ArrayList

El tipo `ArrayList` es una lista de tamaño dinámico que admite cualquier tipo de dato. Es decir, podemos añadir elementos de cualquier tipo a la lista. Para acceder a los elementos de la lista debemos hacer un casting explícito al tipo de dato que queremos recuperar.

#### Declaración de un ArrayList

```c#
ArrayList lista = new ArrayList();
```

Aunque no es necesario, podemos indicar el tamaño inicial de la lista:

```c#
ArrayList lista = new ArrayList(10);
```

### Añadir elementos

```c#
ArrayList lista = new ArrayList();

// Añadimos elementos a la lista.
// Se añaden como objetos de tipo Object.
lista.Add(1);
lista.Add("Hola");
lista.Add(3.14);

```

### Acceder a sus elementos

Para acceder a un elemento del `ArrayList` hemos de indicar el índice del elemento que queremos recuperar. El primer elemento tiene el índice 0.
Para poder utilizar el elemento, ya que se almacenó como `Object` debemos hacer un casting explícito al tipo de dato que queremos recuperar.

Para recuperar un elemento usaremos el método `Get()` pasándole como argumento el índice del elemento que queremos recuperar. También podemos acceder a los elementos del `ArrayList` como si fuera un array:

```c#
// 
// Usando el método Get().
int entero = (int)lista.Get(0);


// Usando el operador [].
int entero = (int)lista[0];
```

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

### Añadir elementos a la lista

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

## Diccionarios
