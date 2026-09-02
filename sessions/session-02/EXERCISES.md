# Actividades

## Modelar un sonido

Queremos representar un sonido mediante una clase llamada Sound.

### 1. Abstracción
### 2. UML
### 3. Código

---


## Modelar una calculadora de IMC

Queremos representar una calculadora de IMC

---

## Modelar un pokemon

Queremos representar un sonido mediante una clase llamada Pokemon.

---

## Modelar una señal cardíaca

Un dispositivo médico registra información básica de una señal cardíaca.

Se proporciona el siguiente modelo UML:

```UML
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

El significado de los atributos es:

- `heartRate`: pulsaciones por minuto.
- `duration`: duración de la medida en segundos.
- `quality`: calidad de la señal entre 0.0 y 1.0.

Los métodos deben comportarse de la siguiente forma:

`showInfo()`

Muestra por pantalla los valores almacenados.

`isTachycardia()`

Devuelve true si la frecuencia cardíaca es superior a 100 pulsaciones por minuto.

`isValid()`

Devuelve true si la calidad de la señal es igual o superior a 0.7.

### Parte A

Implementa la clase HeartSignal en Java respetando el diagrama UML.

### Parte B

Crea un objeto:

HeartSignal signal = new HeartSignal();

y asigna:

```java
heartRate = 120
duration = 15
quality = 0.85
```

Después:

1. muestra su información;
2. comprueba si existe taquicardia;
3. comprueba si la señal es válida.

### Parte C

Explica qué representa cada elemento de esta expresión:

```java
signal.isTachycardia();
```

`signal`
`.`
`isTachycardia()`

---

## Diseña tu propio sensor médico

Un hospital está incorporando distintos dispositivos de monitorización.

Tu tarea consiste en elegir UN dispositivo o señal relacionada con salud y diseñar una clase Java que permita representarlo.

Puedes escoger, por ejemplo:

- termómetro;
- pulsioxímetro;
- glucómetro;
- tensiómetro;
- electrocardiograma;
- señal respiratoria;
- sonido respiratorio;
- sensor de movimiento;
- báscula;
- o cualquier otro.

### Parte 1 Abstracción

Describe brevemente qué representa tu clase.
Selecciona entre 3 y 5 atributos que consideres esenciales.
Para cada atributo explica en una frase por qué es relevante.

### Parte 2 Comportamiento

Define al menos 3 métodos.

Como mínimo:
- uno debe mostrar información;
- uno debe devolver un boolean;
- uno debe realizar algún cálculo utilizando atributos del objeto.

### Parte 3 UML

Representa la clase mediante UML indicando:

- nombre de la clase;
- atributos y tipos;
- métodos;
- parámetros cuando sean necesarios;
- tipo de retorno.

### Parte 4 Java

Crea al menos dos objetos diferentes y demuestra que tienen estados diferentes.

Por ejemplo:

```java
TemperatureSensor sensor1 = new TemperatureSensor();
TemperatureSensor sensor2 = new TemperatureSensor();
```

Modifica sus atributos y llama a varios métodos.



