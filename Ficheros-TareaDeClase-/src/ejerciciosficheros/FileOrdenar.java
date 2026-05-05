package ejerciciosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileOrdenar {

    public static void main(String[] args) throws FileNotFoundException {

        File fr = new File("datos.txt");
        File fw = new File("datosord.txt");

        Scanner sc = new Scanner(fr);
        PrintWriter pw = new PrintWriter(fw);

        ArrayList<String> lista = new ArrayList<String>();

        while (sc.hasNextLine()) {
            lista.add(sc.nextLine());
        }

        Collections.sort(lista);

        for (String linea : lista) {
            pw.println(linea);
        }

        System.out.println("Fichero ordenado creado: datosord.txt");
        
        sc.close();
        pw.close();
    }
}