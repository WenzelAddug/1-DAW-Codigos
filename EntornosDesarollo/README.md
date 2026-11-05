# Entornos de Desarrollo - Pruebas con JUnit

Ejercicio de **pruebas unitarias** de la asignatura de Entornos de Desarrollo.

- `Reloj.java` -> clase reloj que guarda la hora en segundos, la muestra en formato 24 h o 12 h (am/pm) y tiene `tictac()` para sumar un segundo.
- `RelojTest.java` -> pruebas con JUnit de la clase `Reloj`:
  - mostrar la hora en formato 24 h (con ceros y hora normal)
  - mostrar en formato 12 h por la mañana y por la tarde
  - cambiar de formato y volver a 24 h
  - que `tictac()` sume un segundo y cambie bien de minuto y de hora

Para ejecutar las pruebas: botón derecho en `RelojTest.java` > `Run As > JUnit Test`.
