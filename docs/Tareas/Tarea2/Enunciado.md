# Tarea2: Orientación a objetos

Necesitamos crear una jerarquía de clases que represente la situación de alumnos, profesores, ciclos, módulos y aulas.

## Alumnos
* Un alumno estará matriculado en un ciclo.
* Un alumno tendrá nombre y apellidos además de un DNI (único).
* Un alumno tendrá una fecha de nacimiento.
* Un alumno tendrá información de contacto:
  * Teléfono
  * e-mail.
  * Dirección.

## Profesores
* Un profesor estará asignado a uno o más módulos.
* Un profesor tendrá nombre y apellidos además de un DNI (único).
* Un profesor tendrá una fecha de nacimiento.
* Un profesor tendrá información de contacto:
  * Teléfono
  * e-mail.
  * Dirección.

## Ciclos
* Un ciclo ha de ser de "modular", "ordinario" o "dual" (que es el mejor).
* Un ciclo tiene uno o más módulos.
* Un ciclo tiene un código único.

## Modulos 
* Un módulo tiene un código.
* Un módulo tendrá un número de horas asignado.

## Aulas
* Un aula tendrá una capcidad de alumnos.
* Un aula tendrá material.
* Un aula tendrá asignado uno o más módulos y/o uno o más ciclos.