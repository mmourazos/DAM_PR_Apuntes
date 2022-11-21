# Tarea2: Orientación a objetos

Necesitamos crear una jerarquía de clases que represente la situación de alumnos, profesores, ciclos, módulos y aulas.

Todas los objetos han de poder generar una cadena de caracteres que los represente (método `toString`).

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

## Aulas

* Un aula tendrá un "nombre de planta" y un "numero" asociado.
* Un aula tendrá una capcidad de alumnos.
* Un aula tendrá material.
* Un aula tendrá asignado uno o más módulos.
