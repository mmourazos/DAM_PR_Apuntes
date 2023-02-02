m# Extra: Lambdas en Java

Las lambda (equivalentes a métodos en Java) son funciones que se pueden pasar directamente como parámetro a un método.

Para poder utilizar una lambda como parámetro hemos de declarar el argumento del método como un **interfaz** que **sólo tenga un método requerido**.

Así, podríamos decir que el mecanismo de uso de las lambda consta de tres partes:

* El interfaz que define **cómo ha de ser la lambda**.
* El método que acepta como parámetro el interfaz.
* Y la expresión lambda propiamente dicha.

Veámoslo con un ejemplo:

Imaginemos que tenemos una clase `Alumno` y deseamos ordenar objetos de dicha clase. Existe una interfaz en Java que nos permite definir formas de comparar objetos `Compartor`. Esta interfaz sólo define como obligatorio el método `compare` que admite dos argumentos.

Si creamos un par de métodos para obtener el _primero_ y _último_ alumno de una lista según algun criterio podríamos hacer lo siguiente:

```java
public static Alumno primero(List<Alumno> l, Comparator<Alumno> c) {
    Alumno m = l.get(0);
    
    for (Alumno a : l) {
        if (c.compare(a, m) < 0) {
            m = a;
        }
    }
    
    return m
}

public static Alumno ultimo(List<Alumno> l, Comparator<Alumno> c) {
    Alumno m = l.get(0);
    
    for (Alumno a : l) {
        if (c.compare(a, m) > 0) {
            m = a;
        }
    }
    
    return m
}
```

Dependiendo del comparador que le pasemos a los métodos `primero` y `ultimo` devolverán el alumno con menor (mayor) edad, menor (mayor) nota, etc.

En lugar de crear una clase que implemente `Comparator`, crear una instancia de la misma y pasársela al método `menor`, lo que podremos hacer es pasar una lambda:

```java
// Para obtener el alumno con menor edad:
Alumno menor = primero(alumnos, (a1, a2) -> a1.edad() - a2.edad());

// Para obtener el alumno con mejor nota:
Alumno mejor = ultimo(alumnos, (a1, a2) -> a1.nota() - a2.nota());
```

Si a1 tiene menor edad (nota) que a2 el resultado será negativo (lo que indica que a1 es _menor_ que a2). Si el resultado es cero significa que la edad de a1 y la de a2 son la misma y si el resultado es positivo significará que la edad (nota) de a2 será _mayor_ que la de a1.
