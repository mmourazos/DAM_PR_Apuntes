# Flujos o `Stream`s

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

### Los flujos han de **cerrarse**

Los flujos representan recursos y, por tanto, hay que cerrarlos cuando ya no se vayan a usar.

Para cerrar un flujo usaremos el método `Close()`.

## Sentencia `using` para trabajar con recursos

Para evitar tener que cerrar explícitamente los recursos que se usan en un bloque de código, podemos usar la sentencia `using` que nos permite trabajar con recursos de forma segura.

``` C#
using (FileStream fs = new FileStream("fichero.txt", FileMode.Open))
using (StreamWriter sw = new StreamWriter(fs))
{
    // Trabajamos con el flujo sw
}
```

## Escritura de texto a un fichero

Para escribir texto a un fichero es recomendable usar un objeto [[StreamWriter]].
El constructor de `StreamWriter` acepta dos argumentos (el segundo opcional):

- El flujo sobre el que vamos a escribir (un objeto `FileStream` en este caso).
- La codificación del texto (`System.Text.Encoding`):
  - Será `UTF-8` si no se indica nada.
  - Podrá ser `ASCII`, `Unicode`, `Default`, etc.
  
Para escribir usaremos el método `WriteLine`del objeto `StreamWriter` que hayamos creado.
El método `WriteLine` tiene el comportamiento de `Console.WriteLine()`.

### Escribir bytes (o texto) a un fichero

Para escribir bytes (o texto) a un fichero es recomendable usar un objeto `BinaryWriter`.
`BinaryWriter` permite escribir un array de bytes o un texto (también números y caracteres).
Se puede llamar con un argumento pasándole el dato que queremos escribir (array de bytes o cadena generalmente) o...
Se puede llamar con tres argumentos:

- Array a escribir (`byte[]` o `char[]`).
- Un valor de *offset* que indica a partir de que posición del array deseamos escribir.
- Un último valor *longitud* que indica cuantos bytes del array (a partir del *offset*) vamos a escribir.
