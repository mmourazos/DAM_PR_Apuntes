# Tema 8: Entrada y salida a ficheros

## Escribir texto a un fichero

Para escribir datos en un fichero lo primero que hemos de crear es un objeto de la clase `FileWriter`:

```java
FileWriter fb = new FileWriter("fichero.txt");
```

Ahora, para escribir en este objeto que hace referencia a un fichero hemos de usar un `BufferedWriter`. Un `BufferedWriter` será un objeto que puede escribir en muchos _sitios_ distintos por lo que hemos de indicarle que ba a trabajar sobre nuestro fichero:

```java
FileWriter file = new FileWriter("fichero.txt");

BufferedWriter writer = new BufferedWriter(file);
```

Finalmente para escribir en el fichero hemos de invocar al método `write` del `BufferedWriter`:

```java
FileWriter file = new FileWriter("fichero.txt");

BufferedWriter writer = new BufferedWriter(file);

writer.write("Hola mundo cruel");
```

Pero si intentas escribir este código en un IDE se mostrará un error: `Unhandled exception type IOException`. Esto se debe a que la creación de un `FileWriter` puede lanzar una excepción.

Para solventar este error podremos o bien indicar que el método donde nos encontramos puede lanzar esta excepción:

```java
public void miMetodo(String nombreFichero, String texto) throws IOException {
    FileWriter file = new FileWriter(nombreFichero);

    BufferedWriter writer = new BufferedWriter(file);

    writer.write(texto);
}
```

O bien rodeamos el código con una estructura _try-catch_:

```java
public void miMetodo(String fichero, String texto) {
    
    try {
        FileWriter file = new FileWriter(fichero);

        BufferedWriter writer = new BufferedWriter(file);

        writer.write(texto);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

Puesto que cuando creamos nuestro fichero para escribir no indicamos una ruta completa el fichero se creará en el directorio raíz de nuestro proyecto.

Una cosa que no hemos de olvidar es que estos objetos están asociados a un recurso del sistema (el fichero que hemos abierto para escritura). De modo que este recurso estará _ocupado_ mientras no indiquemos lo contrario. Para evitar que el recurso esté ocupado indefinidamente hemos de indicarlo usando el método `close()` cuando hayamos terminado de trabajar con él.
Además, en este caso concreto, no es escribirá nada en el fichero hasta que cerremos el recurso asociado:

```java
public void miMetodo(String fichero, String texto) {
    
    try {
        FileWriter file = new FileWriter(fichero);

        BufferedWriter writer = new BufferedWriter(file);

        writer.write(texto);

        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## Leer texto de un fichero

El proceso de lectura de un fichero es muy similar al de escritura.

Primero hemos de crear un `BufferedReader` asociado al fichero que queremos leer:

```java
public String leeFichero(String nombreFichero) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

Para leer una línea del fichero llamaremos al método `readLine()` del objeto `BufferedReader`. Este método devolverá la siguiente linea del fichero o `null` si ya se ha llegado al final y no hay nada que leer:

```java
public String leeFichero(String nombreFichero) {
    String lineaLeida = null;
    String textoLeido = null;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));

        do {
            lineaLeida = reader.readLine();
            if (lineaLeida != null) textoSalida += lineaLeida + "\n";

        } while (lineaLedia != null);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return textoLeido;
}
```

## Sentencia _Try-con-recursos_

Para evitar tener que cerrar explícitamente los recursos que abrimos podemos usar una variante de _try-catch_ pero de la siguiente forma:

```java
try (FileReader fr = new FileReader(fileName); BufferedWriter writer = new BufferedWriter(fr)) {
    // Código que utiliza el writer.
} catch (IOException e) {
    e.printStackTrace();
}
```

Esta sentencia **asegura** que tanto el 

## Añadir texto a un fichero

Si ejecutamos el código de las secciones anteriores se **sobrescribe** el contenido del fichero que indiquemos con el texto que indiquemos. Si queremos añadir texto sin sobrescribir hemos de usar un constructor distinto de `FileWriter`:

```java
try (FileWriter fr = new FileWriter(fileName, true); BufferedWriter writer = new BufferedWriter(fr)) {
    // Ahora añadimos texto al fichero.
    writer.write(txt);
} catch (IOException e) {
    e.printStackTrace();
}
```

El constructor `FileWriter(String fileName, boolean append)` abrirá el fichero para añadir contenido si `append` es `true`.

## Escritura de datos / _bits_

Lo que hemos visto hasta ahora fueron formas de escribir texto a ficheros. Es posible que en lugar de texto lo que necesitemos es escribir datos en binario (como sería el caso de un fichero de imagen, vídeo o audio). Para escribir binario a un fichero hemos de utilizar objetos `FileOutputStream` (y `FileInputStream` para leer).

### Escritura binaria a un fichero

Para crear un `FileOutputStream` hemos de indicar el nombre del fichero (la ruta en realidad) y añadir `true` si queremos indicar que deseamos añadir datos al fichero en lugar de sobrescribirlo.

```java
OutputStream out = new FileOutputStream(fileName);
```

Para escribir datos podremos usar distintos métodos pero el más sencillo será `write` al que le pasaremos tres argumentos: 

1. El array de bytes que deseamos escribir.
2. El número de bytes del array que deseamos saltarnos (en nuestro caso 0).
3. El número de bytes del array que desamos escribir (en nuestro caso la longitud del array).

```java
OutputStream out = new FileOutputStream(fileName);

// data es un byte[].
out.write(data, 0, data.length);
```

Un `OutputStream` es un recurso que ha de ser cerrado después de su uso por lo que deberíamos usar `try`:

```java
public void writeBinaryDataToFile(String fileName, byte[] BinaryData) {
    try (OutputStream out = new FileOutputStream(fileName)) {
        out.write(data, 0, data.length);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Lectura binaria de un fichero

Este caso es muy similar al anterior. La única diferencia es que si especificamos cuánto leer podríamos:

* No tener nada que leer (fichero vació).
* Que quede menos que leer que nuestro límite.

Por este motivo el método `read` de `InputStream` puede devolver dos valores:

* `-1`: en caso de que no haya podido leer (fin de fichero, fichero vacío, etc.).
* El número de bytes leidos.

Por lo tanto si deseamos leer el contenido **total** de un fichero a memoria usaremos el método `readAllBytes` pero hemos de tener en cuenta que es posible que el fichero no quepa en memoria.

```java
public byte[] readAllFromFile(Sting fileName) {
    byte[] fileData = null;
    try (InputStream input = new FileInputStream(fileName)) {
        fileData = input.readAllBytes();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return fileData;
}
```

Para leer bloques de un tamaño determinado mientras haya algo que leer escribiríamos:

```java
public static final int BUFFER_SIZE = 4096; // 4 KiB.

// más código

byte[] buffer = new byte[BUFFER_SIZE];

// ...

while ((bytesReaded = input.read(buffer, 0, BUFFER_SIZE)) != -1) {
    // Hacer cosas con los datos leidos, bytesReaded bytes guardados en buffer.
}
```
