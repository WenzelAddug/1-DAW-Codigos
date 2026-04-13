import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    static ArrayList<String> tpalabros =
        new ArrayList<String>(Arrays.asList("caca","culo","pedo","pis"));

    public static void main(String argv[]) {

        Scanner sc = new Scanner(System.in);
        String linea = "";

        System.out.println("Introduce tus mensajes, o pulsa . Para terminar:");

        do {
            try {
                linea = leerLineaOK(sc);

                if (!linea.equals(".")) {
                    System.out.println("OK");
                }

            } catch (BurradasNOException e) {
                System.out.println(e.getMessage());
            }

        } while (!linea.equals("."));

        System.out.println("Fin de programa.");
    }

    /**
     * Lee una línea y comprueba palabras prohibidas
     * @param sc Scanner
     * @return línea leída
     * @throws BurradasNOException si hay palabra prohibida
     */
    public static String leerLineaOK(Scanner sc) throws BurradasNOException {

        String linea = sc.nextLine().toLowerCase();

        for (String palabra : tpalabros) {
            if (linea.contains(palabra)) {
                // Lanzar excepción (CLAVE DEL EJERCICIO)
                throw new BurradasNOException(palabra);
            }
        }

        return linea;
    }
}