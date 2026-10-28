# Sesión 16 — GRASP y arquitectura por capas

## Objetivos

- Explicar y reconocer cuatro patrones GRASP: experto de información,
  Controller, bajo acoplamiento y alta cohesión.
- Relacionar la responsabilidad única (SRP) con el diseño de clases.
- Comprender cómo se reparten las responsabilidades en una arquitectura por
  capas sencilla.
- Comparar dos formas de aislar la persistencia: DAO y Repository.

## Antes de empezar

Esta sesión continúa el diseño con objetos y colecciones de la
[sesión 11](../session-11/README.md), donde ya se aplicaron experto de
información y bajo acoplamiento. También conviene recordar las
[interfaces de la sesión 15](../session-15/README.md) y la
[lectura de ficheros de la sesión 06](../session-06/README.md).

## Cuatro patrones GRASP

GRASP (*General Responsibility Assignment Software Patterns*) reúne principios
para decidir qué objeto debe asumir cada responsabilidad. No son reglas
mecánicas: sirven para razonar sobre el diseño y sus consecuencias.

### Experto de información

El **experto de información** asigna una responsabilidad al objeto que dispone
de los datos necesarios para cumplirla. Así, la información y el comportamiento
que la utiliza permanecen próximos.

En el [ejemplo del centro médico de la sesión 11](../session-11/README.md#grasp-experto-de-información),
`Consulta` conoce su número y su camilla, por lo que puede mostrar esos datos; a
su vez, `CentroMedico` conoce la lista de consultas y puede recorrerla. En el
ejemplo de esta sesión, `User` conoce el nombre de una persona y `UserManager`
conoce los usuarios que administra.

El experto no significa que una clase deba hacer cualquier operación relacionada
con sus datos: también hay que considerar acoplamiento y cohesión.

### Controller

El patrón **Controller** asigna a un objeto la recepción de un evento del sistema
y la coordinación de la respuesta. Ese objeto representa el caso de uso o el
sistema frente a la interfaz; no debería absorber el trabajo que corresponde a
las clases de dominio o de persistencia.

En el ejemplo de consola, `Controller` recibe el nombre introducido, solicita a
`UserManager` que cree el usuario y pide los datos para mostrarlos. No lee el
teclado directamente ni guarda los usuarios por su cuenta: delega esas tareas a
la vista y al gestor.

### Bajo acoplamiento

El **bajo acoplamiento** busca que una clase dependa de la menor cantidad
posible de detalles de otras clases. Las colaboraciones siguen existiendo, pero
los cambios internos de una parte deberían afectar lo menos posible a las
demás.

En la arquitectura del ejemplo, `Controller` usa el contrato `Menu`, no necesita
conocer cómo la vista imprime texto ni cómo obtiene la entrada. En las
variantes con persistencia, `UserManager` depende del contrato `UserDao` o
`UserRepository`; puede cambiarse la forma de guardar los datos sin reescribir
la coordinación de la aplicación.

### Alta cohesión

La **alta cohesión** busca que las responsabilidades de una clase estén
relacionadas entre sí y colaboren hacia un propósito claro. Una clase que mezcla
entrada por teclado, reglas de usuarios, formato de pantalla y escritura de
ficheros tiene responsabilidades poco cohesionadas.

En este ejemplo, `MenuConsole` se ocupa de la consola; `Controller`, de coordinar
el caso de uso; `UserManager`, de las operaciones de gestión; y el DAO o
Repository, de acceder a los datos. Mantener cada propósito acotado hace más
sencillo entender y cambiar el programa.

## SOLID: responsabilidad única

La **S** de SOLID significa *Single Responsibility Principle* (principio de
responsabilidad única, SRP): una clase debería tener una responsabilidad bien
definida y, por ello, un motivo principal para cambiar. No significa que una
clase deba tener un solo método; significa que sus operaciones deberían responder
a un mismo propósito.

Por ejemplo, un cambio en el formato de la consola debería afectar a
`MenuConsole`, mientras que un cambio en el formato de almacenamiento debería
afectar a la implementación de persistencia. Si una sola clase hiciera ambas
cosas, habría dos motivos independientes para modificarla.

SRP y alta cohesión están relacionados, pero no son exactamente la misma idea:
SRP ayuda a decidir qué responsabilidad corresponde a una clase; la cohesión
describe lo bien que las responsabilidades de esa clase encajan entre sí. No se
pretende aplicar aquí todos los principios SOLID, sino introducir su principio
de responsabilidad única.

## Arquitectura por capas

El ejemplo original, sin persistencia, separa cuatro responsabilidades:

```text
View (Menu) → Controller → UserManager → User
```

- **View** (`Menu`, `MenuConsole`): presenta información y recoge la entrada.
- **Controller**: recibe la acción y coordina la respuesta.
- **UserManager**: realiza las operaciones de gestión de usuarios.
- **User**: representa a un usuario y sus datos.

El recorrido consiste en que la vista recoge un nombre, el Controller delega la
creación en `UserManager` y la vista presenta el resultado. En este primer
ejemplo, `UserManager` guarda los usuarios en una lista en memoria: al cerrar el
programa se pierden. La persistencia no forma parte del ejemplo original.

El código está en
[`basic-layered-architecture`](examples/basic-layered-architecture/src).
La vista se expresa mediante la interfaz `Menu`, lo que permite intercambiar
implementaciones de consola sin cambiar el Controller.

## Persistencia: DAO y Repository

Las dos variantes siguientes mantienen el mismo caso de uso y la misma
separación por capas, pero guardan usuarios en un fichero de texto llamado
`users.txt`. Cada línea representa un nombre. Es una persistencia didáctica
sencilla: no es una base de datos ni resuelve necesidades como búsquedas
eficientes, transacciones o acceso simultáneo.

| Enfoque | Idea principal | Ventaja | Coste o límite |
| --- | --- | --- | --- |
| **DAO** (*Data Access Object*) | Ofrece operaciones de acceso a los datos, como insertar y consultar usuarios, y oculta los detalles del fichero. | Hace visible el límite entre la aplicación y las operaciones de almacenamiento; la implementación puede sustituirse. | Su API puede quedar muy ligada a operaciones de persistencia y crecer con detalles de cada tecnología. |
| **Repository** | Presenta los usuarios como una colección del dominio, con operaciones como añadir y buscar; oculta cómo se obtiene esa colección. | La capa de aplicación habla en términos del dominio y no del formato de almacenamiento. | Puede ocultar demasiado si se diseña como una colección genérica que no representa bien las consultas del dominio. |

En los ejemplos, la diferencia se refleja en los contratos: `UserDao` ofrece
`insert` y `findAll`; `UserRepository` ofrece `add` y `findAll`. Ambos se apoyan
en una implementación de fichero y devuelven objetos `User`. En proyectos
reales los nombres y límites exactos varían: DAO y Repository a veces se usan
como términos próximos. Lo importante es comparar las responsabilidades y
decidir qué contrato expresa mejor las necesidades de la aplicación.

- [Ejemplo por capas con DAO](examples/basic-layered-architecture-with-dao/)
- [Ejemplo por capas con Repository](examples/basic-layered-architecture-with-repository/)

Para compilar y ejecutar cualquiera de los ejemplos, desde su directorio:

```bash
javac -d out $(find src -name '*.java')
java -cp out Main
```

Al volver a ejecutar el programa desde ese mismo directorio, los nombres
guardados anteriormente se vuelven a leer. Los ficheros `users.txt` y `out/`
son datos de ejecución, no parte del código fuente.

## Qué deberías llevarte de esta sesión

- Experto de información asigna una responsabilidad a quien dispone de los
  datos; Controller coordina la respuesta a un evento del sistema.
- Bajo acoplamiento limita la dependencia de detalles y alta cohesión mantiene
  juntas las tareas que contribuyen a un propósito.
- SRP pide una responsabilidad clara por clase, no un único método por clase.
- Las capas separan presentación, coordinación, gestión y representación de
  datos; el almacenamiento persistente puede añadirse detrás de un contrato.
- DAO y Repository aíslan la persistencia con perspectivas distintas, aunque
  sus límites pueden variar entre proyectos.
