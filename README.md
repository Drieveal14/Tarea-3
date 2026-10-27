<div style="text-align: left;">
  <img width="200" src="https://www.fciencias.unam.mx/sites/default/files/logoFC_2.png" alt="Logo FC">
</div>
# Tarea 3 - Cafetería

 La aplicación presenta el menú de una cafetería mediante un
`ListView` y permite seleccionar cada producto.

**Alumnos:**

| Nombre Completo                 | Número de cuenta |
|---------------------------------| --- |
| Oscar Palacios Gónzalez         | 321095572 |
| Diego Hazael Vega Alonso        | 321301183 |


## Descripción

El menú muestra diferentes bebidas y alimentos disponibles en la cafetería.
Cada elemento contiene:

- Imagen del producto.
- Nombre.
- Descripción.
- Precio.

Cuando el usuario selecciona un producto, la aplicación muestra un mensaje con
el nombre y precio del artículo elegido mediante el evento
`setOnItemClickListener`.

## Productos incluidos

- Espresso.
- Café americano.
- Capuchino.
- Latte vainilla.
- Moka.
- Chai latte.
- Croissant de mantequilla.
- Pastel de chocolate.

## Estructura principal

```text
app/src/main/
├── java/com/example/tarea_3/
│   └── MainActivity.java
└── res/
    ├── drawable/
    ├── layout/
    │   ├── activity_main.xml
    │   └── item_producto_cafe.xml
    └── values/
        ├── colors.xml
        ├── strings.xml
        └── themes.xml
```
