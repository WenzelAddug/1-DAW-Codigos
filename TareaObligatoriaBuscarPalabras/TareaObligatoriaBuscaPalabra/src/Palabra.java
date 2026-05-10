import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * BuscarPalabra - Comando que busca una palabra en un fichero de texto.
 *
 * Argumentos:
 *   args[0] -> palabra a buscar
 *   args[1] -> nombre del fichero de texto
 *
 * Salida:
 *   - Por cada línea donde aparece la palabra: nº de línea y contenido.
 *   - Al final: número total de líneas donde aparece.
 */
public class Palabra{

    public static void main(String[] args) {

        // 1) Comprobar el número de argumentos
        if (args.length != 2) {
            System.out.println("Error: número de argumentos incorrecto.");
            System.out.println("Uso: java BuscarPalabra <palabra> <nombre_fichero>");
            return;
        }

        String palabra = args[0];
        String nombreFichero = args[1];

        // 2) Comprobar que el fichero existe y se puede leer (clase File)
        File fichero = new File(nombreFichero);

        if (!fichero.exists()) {
            System.out.println("El fichero '" + nombreFichero + "' no existe.");
            return;
        }
        if (!fichero.canRead()) {
            System.out.println("El fichero '" + nombreFichero + "' no se puede leer.");
            return;
        }

        // 3) Leer el fichero línea a línea y buscar la palabra
        //    Usamos try-with-resources para que el Scanner se cierre solo.
        int numLinea = 0;
        int totalLineas = 0;

        try (Scanner sc = new Scanner(fichero)) {

            while (sc.hasNextLine()) {
                numLinea++;
                String linea = sc.nextLine();

                if (linea.contains(palabra)) {
                    System.out.println("Línea " + numLinea + ": " + linea);
                    totalLineas++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero " + nombreFichero);
            return;
        } catch (IOException e) {
            System.out.println("Error de lectura " + e);
            return;
        }

        // 4) Mostrar el total al final
        System.out.println();
        System.out.println("Total de líneas donde aparece '" + palabra
                           + "': " + totalLineas);
    }
}