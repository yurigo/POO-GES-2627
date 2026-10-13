# UML y Java

Para cada ejercicio:

Identifica las clases, sus atributos y los métodos necesarios.
- Diseña el diagrama de clases UML, incluyendo relaciones, multiplicidades y herencia cuando corresponda.
- Implementa las clases en Java, respetando la encapsulación.
- Crea un programa principal que permita comprobar el funcionamiento del sistema.

Importante: el programa debe aprovechar el polimorfismo. No debe ser necesario comprobar manualmente de qué clase concreta es cada objeto para determinar su comportamiento.

## 1. Sistema de notificaciones

Una plataforma permite enviar notificaciones a sus usuarios. Cada notificación tiene un identificador, un destinatario, un mensaje y una fecha de creación.

Las notificaciones pueden enviarse mediante tres canales: correo electrónico, SMS y notificaciones push.

Los correos electrónicos contienen además un asunto. Los SMS están limitados a 160 caracteres y las notificaciones push tienen un título y el nombre de la aplicación que las genera.

Cada tipo de notificación se envía de una forma diferente. Para simular el envío, el sistema debe mostrar por consola la información correspondiente al canal utilizado.

La plataforma debe poder gestionar todas las notificaciones pendientes y enviarlas sin necesidad de conocer previamente el canal de cada una.

## 2. Empresa de paquetería

Una empresa de mensajería gestiona envíos de paquetes. De cada envío se conoce su código, destinatario, peso en kilogramos y fecha de creación.

La empresa ofrece tres modalidades de envío:

Estándar: cuesta 3 € más 0,50 € por kilogramo.
Urgente: cuesta 8 € más 1,20 € por kilogramo.
Internacional: cuesta 10 € más 2 € por kilogramo y 0,01 € por kilómetro de distancia.

La empresa debe poder registrar envíos de cualquier modalidad y calcular automáticamente el precio de cada uno.

También debe poder calcular la facturación total de todos los envíos registrados y mostrar un resumen de cada uno.

## 3. Aparcamiento de vehículos

Un aparcamiento permite estacionar motocicletas, turismos y furgonetas.

Todos los vehículos tienen una matrícula, una marca y un modelo. Los turismos tienen además un número de plazas y las furgonetas una capacidad de carga.

El aparcamiento aplica tarifas diferentes según el vehículo:

Las motocicletas pagan 1 € por hora.
Los turismos pagan 2 € por hora.
Las furgonetas pagan 3 € por hora, más un suplemento fijo de 5 € por estancia.

Cuando un vehículo entra, se registra una estancia que contiene la hora de entrada y la de salida, una vez conocida.

Un vehículo puede visitar el aparcamiento muchas veces. Cada estancia corresponde a un único vehículo.

El aparcamiento debe permitir registrar estancias, calcular su coste y mostrar el importe total recaudado durante el día.

## 4. Plataforma de contenidos multimedia

Una plataforma digital ofrece películas, podcasts y episodios de series.

Todos los contenidos tienen un identificador, un título y una duración.

Las películas tienen un director y un año de estreno. Los podcasts tienen un presentador y una temática. Los episodios tienen un número de episodio y pertenecen a una serie.

De cada serie se conoce su nombre y el número de temporadas. Una serie puede contener múltiples episodios.

La plataforma permite reproducir cualquier contenido, pero el mensaje de reproducción debe adaptarse al tipo de contenido.

Además, los usuarios pueden crear listas de reproducción con contenidos de diferentes tipos. Cada lista tiene un nombre y permite calcular su duración total.

## 5. Torneo de robots

Una competición enfrenta robots con diferentes especializaciones.

Todos los robots tienen un nombre, una cantidad de energía disponible y puntos de resistencia.

Existen tres tipos de robots:

Atacantes: utilizan energía para reducir la resistencia de otro robot.
Defensores: utilizan energía para aumentar temporalmente su propia protección.
Reparadores: utilizan energía para recuperar la resistencia de otro robot.

Cada robot tiene una especialización y características particulares que determinan la eficacia y el consumo de energía de sus acciones.

La competición debe permitir registrar robots de diferentes tipos y ejecutar sus acciones.

Ningún robot puede realizar una acción si no dispone de suficiente energía. Un robot queda fuera de combate cuando su resistencia llega a cero.

## 6. Sistema de reservas hoteleras

Un hotel dispone de habitaciones individuales, dobles y suites.

Todas las habitaciones están identificadas por un número y tienen una planta y un precio base por noche.

Las habitaciones individuales tienen una cama. Las dobles pueden alojar hasta dos personas y las suites disponen de servicios adicionales.

Las tarifas se calculan de la siguiente manera:

Individual: precio base por noche.
Doble: precio base más un suplemento de 15 € por noche.
Suite: precio base más un suplemento de 50 € por noche.

Los clientes pueden realizar reservas de habitaciones. Cada reserva registra un cliente, una habitación, una fecha de entrada y un número de noches.

El sistema debe calcular el coste de cada reserva y el importe total de todas las reservas registradas.

## 7. Sistema bancario

Un banco permite gestionar diferentes tipos de cuentas bancarias.

Todas las cuentas tienen un identificador, un titular y un saldo disponible.

El banco ofrece cuentas corrientes y cuentas de ahorro.

Las cuentas corrientes permiten retirar dinero incluso cuando el saldo es insuficiente, siempre que no se supere un descubierto máximo de 100 €. Cada retirada tiene una comisión fija de 2 €, que también se descuenta del saldo.

Las cuentas de ahorro no permiten dejar el saldo negativo, pero generan intereses sobre el dinero depositado. Cada cuenta de ahorro tiene asociado un porcentaje de interés.

El banco debe permitir realizar ingresos, retiradas y consultas de saldo.

También debe poder gestionar una colección de cuentas de diferentes tipos y ejecutar operaciones sobre ellas.

## 8. Plataforma de exámenes

Una plataforma educativa permite crear exámenes formados por diferentes tipos de preguntas.

Todas las preguntas contienen un enunciado, una puntuación máxima y la información necesaria para determinar su respuesta correcta.

La plataforma admite dos tipos de preguntas:

Tipo test: presentan cuatro opciones y solo una respuesta correcta.
Verdadero o falso: presentan una afirmación cuya respuesta es verdadera o falsa.

Un examen tiene un título y está formado por varias preguntas, que pueden ser de cualquier tipo.

Los estudiantes responden a las preguntas y el sistema corrige las respuestas automáticamente.

Una respuesta correcta obtiene la puntuación completa de la pregunta. Una respuesta incorrecta obtiene cero puntos.

El sistema debe poder corregir un examen completo y mostrar su puntuación final sin tener que tratar de forma especial cada tipo de pregunta.