package ejerciciosficheros;

import java.io.FileReader;
import java.io.IOException;

public class File01 {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);

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