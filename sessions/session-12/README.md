# Sesión 12 — Herencia y polimorfismo

## Objetivos

- Repasar la traducción de un diagrama UML a clases y referencias en Java.
- Identificar atributos comunes y generalizar clases mediante herencia.
- Utilizar una lista del tipo general para guardar objetos de distintas clases
  derivadas y observar el polimorfismo.

## Antes de empezar

Repasa las relaciones y multiplicidades del [ejercicio 2 de la sesión
09](../session-09/UML.md#ejercicio-2--laboratorio), así como las referencias a
objetos y `ArrayList` vistos en sesiones anteriores.

## Del UML del laboratorio a Java

La primera parte de la sesión consistió en corregir la implementación del
ejercicio **Laboratorio** de la sesión 09. El código está en
[`projects/laboratorio/src`](projects/laboratorio/src).

Cada clase del diagrama se convierte en una clase Java y sus atributos pasan a
ser campos. `Equipo` y `Muestra` mantienen una lista de análisis, porque el
diagrama permite que cada uno participe en cero o varios. Cada `Analisis`
referencia el equipo y la muestra que le corresponden y el `Resultado` que
genera:

```java
public class Analisis {
    private Equipo equipo;
    private Muestra muestra;
    private Resultado resultado;

    public Analisis(Equipo equipo, Muestra muestra, Resultado resultado) {
        this.equipo = equipo;
        this.muestra = muestra;
        this.resultado = resultado;
        equipo.añadirAnalisis(this);
        muestra.añadirAnalisis(this);
    }
}
```

Así, las referencias de `Analisis` representan las relaciones de uno a uno con
`Equipo`, `Muestra` y `Resultado`; las listas representan la multiplicidad de
varios análisis por equipo o muestra. `Main` crea objetos para ver cómo se
conectan las clases.

## Herencia: generalizar clases

La herencia permite expresar que una clase es un tipo más específico de otra.
Al revisar los animales del ejemplo, los datos que se repetían —nombre, fecha
de nacimiento, peso y sexo— se agruparon en `Animal`. Así se evita volver a
declararlos en cada clase concreta.

`Gato`, `Perro`, `Pato`, `Capibara` y `Mosquito` extienden `Animal`. Además,
`Domestico` agrupa a los animales domésticos y extiende `Animal`; por eso
`Gato` y `Perro` extienden `Domestico`. El ejemplo está en
[`Zoologico/src`](Zoologico/src).

## Polimorfismo

El tipo declarado de una variable determina qué clase de objetos puede
referenciar. Como `Gato` y `Perro` son tipos de `Animal`, una
`ArrayList<Animal>` puede guardar objetos de esas clases junto con patos,
capibaras y mosquitos.

`Animal` define `habla()`, que algunas subclases sobrescriben con su propia
respuesta. Al recorrer la lista y llamar `habla()` en cada elemento, Java
ejecuta la versión correspondiente al tipo real del objeto:

```java
ArrayList<Animal> animales = new ArrayList<>();
animales.add(new Pato());
animales.add(new Gato());
animales.add(new Perro());
animales.add(new Capibara());
animales.add(new Mosquito());

for (Animal animal : animales) {
    animal.habla();
}
```

Aunque todas las variables del recorrido tienen tipo `Animal`, cada llamada
puede producir un sonido diferente. Esa respuesta según la clase concreta del
objeto es el polimorfismo.

## Experimenta

1. Compila y ejecuta el ejemplo de animales desde `Zoologico`:

   ```bash
   javac -d out src/*.java
   java -cp out Main
   ```

2. Añade otro tipo de animal que extienda `Animal`, sobrescribe `habla()` y
   guárdalo en la lista. Comprueba que se ejecuta su versión del método.
3. Compila el ejercicio del laboratorio desde `projects/laboratorio`:

   ```bash
   javac -d out src/*.java
   java -cp out Main
   ```

## Qué deberías llevarte de esta sesión

- Las clases Java se pueden construir a partir de las clases, atributos y
  relaciones de un diagrama UML.
- La generalización permite reunir atributos comunes en una clase base y
  especializarla mediante herencia.
- Una lista de una clase general puede contener objetos de sus subclases.
- Al sobrescribir un método, una llamada hecha mediante el tipo general puede
  ejecutar la implementación de la clase concreta del objeto.
