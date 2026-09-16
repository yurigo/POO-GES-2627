# Sesión 06 — Lectura de ficheros, excepciones y presentación de la AC1

En la [Sesión 05](../session-05/README.md) empezamos a interactuar por consola con `Scanner`.
En esta sesión nos hicimos una pregunta nueva:

```text
si los datos no se escriben cada vez por teclado,
¿cómo los leemos desde un fichero?
```

Ese cambio nos llevó a dos ideas clave:

1. lectura de texto con `FileReader` y `BufferedReader`;
2. primera aproximación práctica a las excepciones.

## Objetivos de aprendizaje

Al finalizar la sesión deberías ser capaz de:

- entender que un programa puede leer información desde un fichero de texto;
- realizar una lectura básica usando `FileReader` y `BufferedReader`;
- comprender por qué Java obliga a tener en cuenta posibles errores en operaciones de fichero;
- reconocer una excepción en tiempo de ejecución como `ArithmeticException`;
- empezar a analizar una actividad grande (AC1) antes de programar toda la solución.

## 1. De teclado a fichero

Hasta ahora trabajábamos con:

```java
Scanner
```

Ahora hemos introducido lectura desde fichero con:

```java
FileReader
BufferedReader
```

La idea práctica fue simple: abrir un fichero y leer su contenido progresivamente (por ejemplo, línea a línea).

Material de referencia utilizado en clase:

- <https://github.com/yurigo/poo/tree/master/io>
- <https://github.com/yurigo/poo/tree/master/io/ejemplos>

## 2. Paréntesis necesario: primeras excepciones

Al leer ficheros apareció una situación nueva: la operación puede fallar.

Ejemplos típicos:

- el fichero no existe;
- no se puede abrir;
- hay un error durante la lectura.

Por eso Java nos obliga a contemplar ese posible fallo cuando usamos estas clases.

En esta sesión **no** hemos hecho todavía un tema completo de excepciones (jerarquías, diseño avanzado, etc.). Solo el mínimo necesario para poder continuar con lectura de ficheros con sentido.

## 3. Contraste: error durante la ejecución

También vimos este ejemplo:

```java
float a = 100 / 0;
```

Resultado observado:

```text
ArithmeticException
```

Esto nos permitió comparar dos situaciones de forma intuitiva:

```text
operación con fichero
        ↓
Java obliga a contemplar que puede fallar

frente a

100 / 0
        ↓
el error aparece durante la ejecución
```

## 4. Referencia de I/O para seguir practicando

Para repasar y ampliar ejemplos de lectura/escritura:

- <https://github.com/yurigo/poo/tree/master/io>
- `io/README.md`
- `io/ejemplos/`

No hace falta copiar todo ese material aquí: úsalo como referencia de consulta.

## 5. Tarea para casa

En clase nos centramos en **leer** ficheros. Como trabajo para casa:

> Investiga cómo **escribir** información en un fichero.

Pista de conceptos a buscar en el material de referencia:

```java
FileWriter
BufferedWriter
```

Importante: la tarea es investigar, probar y entender los ejemplos; no se ha dado una solución completa paso a paso en esta sesión.

## 6. Presentación de la AC1

En la segunda parte se presentó:

- [AC1 — Simulador d'objectes](exercises/AC1.md)

## 7. Primer trabajo de diseño

Antes de escribir todo el código, nos interesa pensar preguntas como:

- ¿Qué responsabilidad tiene `Ball`?
- ¿Qué responsabilidad tiene `GameArea`?
- ¿Qué debería hacer `Main`?
- ¿Quién mueve cada bola?
- ¿Quién conoce los límites del área?
- ¿Quién representa el conjunto de bolas?
- ¿Quién carga o guarda el estado?
- ¿Cómo convertir una línea CSV en datos para crear un objeto?
- ¿Qué validaciones mínimas deben hacerse?
- ¿Qué métodos empiezan a aparecer al leer el enunciado?

Estas preguntas pueden orientarte en el diseño inicial.