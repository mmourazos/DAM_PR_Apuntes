# Tema 7: Introducción a estructuras de datos avanzadas

Además de los arrays que hemos estado viendo hasta el momento Java nos ofrece una serie de estructuras de datos más avanzadas que nos permiten almacenar y manipular conjuntos de datos de una forma más eficiente. Estas estructuras se pueden agrupar en tres grandes grupos:

* Listas: Una lista es una colección de elementos **ordenados**. Los elementos de una lista pueden ser accedidos mediante un **índice que indica su posición en la lista**. Las listas **pueden contener elementos duplicados** y permiten la inserción (y borrado) de elementos en cualquier posición dentro de la lista. Un ejemplo de listas son las clases `ArrayList` y `LinkedList`.
* Conjuntos: Un conjunto es una colección de elementos **no ordenados**. Los elementos de un conjunto **no pueden repetirse**. Un ejemplo de conjuntos son las clases `HashSet` y `TreeSet`.
* Mapas: Un mapa es una colección de elementos **no ordenados**. Los elementos de un mapa se almacenan en **pares de clave-valor**. Estos pares clave-valor **no pueden repetirse**. Un ejemplo de mapas son las clases `HashMap` y `TreeMap`.

Es importante tener en cuenta que las estructuras de datos avanzadas no son más que una forma de almacenar y manipular datos. Por lo tanto, **no se puede decir que una estructura de datos es mejor que otra**. Dependerá de las necesidades de cada aplicación y de la forma en la que se vayan a utilizar los datos.

Todas estas estructuras se basan en la implementación de distintos **interfaces** que definen los métodos que deben implementar. Por este motivo recomiendo que se repase el apartado del [tema 5 sobre interfaces](../Tema%205/T5.1%20-%20Interfaces.md).

Además del uso de interfaces estas estructuras se basan en la utilización del mecanismo de **genéricos** que permite definir clases y métodos que pueden trabajar con cualquier tipo de datos. En el siguiente apartado pasaremos a explicar su funcionamiento.
