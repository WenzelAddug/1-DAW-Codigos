package ejerciciosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File03 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero: ");
        String nombre = teclado.nextLine();

        File f = new File(nombre);
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            System.out.println(linea);
        }

        sc.close();
        teclado.close();
    }
}