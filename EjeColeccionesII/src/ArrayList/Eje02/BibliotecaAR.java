package ArrayList.Eje02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Test de gestion de la biblioteca
 */
public class BibliotecaAR {

    public static void main(String[] args) {

        List<Libro> disponibles = new ArrayList<Libro>();
        List<Libro> prestados = new ArrayList<Libro>();
        Scanner sc = new Scanner(System.in);

        // Rellenar listas con datos de prueba
        Libro nuevo = new Libro(19, "El Quijote", "Cervantes", Genero.NOVELA, 2012);

        disponibles.add(nuevo);
        disponibles.add(new Libro(20, "El Buscón", "Quevedo", Genero.NOVELA, 1997));
        disponibles.add(new Libro(21, "Romeo y Julieta", "Shakespeare", Genero.TEATRO, 1997));
        disponibles.add(new Libro(22, "Mio Cid", "Anónimo", Genero.POESIA, 1989));

        prestados.add(new Libro(30, "Harry Potter I", "J. K. Rowling", Genero.NOVELA, 1998));
        prestados.add(new Libro(34, "Guerra y Paz", "León Tolstói", Genero.NOVELA, 1975));
        prestados.add(new Libro(39, "El Decamerón", "Giovanni Boccaccio", Genero.CUENTOS, 1992));

        // Mostrar listas
        System.out.println("Libros disponibles:");
        mostrarLibros(disponibles);

        System.out.println("\nLibros prestados:");
        mostrarLibros(prestados);

        // Pedir libro al usuario
        System.out.println("\nPréstamo de libros:");
        System.out.print("¿Qué libro desea?: ");
        String titulo = sc.nextLine();

        int resu = prestarLibro(titulo, prestados, disponibles);

        switch (resu) {
            case 0:
                System.out.println("El libro no está en el catálogo");
                break;
            case -1:
                System.out.println("El libro está prestado");
                break;
            case 1:
                System.out.println("Su préstamo ha sido anotado");
                break;
        }

        // Mostrar listas actualizadas
        System.out.println("\nLibros disponibles:");
        mostrarLibros(disponibles);

        System.out.println("\nLibros prestados:");
        mostrarLibros(prestados);

        sc.close();
    }

    /*
     * Realiza el préstamo pasando un libro de la lista de disponibles
     * a la lista de prestados.
     *
     * Devuelve:
     *  0 si no existe el libro en ninguna de las listas
     *  1 si puede prestarlo
     * -1 si ya está prestado
     */
    public static int prestarLibro(String titulo, List<Libro> prestados, List<Libro> disponibles) {

        Libro libroPrestado = buscarLibro(prestados, titulo);
        Libro libroDisponible = buscarLibro(disponibles, titulo);

        if (libroPrestado == null && libroDisponible == null) {
            return 0;
        }

        if (libroPrestado != null) {
            return -1;
        }

        disponibles.remove(libroDisponible);
        prestados.add(libroDisponible);
        return 1;
    }

    public static Libro buscarLibro(List<Libro> listaLibros, String titulo) {
        Libro resu = null;

        for (Libro l : listaLibros) {
            if (l.titulo.equalsIgnoreCase(titulo)) {
                resu = l;
                break;
            }
        }

        return resu;
    }

    public static void mostrarLibros(List<Libro> listaLibros) {
        for (Libro l : listaLibros) {
            System.out.println(l);
        }
    }
}