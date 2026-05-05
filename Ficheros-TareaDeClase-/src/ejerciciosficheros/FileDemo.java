package ejerciciosficheros;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class FileDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Indica el nombre de un fichero o directorio: ");
        String nombre = sc.nextLine();

        File fichero = new File(nombre);

        if (fichero.exists()) {
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Ruta completa: " + fichero.getAbsolutePath());
            System.out.println("Tamaño: " + fichero.length() + " bytes");
            System.out.println("Ultima modificacion: " + new Date(fichero.lastModified()));

            if (fichero.isFile()) {
                System.out.println("Es un fichero normal");
            } else if (fichero.isDirectory()) {
                System.out.println("Es un directorio");

                String ficheros[] = fichero.list();

                for (int i = 0; i < ficheros.length; i++) {
                    System.out.println(ficheros[i]);
                }
            }

        } else {
            System.out.println("El fichero no existe");
        }

        sc.close();
    }
}