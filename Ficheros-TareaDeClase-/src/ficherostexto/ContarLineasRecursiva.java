package ficherostexto;

import java.io.File;
import java.util.Scanner;

public class ContarLineasRecursiva {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Error hay que indicar el directorio");
            return;
        }

        File f = new File(args[0]);

        if (!f.isDirectory() || !f.canRead()) {
            System.out.println("No se puede leer el directorio");
            return;
        }

        int total = infoDirectorio(args[0]);

        System.out.println("TOTAL LINEAS " + total);
    }

    public static int contarLineasFichero(String nombrefichero) throws Exception {

        File archivo = new File(nombrefichero);
        Scanner sc = new Scanner(archivo);

        int contador = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contador++;
        }

        sc.close();

        return contador;
    }

    // Metodo Recursivo
    private static int infoDirectorio(String nombredir) throws Exception {

        int contador = 0;

        File fdir = new File(nombredir);
        String ficheros[] = fdir.list();

        for (String fichero : ficheros) {

            File fentrada = new File(nombredir + "/" + fichero);

            if (fentrada.isFile() && fichero.endsWith(".java")) {

                int lineas = contarLineasFichero(nombredir + "/" + fichero);

                System.out.println(fichero + " " + lineas);

                contador += lineas;

            } else if (fentrada.isDirectory()) {

                
                contador += infoDirectorio(nombredir + "/" + fichero);
            }
        }

        return contador;
    }
}