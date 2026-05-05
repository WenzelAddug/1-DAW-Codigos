package ejerciciosficheros;

import java.io.FileReader;
import java.io.IOException;

public class File00 {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("datos.txt");

        int letrai;

        letrai = fr.read();

        while (letrai != -1) {
            char letra = (char) letrai;
            System.out.print(letra);
            letrai = fr.read();
        }

        fr.close();
    }
}