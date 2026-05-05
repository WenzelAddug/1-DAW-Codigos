package ficherostexto;

import java.io.File;
import java.util.Scanner;
import java.util.Date;

public class Ejemplo01 {
	public static void main(String argv[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Indique le nombre de un fichero o directorio:");
		String nombre = sc.nextLine();
		File fichero = new File(nombre);
		
		if (fichero.exists()) {
			System.out.println("Nombre: " + fichero.getName());
			System.out.println("- Ruta completa: " + fichero.getAbsolutePath());
			System.out.println("- Tamaño: " + fichero.length() + " bytes");
			System.out.println("- Última modificación: " + new Date(fichero.lastModified()));
			if (fichero.isFile()) {
				System.out.println("- Fichero normal");
			} else if (fichero.isDirectory()) {
				System.out.println("- Directorio");
				String ficheros[] = fichero.list();
				for (int i = 0; i < ficheros.length; i++) {
					System.out.println("\t" + ficheros[i]);
				}
			}

		} else {
			System.out.println("El fichero '" + nombre + "' no existe");
		}

	}

}
