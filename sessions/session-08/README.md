# Sesión 8

[Se adjunta el documento de UML consultado](./POO-UML-DiagramaClasses.pdf)

Se han trabajado las relaciones entre clases en UML:

- Dependencia
- Asociación (y caracteristicas como: cardinalidad, navegabilidad y roles o atributos)
- Agregación (Concepto PARTE-TODO)
- Composición (Concepto PARTE-TODO + destrucción del TODO => destrucción de PARTE)

ejemplos:

Dependencia:  Printer - Document
Asociación: Biblioteca - Libro  // Worker - Company
Agregación: Curso - Asignatura
Composición: Chessboard - Cell // GameArea - Ball  // Libro - Página

Se ha resuelto el ejercicio de la sesión 4 (copiados también en la sesión 8): [ejercicios](EXERCISES.md)

> ### Ejercicio 1
> 
> Una empresa de electrodomésticos, identificada con un NIF y un nombre comercial, consta de una serie de naves industriales distribuidas por el país. Cada nave tiene un número de teléfono y está ubicada en una dirección física. La dirección física está caracterizada por el nombre de la calle, el número, el código postal y la provincia donde está ubicada. Adicionalmente, una nave está formada por distintas áreas. Un área puede ser de tipo: producción, administración o comercial. Con independencia de su tipo, todas las áreas son identificadas mediante un código alfanumérico.

Se pide hacer los demás [ejercicios](EXERCISES.md) en casa

## Diagramas UML de la sesión

Se han preparado los diagramas UML de:

- los ejemplos vistos en clase (dependencia, asociación, agregación y composición);
- el ejercicio 1.

Puedes consultarlos en [UML.md](./UML.md).