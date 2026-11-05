# Ejercicio Excepciones

Ejercicios de control de errores con excepciones en Java. El proyecto de Eclipse está en `EjercicioExcepciones/`.

| Clase | Qué hace |
|---|---|
| `Eje01` | Calculadora básica que controla `InputMismatchException` (no meter un número) y `ArithmeticException` (dividir entre 0) |
| `Eje02` | Calculadora con límite: si el resultado pasa de 99999 lanza `DesbordamientoException` |
| `Eje03` | Genera números aleatorios del 1 al 10 y si sale el 6 tres veces seguidas lanza `DevilException` |
| `Eje04` | Menú de una pescadería: coger número, dejar número y ver clientes en espera |
| `Eje05` | Método que puede lanzar muchas excepciones distintas y se captura cada una con su mensaje |

## Excepciones propias
- `DesbordamientoException` -> el resultado supera el límite
- `DevilException` -> sale tres veces seguidas el 6
- `EstoySaturaoException` -> la pescadería no puede dar más números
- `NumerosPescaderia` -> clase que lleva los números de turno (la usa `Eje04`)
