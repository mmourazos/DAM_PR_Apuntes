# Tema 9.6 : `struct` y `enum`

El tipo `struct` sirve para definir tipos de datos que no son objetos. Un `struct` es prácticamente igual a una clase pero con ciertas limitaciones:

* Un `stuct` no puede heredar de otra clase o `struct`.
* Ninguna clase puede heredar de un `struct`.

Además de estas limitaciones un struct tiene algunas características que lo diferencian de una clase:

* Un objeto tipo `struct`, a diferencia de un objeto derivado de un clase, se almacena en la pila de ejecución y no en el heap.
* Un objeto tipo `struct` se pasa como argumento a un método por valor, no por referencia.

## Tipo `struct`

