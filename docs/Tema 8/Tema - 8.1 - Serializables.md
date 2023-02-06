# Tema 8.1: Serializables

## Objetos P.O.J.O. (_Plain_ _Old_ _Java_ _Object_)

Un _POJO_ es cualquier clase definida en Java que cumpla estas tres condiciones:

1. No puede extender ninguna otra clase.
2. No puede implementar ningún interfaz.
3. No puede usar _anotaciones externas_.

**Veamos un ejemplo:**

La siguiente clase será un _POJO_.

```java
public class Gato {
    String nombre;
    LocalDate fechaNacimiento;
}
```

## Objetos _JavaBean_

Un objeto _JavaBean_ debe cumplir las siguientes condiciones:

1. Ha de disponer de un constructor **sin argumentos**.
2. Todas sus propiedades han de ser privadas.
3. Tendrá _getters_ y _setters_ públicos.
4. Será **serializable**.

**Veamos un ejemplo:**

Convitamos la clase `Gato` a un _JavaBean_:

```java
public class Gato implements Serializable {
    private String nombre;
    private LocalDate fechaNacimiento;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento
    }
}
```

## Serializable

Que una clase sea serializabe quiere decir que dicha clase se puede _escribir_ y _leer_ de una base de datos o un fichero.

Para que una clase sera serializabe ha de implementar el interfaz `Serializable`.

```java
public class Alumno implements Serializable {
    // ...
}
```

## Guardar objetos en ficheros

Los objetos serializables pueden ser escritos en ficheros y, obviamente, recuperdos leyéndolos del fichero.

### Escritura de objeto a fichero

Para escribir un objeto a un fichero hemos de utilizar un `ObjectOutputStream`. Esto objeto necesitará a su vez que le pasemos algún lugar a dónde _enviar_ el objeto. En el caso de escritura a un fichero usaremos un `FileOutputStream`.

Veámoslo con un ejemplo:

```java

Gato gatito = new Gato();
gatito.setNombre("Michi");
gatito.setFechaNacimiento(new LocalDate())

```