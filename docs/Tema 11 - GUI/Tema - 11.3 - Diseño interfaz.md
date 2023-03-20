# Tema 11.3: Diseño interfaz

## Recursos

[Figma](https://www.figma.com/) es una herramienta de diseño de interfaces gráficas que permite diseñar interfaces de usuario para aplicaciones web y móviles. Tiene una versión gratuita.

## Grid

El grid es una rejilla que nos permite organizar los elementos de la interfaz.

Para usar el grid debemos establecer divisiones del mismo. Esto se hará en forma de filas y o columnas.

### Filas del Grid

Para definir dos o más filas dentro de un grid hemos de crear una sección `<Grid.RowDefinitions>` dentro de la etiqueta `<Grid>`. Y, a su vez, dentro de `<Grid.RowDefinitions>` debemos crear tantas etiquetas `<RowDefinition>` como filas necesitemos.

```xml
<Grid>
    <Grid.RowDefinitions>
        <RowDefinition Height="Auto" />
        <RowDefinition Height="Auto" />
    </Grid.RowDefinitions>
</Grid>
```

### Columnas del Grid

De forma análoga podremos crear columnas del grid. Para ello utilizaremos la etiqueta `<Grid.ColumnDefinitions>` y dentro de ella crearemos tantas etiquetas `<ColumnDefinition>` como columnas necesitemos.

```xml
<Grid>
    <Grid.ColumnDefinitions>
        <ColumnDefinition Width="Auto" />
        <ColumnDefinition Width="Auto" />
    </Grid.ColumnDefinitions>
</Grid>
```

### Uso de filas y columnas

Una vez definidas nuestras filas y o columnas dentro del grid podremos añadir otros componentes. Para ello debemos indicar en qué fila y columna queremos que se coloquen. Para ello utilizaremos las propiedades `Grid.Row` y `Grid.Column`.

```xml
<Grid>
    <Grid.RowDefinitions>
        <RowDefinition Height="Auto" />
        <RowDefinition Height="Auto" />
    </Grid.RowDefinitions>
    <Grid.ColumnDefinitions>
        <ColumnDefinition Width="Auto" />
        <ColumnDefinition Width="Auto" />
    </Grid.ColumnDefinitions>
    <Button Grid.Row="0" Grid.Column="0" Content="Botón 1" />
    <Button Grid.Row="0" Grid.Column="1" Content="Botón 2" />
    <Button Grid.Row="1" Grid.Column="0" Content="Botón 3" />
    <Button Grid.Row="1" Grid.Column="1" Content="Botón 4" />
</Grid>
```

### Tamaños de filas y columnas

En cada fila y columna podemos definir el tamaño que queremos que tenga. Para ello utilizaremos las propiedades `Height` y `Width` de las etiquetas `<RowDefinition>` y `<ColumnDefinition>` respectivamente.

El valor de `Height` y `Width` puede ser absoluto si indicamos un número. Este valor hará referencia al número de píxeles que tendrá la fila o columna de alto o de ancho.

También se puede indicar el valor  `Auto` que hará que la fila (o columna) tome tanto tamaño como necesite para acomodar los elementos que contenga.

Por último podremos indicar el valor `*`. `*` indica que la fila (o columna) ocupará el espacio restante. Por ejemplo, si tenemos dos filas y en la primera indicamos `Height="Auto"` y en la segunda `Height="*"` la segunda fila ocupará todo el espacio restante que quede libre después de colocar los elementos de la primera fila.

También podremos acompañar `*` de un número. Por ejemplo, si tenemos dos filas y en la primera indicamos `Height="1*` y en la segunda `Height="2*"` la segunda fila ocupará el doble de espacio que la primera fila.

## Estilos
