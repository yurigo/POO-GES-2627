# Sesión 03 — Objetos, visibilidad y encapsulación

En la [Sesión 02](../session-02/README.md) seguimos practicando la diferencia
entre clase, objeto, atributos y métodos. Ahora damos el siguiente paso: no solo
queremos construir objetos, sino también decidir cómo se puede acceder a su
estado y cómo controlar ese acceso.

## Objetivos de aprendizaje

Al finalizar la sesión serás capaz de:

- reforzar la diferencia entre clase, objeto e instancia;
- entender que dos objetos de la misma clase pueden tener estados diferentes;
- comprender el significado de `public` y `private`;
- interpretar `+` y `-` en un diagrama UML;
- explicar por qué el estado interno de un objeto no debe ser accesible
  indiscriminadamente desde cualquier parte del programa;
- introducir la idea de encapsulación como mecanismo para proteger y controlar
  el estado del objeto;
- decidir cuándo hace falta proporcionar acceso a un atributo mediante getters y
  setters;
- reconocer que también puede modificarse el estado mediante métodos que
  representan comportamientos propios del objeto;
- seguir el proceso de análisis de requisitos, abstracción, diseño y primera
  implementación.

## 1. Clase, objeto e instancia

La sesión comenzó precisamente con una idea que ya habíamos visto antes, pero que
conviene repetir con calma:

- una clase define un modelo;
- un objeto es una instancia concreta de esa clase;
- dos objetos distintos pueden compartir la misma clase pero tener estados
  diferentes.

Si pensamos en una clase como el plano, cada objeto es una construcción distinta
que sale de ese plano. La clase no contiene un valor concreto para cada
instancia; cada objeto guarda su propio estado.

```java
HeartSignal signal1 = new HeartSignal();
HeartSignal signal2 = new HeartSignal();
```

Ambos son objetos de la misma clase `HeartSignal`, pero `signal1` y `signal2`
pueden tener distintas frecuencias, duraciones o calidades. La clase describe el
modelo; cada objeto lleva su propio conjunto de datos.

Esta diferencia es importante porque da sentido a la encapsulación: una clase
modelo puede crear múltiples objetos, pero no todos deben compartir ni exponer
su estado de la misma forma.

## 2. `public` y `private`

Durante la sesión realizamos una comprobación práctica muy útil: cuando un
atributo o un método está marcado como `private`, ya no puede accederse desde
otra clase, mientras que si está marcado como `public` sí se permite.

Esto no es una mera regla formal. Tiene un efecto muy visible en el IDE:

- con `public`, el miembro aparece como accesible desde otros objetos;
- con `private`, deja de estar disponible desde fuera de la clase;
- el compilador muestra un error si intentamos acceder a algo que no es
  visible.

En Java, esa relación se refleja en UML de la siguiente forma:

```text
+ atributoOMetodo   -> public
- atributoOMetodo   -> private
```

Es decir, la notación UML y la palabra clave Java se corresponden de manera muy
simple:

```text
+  -> public
-  -> private
```

Esto nos ayuda a leer un diagrama antes incluso de escribir código. Si vemos un
atributo con `-`, sabemos que formará parte del estado interno de la clase y no
se debe manipular directamente desde fuera.

### Ejemplo de acceso permitido y no permitido

```java
class Persona {
    public String nombre;
    private int edad;
}
```

Desde otra clase podríamos hacer algo como esto:

```java
Persona p = new Persona();
p.nombre = "Ana";
```

y eso sería válido porque `nombre` es `public`.

Pero esto no sería válido:

```java
p.edad = 20;
```

porque `edad` es `private`. Aquí aparece claramente la diferencia entre un dato
que se puede acceder directamente y un dato que queda protegido dentro del
objeto.

## 3. Encapsulación

La idea central que desarrollamos en la sesión fue esta:

> El estado interno de un objeto no debería poder modificarse
> indiscriminadamente desde cualquier parte del programa.

Eso es la encapsulación.

La encapsulación no consiste en esconder todo sin más. Consiste en decidir qué
parte del estado del objeto pertenece al propio objeto y cómo se va a consultar
o modificar esa información.

Cuando escribimos algo como:

```java
objeto.atributo = valor;
```

estamos accediendo directamente al estado. Eso puede estar bien en ejemplos muy
sencillos, pero en la práctica no siempre es una buena idea. El problema es que
quien usa el objeto puede cambiar el estado sin respetar reglas del dominio.

Imagina una clase donde el valor de una frecuencia cardíaca debe estar siempre en
un rango razonable. Si cualquiera puede escribir directamente el atributo, la
clase pierde el control sobre esa regla.

Por eso, como regla general en los ejemplos trabajados en la asignatura,
hemos empezado a usar atributos `private` para que el estado quede protegido.

### Diferencia entre acceso directo y acceso controlado

- acceso directo: `objeto.atributo = valor;`
- acceso controlado: el propio objeto ofrece operaciones que validan o manipulan
  ese valor.

Con esto aparece una idea muy importante: el estado no se modifica solo por
"ponerle un valor" desde fuera, sino por operaciones que el propio objeto
controla y entiende.

## 4. Getters, setters y métodos que representan comportamiento

Cuando hace falta permitir consultar o modificar cierta información privada, la
clase puede ofrecer métodos de acceso.

Conceptualmente, suelen aparecer nombres como:

```java
getNombre()
setNombre()
```

y lo mismo para otros atributos.

Pero es muy importante entender algo que repetimos en clase:

- no todos los atributos necesitan automáticamente un getter y un setter;
- se crean si son necesarios para resolver el problema;
- no hay que convertir la encapsulación en "atributos privados + getters/setters
  por sistema".

La encapsulación no es solo una técnica de escritura. Es una forma de decidir
qué información se expone y cómo se modifica.

Un objeto no tiene por qué cambiar su estado solo a través de setters. Muchas
veces es mejor tener métodos que representen comportamientos reales del dominio,
por ejemplo:

```java
mover();
rebotar();
colisionar();
```

Estos métodos pueden cambiar el estado del objeto, pero hacerlo de una manera
que tenga sentido dentro del comportamiento de la clase.

## 5. Ejemplo trabajado en clase: frecuencia cardíaca

La práctica de la sesión se apoyó especialmente en un ejemplo relacionado con la
frecuencia cardíaca. En este repositorio ese ejemplo aparece en la
[Sesión 02](../session-02/EXERCISES.md), donde se presenta la clase `HeartSignal`.

El diagrama básico que trabajamos fue este:

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

Este ejemplo fue muy útil para practicar varias cosas a la vez:

- `HeartSignal` es la clase;
- cada creación con `new HeartSignal()` da lugar a un objeto o instancia;
- cada objeto puede guardar un estado distinto;
- el estado se representa con atributos;
- `showInfo()`, `isTachycardia()` e `isValid()` muestran comportamiento;
- si quisiéramos proteger ciertos datos, haríamos que fueran `private`;
- si necesitáramos consultar o modificar información concreta, podríamos añadir
  getters o setters cuando fueran realmente útiles.

Este es precisamente el tipo de ejemplo que nos ayuda a entender el punto clave:
la clase define el comportamiento, pero cada objeto conserva su propio estado.

## 6. El simulador de bolas: modelado con un cliente real

La segunda parte de la sesión tuvo un enfoque distinto. No se nos dio un
problema cerrado con un enunciado perfecto. El profesor actuó como un cliente
que quería una aplicación para simular bolas en un espacio rectangular.

Durante la conversación aparecieron ideas poco a poco:

- existen dos bolas;
- cada una tiene una posición;
- se mueven;
- el movimiento era inicialmente rectilíneo uniforme;
- hay un espacio rectangular que limita el movimiento;
- las bolas pueden chocar con las paredes;
- al llegar a ciertos límites deben poder rebotar;
- también pueden colisionar entre sí;
- una bola puede llegar a «comerse» a otra;
- la fuerza de cada bola influye en la colisión.

Todo eso se fue descubriendo mediante preguntas, no mediante una especificación
final y cerrada. Esa es una parte importante del ejercicio: no se trata de
resolver un problema ya completamente definido, sino de ir transformando una
idea inicial en un modelo.

### Identificación de clases

Durante la discusión se identificaron dos responsabilidades principales:

- `Campo`: representa el espacio donde ocurre la simulación;
- `Bola`: representa cada objeto que se desplaza dentro del campo.

No se partió de un UML ya hecho. Las clases surgieron a partir del problema y de
la conversación con el cliente.

### Primera versión del UML

La primera versión del modelo que dibujamos en clase quedó así:

```text
Campo
--------------------------------
- limX : int
- limY : int
- p1 : Bola
- p2 : Bola
--------------------------------
+ pinta() : void
+ simula() : void

Bola
--------------------------------
- fuerza : int
- posicionX : int
- posicionY : int
- velocidadX : int
- velocidadY : int
- tamano : int
--------------------------------
+ rebote(limiteX : int, limiteY : int) : void
+ colision(otra : Bola)
+ simula()
```

Esta es la primera versión del diseño. No es una solución final ni una versión
perfecta. Es una fotografía de cómo estaba pensado el problema en ese momento.
Por eso es importante conservar su carácter provisional.

La imagen trabajada en clase fue esta:

![Primera versión del UML del simulador de bolas](https://github.com/user-attachments/assets/ebec7da3-3c4b-4f67-a1be-4775de338ed9)

Esta imagen debe leerse como una primera idea de modelado, no como un diagrama
perfecto que ya no necesita cambiar.

### Por qué este ejercicio resulta valioso

El simulador de bolas fue útil porque nos permitió ver que el diseño orientado a
objetos no empieza escribiendo Java. Empieza así:

```text
cliente: «quiero una simulación de dos bolas»
        ↓
   hacer preguntas
        ↓
   obtener requisitos
        ↓
   identificar responsabilidades
        ↓
   identificar clases
        ↓
   identificar estado necesario
        ↓
   identificar comportamientos
        ↓
   UML y primera propuesta
```

Además, conecta muy bien con la encapsulación:

- `Campo` y `Bola` tienen atributos privados (`-`);
- las operaciones que ofrecen aparecen como públicas (`+`);
- esto lleva a preguntas muy importantes:
  - ¿quién debe poder mover una bola?
  - ¿deberíamos modificar `posicionX` y `posicionY` directamente desde fuera?
  - ¿es necesario un setter para cada atributo?
  - ¿es mejor que cada bola controle su propio movimiento y rebote?

Estas preguntas no tienen que resolverse ya de forma definitiva. Forman parte
exactamente del razonamiento que queremos desarrollar.

## 7. Qué no se ha explicado todavía

La sesión tuvo un enfoque muy concreto y progresivo. Por eso no se introdujeron
conceptos que aún no correspondían a este nivel del curso:

- variables o métodos de clase (`static`);
- relaciones UML formales;
- asociación, agregación o composición como conceptos formales;
- herencia;
- polimorfismo;
- interfaces;
- clases abstractas;
- colecciones;
- excepciones.

Aunque `Campo` tenga atributos de tipo `Bola`, no estamos todavía enseñando
formalmente cómo se modelan las relaciones entre clases. Lo que importa en este
momento es que dos objetos puedan colaborar sin adelantarnos a contenidos que se
trabajarán en sesiones posteriores.

## 8. Resumen

La sesión de hoy ha puesto el foco en un punto clave:

```text
objeto e instancia
        ↓
public / private
        ↓
control de acceso
        ↓
encapsulación
        ↓
objetos con estado protegido
        ↓
getters/setters solo cuando son necesarios
        ↓
métodos de dominio que controlan el comportamiento
        ↓
modelado de un problema mayor
        ↓
Campo + Bola
```

La encapsulación no es un adorno de la programación orientada a objetos. Es la
forma en que un objeto decide qué parte de su estado puede ser consultada o
modificada, y cómo se hace.

Y el simulador de bolas nos recuerda algo fundamental: el diseño no es una
specificación definitiva desde el principio. Es un modelo que evoluciona,
se pregunta y se corrige cuando aparecen nuevos requisitos.

No se ha definido una tarea formal nueva para casa en esta sesión. El ejercicio
parece estar deliberadamente abierto, como una primera fase de modelado que se
podrá completar o refinar más adelante según avance el curso.
