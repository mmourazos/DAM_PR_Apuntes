# Tema 7.1 Genéricos

## Introducción

¿Para qué sirven los genéricos?

Los genéricos nos permiten crear clases y métodos que pueden trabajar con **cualquier tipo de dato**, sin necesidad de especificar el tipo de dato concreto en el momento de definir las clases. Debido a que no se especifica el tipo exacto en la fase de diseño de la clase podemos decir que usa un tipo _genérico_ y de ahí su nombre.

En el momento en que creemos objetos de una clase que use genéricos **sí hemos de concretar con qué tipo de datos va a trabajar**.

### Ejemplo _práctico_

Veámoslo con un ejemplo:

Imaginemos que queremos que una clase almacenen un valor `Integer` y pueda imprimirlo:

```java
public class AlmacenadorEntero {
    private Integer valor;
    public Almacenador(Integer valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

Esta clase sólo puede almacenar e imprimir valores `Integer`, pero si queremos una clase que tenga la misma funcionalidad que pueda almacenar valores `Double` o `Float`, tendremos que crear una nueva clase (virtualmente idéntica) para cada tipo de dato nuevo que queramos tratar:

```java
public class AmacenadorDoble {
    private Doble valor;
    public Almacenador(Doble valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

Para evitar tener que repetir una y otra vez _el mismo código_ en cada clase podemos utilizar los **genéricos**. Esto permitirá crear una clase que pueda almacenar cualquier tipo de dato y que pueda imprimirlo. Indicaremos el tipo concreto en el momento de usar la clase (de crear un objeto). El código de la clase sería de esta forma *genérico*. Valdría para cualquier tipo de dato.

En el siguiente ejemplo de código usamos `T` para indicar _un tipo cualquiera_ que especificaremos en otro momento. No es necesario usar la letra **T** pero una vez la indiquemos hemos de mantener la consistencia y emplear la misma letra para indicar el tipo genérico:

```java
public class Almacenador<T> {
    private T valor;
    public Almacenador(T valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

A la hora de utilizarlo debemos indicar el tipo de dato concreto que queremos almacenar. Por ejemplo, si queremos almacenar un `Integer`:

```java
public class Main {
    public static void main(String[] args) {
        Almacenador<Integer> almacenador = new Almacenador<>(5);
        almacenador.imprimir();
    }
}
```

## Sintaxis de los genéricos

Como acabamos de ver en el ejemplo la sintaxis de los genéricos es muy sencilla.

### Declaración de la clase

En el momento de declarar una clase que use genéricos primero escribiremos el código de declaración de la misma como siempre:

```java
public class MiClase {
    //...
}
```

A continuación indicaremos entre los símbolos `<` y `>` una palabra (generalmente la letra T) que indica el tipo genérico:

```java
public class MiClase<T> {
    //... 
}
```

Si fuese necesario se podrán indicar varios genéricos:

```java
public class MiClase<T, E> {
    //...
}
```

Después de indicar el **código (T, E, etc.)** del tipo genérico que se va a utilizar en la clase podremos utilizar este código como indicador de tipo de las variables y métodos:

```java
public class MiClase<T, E> {
    private ArrayList<T> datos;
    
    public E resultado(T dato) {
        // ...
    }
}
```

Cuando, al usar la clase genérica, indiquemos el tipo concreto que queremos usar se substituirá `T` en el código de la clase por dicho tipo concreto.

### Uso de la clase

Cuando necesitemos crear una instancia de nuestra clase **hemos de concretar con qué dato va a trabajar**:

```java
MiClase<Integer, String> mc = new MiClase<Integer, String>();
```

Puesto que es redundante repetir el tipo de dato Java permite omitirlo para mayor comodidad:

```java
MiClase<String> mc = new MiClase<>();
```

Esto hará que Java _transforme_ el código del la clase generica en el siguiente antes de crear la instancia:
_(Es una forma de verlo, no digo que haga esto **literalmente**)._

```java
public class MiClase {
    private ArrayList<Integer> datos;
    
    public String resultado(Integer dato) {
        // ...
    }
}
```

### Tipos de datos genéricos

El tipo dato que indicamos al crear la clase genérica puede ser cualquier _tipo de dato_, incluyendo clases, interfaces, etc. pero **no puede ser un tipo primitivo**.

```java
// El siguiente código no sería válido:
MiClase<int> mc = new MiClase<>();
// Tendríamos que utilizar la clase envoltorio Integer:
MiClase<Integer> mc = new MiClase<>();
```

Nótese también que, si trabajamos con tipos primitivos (`int`, `float`, `boolean`, etc.) no es necesario convertir expícitamente éste a su tipo envoltorio (`Integer`, `Float`, `Boolean`, etc.) ya que Java lo hace automáticamente.

```java	
ArrayList<Integer> listaInt = new ArrayList<>();

listaInt.add(5); // Esto es válido
listaInt.add
(Integer.valueOf(6)); // Esto también es válido pero más complicado e innecesario.
```

## Genéricos limitados

También es posible **limitar o restringir** las características del tipo de datos genérico que vamos a usar.

### Limitar superclase

Por ejemplo, si queremos usar un tipo genérico pero que sea de un tipo dado (por ejemplo `Persona`) lo podemos indicar como:

```java
public class Almacenador<T extends Persona> {
    private T valor;
    public Almacenador(T valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

Una vez hecho esto una variable de tipo `T` tendrá acceso a todos los métodos de `Persona` y, cuando se cree una instancia de `Almacenador` se tendrá que indicar un tipo que herede de `Persona`.

### Limitar interfaz

Del mismo modo que podemos limitar cual ha de ser la superclase del tipo de nuestro genérico también podemos hacer lo mismo con respecto a un interfaz:

```java
public class Almacenador<T extends Comparable> {
    private T valor;
    public Almacenador(T valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

Nótese que hemos de utilizar **extends** tanto para indicar la superclase como el interfaz que implementa y no **implements** (que sería lo _lógico_).

### Limitar superclase e interfaces

Podemos combinar la limitación de superclase con la indicación de que ha de implementar uno o más interfaces. Para ello **hemos de indicar primero siempre la superclase** y a continuación todos los interfaces que deseemos **separados por &**:

```java
public class Almacenador<T extends Persona & Comparable & Serializable> {
    private T valor;
    public Almacenador(T valor) {
        this.valor = valor;
    }
    public void imprimir() {
        System.out.println(valor);
    }
}
```

## Métodos genéricos

Los métodos también pueden ser genéricos. Para ello, simplemente indicamos el tipo de dato genérico entre `<` y `>` después del tipo de retorno del método.

```java
public class Printer {
    public static <T> void print(T valor) {
        System.out.println(valor);
    }
}
```

Si queremos que el método admita más de un genérico:

```java
public class GenericMethod {
    public static <T, U> void print(T valor1, U valor2) {
        System.out.println(valor1);
        System.out.println(valor2);
    }
}
```

## Comodines (_wildcards_)

Hay casos en los que deseamos indicar que un método que estamos escribiendo admite un tipo genérico con cualquier tipo de datos. Veamos un ejemplo:

```java
public class MiClase {
    //...
    // Este código no es correcto, es sólo ilustrativo.
    public static void imprime(List<DeLoQueSea> lista) {
        //...
    }
}
```

Nuestro método `imprime` estará diseñado de manera que pueda imprimir una lista independientemente de lo que contenga. Para indicar esto en la sintaxis de genéricos hemos de escribir un **comodín (`?`)** como tipo de la lista:

```java
public class MiClase {
    //...
    // Este código no es correcto, es sólo ilustrativo.
    public static void imprime(List<?> lista) {
        //...
    }
}
```
