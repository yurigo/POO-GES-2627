# Sesión 15 — Clases abstractas e interfaces

## Objetivos

- Comprender qué es una clase abstracta y por qué no se pueden crear objetos
  directamente a partir de ella.
- Declarar operaciones abstractas y completar su implementación en una clase
  concreta.
- Definir una interfaz como contrato y hacer que distintas clases lo cumplan.
- Distinguir la abstracción como principio de la programación orientada a
  objetos de las clases abstractas como mecanismo concreto de Java.

## Abstracción y clases abstractas

La **abstracción** es el proceso de identificar las características y operaciones
relevantes de un concepto para un problema, dejando fuera los detalles que no son
necesarios. Como principio de la programación orientada a objetos, permite
trabajar con modelos que describen qué es importante y no con todos los detalles
de cada objeto real.

Una **clase abstracta** es una clase que representa un concepto general o
incompleto y que, por tanto, no se puede instanciar directamente. Puede reunir
atributos, constructores y métodos con implementación compartidos por sus
subclases, además de declarar **métodos abstractos**: operaciones sin cuerpo que
una subclase concreta debe implementar. Una clase que no implemente todos los
métodos abstractos heredados también debe ser abstracta.

En el [ejemplo del zoológico](examples/Zoologico/src/Animal.java), `Animal` es
abstracta porque `habla()` se declara sin implementación: cada subtipo concreto
debe proporcionar su propia respuesta. La clase también contiene información y
comportamiento común, como el nombre y `toString()`. `Domestico` se declara
abstracta en
[`Domestico.java`](examples/Zoologico/src/Domestico.java), mientras que
[`Gato.java`](examples/Zoologico/src/Gato.java) y
[`Perro.java`](examples/Zoologico/src/Perro.java) proporcionan implementaciones
concretas de `habla()`.

## Interfaces

Una **interfaz** define un tipo mediante un contrato de operaciones que sus
implementaciones se comprometen a ofrecer. No se crean objetos directamente de
una interfaz: una clase la implementa con `implements` y proporciona el
comportamiento requerido. En los ejemplos de esta sesión, la interfaz declara
métodos sin cuerpo y las clases implementadoras proporcionan su implementación.

El ejemplo
[`MenuAbstract`](examples/MenuAbstract/src/Menu.java) expresa el contrato del
menú mediante una clase abstracta cuyos métodos son todos abstractos. En
[`MenuInterface`](examples/MenuInterface/src/Menu.java) se representa el mismo
contrato mediante una interfaz. `MenuBasic` y `MenuWithColors` la implementan
con `implements`. En ambos programas, `Main` trabaja con una referencia de tipo
`Menu` y puede utilizar distintas implementaciones. Así, el código que usa el
menú depende de las operaciones disponibles y no de una implementación
concreta.

## Diferencias y elección

Una clase abstracta sirve como base para clases relacionadas y puede compartir
estado y código ya implementado, además de declarar operaciones pendientes. Una
interfaz expresa un contrato que pueden cumplir clases distintas, sin exigir que
compartan una clase base. En Java, una clase solo puede extender una clase
(abstracta o no), pero puede implementar varias interfaces.

Por tanto, ambos mecanismos permiten expresar operaciones comunes y aprovechar
el polimorfismo, pero organizan el diseño de forma distinta. Conviene utilizar
una clase abstracta cuando las subclases deban compartir una base y parte de su
implementación; una interfaz resulta adecuada cuando interesa definir una
capacidad o contrato común para clases que no necesariamente pertenecen a la
misma jerarquía.

La palabra **abstracto** aparece en ambos temas, pero no los convierte en el
mismo concepto: la abstracción es un principio de diseño; `abstract` y las
interfaces son mecanismos del lenguaje que ayudan a expresarlo.

## Qué deberías llevarte de esta sesión

- Una clase abstracta no se instancia directamente; puede combinar elementos
  compartidos con operaciones que sus subclases deben completar.
- Una interfaz define un contrato que pueden implementar clases diferentes.
- La abstracción como principio de la POO no es lo mismo que declarar una clase
  `abstract`.
