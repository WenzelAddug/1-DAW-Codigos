package ejerciciosficheros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File04 {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("datos.txt");
        FileWriter fw = new FileWriter("resu.txt");

        int letrai = fr.read();

        while (letrai != -1) {
            char letra = (char) letrai;
            fw.write(letra);
            letrai = fr.read();
        }

        System.out.println("Fichero copiado caracter a caracter");

        fr.close();
        fw.close();
    }
}