package ficherostexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Eje02 {
	// Lee de un fichero y lo escribe en otro carácter a carácter.
	public static void main ( String argv[] )
	 throws IOException {

	 FileReader fr = new FileReader("datos.txt");
	 FileWriter fw = new FileWriter("copiadatos.txt");
	 
	 
	 int letrai;
	 System.out.println("Copiando datos:");
	 // Mientras no devuelva la lectura -1
	 letrai = fr.read();
	 char letra = (char) letrai;

	 while (letrai != -1) {
	 fw.write(letra);
	 System.out.print(".");
	 letrai = fr.read();
	 letra = (char) letrai;
	 }
	 System.out.println(" Fichero copiado.");
	 // Cierra el fichero
	 fr.close();
	 fw.close();
	 } 
}
