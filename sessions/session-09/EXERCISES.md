# Actividades UML

## 1

Un centro médico está identificado por un código y un nombre. El centro dispone de varias consultas. Cada consulta tiene un número y una planta, y pertenece a un único centro médico. En cada consulta hay una camilla, identificada mediante un número de serie. Una camilla pertenece exclusivamente a una consulta y deja de formar parte del sistema si la consulta es eliminada.

## 2

Un laboratorio dispone de varios equipos de análisis. Cada equipo está identificado mediante un código, tiene un modelo y registra la fecha de su última revisión.

Los equipos analizan muestras. Cada muestra tiene un identificador, una fecha de extracción y un volumen. Una muestra puede ser analizada por distintos equipos y un equipo puede analizar múltiples muestras.

Cada análisis genera un resultado. El resultado almacena el valor obtenido, la unidad de medida y la fecha en la que se realizó el análisis. Cada resultado corresponde al análisis de una única muestra realizado por un único equipo.

## 3

Un festival de música tiene un nombre, una ciudad y una fecha de inicio. El festival se organiza en varios escenarios. Cada escenario tiene un nombre y una capacidad máxima.

Durante el festival actúan distintos grupos musicales. De cada grupo se conoce su nombre y su país de origen. Un grupo puede actuar en varios escenarios y en un mismo escenario pueden actuar varios grupos a lo largo del festival.

Cada actuación tiene una hora de inicio y una duración determinada. Una actuación corresponde a un único grupo y se realiza en un único escenario.

## 4

Una plataforma digital dispone de un catálogo de videojuegos. Cada videojuego tiene un identificador, un título, un precio y una fecha de lanzamiento.

Los usuarios de la plataforma están identificados mediante un nombre de usuario y un correo electrónico. Un usuario puede comprar varios videojuegos y un mismo videojuego puede ser comprado por muchos usuarios.

Cada compra almacena la fecha en que se realizó y el precio que tenía el videojuego en ese momento.

Los usuarios también pueden añadir videojuegos a una lista de deseos. Un usuario puede tener muchos videojuegos en su lista y un mismo videojuego puede aparecer en las listas de deseos de muchos usuarios.

## 5

Una plataforma ofrece cursos online. Cada curso tiene un código, un título, una descripción y una duración estimada.

Cada curso está formado por varios módulos. Un módulo tiene un título y un orden dentro del curso. Los módulos pertenecen exclusivamente a un curso.

Cada módulo contiene varias lecciones. Una lección tiene un título, una duración y un tipo de contenido. Una lección no puede existir independientemente del módulo al que pertenece.

Los estudiantes pueden matricularse en varios cursos y un mismo curso puede tener muchos estudiantes.

Para cada matrícula se almacena la fecha en que se realizó y el porcentaje de progreso del estudiante en ese curso.

Además, los estudiantes pueden completar lecciones. Para cada lección completada se registra la fecha de finalización.

## 6

Una compañía aérea gestiona varios aviones. Cada avión tiene una matrícula, un modelo y un número máximo de pasajeros.

La compañía ofrece vuelos. Cada vuelo tiene un código, una fecha, una hora de salida y una hora estimada de llegada. Cada vuelo se realiza utilizando un único avión, aunque un mismo avión puede realizar muchos vuelos.

Cada vuelo tiene un aeropuerto de origen y un aeropuerto de destino. De cada aeropuerto se conoce su código internacional, su nombre y la ciudad en la que se encuentra.

Los pasajeros pueden realizar reservas para los vuelos. Cada reserva tiene un código de localización, una fecha y un número de asiento. Una reserva corresponde a un único pasajero y a un único vuelo.

## 7

Un restaurante tiene un nombre, una dirección y un número máximo de clientes. El restaurante dispone de varias mesas. Cada mesa está identificada mediante un número y tiene una capacidad determinada.

Los clientes pueden realizar reservas. Cada reserva tiene una fecha, una hora y un número de personas. Una reserva corresponde a un único cliente y asigna una única mesa. Un cliente puede realizar varias reservas a lo largo del tiempo.

El restaurante ofrece una carta formada por distintos platos. Cada plato tiene un nombre y un precio.

Cuando los clientes ocupan una mesa pueden realizar un pedido. Un pedido pertenece a una mesa y contiene uno o varios platos. De cada plato solicitado se debe registrar también la cantidad pedida.

## 8

Un cine dispone de varias salas. Cada sala tiene un número y una capacidad máxima. Las butacas forman parte de una sala y cada una está identificada mediante una fila y un número.

El cine proyecta películas. De cada película se conoce su título, duración y clasificación por edades.

Una película puede proyectarse en diferentes salas y en diferentes horarios. Cada proyección tiene una fecha y una hora de inicio y se realiza en una única sala.

Los espectadores pueden comprar entradas para una proyección. Cada entrada tiene un código y un precio y reserva exactamente una butaca para esa proyección.

Una misma butaca puede utilizarse en muchas proyecciones diferentes, pero no puede venderse dos veces para una misma proyección.

## 9

Una red social permite registrar usuarios. Cada usuario tiene un identificador, un nombre visible y una fecha de registro.

Los usuarios pueden publicar mensajes. Cada publicación tiene un identificador, un texto y una fecha de publicación. Una publicación pertenece exclusivamente al usuario que la creó, mientras que un usuario puede crear cualquier número de publicaciones.

Los usuarios pueden seguir a otros usuarios. Un usuario puede seguir a muchos usuarios y puede ser seguido por muchos otros.

Las publicaciones pueden recibir comentarios. Cada comentario tiene un texto y una fecha, está escrito por un único usuario y pertenece a una única publicación.

Los usuarios también pueden indicar que les gusta una publicación. Un usuario solo puede marcar una misma publicación como favorita una vez, mientras que una publicación puede gustar a muchos usuarios.

## 10

Un entrenador Pokémon está identificado mediante un nombre y un número de licencia. Cada entrenador puede tener varios Pokémon, aunque solo puede seleccionar un máximo de seis para formar su equipo activo.

De cada Pokémon se conoce su nombre, su especie, su nivel y sus puntos de salud actuales. Un Pokémon pertenece a un único entrenador en un momento determinado.

Los Pokémon pueden conocer varios movimientos. Cada movimiento tiene un nombre, una potencia y un número máximo de usos. Un mismo movimiento puede ser conocido por muchos Pokémon.

Dos entrenadores pueden enfrentarse en un combate. Cada combate registra la fecha y el lugar donde se realiza. En el combate participa el equipo seleccionado por cada entrenador.

Durante el combate se registran los ataques realizados. De cada ataque se conoce qué Pokémon lo realizó, qué movimiento utilizó y sobre qué Pokémon se aplicó.