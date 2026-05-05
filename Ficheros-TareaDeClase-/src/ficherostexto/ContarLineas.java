package ficherostexto;
import java.io.File;
import java.util.Scanner;

public class ContarLineas {

    public static void main(String[] args) throws Exception {

        // Comprobar argumentos
        if (args.length != 1) {
            System.out.println("Error hay que indicar el directorio");
            return;
        }

        java.io.File f = new java.io.File(args[0]);

        // Comprobar directorio
        if (!f.isDirectory() || !f.canRead()) {
            System.out.println("No se puede leer el directorio");
            return;
        }

        // Obtener lista de ficheros
        int total = 0;
        String ficheros[] = f.list();
        for (String fichero : ficheros) {
            if (fichero.endsWith(".java")) {
                int contlineas = contarLineasFichero(args[0], fichero);
                System.out.println(fichero + " " + contlineas);
                total += contlineas;
            }
        }

        System.out.println("TOTAL LINEAS " + total);
    }

    // 🔥 Método contarLineasFichero
    public static int contarLineasFichero(String ruta, String fichero) throws Exception {
        java.io.File archivo = new java.io.File(ruta, fichero);
        java.util.Scanner sc = new java.util.Scanner(archivo);
        int contador = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contador++;
        }

        sc.close();

        return contador;
    }
}