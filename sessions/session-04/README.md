# Sesión 04 — Actividades de modelado de clases e implementación

En la [Sesión 02](../session-02/README.md) practicamos cómo pasar de una
abstracción sencilla a UML y de UML a Java. En la
[Sesión 03](../session-03/README.md) apareció además la idea de encapsulación y
empezamos a pensar mejor qué responsabilidad pertenece a cada clase.

En esta sesión hemos trabajado dos actividades muy relacionadas:

- extraer clases y atributos a partir de varios textos;
- empezar a diseñar e implementar `GameArea` a partir de un programa cliente.

## Objetivos de aprendizaje

Al finalizar la sesión deberías ser capaz de:

- detectar clases candidatas dentro de un enunciado escrito;
- separar la información que describe una clase de las relaciones que todavía no
  vamos a modelar;
- identificar atributos explícitos en un texto;
- representar una primera versión UML centrada solo en clases y atributos;
- leer un `main` para deducir qué atributos y métodos necesita otra clase;
- reconocer que el diseño también puede empezar desde el código que usa una
  clase, y no solo desde una descripción teórica.

## 1. Modelado a partir de textos

La primera parte de la sesión se dedicó a una actividad de análisis. A partir de
cuatro textos fuimos buscando:

1. posibles clases;
2. atributos mencionados de forma explícita;
3. una primera representación UML sin entrar todavía en relaciones ni herencia.

Las actividades literales están recogidas en [EXERCISES.md](EXERCISES.md).

### Cómo enfocamos la lectura

Durante la actividad nos hicimos preguntas como estas:

- ¿este sustantivo representa una entidad con información propia?
- ¿el texto dice claramente qué datos la describen?
- ¿estamos viendo un atributo o más bien una relación con otra entidad?
- ¿hay algo que convenga dejar aparcado para más adelante?

Eso fue importante porque en los textos aparecían muchas relaciones:

- una empresa consta de naves;
- una nave tiene áreas;
- un almacén es gestionado por un área comercial;
- un asalariado tiene contrato;
- un jefe es responsable de un área;
- un director dirige una nave.

Sin embargo, en esta sesión **no** nos detuvimos todavía en cardinalidades,
asociaciones ni herencia. El objetivo era más básico: localizar clases y
atributos.

### Una posible extracción inicial

Sin pretender cerrar todavía el modelo completo, una primera lectura permitía
detectar clases como estas:

- `Empresa`, con atributos como `nif` y `nombreComercial`;
- `NaveIndustrial`, con `telefono`;
- `Direccion`, con `calle`, `numero`, `codigoPostal` y `provincia`;
- `Area`, con `codigo` y `tipo`;
- `CadenaProduccion`, con `estado`;
- `Producto`, con `identificador`, `peso` y `precio`;
- `Almacen`, con `capacidad` y `porcentajeOcupacion`;
- `Asalariado`, con `identificador`, `nombre`, `apellidos` y `direccionFisica`;
- `ContratoLaboral`, con `codigo` y `retribucionBrutaAnual`;
- `CategoriaLaboral`, con un posible atributo `tipo`.

En cambio, `jefe de área`, `director` y `otra` se interpretaron en esta sesión
como valores o categorías de trabajo, no como una jerarquía de herencia ya
resuelta. Esa discusión se deja para más adelante.

## 2. Del programa cliente al diseño de `GameArea`

En la segunda parte retomamos el ejercicio de la sesión anterior sobre bolas en
un área de juego. En vez de empezar con un UML completo, arrancamos desde el
código que quería usar la clase:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al juego.");

        GameArea gameArea = new GameArea(20, 10);

        gameArea.addPlayer1();
        gameArea.addPlayer2();
        gameArea.draw();
    }
}
```

Este `main` ya nos obliga a responder varias preguntas:

- ¿qué información debe guardar `GameArea`?
- ¿qué métodos públicos necesita para que `Main` pueda usarla?
- ¿qué objetos forman parte del estado del área de juego?

### Qué dedujimos para `GameArea`

A partir del cliente y del dibujo del tablero, surgió una primera versión con:

- `width` y `height` para el tamaño del área;
- `p1` y `p2` para las dos bolas o jugadores;
- un constructor `GameArea(int width, int height)`;
- los métodos `addPlayer1()`, `addPlayer2()` y `draw()`.

Una representación UML sencilla de esa primera idea sería:

```text
GameArea
--------------------------------
- width : int
- height : int
- p1 : Ball
- p2 : Ball
--------------------------------
+ GameArea(width : int, height : int)
+ addPlayer1() : void
+ addPlayer2() : void
+ draw() : void
```

### Qué necesitaba conocer `Ball`

Para poder dibujar el tablero también necesitábamos una clase `Ball` que
guardara, al menos, la información con la que ya se estaba trabajando:

- posición `x` e `y`;
- velocidad `vx` y `vy`;
- `force`.

Además, `GameArea` necesitaba preguntarle a cada bola si estaba ocupando una
posición concreta del tablero. De ahí surgió el método:

```java
isOn(int x, int y)
```

que devuelve `true` cuando la bola está exactamente en esa coordenada.

## 3. Ejemplo trabajado en clase

El código base que se empezó a construir en clase está disponible en:

- [Main.java](examples/game-area/Main.java)
- [GameArea.java](examples/game-area/GameArea.java)
- [Ball.java](examples/game-area/Ball.java)

En esta fase el objetivo no era completar todavía toda la simulación, sino
tener una primera versión que permitiera:

- crear el área de juego;
- añadir dos jugadores;
- recorrer la rejilla;
- imprimir `1`, `2` o `-` según la posición ocupada.

Es decir, el foco estuvo en pasar de:

```text
cliente
    ↓
qué necesita usar
    ↓
qué debe ofrecer la clase
    ↓
qué atributos y métodos aparecen
    ↓
primera implementación
```

## 4. Experimenta

Si quieres seguir practicando con este ejemplo, prueba a:

- cambiar el tamaño del `GameArea`;
- mover las posiciones iniciales de `p1` y `p2`;
- comprobar cómo cambia el dibujo al modificar las coordenadas;
- anotar qué otros métodos harían falta si quisiéramos simular movimiento,
  rebotes o colisiones.

## Resumen

En esta sesión hemos reforzado dos ideas muy útiles:

- desde un texto podemos extraer clases y atributos antes de preocuparnos por
  relaciones más complejas;
- también podemos diseñar una clase observando cómo otra parte del programa
  necesita utilizarla.

El trabajo de hoy no cierra todavía el modelo completo de la empresa ni la
simulación de las bolas. Son primeras versiones que nos ayudan a practicar el
análisis y a decidir qué necesita realmente cada clase.
