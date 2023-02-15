# Tema 7.4: Mapas

Los mapas son estructuras de datos de Java que almacenan dos valores por cada entrada. Un de los valores funcionará como una clave a partir de la cual se podrá obtener el valor con el que está emparejado. Así, diremos que un mapa se compone de pares **clave - valor**.

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

Almacena los elementos en una tabla [_hash_](https://en.wikipedia.org/wiki/Hash_table) y es el más rápido. Como consecuencia de este método de almacenamiento **no se puede saber a priori con qué orden se iteraría sobre los datos**.

En cuanto a rendimiento las operaciones básicas se realizan en tiempo constante.

Tiene penalización si varía mucho de tamaño o en caso de colecciones muy grandes (cuando un `HashMap` alcanza un cierto tamaño se _transformará_ en un tipo de `TreeMap`).

### `TreeMap`

Este mapa almacena sus elementos en un árbol binario equilibrado. El orden con que se almacenan los elementos será siguiente el **orden natural de sus claves**.

El rendimiento es logarítmico respecto al tamaño del mapa.

Sólo utiliza la memoria necesaria para almacenar los datos.

### `LinkedHasMap`

Este útimo tiene las ventajas del `HashMap` pero garantiza que el orden de iteración sobre los elementos coincide con el orden de inserción de los mismos en el mapa.

## Uso de un mapa

Para crear un `Map` hemos de indicar los tipos de datos de la clave y el valor:

```java
Map<String, Alumno> mapaAlumnos = new HashMap<>();
mapaAlumnos.put(a1.getDni(), a1);
mapaAlumnos.put(a2.getDni(), a2);
```