package ejerciciosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File05 {

    public static void main(String[] args) throws FileNotFoundException {

        File fr = new File("datos.txt");
        File fw = new File("resu.txt");

        Scanner sc = new Scanner(fr);
        PrintWriter pw = new PrintWriter(fw);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            pw.println(linea);
        }

        System.out.println("Fichero copiado linea a linea");

        pw.close();
        sc.close();
    }
}