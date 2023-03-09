# Tema 10.0: Flujos o `Stream`s

Un `Stream` representa un flujo de datos, generalmente unidireccional, desde un origen a un destino.
Los `Stream`s se usan comúnmente para leer y escribir datos desde o hacia un fichero.

## Creación de un `Stream`

Para crear un `Stream` a partir de un fichero usaremos la clase `FileStream`.
`FileStream` *guarda* o representa la información como un array de bytes.

Para usar un `FileStream` para lectura o escritura habrá que indicar el número de bytes que deseamos usar (leer o escribir).

El constructor de un `FileStream` acepta dos argumentos:

- *Path* al fichero sobre el que vamos a actuar.
- La enumeración `FileMode` que Especifica cómo el sistema operativo debe abrir un archivo y ofrece las siguientes opciones:
  - `CreateNew`: Especifica que el sistema operativo debe crear un archivo nuevo. Si el archivo ya existe, se produce una excepción `System.IO.IOException`.
  - `Create`: Especifica que el sistema operativo debe crear un archivo nuevo. Si el archivo ya existe, se sobrescribirá.
    - Si el archivo no existe es equivalente a `CreateNew`.
    - Si el archivo existe será equivalente al `Truncate`.
  - `Open`: Especifica que el sistema operativo debe abrir un archivo existente. Se desencadena una excepción `FileNotFoundException` si el archivo no existe
  - `OpenOrCreate`: Especifica que el sistema operativo debe abrir un archivo si ya existe; en caso contrario, debe crearse uno nuevo.
  - `Truncate`:Especifica que el sistema operativo debe abrir un archivo existente. Cuando se abre el archivo, debe truncarse el archivo para que su tamaño sea de cero bytes. Al intentar leer un archivo abierto con `Truncate`, se produce una excepción `ArgumentException`.
  - `Append`:   Abre el archivo si existe y realiza una búsqueda hasta el final del mismo, o crea un archivo nuevo. Se produce un error de cualquier intento de lectura y una excepción `NotSupportedException`.

Veamos un ejemplo:

``` C#
FileStream fs = new FileStream("fichero.txt", FileMode.Open);
```

Este código crea un objeto `FileStream` que representa el fichero `fichero.txt` y que se abrirá en modo lectura.

Una vez creado el objeto `FileStream` podemos usarlo para leer o escribir datos:

### Lectura de bytes de un `FileStream`

Para leer bytes directamente de un `FileStream` usaremos el método `Read` que acepta tres argumentos:

- Un array de bytes donde se guardarán los datos leídos.
- Un valor de *offset* que indica a partir de que posición del array deseamos escribir los datos leídos.
- El número de bytes que deseamos leer.

``` C#
byte[] buffer = new byte[100];
int nBytes = fs.Read(buffer, 0, 100);
```

### Escritura de bytes a un `FileStream`

Para escribir bytes directamente a un `FileStream` usaremos el método `Write` que acepta tres argumentos:

- Un array de bytes que contiene los datos a escribir.
- El valor de *offset* que indica a partir de que posición del array deseamos escribir.
- El número de bytes que deseamos escribir.

``` C#
byte[] buffer = new byte[100];

for (int i = -100; i < 100; i++)
{
    buffer[i] = (byte)i;
}

int nBytes = fs.Write(buffer, 0, 100);
```

### Los flujos han de **cerrarse**

Los flujos representan recursos y, por tanto, hay que cerrarlos cuando ya no se vayan a usar.

Para cerrar un flujo usaremos el método `Close()`.

Si no cerramos explícitamente el flujo, el recolector de basura de .NET no lo cerrará y, por tanto, no liberará los recursos que ocupa.

Puesto que nos podemos olvidar de invocar a `Close()` o podría producirse una excepción que impida que se cierre el flujo, es recomendable usarlos dentro de un bloque `using` que se encargará de cerrarlos automáticamente.

## Sentencia `using` para trabajar con recursos

Para evitar tener que cerrar explícitamente los recursos que se usan en un bloque de código, podemos usar la sentencia `using` que nos permite trabajar con recursos de forma segura.

Si necesitamos trabajar con varios recursos (`Streams`) en un mismo segmento de código podemos usar varios bloques `using` consecutivos.

``` C#
using (FileStream fs = new FileStream("fichero.txt", FileMode.Open))
using (StreamWriter sw = new StreamWriter(fs))
{
    // Trabajamos con el flujo sw.
}
// Aquí el flujo sw ya está cerrado.
```

## Escritura de texto a un fichero

Aunque, como hemos visto, es posible leer y escribir en un fichero utilizando simplemente referencias `FileStream`, estas nos limitan a hacerlo en forma de bytes.

Para escribir texto a un fichero es recomendable usar un objeto `StreamWriter`.
El constructor de `StreamWriter` acepta dos argumentos (el segundo opcional):

- El flujo sobre el que vamos a escribir (un objeto `FileStream` en este caso).
- La codificación del texto (tomada de la enumeración `System.Text.Encoding`):
  - Será `UTF-8` si no se indica nada (opción por defecto).
  - Podrá ser `ASCII`, `Unicode`, `Default`, etc.
  
Para escribir usaremos el método `WriteLine` del objeto `StreamWriter` que hayamos creado.
El método `WriteLine` tiene el comportamiento del `Console.WriteLine()` pues se trata del mismo método ya que `Console` se comporta como un `StreamWriter`.

Veamos un ejemplo:
  
``` C#
using (FileStream fs = new FileStream("fichero.txt", FileMode.Create))
using (StreamWriter sw = new StreamWriter(fs))
{
    sw.WriteLine("Hola mundo");
}
```

## Lectura de texto de un fichero

## Escritura de
 bytes (o texto) a un fichero

Para escribir bytes (o texto) a un fichero es recomendable usar un objeto `BinaryWriter`.
`BinaryWriter` permite escribir un array de bytes o un texto (también números y caracteres). Este objeto facilita la escritura a un archivo de datos de tipos primitivos así como de cadenas de caracteres.
Si vamos a escribir caracteres podremos crear el objeto `BinaryWriter` indicando la codificación de los caracteres (por defecto será `UTF-8`).

``` C#
using (FileStream fs = new FileStream("fichero.txt", FileMode.Create))
using (BinaryWriter bw = new BinaryWriter(fs, Encoding.UTF8))
{
    // Trabajamos con el flujo bw
}
```

Para escribir mediante el `BinaryWriter` podemos usar el método `Write` que acepta uno o tres argumentos:

### `Write` con un argumento

Se usa para escribir tipos primitivos al stream (que hace referencia a un fichero en nuestros ejemplos).

``` C#
bw.Write(1);
bw.Write(1.5);
bw.Write('a');
bw.Write(true);

// También acepta strings:
bw.Write("Hola mundo");

// Y arrays de chars:
bw.Write(new char[] { 'a', 'b', 'c' });
```

Cuando escribimos una cadena usando el método `Write` de `BinaryWriter` hemos de tener en cuenta que la conversión a bytes la realizará en función de la codificación que hayamos indicado al crear el objeto `BinaryWriter`.

### `Write` con tres argumentos

Los argumentos son:

- Array a escribir (`byte[]` o `char[]`).
- Un valor de *offset* que indica a partir de que posición del array deseamos escribir.
- Un último valor *longitud* que indica cuantos bytes del array (a partir del *offset*) vamos a escribir.

Veámoslo con un ejemplo:

``` C#
using(FileStream fs = new FileStream("fichero.txt", FileMode.Create) using(BinaryWriter bw = new BinaryWriter(fs))
{
    byte[] buffer = new byte[100];
    for (int i = 0; i < 100; i++)
    {
        buffer[i] = (byte)i;
    }

    // Escribimos los números de 9 al 19
    bw.Write(buffer, 10, 10);
}
```

## Lectura de bytes (o texto) de un fichero

Para leer bytes (o texto) de un fichero es recomendable usar un objeto `BinaryReader`.