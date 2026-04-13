/**
 * Excepción para lenguaje obsceno
 */
public class BurradasNOException extends Exception {

    /**
     * Constructor que recibe la palabra prohibida
     * @param palabra palabra que provoca la excepción
     */
    public BurradasNOException(String palabra) {
        super("Error no se permite lenguaje obsceno: " + palabra);
    }
}