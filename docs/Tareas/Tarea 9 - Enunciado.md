# Tema 9 - Tarea 1: C# Clases, Propiedades, Listas

En esta tarea nos familiarizaremos con el uso de clases, variables de case e instancia así como de **propiedades** y métodos.

## Primera parte (clases)

Crea una clase `Persona` que cumpla las siguientes condiciones:

1. Todas la variables tanto de clase como de instancia han de declararse como privadas.
2. Ha de tener una **variable de clase** que lleve cuenta del número de personas creadas.
3. Cada persona tendrá:
      1. Nombre.
      2. Primer apellido.
      3. Segundo apellido.
      4. Hombre (podrá ser verdadero o falso).
      5. Mujer (podrá ser verdadero o falso).
      6. Fecha de nacimiento (se usará un objeto de la clase [`DateTime`](https://learn.microsoft.com/es-es/dotnet/api/system.datetime?view=net-7.0)).
      7. Dni.
      8. Sueldo.
4. La **clase dispondrá de un método para validad el DNI**.
5. Todo elemento de la clase `Persona` dispondrá de las siguiente **propiedades**:
      1. `Nombre`, `PrimerApellido`, `SegundoApellido`: `string` y de **lectura y escritura**.
      2. `Sueldo`: `float` de **lectura y escritura**.
      3. `Sexo`: `string` de **lectura y escritura** (admitirá dos posibles valores: hombre o mujer).
      4. `NombreCompleto`: `string` **de sólo lectura** que devolverá el nombre de la forma: "[nombre] [primerApellido] [segundoApellido]".
      5. `Edad`: `int` **de sólo lectura** que devolverá la edad de la persona.
      6. `FechaDeNacimiento`: `string` de lectura y escritura.
6. Dispondremos también de un método de clase `CuantasPersonas` que nos devolverá el número de personas creadas.

## Segunda parte (listas)

Crearemos una lista de personas sobre la que aplicaremos las funciones [`Select`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.queryable.select?view=net-7.0), [`Where`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.queryable.where?view=net-7.0) y [`Aggregate`](https://learn.microsoft.com/es-es/dotnet/api/system.linq.enumerable.aggregate?view=net-7.0) para obtener la información siguiente:

1. Las personas con mayor y menor edad de la lista.
2. La edad media de las personas de la lista.
3. Sueldo medio de las personas menores de 30 años.
4. Sueldo medio de las personas mayores de 30 años.
5. Sueldo medio de las personas con edad comprendida entre 35 y 45 años.

## Código para crear una lista de personas

```c#
List<Persona> personas = new List<Persona>(10);

personas.Add(new Persona("Manuel", "Piñeiro", "Mourazos", "1977, 5, 15", "hombre", 1500));
personas.Add(new Persona("Cristina", "Fernadez", "Garrido", "2001, 8, 25", "mujer", 2500));
personas.Add(new Persona("Álvaro", "Pose", "Castro", "1997, 10, 7", "hombre", 1800.5f));
personas.Add(new Persona("Tristan", "Gómez", "Pérez", "2010, 1, 30", "hombre", 300.9f));
personas.Add(new Persona("Sara", "Salamanca", "Torres", "1999, 12, 31", "mujer", 3750.66f));
personas.Add(new Persona("Fernando", "Fernandez", "Fernandez", "2000, 1, 11", "hombre", 2220.20f));
personas.Add(new Persona("Cármen", "Abrente", "Montiel", "1992, 3, 17", "mujer", 1770.5f));
personas.Add(new Persona("Cristiano Ronaldo", "dos Santos", "Aveiro", "1985, 2, 5", "hombre", 999999.999f));
personas.Add(new Persona("Bat", "Man", "Wayne", "1915, 3, 7", "hombre", 000.0f));
```
