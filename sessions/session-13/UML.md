# Diagramas UML — Sesión 13

## Ejercicio 1 — Sistema de notificaciones

La plataforma mantiene notificaciones pendientes y las envía mediante el método
polimórfico `enviar()`. Cada tipo concreto adapta ese método al canal utilizado.

```mermaid
classDiagram
    class Plataforma {
        +registrarNotificacion(notificacion : Notificacion) void
        +enviarNotificacionesPendientes() void
    }

    class Notificacion {
        -identificador : String
        -destinatario : String
        -mensaje : String
        -fecha : Date
        +enviar() void
    }

    class Correo {
        -asunto : String
        +enviar() void
    }

    class SMS {
        +enviar() void
    }

    class Push {
        -titulo : String
        -nombreApp : String
        +enviar() void
    }

    Plataforma "1" --> "0..*" Notificacion : gestiona
    Notificacion <|-- Correo
    Notificacion <|-- SMS
    Notificacion <|-- Push
```

El mensaje de un SMS no puede superar los 160 caracteres. `Plataforma` recorre
las notificaciones pendientes y llama a `enviar()` sin necesitar conocer su
canal concreto.

## Ejercicio 2 — Empresa de paquetería

`Envio` reúne los datos comunes y el cálculo de precio. Las modalidades
configuran sus tarifas; el envío internacional añade la distancia al cálculo.
La empresa gestiona envíos de cualquier modalidad y puede sumar sus precios.

```mermaid
classDiagram
    class EmpresaMensajeria {
        +registrarEnvio(envio : Envio) void
        +calcularFacturacionTotal() double
        +mostrarResumenEnvios() void
    }

    class Envio {
        -codigo : String
        -destinatario : String
        -pesoKg : double
        -fechaCreacion : Date
        -costeBase : double
        -costeKg : double
        +calcularPrecio() double
        +mostrarResumen() String
    }

    class Estandar

    class Urgente

    class Internacional {
        -distanciaKm : double
        +calcularPrecio() double
    }

    EmpresaMensajeria "1" --> "0..*" Envio : registra
    Envio <|-- Estandar
    Envio <|-- Urgente
    Envio <|-- Internacional
```

Las tarifas son:

- Estándar: `3 + 0,50 × pesoKg`.
- Urgente: `8 + 1,20 × pesoKg`.
- Internacional: `10 + 2 × pesoKg + 0,01 × distanciaKm`.

El diagrama describe el modelo completo del ejercicio. El código Java del
proyecto `envios-ejercicio` solo contiene una parte de su implementación.
