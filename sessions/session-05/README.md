# Sesión 05 — Entrada/salida por consola y ejemplo de IMC

Tras la [Sesión 04](../session-04/README.md), en esta sesión hemos reforzado
ideas básicas de Java y hemos dado el primer paso para interactuar con el
usuario desde consola.

## Objetivos de aprendizaje

Al finalizar la sesión deberías ser capaz de:

- repasar la diferencia entre clase, objeto, atributo y método;
- escribir salidas por consola con `System.out.print` y `System.out.println`;
- leer datos de entrada con `Scanner`;
- distinguir usos básicos de `next()`, `nextInt()` y `nextFloat()`;
- seguir un ejemplo completo sencillo que calcula y clasifica el IMC.

## 1. Repaso inicial

La sesión comenzó con un repaso breve de:

- qué representa una clase frente a un objeto;
- qué información guardan los atributos;
- qué comportamientos describen los métodos;
- pautas básicas de estilo al escribir código Java en clase.

## 2. Salida por consola

Practicamos cómo mostrar mensajes para guiar al usuario:

```java
System.out.println("Bienvenido al programa");
System.out.print("Introduce tu edad: ");
```

Con esto se reforzó la idea de que un programa no solo calcula, también debe
comunicar claramente qué está ocurriendo.

## 3. Entrada por consola con `Scanner`

Después introdujimos la lectura de datos:

```java
Scanner sc = new Scanner(System.in);
String nombre = sc.next();
int edad = sc.nextInt();
float altura = sc.nextFloat();
```

En este punto trabajamos únicamente el uso básico de estos métodos, sin entrar
todavía en el tratamiento de excepciones.

Puedes revisar el ejemplo trabajado en:

- [examples/input-output/src/Main.java](examples/input-output/src/Main.java)

## 4. Ejemplo guiado: calculadora de IMC

Como práctica integrada de entrada y salida, se desarrolló un programa que:

1. pide peso y altura al usuario;
2. calcula el índice de masa corporal (IMC);
3. muestra una clasificación básica del resultado.

Archivos del ejemplo:

- [Main.java](examples/IMC-calculator/src/Main.java)
- [Person.java](examples/IMC-calculator/src/Person.java)
- [IMCCalculator.java](examples/IMC-calculator/src/IMCCalculator.java)

## 5. Experimenta

Para practicar un poco más:

- cambia los mensajes mostrados al usuario;
- prueba distintos valores de peso y altura;
- comprueba cómo cambia la clasificación del IMC;
- modifica el programa para pedir también el nombre y mostrarlo en la salida.

## Resumen

En esta sesión hemos conectado conceptos de modelado ya conocidos con una
habilidad práctica esencial: escribir programas que interactúan con el usuario
por consola. Este paso prepara el terreno para ejercicios más completos en las
siguientes sesiones.