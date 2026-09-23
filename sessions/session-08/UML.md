# Diagramas UML — Sesión 08

## Ejemplos trabajados en clase

### 1) Dependencia — `Printer` y `Document`

```mermaid
classDiagram
    class Printer
    class Document
    Printer ..> Document : usa para imprimir
```

### 2) Asociación — `Biblioteca` y `Libro`

```mermaid
classDiagram
    class Biblioteca
    class Libro
    Biblioteca "1" --> "0..*" Libro : gestiona
```

### 3) Asociación — `Worker` y `Company`

```mermaid
classDiagram
    class Worker
    class Company
    Worker "0..*" --> "1" Company : trabaja en
```

### 4) Agregación — `Curso` y `Asignatura`

```mermaid
classDiagram
    class Curso
    class Asignatura
    Curso "1" o-- "1..*" Asignatura : incluye
```

### 5) Composición — `Chessboard` y `Cell`

```mermaid
classDiagram
    class Chessboard
    class Cell
    Chessboard "1" *-- "64" Cell : está formado por
```

### 6) Composición — `GameArea` y `Ball`

```mermaid
classDiagram
    class GameArea
    class Ball
    GameArea "1" *-- "2" Ball : contiene
```

### 7) Composición — `Libro` y `Pagina`

```mermaid
classDiagram
    class Libro
    class Pagina
    Libro "1" *-- "1..*" Pagina : está formado por
```

## Ejercicio 1

```mermaid
classDiagram
    class Empresa {
        +nif : String
        +nombreComercial : String
    }

    class NaveIndustrial {
        +telefono : String
    }

    class Direccion {
        +calle : String
        +numero : int
        +codigoPostal : String
        +provincia : String
    }

    class Area {
        +codigo : String
        +tipo : String
    }

    Empresa "1" *-- "1..*" NaveIndustrial : consta de
    NaveIndustrial "1" *-- "1" Direccion : ubicada en
    NaveIndustrial "1" *-- "1..*" Area : formada por
```
