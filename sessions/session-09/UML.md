# Diagramas UML — Sesión 09

## Ejercicio 1 — Centro médico

```mermaid
classDiagram
    class CentroMedico {
        +codigo : String
        +nombre : String
    }

    class Consulta {
        +numero : int
        +planta : int
    }

    class Camilla {
        +numeroSerie : String
    }

    CentroMedico "1" -- "1..*" Consulta : dispone de
    Consulta "1" *-- "1" Camilla : contiene
```

## Ejercicio 2 — Laboratorio

```mermaid
classDiagram
    class Equipo {
        +codigo : String
        +modelo : String
        +fechaUltimaRevision : Date
    }

    class Muestra {
        +identificador : String
        +fechaExtraccion : Date
        +volumen : double
    }

    class Analisis

    class Resultado {
        +valor : double
        +unidadMedida : String
        +fecha : Date
    }

    Equipo "1" -- "0..*" Analisis : realiza
    Muestra "1" -- "0..*" Analisis : se analiza en
    Analisis "1" -- "1" Resultado : genera
```

## Ejercicio 3 — Festival de música

```mermaid
classDiagram
    class Festival {
        +nombre : String
        +ciudad : String
        +fechaInicio : Date
    }

    class Escenario {
        +nombre : String
        +capacidadMaxima : int
    }

    class GrupoMusical {
        +nombre : String
        +paisOrigen : String
    }

    class Actuacion {
        +horaInicio : String
        +duracion : int
    }

    Festival "1" -- "1..*" Escenario : organiza
    Festival "1" -- "0..*" Actuacion : programa
    Escenario "1" -- "0..*" Actuacion : acoge
    GrupoMusical "1" -- "0..*" Actuacion : realiza
```

## Ejercicio 4 — Plataforma de videojuegos

```mermaid
classDiagram
    class Plataforma

    class Videojuego {
        +identificador : String
        +titulo : String
        +precio : double
        +fechaLanzamiento : Date
    }

    class Usuario {
        +nombreUsuario : String
        +correoElectronico : String
    }

    class Compra {
        +fecha : Date
        +precio : double
    }

    Plataforma "1" -- "0..*" Videojuego : incluye en el catalogo
    Usuario "1" -- "0..*" Compra : realiza
    Videojuego "1" -- "0..*" Compra : corresponde a
    Usuario "0..*" -- "0..*" Videojuego : incluye en lista de deseos
```

## Ejercicio 6 — Compañía aérea

```mermaid
classDiagram
    class CompaniaAerea

    class Avion {
        +matricula : String
        +modelo : String
        +maximoPasajeros : int
    }

    class Vuelo {
        +codigo : String
        +fecha : Date
        +horaSalida : String
        +horaEstimadaLlegada : String
    }

    class Aeropuerto {
        +codigoInternacional : String
        +nombre : String
        +ciudad : String
    }

    class Pasajero

    class Reserva {
        +codigoLocalizador : String
        +fecha : Date
        +numeroAsiento : int
    }

    CompaniaAerea "1" -- "0..*" Avion : gestiona
    CompaniaAerea "1" -- "0..*" Vuelo : ofrece
    Avion "1" -- "0..*" Vuelo : utiliza
    Vuelo "0..*" --> "1" Aeropuerto : origen
    Vuelo "0..*" --> "1" Aeropuerto : destino
    Pasajero "1" -- "0..*" Reserva : realiza
    Vuelo "1" -- "0..*" Reserva : recibe
```
