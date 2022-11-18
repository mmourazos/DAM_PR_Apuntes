# Genéricos

## Introducción

¿Para qué sirven los generics?

Los generics nos permiten crear clases y métodos que pueden trabajar con cualquier tipo de dato, sin necesidad de especificar el tipo de dato concreto.

Veamos un ejemplo:

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

Esta clase sólo puede almacenar valores `Integer`, pero si queremos que pueda almacenar valores de cualquier tipo, tendremos que crear una clase para cada tipo de dato que queramos almacenar:

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

Y tendríamos que crear una clase para cualquier nuevo tipo de dato que queramos almacenar e imprimir.

Para evitar tener que repetir una y otra vez el código de la clase podemos utilizar los generics. Esto permitirá crear una clase que pueda almacenar cualquier tipo de dato y que pueda imprimirlo. Indicaremos el tipo concreto en el momento de usar la clase. El código de la clase sería de esta forma *genérico*. Valdría para cualquier tipo de dato.

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

## Sintaxis de los generics

Los generics se definen entre `<` y `>`. Dentro de los `<` y `>` se indica el tipo de dato que queremos almacenar.

```java
ArrayList<String> lista = new ArrayList<>();
```

Nótese que no es necesario repetir el tipo que usamos al crear la instancia de clase y en su lugar podemos poner simplemente `<>`.

### Tipos de datos genéricos

El tipo dato que indicamos al crear la clase genérica puede ser cualquier tipo de dato, incluyendo clases, interfaces, etc. pero **no puede ser un tipo primitivo**.

Por ejemplo, podemos indicar que nuestro genérico solo administre tipos de datos que implementen la interfaz `Comparable`:

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
