package ficherostexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Eje03 {
	public static void main(String[] args) throws FileNotFoundException {
		
		File fi = new File("datos.txt");
		File fs = new File("datosmas1.txt");
		Scanner sc = new Scanner(fi);
		
		System.out.println("Leyendo un entero....");
		PrintWriter pw = new PrintWriter(fs);
		int num;
		while (sc.hasNextInt() ) {
			num = sc.nextInt();
			num++;
			pw.println(num);
			
		}
			pw.close();	
	}
}