# Tema 9.0: Introducción a C Sharp

## Instalación de Visual Studio

Existen varias opciones para instalar Visual Studio y también varias versiones del mismo. Para nosotros será suficiente Visual Studio Community.

Como opción de instalación realizaremos una _offline_ ya que así evitaremos tener que descargar Visual Studio y los componentes necesarios para cada instalación.

Los pasos a seguir para realizar esta instalación (Visual Studio Community + Herramientas de desarrollo en C# para consola) son los [siguientes](https://learn.microsoft.com/en-us/visualstudio/install/create-an-offline-installation-of-visual-studio?view=vs-2022#use-the-command-line-to-create-a-local-layout):

1. Descargar el _bootstrapper_ para Visual Studio Community [vs_community.exe](https://aka.ms/vs/17/release/vs_community.exe)
2. Apuntar los identificador de los componentes que desemos instalar (listados en [esta página](https://learn.microsoft.com/en-us/visualstudio/install/workload-component-id-vs-community?source=recommendations&view=vs-2022)). En nuestro caso será suficiente con: **.Net desktop development** con ID `Microsoft.VisualStudio.Workload.ManagedDesktop`.
3. Seleccionar el directorio donde descargaremos los archivos de Visual Studio Community y sus componentes mediante la opción `--layout c:\mi_dir_VSC`.
4. Hemos de indicar también el lenguaje que deseemos `--lang es-ES` por ejemplo (lenguajes válidos [aquí](https://learn.microsoft.com/en-us/visualstudio/install/create-an-offline-installation-of-visual-studio?view=vs-2022#list-of-language-locales)).
5. Finalmente es importante indicar que instale los componentes opcionales con `--includeOptional`

Así, par instalar la versión Community de Visual Studio con el componente para desarrollo .NET en consola (incluirá los lenguajes C#, Visual Basic, and F#) hemos de ejecutar el siguiente comando (en el directorio donde hayamos descargado `vs_community.exe`):

```bash
vs_community.exe --offline --layout D:\VS_Community_Offline --add Microsoft.VisualStudio.Workload.ManagedDesktop --includeOptional --lang es-ES
```

Una vez finalice de descargar los ficheros entraremos en el directorio elegido (`D:\VS_Community_Offline` en el ejemplo) y ejecutaremos el comando:

```bash
vs_community.exe --noweb --add Microsoft.VisualStudio.Workload.ManagedDesktop --includeOptional
```

## ¿Qué es C Sharp?

Este lenguaje de programación fue diseñado en el año 2000 por Anders Hejlsberg (Microsoft). Se trata de un lenguaje de **alto nivel** y **propósito general** con soporte para múltiples paradigmas de programación como: tipado estático, tipado fuerte, ámbito léxico, **imperativo**, **declarativo**, **funcional**, genérico, **orientado a objetos** (basado en clases) y orientado a componentes.

El estándar Ecma lista como objetivos de diseño para C# los siguientes:
_(copiado de la Wikipedia)_

* Su intención es ser un lenguaje de programación simple, moderno, de propósito general y **orientado a objetos**.
* El lenguaje deberá de incluir **comprobación de tipado fuerte, comprobación de los límites de los array, detectar el uso de variables no inicilizadas y _recolección de basura_ automática**.
* La robustez del software, durabilidad y la productividad del programador serán aspectos importantes.
* El lenguaje está pensado para desarrollo de componentes software en **entornos distribuidos**.
* La **portabilidad** es muy importante para el código fuente y los programadores, especialmente los familiarizados con **C y C++**.
* El soporte para **internacionalización** es muy importante.
* Aunque la intención es que las aplicaciones escritas en C# sean _económicas_ en cuanto al uso de memoria y CPU, el lenguaje no ha sido diseñado para competir directamente en rendimiento y tamaño con C o ensamblador.

## La sintaxis de C Sharp

Los elementos fundamentales de la sintaxis de C#  es similar a la de otros lenguajes estilo C como C, C++ y Java:

* Se usan `;` para indicar el fin de una instrucción.
* Las `{}` se usan para agrupar instrucciones.
* Las instrucciones se agrupan generalmente en métodos (funciones), los métodos en clases y las clases en _namespaces_ (paquetes).
* Los valores se asignan a variables mediante el símbolo `=` y se comparan con `==`.
* Los `[]` se usan con _arrays_, tanto para declararlos como para acceder a sus posiciones.
* ...
