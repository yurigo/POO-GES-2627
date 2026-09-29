# Actividades

## 1. Extraer clases y atributos de un texto

En esta actividad el objetivo es detectar **clases** y **atributos**, **relaciones**, **cardinalidad**, **navegabilidad** a partir de
un texto. En esta fase no entraremos todavía en:

- herencia.

La idea es leer con calma, subrayar entidades candidatas y anotar qué datos
aparecen descritos de forma explícita y crear su diagrama UML.

### Ejercicio 1

Una empresa de electrodomésticos, identificada con un NIF y un nombre
comercial, consta de una serie de naves industriales distribuidas por el país.
Cada nave tiene un número de teléfono y está ubicada en una dirección física. La
dirección física está caracterizada por el nombre de la calle, el número, el
código postal y la provincia donde está ubicada. Adicionalmente, una nave está
formada por distintas áreas. Un área puede ser de tipo: producción,
administración o comercial. Con independencia de su tipo, todas las áreas son
identificadas mediante un código alfanumérico.

### Ejercicio 2

Las áreas de tipo producción gestionan una o varias cadenas de producción. Una
cadena de producción sólo puede estar gestionada por una única área de
producción. Las cadenas de producción presentan un estado, en funcionamiento o
paro, producen productos y abastecen los almacenes. Un producto tiene un
identificador numérico, un peso y un precio. Un almacén es gestionado por una
única área comercial, mientras que un área comercial puede gestionar uno o
varios almacenes al mismo tiempo. Un almacén está caracterizado por una
capacidad y un porcentaje de ocupación.

### Ejercicio 3

En la empresa trabajan asalariados, vinculados con la empresa mediante la
existencia de un único contrato laboral. La información asociada a cada
asalariado es: un identificador alfanumérico, un nombre, los apellidos y una
dirección física. El contrato consta de un código alfanumérico y la retribución
bruta anual en euros que recibe el trabajador. Adicionalmente un asalariado
pertenece a una categoría laboral, la cual puede ser del tipo: jefe de área,
director, u otra.

### Ejercicio 4

Un jefe es responsable de un área, sin importar su tipo. Un área puede presentar
varios jefes, pero un jefe es únicamente responsable de un área. El director
dirige una nave industrial. Una nave industrial puede ser dirigida por uno o un
máximo de dos directores, pudiendo los directivos ocupar, únicamente, el cargo
directivo de una de ellas. La categoría otra se corresponde a aquellos
asalariados que trabajan en alguna de las áreas de las naves industriales, sin
importar el tipo de la área. Los asalariados de categoría otra pueden trabajar
en una o en varias áreas, y en cada una de éstas pueden trabajar varios
trabajadores.

### Guía de trabajo

Para cada texto:

1. anota las clases que crees que aparecen;
2. escribe únicamente los atributos explícitos que encuentres;
3. dibuja el UML solo con el nombre de la clase y sus atributos;
4. dibuja las relaciones entre clases.
5. deja para más adelante la herencia.
