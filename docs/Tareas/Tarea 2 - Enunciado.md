# Tarea2: Orientación a objetos

Necesitamos crear una jerarquía de clases que represente la situación de alumnos, profesores, ciclos, módulos y aulas.

Todas los objetos han de poder generar una cadena de caracteres que los represente (método `toString`).

## Objetivos / requerimientos

* Se ha de poder almacenar información de alumnos, ciclos y módulos.
* Se ha de poder mostar el ciclo y los módulos en los que está matriculado un alumno.
* Se ha de poder mostar los alumnos que están matriculados en un ciclo.

## Alumnos

* Un alumno estará matriculado en un ciclo.
* Un alumno tendrá nombre y apellidos además de un DNI (único).
* Un alumno tendrá una fecha de nacimiento.
* Un alumno tendrá información de contacto:
  * Teléfono
  * e-mail.
  * Dirección.

## Delegados

* Un alumno puede ser delegado de un único ciclo y curso.
* Solo habrá un delegado por ciclo y curso.

## Profesores

* Un profesor estará asignado a uno o más módulos.
* Un profesor tendrá nombre y apellidos además de un DNI (único).
* Un profesor tendrá una fecha de nacimiento.
* Un profesor tendrá información de contacto:
    * Teléfono
    * e-mail.
    * Dirección.

## Tutores

* Un tutor ha de ser profesor del ciclo y curso.
* Un tutor está asociado a un ciclo y curso.

## Ciclos

* Un ciclo ha de tener un nombre.
* Un ciclo tiene un código único.
* Un ciclo podrá ser de tipo "modular", "ordinario" o "dual" (que es el mejor).
* Un ciclo tiene uno o más módulos.
* Un ciclo tendrá dos os tres cursos.

## Modulos 

* Un módulo tiene un nombre.
* Un módulo tiene un código único.
* Un módulo tendrá un número de horas asignado.
* Un móudlo ha de estar asignado a un curso (1º, 2º o 3º).

## Aulas

* Un aula tendrá un "nombre de planta" y un "numero" asociado.
* Un aula tendrá una capcidad de alumnos.
* Un aula tendrá material.
* Un aula tendrá asignado uno o más módulos.

## Relación aula-modulo

Para reflejar la relación entre aulas y módulos podremos utilizar la clase `AulaModulo` que almacenará pares "Aula" / "Modulo".

Un módulo solo se impartirá en un aula.

Un aula podrá utilizarse en varios módulos.

