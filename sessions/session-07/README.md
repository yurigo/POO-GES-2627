# Sesión 07 — Trabajo práctico de AC1 y dudas sobre constructores

En esta sesión se dedicó el tiempo completo a avanzar en la AC1, revisando
dudas reales que aparecieron al empezar a implementar clases.

## Objetivos de aprendizaje

Al finalizar la sesión deberías ser capaz de:

- interpretar la parte del enunciado de AC1 relacionada con constructores;
- distinguir dos formas de crear un objeto según el origen de los datos;
- proponer una estrategia simple para transformar una línea leída de fichero en
  los valores necesarios para crear un objeto;
- continuar el trabajo de AC1 con un diseño más claro de responsabilidades.

## 1. Contexto: trabajo guiado sobre la AC1

No se introdujo contenido teórico nuevo fuera de la AC1. La sesión se centró en
resolver bloqueos de implementación y en aterrizar decisiones de diseño a partir
del enunciado.

## 2. Duda clave trabajada en clase: constructores

Se aclaró este fragmento del enunciado:

> ## Constructors
>
> La classe haurà de permetre, com a mínim:
>
> - crear un objecte proporcionant els seus valors;
> - crear un objecte a partir de les dades llegides del fitxer.

La interpretación práctica fue:

1. una vía de creación cuando ya tenemos los datos separados;
2. otra vía de creación cuando primero llega texto leído de fichero y hay que
   convertirlo en atributos.

## 3. Material de dudas trabajado

Código usado durante la sesión para discutir posibles enfoques:

- [dudas/AC1/src/Main.java](dudas/AC1/src/Main.java)
- [dudas/AC1/src/Ball.java](dudas/AC1/src/Ball.java)
- [dudas/AC1/src/FactoryBall.java](dudas/AC1/src/FactoryBall.java)

En clase se compararon dos ideas:

- crear directamente desde `Ball` con distintos constructores;
- delegar la creación en una clase auxiliar (`FactoryBall`) cuando la entrada
  viene en bruto y hay que prepararla.

## 4. Qué practicar después de la sesión

Para consolidar lo trabajado, sigue con la AC1 aplicando este orden:

1. definir qué datos mínimos necesita cada objeto para existir;
2. comprobar cómo llegan esos datos (ya separados o en una cadena leída);
3. decidir dónde convertir el texto leído antes de crear el objeto;
4. probar varios casos de entrada para validar que se crean objetos correctos.

## 5. Resultado esperado tras esta sesión

Al terminar, deberías poder continuar la AC1 sin bloquearte en la creación de
objetos desde fichero y con una idea más clara de qué responsabilidad tiene cada
clase implicada en ese proceso.
