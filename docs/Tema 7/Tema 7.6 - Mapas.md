# Tema 7.5: Mapas

Los mapas son estructuras de datos de Java que almacenan dos valores por cada entrada. Un de los valores funcionará como una clave a partir de la cual se podrá obtener el valor con el que está emparejado. Así, diremos que un mapa se compone de pares **clave - valor**.

En un mapa **nunca podrán existir dos claves iguales**.

Los mapas, al igual que todas las demás estructuras de datos (salvo los arrays) son genéricos, por lo que habrá que indicar el tipo tanto de la clave como del valor.

## Definición de un mapa

La sintaxis para definir un mapa es la siguiente:

```java
Map<String, Alumno> mapaAlumnos = new HashMap<>();
```

Para instar elementos en el mapa deberemos de usar el método `put` pasándole el par _clave - valor_:

```java
mapaAlumnos.put("primero", new Alumno("Ángel", "32124F", "16-07-2005"));
```

Y para extraer elementos (en nuestro ejemplo de tipo `Alumno`) usaremos `get` pasándolo la _clave_.

```java
Alumno alumno = mapaAlumnos.get("primero");
```

## Tipos de mapas

En Java existen tres tipos de mapas ya implementados:

* `HashMap`
* `TreeMap`
* `LinkedHashMap`

Las diferencias existentes entre ellos son respecto a cómo almacenan los datos internamente y, como consecuencia de ello, la velocidad con que se pueden realizar las operaciones de inserción y extracción de datos.

### `HashMap`

Almacena los elementos en una tabla [_hash_](https://en.wikipedia.org/wiki/Hash_table) y es el más rápido. Como consecuencia de su método de almacenamiento no se puede saber a priori con qué orden se iteraría sobre los datos. Es decir, un `HashMap` **no garantiza ningún orden en sus elementos cuando es recorrido**.

### `TreeMap`

Un `TreeMap` emplea una estructura de [árbol binario](https://es.wikipedia.org/wiki/Árbol_binario). Esto permite que el `TreeMap` ofrezca una [complejidad logarítmica (log(n))](https://es.wikipedia.org/wiki/Complejidad_temporal#Tiempo_logar%C3%ADtmico) bastante eficiente para las operaciones `containsKey`, `get`, `put` and `remove`.

Los elementos se encontrarán _ordenados_ con respecto a la clave. Se le puede pasar un `Comparator` para establecer un orden respecto a la clave.

### `LinkedHashMap`

Un `LinkedHashMap` almacena los datos de la misma forma que un `HashMap` pero guarda además información sobre el orden en que fueron insertados. De este modo, al iterar sobre un `LinkedHashMap` éste se recorrerá en el orden en que fueron introducidas sus entradas. Es decir, un `LinkedHashMap` **garantiza que sus elementos se recorrerán en el orden en que fueron insertados**.

### Como recorrer un mapa

Existen varias formas de recorrer un mapa dependiendo de la función que usemos para obtener su contenido en forma de `Iterable`:

* `entrySet()`: Nos devolverá el contenido de un mapa en forma de un conjunto de las entradas (pares clave - valor) del mapa.
* `keySet()`: Nos devolverá a su vez un conjunto con las claves del mapa.
* `values()`: De manera similar a las anteriores, nos devolverá un conjunto con los valores del mapa.

#### Bucle `for` mejorado

Este bucle podremos utilizarlo tanto con `entrySet()`:

```java
for (Entry<String, Alumno> entrada : mapa.entrySet()) {
    System.out.println(entrada.getKey() + " -> " + entrada.getValue());
}
```

como con `keySet()`:

```java
for (String clave : mapa.keySet()) {
    System.out.println(clave + " -> " + mapa.get(clave));
}
```

o directamente con `values()`:

```java
for (Alumno valor : mapa.values()) {
    System.out.println(valor);
}
```

#### Método `forEach()`

Los mapas, así como todas las clases que implementan `Collection`, disponen de un método denominado `forEach()`. Este método acepta una función **lambda** con dos parámetros como entrada. El primer parámetro de la lambda será la clave y el segundo su valor asociado. Esta función lambda se aplicará a cada **entrada** del mapa.

```java
mapa.forEach((k, v) -> System.out.println(k + " -> " + v));
```
