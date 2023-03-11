# Tema 9.5: Comentarios

Para comentar código en C# se emplean dos tipos de comentarios:

- Comentarios de una línea que empiezan con `//` y terminan al final de la línea.
- Comentarios de múltiples líneas que empiezan con `/*` y terminan con `*/`.

## Comentarios de documentación

Los comentarios de documentación son comentarios que se emplean para documentar el código. Estos comentarios utilizarán ciertas etiquetas en formato XML para informar sobre, por ejemplo, el funcionamiento de los métodos. Finalmente se podrá generar la documentación automáticamente a partir de los comentario de documentación utilizando alguna de las herramientas desarrolladas para ese fin como `DocFX`.

### Comentarios de documentación de una línea

Los comentarios de documentación de una línea empiezan con `///` y terminan al final de la línea.

```c#
/// <summary>
/// Este texto explicaría el funcionamiento de un método.
/// </summary>
```

### Comentarios de documentación de múltiples líneas

Los comentarios de documentación de múltiples líneas empiezan con `/**` y terminan con `*/`.

```c#
/**
 * <summary>
 * Este texto explicaría el funcionamiento de un método.
 * </summary>
 * <Param>
 *     <name>param1</name>
 *     <description>Descripción del parámetro</description>
 *  </Param>
 */
```

### Etiquetas de comentarios de documentación

Las etiquetas de comentarios de documentación son etiquetas que se emplean dentro de los comentarios de documentación para indicar información sobre el código. Estas etiquetas se encuentran dentro de etiquetas XML.

| Etiqueta | Propósito |
| --- | --- |
| `<c>` | Establecer texto en una fuente similar a la de código |
| `<code>` | Establecer una o más líneas de código fuente o resultado del programa |
| `<example>` | Indicar un ejemplo |
| `<exception>` | Identifica las excepciones que un método puede producir |
| `<include>` | Incluye XML de un archivo externo |
| `<list>` | Crear una lista o una tabla |
| `<para>` | Permitir agregar estructura a texto |
| `<param> `| Describir un parámetro para un método o constructor |
| `<paramref>` | Identificar que una palabra es un nombre de parámetro |
| `<permission>` | Documentar la accesibilidad de seguridad de un miembro |
| `<remarks>` | Describir información adicional sobre un tipo |
| `<returns>` | Describir el valor devuelto de un método |
| `<see> `| Especificar un vínculo |
| `<seealso> `| Generar una entrada vea también |
| `<summary>` | Describir un tipo o un miembro de un tipo |
| `<value>` | Describir una propiedad |
| `<typeparam>` | Describir un parámetro de tipo genérico |
| `<typeparamref>` | Identificar que una palabra es un nombre de parámetro de tipo |
