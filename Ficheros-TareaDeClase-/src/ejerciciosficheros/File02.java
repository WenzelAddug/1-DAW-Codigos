package ejerciciosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File02 {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File(args[0]);
        Scanner sc = new Scanner(f);

        int lineas = 0;
        int caracteres = 0;

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            System.out.println(linea);

            lineas++;
            caracteres = caracteres + linea.length();
        }

        System.out.println("Numero de lineas: " + lineas);
        System.out.println("Numero de caracteres: " + caracteres);

        sc.close();
    }
}