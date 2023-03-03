# Estructuras de control

Las estructuras de control son similares a las de Java con diferencias menores.

## `if-else`

Esta estructura no tiene ninguna diferencia en funcionamiento o sintaxis a Java.

## `switch`

## `for`

Esta estructura presenta alguna diferencia. En la sección _inicial_ y _final_ se pueden incluir más instrucciones de las de inicialización e incremento:

```c#
int i, j; // Importante declaración externa.
for (System.Console.WriteLine("Sección de inicialización."), i = 0, j = 10; i < j; ++i, --j, System.Console.WriteLine($"Sección de incremento i = {i} y j = {j}.")) {
    System.Console.WriteLine($"Dentro del bucle iteración {i}.");
}
```

```bash
Sección de inicialización.
Dentro del bucle iteración 0.
Sección de incremento i = 1 y j = 9.
Dentro del bucle iteración 1.
Sección de incremento i = 2 y j = 8.
Dentro del bucle iteración 2.
Sección de incremento i = 3 y j = 7.
Dentro del bucle iteración 3.
Sección de incremento i = 4 y j = 6.
Dentro del bucle iteración 4.
Sección de incremento i = 5 y j = 5.
```

### `for-each`

Las diferencias en el bucle `for-each` son también (al menos externamente) muy pequeñas:

```c#
List<int> listInt = new List<int>();
int i = 0;
foreach(int e in listInit)
{
    Console.WriteLn($"elemento {++i}: {e}.");
}
```

## `while`

De nuevo, el bucle `while` es similar al de java:

```c#
while(i < 100)
{
    // Instrucciones a repetir.
    ++i;
}
```

## `do-while`

```c#
do 
{
    // Instrucciones a repetir.
    ++i;

} while(i < 100)
```
