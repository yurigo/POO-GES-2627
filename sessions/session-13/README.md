# Sesión 13 — Sobreescritura y `super`

## Objetivos

- Sobrescribir en una subclase un método definido en la clase base.
- Relacionar la sobreescritura con el comportamiento polimórfico de los objetos.
- Encadenar constructores para inicializar la parte heredada de un objeto.
- Invocar explícitamente un constructor o un método de la clase base mediante
  `super`.

## Antes de empezar

Repasa los conceptos de [herencia y polimorfismo de la sesión
12](../session-12/README.md#herencia-generalizar-clases). En particular, recuerda
que una referencia de tipo general puede apuntar a objetos de sus subclases y
que, al llamar a un método sobrescrito, se ejecuta la implementación
correspondiente al tipo concreto del objeto.

## Sobreescritura de métodos

Una subclase puede proporcionar su propia implementación de un método heredado,
manteniendo su nombre y sus parámetros. A esto se le llama **sobreescritura**.
De este modo, varios tipos relacionados comparten una operación, pero pueden
responder a ella de forma distinta.

El ejemplo de notificaciones aplica esta idea a `enviar()`: `Notificacion`
contiene el comportamiento común y `Correo`, `SMS` y `Push` lo amplían con
información propia de cada canal. En el programa principal, una lista de tipo
`Notificacion` puede reunir objetos de esas subclases. Al recorrerla y llamar a
`enviar()`, cada objeto ejecuta su propia implementación.

## La palabra reservada `super`

`super` permite referirse a la clase base desde una subclase. En esta sesión se
utiliza de dos formas:

### Encadenar constructores

Una subclase puede llamar al constructor de su clase base para inicializar los
datos que esta administra. Por ejemplo, el constructor de `Correo` pasa el
mensaje al constructor de `Notificacion`:

```java
public Correo(String mensaje) {
    super(mensaje);
}
```

La llamada `super(...)` debe ser la primera instrucción del constructor. Así,
la parte heredada del objeto se inicializa antes de continuar con la
inicialización específica de la subclase.

### Reutilizar un método de la clase base

Una implementación sobrescrita puede llamar al método original de la clase
base con `super.nombreDelMetodo(...)`. En el ejemplo, `Correo.enviar()` muestra
primero información propia del correo y después delega en `Notificacion` para
mostrar los datos comunes:

```java
public void enviar() {
    System.out.println("se envia un correo");
    super.enviar();
}
```

Así se conserva el comportamiento común sin duplicarlo en cada tipo de
notificación.

## Ejercicios trabajados

### Sistema de notificaciones

En clase se trabajó el [ejercicio 1](EXERCISES.md#1-sistema-de-notificaciones),
que propone distintos canales de envío para una notificación. La jerarquía de
`Notificacion` y sus subclases permite practicar la sobreescritura de
`enviar()`, el encadenamiento de constructores y la reutilización del método
base mediante `super`.

El proyecto de apoyo está en
[`projects/mensajeria-ejercicio/src`](projects/mensajeria-ejercicio/src/). En él,
`Main` guarda notificaciones de distintos tipos en una lista y llama a
`enviar()` sin comprobar el canal de cada objeto. El ejercicio completo también
plantea que una plataforma gestione las notificaciones; consulta el enunciado y
el [diagrama UML](UML.md#ejercicio-1--sistema-de-notificaciones) para ver el
modelo propuesto.

### Empresa de paquetería

El [ejercicio 2](EXERCISES.md#2-empresa-de-paquetería) se presentó para
practicar la misma organización con distintas modalidades de envío. Se
resolvieron dudas sobre el polimorfismo y se avanzó parcialmente en su
desarrollo. El proyecto
[`projects/envios-ejercicio/src`](projects/envios-ejercicio/src/) contiene esa
parte: `Envio` reúne los datos de tarifa y peso y calcula el precio; `Estandar`
encadena su constructor con el de `Envio`, proporcionándole las tarifas
correspondientes. El modelo y las tarifas de las demás modalidades están
descritos en el [diagrama UML](UML.md#ejercicio-2--empresa-de-paquetería) y en el
enunciado.

## Trabajo para casa

Completa el desarrollo del ejercicio de la empresa de paquetería y prepáralo
para la siguiente sesión. La empresa debe poder gestionar envíos de distintas
modalidades y operar con ellos aprovechando el polimorfismo, tal como se
describe en el [enunciado](EXERCISES.md#2-empresa-de-paquetería).

## Qué deberías llevarte de esta sesión

- La sobreescritura permite adaptar en una subclase un método heredado.
- El polimorfismo hace posible llamar a ese método mediante una referencia del
  tipo general y obtener el comportamiento del objeto concreto.
- `super(...)` llama al constructor de la clase base para inicializar la parte
  heredada del objeto.
- `super.metodo(...)` permite reutilizar explícitamente la implementación de un
  método de la clase base.
