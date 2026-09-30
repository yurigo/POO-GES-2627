# Sesión 10 — Implementación del centro médico

## Objetivos

- Pasar a Java el modelo UML del ejercicio **Centro médico** de la [sesión
  09](../session-09/UML.md).
- Relacionar las clases `CentroMedico`, `Consulta` y `Camilla` mediante
  referencias a objetos.
- Practicar la creación de objetos y su incorporación a una colección.
- Comparar un array de tamaño fijo con un `ArrayList` de tamaño dinámico.

## Antes de empezar

Repasa las clases, atributos, relaciones y multiplicidades del ejercicio 1 de
los [diagramas UML de la sesión 09](../session-09/UML.md).

## Desarrollo de la sesión

La implementación se encuentra en
[`solutions/centro-medico/src`](solutions/centro-medico/src).

### Del modelo UML a las clases Java

El centro médico tiene un código, un nombre y varias consultas. Una consulta
tiene un número, una planta y una camilla. La camilla se crea al construir la
consulta, de acuerdo con la relación de composición del diagrama:

```java
public class Consulta {
    private int numero;
    private int planta;
    private Camilla camilla;

    public Consulta(int numero, int planta, String serieCamilla) {
        this.numero = numero;
        this.planta = planta;
        this.camilla = new Camilla(serieCamilla);
    }
}
```

`CentroMedico` mantiene las consultas mediante objetos `Consulta`. El método
`añadirConsulta` recibe una consulta ya creada y la incorpora al centro.

### De un array estático a `ArrayList`

En el primer intento se utilizó un array con capacidad fija:

```java
private Consulta[] consultas;
```

Con este enfoque hay que reservar un tamaño y buscar manualmente una posición
libre. En la solución de la sesión se sustituye por:

```java
private ArrayList<Consulta> consultas;

public CentroMedico(String codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.consultas = new ArrayList<Consulta>();
}

public void añadirConsulta(Consulta c) {
    consultas.add(c);
}
```

`ArrayList` crece cuando se añaden elementos, por lo que ya no es necesario
decidir de antemano cuántas consultas caben. La clase se importa desde
`java.util` y se parametriza con `Consulta` para indicar qué tipo de objetos
contiene.

## Ejemplo trabajado en clase

En [`Main.java`](solutions/centro-medico/src/Main.java) se crea un centro
médico y se añaden varias consultas:

```java
CentroMedico cm = new CentroMedico("LSHC", "La Salle Health Center");

cm.añadirConsulta(new Consulta(1, 2, "camilla1"));
cm.añadirConsulta(new Consulta(3, 4, "camilla2"));
cm.añadirConsulta(new Consulta(8, 9, "camilla cabello"));
```

Cada llamada crea una `Consulta`, y su constructor crea la `Camilla`
correspondiente. La colección del centro puede recibir todas las consultas sin
ampliar manualmente un array.

## Experimenta

1. Compila y ejecuta el ejemplo desde el directorio
   `solutions/centro-medico`:

   ```bash
   javac -d out src/*.java
   java -cp out Main
   ```

2. Añade más consultas en `Main` y comprueba que el programa sigue aceptándolas.
3. Observa el código comentado de `CentroMedico` y explica qué pasos eran
   necesarios para localizar una posición libre en el array.
4. Añade temporalmente un método que muestre cuántas consultas contiene el
   centro. ¿Qué operación de `ArrayList` necesitas?

## Qué deberías llevarte de esta sesión

- Un diagrama UML se puede traducir a varias clases relacionadas mediante
  atributos que referencian objetos.
- Un objeto puede crear otro objeto relacionado como parte de su construcción.
- Un array tiene una capacidad fija; `ArrayList` permite añadir elementos de
  forma dinámica.
- Las colecciones se pueden parametrizar para trabajar con un tipo concreto,
  como `ArrayList<Consulta>`.
