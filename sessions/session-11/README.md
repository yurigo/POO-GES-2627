# Sesión 11 — Del UML a Java: `ArrayList` y GRASP

## Objetivos

- Traducir a Java las clases y relaciones del modelo UML del centro médico.
- Utilizar `ArrayList` para guardar un número variable de consultas.
- Reconocer los principios GRASP de experto de información y bajo acoplamiento
  en el diseño del proyecto.

## Antes de empezar

Repasa las clases y relaciones del [diagrama del centro médico de la sesión
09](../session-09/UML.md#ejercicio-1--centro-médico) y la implementación del
centro médico de la [sesión 10](../session-10/README.md). En esta sesión se
continúa trabajando sobre el proyecto de
[`projects/centro-medico`](projects/centro-medico/src).

## Del UML a Java

El diagrama describe tres clases: `CentroMedico`, `Consulta` y `Camilla`. Sus
atributos se convierten en campos Java: por ejemplo, `numero : int` pasa a ser
`private int numero;` en `Consulta`. Las relaciones también se representan en
el código:

- `CentroMedico` tiene varias consultas, por eso guarda una colección de
  `Consulta`.
- Cada `Consulta` tiene una `Camilla`. El constructor de `Consulta` crea esa
  camilla, reflejando la composición del diagrama.

La implementación completa está en
[`src`](projects/centro-medico/src). En ella se puede seguir la traducción de
cada clase y relación a sus campos, constructores y métodos.

## `ArrayList` de consultas

`CentroMedico` declara e inicializa la colección así:

```java
private ArrayList<Consulta> consultas;

public CentroMedico(String codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.consultas = new ArrayList<Consulta>();
}
```

El tipo entre `< >` indica que la lista guarda objetos `Consulta`. El método
`añadirConsulta` los incorpora con `add`, sin reservar de antemano un tamaño
máximo:

```java
public void añadirConsulta(Consulta c) {
    consultas.add(c);
}
```

Para mostrar las consultas, `ShowYourConsultas` recorre la lista con `size()` y
`get(i)`, y llama al método de cada elemento.

## GRASP: experto de información

El principio de **experto de información** propone asignar una responsabilidad
a la clase que tiene los datos necesarios para cumplirla. `Consulta` conoce su
número, su planta y su `Camilla`, por lo que su método `showYourInfo` muestra
esa información y delega en `Camilla` la presentación de los datos de la
camilla. A su vez, `CentroMedico` conoce su lista y recorre sus consultas.

Así, cada objeto puede encargarse de la información que conoce, en vez de
concentrar todos los detalles en `Main` o en `CentroMedico`.

## GRASP: bajo acoplamiento

El **bajo acoplamiento** busca limitar cuánto necesita saber una clase sobre
las demás. `CentroMedico` necesita conocer el tipo `Consulta` para mantener la
lista, pero no accede directamente a los campos privados de cada consulta:
recorre los objetos y les pide que muestren su información. `Consulta`, por su
parte, usa `Camilla` para mostrar los datos de esta.

Las clases siguen relacionadas —como indica el UML—, pero cada una oculta sus
detalles y ofrece métodos para colaborar. Esto reduce la dependencia de una
clase respecto a cómo otra organiza internamente sus datos.

## Ejemplo trabajado en clase

En [`Main.java`](projects/centro-medico/src/Main.java) se crea el centro
médico, se crean consultas y se añaden a la colección:

```java
CentroMedico cm = new CentroMedico(codigo, nombre);
Consulta consulta = new Consulta(1, 2, "camilla1");
cm.añadirConsulta(consulta);
cm.añadirConsulta(new Consulta(8, 9, "camilla cabello"));
cm.ShowYourConsultas();
```

`Main` coordina las acciones; la gestión de la lista y la presentación de los
datos se dejan a los objetos correspondientes.

## Experimenta

Desde `sessions/session-11/projects/centro-medico`, compila y ejecuta el
proyecto:

```bash
javac -d out src/*.java
java -cp out Main
```

Después, añade otra consulta en `Main` y observa cómo aparece al mostrar las
consultas del centro. Identifica qué clase conoce cada dato y qué método se
invoca para mostrarlo.

## Qué deberías llevarte de esta sesión

- Los atributos y las relaciones de un diagrama UML se traducen en campos que
  pueden referenciar otros objetos o colecciones.
- `ArrayList<Consulta>` permite guardar consultas y recorrerlas con operaciones
  como `add`, `size` y `get`.
- El experto de información asigna una responsabilidad a la clase que dispone
  de los datos necesarios.
- El bajo acoplamiento se favorece cuando las clases colaboran mediante sus
  métodos, sin depender de los detalles internos de las otras.
