# El tiempo en Java: `Date`, `Calendar` y `java.time`

En todos los lenguajes de programación existe la necesidad de almacenar valores que representen el tiempo. Es necesario saber, por ejemplo, cuando fue la última vez que se accedió o modificó un fichero, en qué fecha se realizó la última actualización o en qué momento se estableció una conexión con un servidor.

La tarea de llevar cuenta de en que momento se produjo un evento se complica aún más cuando tenemos que tener en cuenta los distintos usos horarios. Aún más si tenemos que tener en cuenta que distintas  culturas (como China, Japón) tienen distintos calendarios.

Java intenta resolver este problema mediante las clases `Date` y `Calendar`.

## `Date`

Este es el sistema *antiguo* y prácticamente obsoleto de almacenar fechas y horas.

En Java (al igual que otros muchos lenguajes) se mide el tiempo contando los **milisegundos** (segundos, microsegundos o nanosegundos en otros sistemas) que han transcurrido desde el **año cero de la informática** o tiempo de Unix (**oo:oo:oo del 1 de enero de 1970**).

Para crear un objeto `Date` escribiremos el siguiente código:

```java
Date d = new Date();
```

de esta forma creamos el objeto `d` con la fecha y hora del instante en que se haya ejecutado la sentencia.

Si queremos obtener el número de milisegundos desde el 1 de enero de 1970 almacenado en `d` simplemente tendremos que mostrar:

```java
System.out.println("Milisegundos desde el origen de tiempo: " + d.getTime());
```

Pero para obtener el día, mes y año lo tenemos complicado...

## `Calendar` al rescate

Trabajar con `Date` para obtener los valores del año, día del mes, de la semana, etc. es bastante complicado. Para facilitar el trabajo se creó la clase `Calendar`. `Calendar` es una actualización `Date` pero que **no lo substituye**. Funciona en *tandem* con `Date`.

Por ejemplo, para crear un `Calendar` que represente la fecha y hora actual escribiremos:

```java
Calenda c = Calendar.getInstance();
```

Si queremos obtener año, mes y día de un objeto `Date`:

```java
Date d = new Date();
Calendar c = Calendar.getInstance();
c.setTime(d);
int year = c.get(Calendar.YEAR);
int mont = c.get(Calendar.MONTH);
/...
```

## Paquete `java.time`

En cualquier caso parece que `Calendar` no fue una solución definitiva si no más bien un parche y finalmente se desarrolló el paquete `java.time` con las clases `LocalDate` y  `LocalDateTime` para facilitar el tratamiento del tiempo.

### `LocalDate`

Para almacenar el momento actual usaremos el método `now()`:

```java
LocalDate hoy = LocalDate.now();
```

Y para obtener año, mes y día:

```java
int anho = hoy.getYear();
int mes = hoy.getMonth();
int diaMes = hoy.getDayOfMonth();
int diaSemana = hoy.getDayOfWeek();
```

### `LocalDateTime `

Almacena dos valores:

* El **numero de segundos transcurridos** desde la medianoche del 1 de enero de 1970.
* El número de **nanosegundos** transcurridos dentro del segundo en que nos encontramos.

## Formato de las fechas

Para dar formato a las fechas se usará la clase `DateTimeFormatter`:

```java
LocalDateTime ahora = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
String ahoraString = ahora.format(formatter);

System.out.println("La fecha de hoy es: " + ahoraString);
```

También podremos crear un formateador a nuestra medida usando patrones:

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
String ahoraString = ahora.format(formatter);

System.out.println("La fecha de hoy es: " + ahoraString);
```

Los símbolos para construir formatos son (entre otros):

| Símbolo | Significado       | Representación | Ejemplo             |
| ------- | ----------------- | -------------- | ------------------- |
| G       | era               | texto          | AD; Anno Domini; A  |
| u       | año               | año            | 2004; 04            |
| y       | año de la era     | año            | 2004; 04            |
| D       | día del año       | número         | 189                 |
| M/L     | mes del año       | número / texto | 7; 07; Jul; July; J |
| d       | día del mes       | número         | 10                  |
| E       | día de la semana  | texto          | Tue; Tuesday; T     |
| a       | am-pm             | texto          | PM                  |
| h       | hora 1-12         | número         | 12                  |
| k       | hora formato 1-24 | númerop        | 15                  |

```bash
  Symbol  Meaning                     Presentation      Examples
  ------  -------                     ------------      -------
   G       era                         text              AD; Anno Domini; A
   u       year                        year              2004; 04
   y       year-of-era                 year              2004; 04
   D       day-of-year                 number            189
   M/L     month-of-year               number/text       7; 07; Jul; July; J
   d       day-of-month                number            10

   Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
   Y       week-based-year             year              1996; 96
   w       week-of-week-based-year     number            27
   W       week-of-month               number            4
   E       day-of-week                 text              Tue; Tuesday; T
   e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
   F       week-of-month               number            3

   a       am-pm-of-day                text              PM
   h       clock-hour-of-am-pm (1-12)  number            12
   K       hour-of-am-pm (0-11)        number            0
   k       clock-hour-of-am-pm (1-24)  number            0

   H       hour-of-day (0-23)          number            0
   m       minute-of-hour              number            30
   s       second-of-minute            number            55
   S       fraction-of-second          fraction          978
   A       milli-of-day                number            1234
   n       nano-of-second              number            987654321
   N       nano-of-day                 number            1234000000
```

