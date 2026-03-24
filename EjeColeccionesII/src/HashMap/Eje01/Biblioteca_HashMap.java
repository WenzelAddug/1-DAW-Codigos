package HashMap.Eje01;

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class Biblioteca_HashMap {

    public static void main(String[] args) {

        HashMap<String, Libro> disponibles = new HashMap<String, Libro>();
        HashMap<String, Libro> prestados = new HashMap<String, Libro>();

        Scanner sc = new Scanner(System.in);

        // Rellenar los mapas con valores de prueba
        Libro nuevo = new Libro(19, "El Quijote", "Cervantes", Genero.NOVELA, 2012);

        disponibles.put(nuevo.titulo, nuevo);
        disponibles.put("El Buscón", new Libro(20, "El Buscón", "Quevedo", Genero.NOVELA, 1997));
        disponibles.put("Romeo y Julieta", new Libro(21, "Romeo y Julieta", "Shakespeare", Genero.TEATRO, 1997));
        disponibles.put("Mio Cid", new Libro(22, "Mio Cid", "Anónimo", Genero.POESIA, 1989));

        prestados.put("Harry Potter I", new Libro(30, "Harry Potter I", "J. K. Rowling", Genero.NOVELA, 1998));
        prestados.put("Guerra y Paz", new Libro(34, "Guerra y Paz", "León Tolstói", Genero.NOVELA, 1975));
        prestados.put("El Decamerón", new Libro(39, "El Decamerón", "Giovanni Boccaccio", Genero.CUENTOS, 1992));

        System.out.println("Libros disponibles:");
        verCatalogo(disponibles);

        System.out.println("Libros prestados:");
        verCatalogo(prestados);

        // Pedir datos al usuario y probar prestarLibro
        System.out.println("¿Qué libro desea?");
        String titulo = sc.nextLine();

        int resu = prestarLibro(titulo, prestados, disponibles);

        if (resu == 0) {
            System.out.println("El libro no está en el catálogo");
        } else if (resu == -1) {
            System.out.println("El libro está prestado");
        } else {
            System.out.println("Su préstamo ha sido anotado");
        }

        System.out.println("Libros disponibles:");
        verCatalogoOrdenado(disponibles);

        System.out.println("Libros prestados:");
        verCatalogoOrdenado(prestados);

        sc.close();
    }

    public static void verCatalogo(HashMap<String, Libro> mlibros) {
        int n = 1;
        for (Libro l : mlibros.values()) {
            System.out.println(n + "º : " + l);
            n++;
        }
    }

    // Los HashMap no se ordenan directamente, por eso usamos un TreeMap auxiliar
    public static void verCatalogoOrdenado(HashMap<String, Libro> mlibros) {
        TreeMap<String, Libro> mlibrosaux = new TreeMap<String, Libro>(mlibros);

        int n = 1;
        for (Libro l : mlibrosaux.values()) {
            System.out.println(n + "º : " + l);
            n++;
        }
    }

    /*
     * Devuelve:
     *  0 si no existe el libro en ninguno de los mapas
     *  1 si puede prestarlo
     * -1 si ya está prestado
     */
    public static int prestarLibro(String titulo, HashMap<String, Libro> mprestados,
                                   HashMap<String, Libro> mdisponibles) {

        Libro libroPrestado = mprestados.get(titulo);
        Libro libroDisponible = mdisponibles.get(titulo);

        if (libroPrestado == null && libroDisponible == null) {
            return 0;
        }

        if (libroPrestado != null) {
            return -1;
        }

        mdisponibles.remove(titulo);
        mprestados.put(titulo, libroDisponible);
        return 1;
    }
}