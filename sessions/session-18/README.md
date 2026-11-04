# Sesión 18 — Herramientas para el proyecto: SoundSynth y JSON

## Objetivos

Al finalizar la sesión, deberías poder:

- reconocer cómo una clase de apoyo permite reutilizar una funcionalidad concreta, como generar sonido;
- identificar qué información de un sonido se configura mediante sus parámetros;
- explicar qué representa JSON y distinguir un objeto de un array JSON;
- relacionar una estructura JSON con clases y tipos de Java;
- leer desde un fichero JSON una lista o un mapa de objetos Java utilizando Gson.

## Antes de empezar

Esta sesión se apoya en el trabajo previo con clases, objetos, métodos, enumeraciones, colecciones y lectura de ficheros. En particular, conviene recordar cómo se representan en Java los atributos de un objeto y cómo se recorre una colección.

## Conceptos

### SoundSynth: utilizar una clase de apoyo

`SoundSynth` encapsula la generación y reproducción de sonido. Su método `makeSound` recibe el tipo de onda, la frecuencia en hercios y la duración en milisegundos. La enumeración `WaveType` limita los tipos de onda disponibles a `SINE`, `SQUARE`, `TRIANGLE` y `SAWTOOTH`.

El programa principal crea un sintetizador y lo utiliza con distintas combinaciones de parámetros. Al comparar los resultados, observa qué cambia al variar el tipo de onda, la frecuencia o la duración. El ejemplo utiliza la API de sonido incluida en Java; su documentación y sus instrucciones de compilación están en el [README del ejemplo](./examples/sound-synth-example-master/README.md).

### JSON: representar datos

JSON es un formato de texto para representar e intercambiar datos. Sus estructuras más habituales son:

- **Objeto**: un conjunto de pares nombre-valor entre llaves (`{}`). Se corresponde con los atributos de un objeto, como `login` y `password` en los datos de `User`.
- **Array**: una secuencia ordenada de valores entre corchetes (`[]`). Puede representar varios usuarios.

Los valores de un documento JSON se escriben como texto, pero Gson puede convertirlos a los tipos Java correspondientes. La correspondencia entre los nombres de las propiedades JSON y los atributos de la clase permite construir objetos a partir de esos datos.

### Gson: leer JSON en objetos Java

Gson es una biblioteca que facilita la conversión entre JSON y objetos Java. No forma parte del JDK, por lo que debe estar disponible para compilar y ejecutar los ejemplos. En ellos se crea un `Gson` y se llama a `fromJson` para leer datos desde un `FileReader`.

Los dos ejemplos muestran formas distintas de organizar los mismos tipos de datos:

- [`EjemploJavaArrayGSON.java`](./examples/gson/EjemploJavaArrayGSON.java) lee un array JSON como `List<User>` y recorre la lista para mostrar sus elementos.
- [`EjemploJavaMapGSON.java`](./examples/gson/EjemploJavaMapGSON.java) lee un objeto JSON como `Map<Integer, User>` y accede tanto a un usuario por su clave como a los valores del mapa.

Al leer tipos genéricos, como `List<User>` o `Map<Integer, User>`, los ejemplos usan `TypeToken` para indicar a Gson el tipo completo que deben tener los datos. Compara los ficheros [`usuarios-array.json`](./examples/gson/usuarios-array.json) y [`usuarios-object.json`](./examples/gson/usuarios-object.json): uno contiene una lista de usuarios y el otro asocia claves con usuarios.

## Desarrollo de la sesión

1. Ejecuta el ejemplo de `SoundSynth` y localiza en `Main` las llamadas a `makeSound`. Predice qué parámetros cambian entre llamadas y escucha el resultado.
2. Examina los valores de `WaveType` y relaciona cada llamada del programa con el tipo de onda solicitado.
3. Abre ambos ficheros JSON y reconoce sus llaves, corchetes, propiedades y valores.
4. Relaciona las propiedades de los datos con los atributos de la clase `User`.
5. Sigue cada llamada a `fromJson`: identifica el fichero leído, el tipo Java esperado y la forma en que el resultado se utiliza.
6. Compara `List<User>` con `Map<Integer, User>` y explica qué permite hacer cada estructura en el ejemplo.

## Para seguir explorando

- Cambia una propiedad JSON y observa el efecto al leer de nuevo el fichero. Comprueba qué sucede cuando un objeto no contiene una de las propiedades de `User`.
- Modifica una llamada a `makeSound` cada vez y compara el efecto de cambiar la frecuencia, la duración o el tipo de onda.
- JSON describe datos, pero no los protege: no debe confundirse la lectura de un fichero JSON con un mecanismo de almacenamiento seguro de contraseñas.

## Recursos

- [JSON en español](https://www.json.org/json-es.html)
- [Java y JSON](https://www.baeldung.com/java-json)
- [Ejemplos Gson de esta sesión](./examples/gson)
- [Guía de deserialización con Gson](https://www.baeldung.com/gson-deserialization-guide)
- [Tutorial de Jackson](https://www.baeldung.com/jackson)
- [Repositorio original de SoundSynth](https://github.com/yurigo/sound-synth-example) y [código disponible en esta sesión](./examples/sound-synth-example-master)

## Qué deberías llevarte de esta sesión

Una biblioteca puede integrar en un programa funcionalidades ya preparadas, como la generación de sonido o la conversión de datos. Para trabajar con JSON, primero hay que entender la estructura del documento y después elegir el tipo Java que representa esos datos: en estos ejemplos, una lista o un mapa de objetos `User`.