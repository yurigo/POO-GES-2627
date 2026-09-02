# Sesión 01 — Introducción a la Programación Orientada a Objetos

## Objetivos de aprendizaje

Al finalizar esta sesión serás capaz de:

- Explicar de manera introductoria qué es la Programación Orientada a Objetos.
- Diferenciar entre clase y objeto.
- Identificar atributos y métodos de una clase sencilla.
- Entender que los atributos representan el estado de un objeto.
- Entender que los métodos permiten definir su comportamiento y modificar su estado.
- Comprender de manera inicial el concepto de abstracción.
- Reconocer la estructura básica de una clase en Java.
- Crear y manipular objetos sencillos a partir de una clase.

## 1. Presentación de la asignatura

Durante este curso vamos a aprender a programar con Java desde una perspectiva orientada a objetos. La idea no es memorizar teoría aislada, sino construir modelos sencillos para resolver problemas reales.

En esta asignatura trabajarás con:

- Java como lenguaje principal.
- Ejercicios y ejemplos progresivos.
- Un enfoque práctico: escribir, ejecutar y probar código.
- Sesiones con explicación, experimentación y actividades cortas.

La clave es ir construyendo poco a poco una forma de pensar más cercana a la resolución de problemas con objetos.

## 2. Preparación del entorno

Como hemos hecho en clase, usaremos IntelliJ de Jetbrains para trabajar.  Éste nos proporciona un entorno de trabajo y un editor para programar y ejecutar.

## 3. ¿Qué es un objeto?

Antes de hablar de formalismos, pensemos en cosas del día a día.

- ¿Qué consideramos un objeto?
- ¿Cómo describiríamos ese objeto?
- ¿Qué información necesitamos conocer sobre él?
- ¿Qué puede hacer?
- ¿Qué acciones podemos realizar sobre él?

Un objeto es una entidad concreta del mundo real o del problema que estamos modelando. Puede ser una silla, una botella, un termómetro, un coche o incluso una calculadora.

Cuando hablamos de un objeto, normalmente queremos distinguir entre:

- su estado: la información que tiene en un momento dado;
- su comportamiento: las acciones que puede realizar o las cosas que puede hacer.

Por ejemplo, si pensamos en una silla:

- ¿Qué información describe su estado?
  - número de patas;
  - color;
  - posición en el espacio;
  - etc.
- ¿Qué puede hacer?
  - quedarse quieta;
  - moverse un poco;
  - mostrarse en pantalla;
  - etc.

La idea importante es que un objeto tiene estado y comportamiento.

## 4. Clase y objeto

La diferencia entre clase y objeto es muy importante.

- Una clase es la definición o el modelo del tipo de objeto.
- Un objeto es una instancia concreta de esa clase.

Si la clase es el plano, el objeto es la casa construida a partir de ese plano.

Podemos pensar en una guitarra:

- Clase: Guitarra.
- Objetos: la guitarra de Ana, la guitarra de Luis, la guitarra del aula.

Todos son guitarras, pero cada una puede tener un estado distinto.

## 5. Atributos

Los atributos describen el estado de un objeto. Son las variables que guardan información sobre ese objeto.

Si modelamos una silla, podríamos decidir representar algo así:

```java
int patas;
int color;
int posicionX;
```

Aquí estamos diciendo que una silla puede tener:

- un número de patas;
- un color;
- una posición horizontal.

Es importante entender que no todas las características reales de una silla tienen que estar representadas en el programa. Eso es una decisión de modelado.

Por ejemplo, una silla real puede tener también:

- material;
- altura;
- anchura;
- fabricante;
- peso;
- textura;
- precio;
- etc.

Pero para nuestro primer programa quizá no necesitamos todas esas cosas. Lo que importa es elegir solo la información relevante para el problema que queremos resolver.

## 6. Métodos

Los métodos representan el comportamiento de un objeto. Son acciones que el objeto puede hacer, o operaciones que cambian o consultan su estado.

En el ejemplo de la silla, podríamos definir métodos como:

- `showData()`
- `push()`
- `pull()`

```java
void showData() {
    // Muestra la información actual de la silla
}

void push() {
    // Desplaza la silla a la derecha
}

void pull() {
    // Desplaza la silla a la izquierda
}
```

La relación que queremos observar aquí es muy clara:

- el objeto tiene un estado;
- se ejecuta un método;
- el estado puede cambiar.

Esto es la base de la programación orientada a objetos: los objetos encapsulan información y comportamiento.

## 7. Introducción a la abstracción

La abstracción consiste en seleccionar solo las características relevantes para el problema que estamos resolviendo.

Volvamos a la silla:

- una silla real puede tener muchísimas propiedades;
- pero para un programa sencillo no necesitamos representar todas.

La pregunta clave es:

¿Qué información necesitamos realmente para resolver nuestro problema?

Esto significa que un mismo objeto del mundo real puede modelarse de distinta forma según el contexto.

Por ejemplo:

- En un catálogo de una tienda, quizá importa el material y precio.
- En un videojuego, quizá importa la posición y el color.
- En una aplicación de diseño, quizá importa tamaño y orientación.

La abstracción no es inventar cosas raras: es decidir qué detalles son importantes para el problema concreto.

## 8. Ejemplo trabajado: la clase `Silla`

Vamos a crear una clase muy sencilla para representar una silla.

### Versión inicial y progresiva

```java
class Silla {
    int patas;
    int color;
    int posicionX;

    void showData() {
        System.out.println("Patas: " + patas);
        System.out.println("Color: " + color);
        System.out.println("Posicion X: " + posicionX);
    }

    void push() {
        posicionX = posicionX + 1;
    }

    void pull() {
        posicionX = posicionX - 1;
    }
}
```

Aquí vemos los elementos básicos de una clase:

- comienza con la palabra clave `class`;
- dentro de la clase se declaran los atributos;
- después se definen los métodos;
- los métodos pueden leer atributos;
- los métodos pueden modificarlos.

### ¿Qué hace cada método?

- `showData()`: muestra por pantalla el estado actual de la silla.
- `push()`: mueve la silla en una dirección.
- `pull()`: mueve la silla en la dirección contraria.

Podemos considerar un desplazamiento fijo, por ejemplo un paso de 1 unidad, para mantener el ejemplo simple.

## 9. Crear objetos en Java

Para trabajar con una clase, necesitamos crear objetos a partir de ella.

```java
Silla silla1 = new Silla();
Silla silla2 = new Silla();
```

Cada objeto es independiente. Aunque ambos sean del mismo tipo, pueden tener estados distintos.

```java
silla1.patas = 4;
silla1.color = 2;
silla1.posicionX = 0;

silla2.patas = 3;
silla2.color = 1;
silla2.posicionX = 5;
```

Ahora observamos algo muy importante:

- `silla1` y `silla2` son dos objetos distintos;
- tienen atributos distintos;
- si ejecutamos `push()` sobre una de ellas, no afecta automáticamente a la otra.

## 10. Ejemplo completo

Este ejemplo muestra cómo crear dos sillas y cómo cambian sus estados:

```java
public class Silla {
    int patas;
    int color;
    int posicionX;

    void showData() {
        System.out.println("Patas: " + patas);
        System.out.println("Color: " + color);
        System.out.println("Posicion X: " + posicionX);
    }

    void push() {
        posicionX = posicionX + 1;
    }

    void pull() {
        posicionX = posicionX - 1;
    }

    public static void main(String[] args) {
        Silla silla1 = new Silla();
        Silla silla2 = new Silla();

        silla1.patas = 4;
        silla1.color = 2;
        silla1.posicionX = 0;

        silla2.patas = 3;
        silla2.color = 1;
        silla2.posicionX = 5;

        silla1.showData();
        silla2.showData();

        silla1.push();
        silla2.pull();

        System.out.println("Tras cambiar el estado:");
        silla1.showData();
        silla2.showData();
    }
}
```

Si ejecutas este programa verás que cada silla conserva su propio estado.

## 11. Actividades de experimentación

### Actividad 1 — Identificar objetos

Piensa en elementos cotidianos como una botella, una lámpara, un reloj o una bici. Para cada uno, responde:

- ¿Qué atributos podría tener?
- ¿Qué métodos podría tener?

No hay una única respuesta correcta. Lo importante es pensar en qué información es relevante.

### Actividad 2 — Nuestra silla

Antes de implementar cualquier clase, pregunta:

- ¿Qué características de una silla son relevantes para nuestro programa?
- ¿Qué características podemos ignorar?

Por ejemplo, si solo necesitamos moverla horizontalmente, quizá el color y el número de patas sí importan, pero otros detalles del mundo real pueden quedar fuera.

### Actividad 3 — Dos objetos

Crea dos objetos `Silla` con estados distintos.

Comprueba que:

- puede haber dos sillas con distinta cantidad de patas;
- puede haber dos sillas con distintos colores;
- puede haber dos sillas en diferentes posiciones;
- ejecutar `push()` sobre una no debe cambiar automáticamente la otra.

### Actividad 4 — Cambiar el estado

Muestra el estado inicial de una silla, ejecuta varias veces `push()` o `pull()` y vuelve a mostrar los datos.

Esto te ayudará a visualizar claramente que los métodos pueden cambiar el estado del objeto.

## 12. Reflexión final: la abstracción depende del problema

La abstracción no es una regla fija: cambia según lo que queramos modelar.

Si tu programa fuera:

- el catálogo de una tienda de muebles;
- un videojuego;
- una aplicación de diseño de interiores;
- un sistema de inventario;

entonces la clase `Silla` probablemente sería distinta en cada caso.

Por ejemplo:

- En un catálogo, quizá importan el precio, el material y la disponibilidad.
- En un videojuego, quizá importan la posición, el color y la capacidad de interacción.
- En un sistema de inventario, quizá importan la referencia y la cantidad disponible.

La idea es que la misma entidad del mundo real puede dar lugar a distintos modelos según el problema que estamos resolviendo.

## 13. Tarea para casa

Elige una entidad sencilla del mundo real, por ejemplo:

- una botella;
- una lámpara;
- una bicicleta;
- un termómetro;
- una cama;
- una báscula;
- u otra entidad similar.

Para esa entidad, realiza lo siguiente:

1. Explica brevemente qué objeto has escogido.
2. Propón entre 2 y 4 atributos relevantes.
3. Propón entre 2 y 4 métodos.
4. Indica qué atributo o atributos modifica cada método.
5. Justifica brevemente alguna característica real del objeto que hayas decidido no representar en tu modelo.
6. Si procede, implementa una primera versión sencilla de la clase en Java siguiendo el ejemplo de la silla.

No se espera una solución compleja ni un diseño completo. Lo importante es practicar el camino:

abstracción → atributos → métodos → clase.

## 14. Resumen

En esta sesión hemos visto que:

- un objeto tiene estado y comportamiento;
- una clase define el tipo de objeto;
- los atributos describen el estado;
- los métodos describen el comportamiento;
- la abstracción es una decisión de modelado;
- en Java, un objeto se crea a partir de una clase;
- dos objetos de la misma clase pueden mantener estados distintos.

Con esto ya tenemos una primera intuición del paradigma orientado a objetos, que iremos desarrollando sesión tras sesión.
