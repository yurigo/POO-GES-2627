# Sesión 02 — Abstracción, UML y modelado de clases

En la [Sesión 01](../session-01/README.md) empezamos a distinguir clases,
objetos, atributos, métodos, estado y comportamiento. En esta sesión hemos
seguido practicando esas ideas con una pregunta central:

> ¿Cómo decidimos qué atributos y métodos debe tener una clase?

Antes de escribir código, recorrimos este camino:

```text
¿Qué queremos representar?
        ↓
¿Qué información importa?
        ↓
¿Esa información pertenece al objeto?
        ↓
¿Qué comportamiento necesitamos?
        ↓
¿Cómo lo representamos en UML?
        ↓
¿Cómo lo llevamos a Java?
```

Las actividades de la sesión están en [EXERCISES.md](EXERCISES.md).

## Objetivos de aprendizaje

Al finalizar la sesión deberías ser capaz de:

- analizar una entidad antes de escribir código;
- decidir qué información forma parte del estado de un objeto;
- diferenciar atributos de parámetros de un método;
- identificar comportamientos adecuados para una clase;
- representar una clase sencilla en UML con atributos, tipos, métodos,
  parámetros y tipos de retorno;
- comprender que una clase puede no necesitar atributos;
- reconocer que la abstracción depende del contexto y de los requisitos;
- pasar de una abstracción sencilla a una primera implementación en Java.

## 1. Sonido: de la abstracción a Java

Comenzamos modelando un sonido. Nos preguntamos qué datos necesitamos guardar
para representarlo y qué acciones queremos poder realizar con él. La respuesta
fue:

- `volumen`, `duracion` y `frecuencia` describen el **estado** del sonido;
- `play()` e `isAudible()` describen su **comportamiento**.

Una posible representación UML del modelo trabajado es:

```text
Sonido
--------------------------------
volumen : float
duracion : float
frecuencia : float
--------------------------------
play()
isAudible() : boolean
```

Después llevamos ese modelo a Java. Puedes consultar el
[código realizado en clase](solutions/sonidos/sonido.java): la clase `Sonido`
guarda esos tres atributos, `play()` muestra cómo se reproduce y `isAudible()`
comprueba, a partir de la frecuencia, si el sonido está dentro del intervalo
audible.

Este ejemplo muestra la relación que usaremos durante toda la sesión:

```text
atributos → estado
métodos    → comportamiento
```

No hemos intentado describir todo lo que puede tener un sonido real. Hemos
seleccionado solamente la información y las operaciones que interesaban para
este problema.

## 2. Calculadora de IMC: atributo o parámetro

Al modelar una calculadora de IMC apareció una pequeña trampa: es fácil pensar
que `peso` y `altura` deben ser atributos de la calculadora. Antes de decidirlo,
conviene preguntar: **¿esos datos describen a la calculadora?**

El modelo pensado fue:

```text
CalculadoraIMC
--------------------------------
calcular(peso, altura) : float
traducir(imc : float) : String
```

La calculadora no necesita guardar `peso` ni `altura`. Los recibe temporalmente
cuando `calcular()` debe realizar la operación. Del mismo modo, `traducir()`
recibe un IMC y devuelve un texto comprensible para una persona.

Por tanto, distinguimos dos ideas:

- un **atributo** es información que forma parte del estado de un objeto;
- un **parámetro** es información que un método recibe para poder realizar una
  operación.

Una clase no está obligada a tener atributos. En este caso, lo importante de
`CalculadoraIMC` son las operaciones que ofrece, no un estado propio.

### ¿Dónde sí pertenecen el peso y la altura?

`peso` y `altura` sí pueden describir el estado de una `Persona`:

```text
Persona
--------------------------------
peso
altura
```

La calculadora puede usar esos datos para calcular un IMC, pero eso no los
convierte en datos de la calculadora. Cuando dudemos, podemos volver a la misma
pregunta: **¿a qué objeto pertenece realmente este dato?**

## 3. Pokémon: necesitamos conocer el contexto

Después intentamos modelar un Pokémon. El enunciado «Modela un Pokémon» es
demasiado ambiguo: no existe una única clase `Pokemon` correcta sin saber para
qué la necesitamos.

- En un videojuego nos interesarían unas características.
- En un juego de cartas serían relevantes otras.
- En una base de datos de imágenes probablemente elegiríamos información
  distinta.

Antes de decidir atributos y métodos debemos preguntar: **¿para qué estamos
modelando este objeto?** En un proyecto real tendremos que hablar con quien
define el problema, concretar los requisitos y conocer el contexto. La
abstracción consiste precisamente en elegir lo relevante para ese contexto, no
en construir una lista definitiva de características.

Esta idea también ayuda a responder dos preguntas: no todo sustantivo se
convierte automáticamente en una clase y no podemos modelar bien una situación
ambigua sin obtener más información.

## 4. Señal cardíaca: leer UML para implementar una clase

En el ejercicio de [señal cardíaca](EXERCISES.md#modelar-una-señal-cardíaca)
partimos del siguiente UML:

```text
HeartSignal
--------------------------------
heartRate : int
duration : double
quality : double
--------------------------------
showInfo()
isTachycardia() : boolean
isValid() : boolean
```

El diagrama nos permite identificar directamente:

- `HeartSignal`: el nombre de la clase;
- `heartRate`, `duration` y `quality`: los atributos y sus tipos;
- `showInfo()`, `isTachycardia()` e `isValid()`: los métodos;
- `boolean`: el tipo de retorno de los dos métodos de comprobación.

Durante la sesión se realizó únicamente la implementación de la clase
`HeartSignal` (la parte A del ejercicio). Así hemos practicado el paso de
**UML → clase Java**.

### Pendiente: crear y usar un objeto desde `Main`

Queda como tarea completar las partes B y C de
[EXERCISES.md](EXERCISES.md#parte-b). Crea el objeto indicado, asigna sus
valores y llama a los métodos de la clase. Al hacerlo, practica esta secuencia:

```text
clase → instancia → estado → llamada a métodos
```

No se incluye aquí la solución de `Main`: es importante que realices ese paso
de forma autónoma.

## 5. Tarea para casa: diseña tu propio sensor médico

Como cierre, realiza el ejercicio
[Diseña tu propio sensor médico](EXERCISES.md#diseña-tu-propio-sensor-médico).
Elige qué dispositivo o señal quieres representar y toma tus propias decisiones:

1. escoge qué quieres modelar;
2. determina qué información es relevante;
3. define atributos;
4. define comportamientos;
5. represéntalo mediante UML;
6. impleméntalo;
7. crea objetos y utilízalos.

No buscamos un único sensor ni una única solución correcta. Lo importante es
justificar tus decisiones de abstracción con el problema que hayas elegido.

## Resumen

Hoy hemos usado los ejemplos de sonido, calculadora de IMC, persona, Pokémon y
señal cardíaca para profundizar en el modelado de clases. Al diseñar, recuerda:

- los atributos representan el estado de un objeto;
- los métodos representan el comportamiento;
- los parámetros sirven para información temporal que necesita una operación;
- una clase puede no tener atributos;
- el contexto y los requisitos determinan qué información es relevante.
