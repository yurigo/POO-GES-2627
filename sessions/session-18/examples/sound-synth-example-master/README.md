# sound-synth-example

Sintetizador de audio en Java que genera y reproduce diferentes tipos de ondas sonoras (seno, cuadrada, triángulo y diente de sierra) con frecuencia y duración configurables.

## Estructura del proyecto

```
sound-synth-example/
└── src/
    ├── Main.java         # Punto de entrada y demostración del sintetizador
    ├── SoundSynth.java   # Lógica de síntesis y reproducción de audio
    └── WaveType.java     # Enumeración de tipos de onda disponibles
```

## Componentes

### `WaveType.java` — Tipos de onda

Enumeración que define los cuatro tipos de onda que el sintetizador puede generar:

| Valor      | Descripción                                                                 |
|------------|-----------------------------------------------------------------------------|
| `SINE`     | Onda sinusoidal — oscilación suave y continua                               |
| `SQUARE`   | Onda cuadrada — alterna bruscamente entre +1 y −1 cada medio ciclo          |
| `TRIANGLE` | Onda triangular — sube y baja linealmente formando picos                    |
| `SAWTOOTH` | Onda diente de sierra — sube linealmente y cae de golpe al inicio del ciclo |

---

### `SoundSynth.java` — Sintetizador de audio

Clase principal que sintetiza y reproduce las ondas usando la API de sonido de Java (`javax.sound.sampled`).

**Método principal:**

```java
public void makeSound(WaveType type, int numberOfTimesFullFuncPerSec, int durationMs)
        throws LineUnavailableException
```

| Parámetro                    | Tipo       | Descripción                                         |
|------------------------------|------------|-----------------------------------------------------|
| `type`                       | `WaveType` | Tipo de onda a generar                              |
| `numberOfTimesFullFuncPerSec`| `int`      | Frecuencia en Hz (ciclos por segundo)               |
| `durationMs`                 | `int`      | Duración del sonido en milisegundos                 |

**Detalles técnicos:**

- **Frecuencia de muestreo:** 44 100 Hz (calidad CD)
- **Formato de audio:** PCM con signo, 16 bits, mono
- **Rango de amplitud:** −32 767 a 32 767 (entero de 16 bits con signo)

**Fórmulas de cada onda (siendo `phase` la posición en el ciclo, de 0.0 a 1.0):**

| Onda       | Fórmula                             |
|------------|-------------------------------------|
| SINE       | `Math.sin(2 * π * phase)`           |
| SQUARE     | `phase < 0.5 ? 1.0 : -1.0`         |
| TRIANGLE   | `4 * Math.abs(phase - 0.5) - 1` (distancia al punto medio escalada para obtener rango −1 a 1) |
| SAWTOOTH   | `2 * phase - 1`                     |

El valor resultante se convierte a un entero de 16 bits y se escribe byte a byte en el `SourceDataLine` del sistema de audio.

---

### `Main.java` — Punto de entrada

Clase de demostración que instancia `SoundSynth` y reproduce una secuencia de 16 sonidos: cuatro por cada tipo de onda, variando frecuencia y duración:

| # | Tipo      | Frecuencia | Duración |
|---|-----------|-----------|---------|
| 1 | SINE      | 440 Hz    | 1000 ms |
| 2 | SINE      | 440 Hz    | 200 ms  |
| 3 | SINE      | 700 Hz    | 500 ms  |
| 4 | SINE      | 440 Hz    | 1000 ms |
| … | SQUARE, TRIANGLE, SAWTOOTH | (mismas combinaciones) | … |

## Compilación y ejecución

Requiere **Java 8 o superior** (no tiene dependencias externas; usa únicamente la API estándar del JDK).

```bash
# Compilar
javac -d out src/WaveType.java src/SoundSynth.java src/Main.java

# Ejecutar
java -cp out Main
```
