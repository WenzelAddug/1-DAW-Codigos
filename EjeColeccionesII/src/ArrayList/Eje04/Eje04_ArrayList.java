package ArrayList.Eje04;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

public class Eje04_ArrayList {
    public static void main(String[] args) {

        final int NELEMENTOS = 20;

        ArrayList<Integer> lista = new ArrayList<Integer>();

        // Generar valores aleatorios (0 - 100)
        for (int i = 0; i < NELEMENTOS; i++) {
            lista.add((int)(Math.random() * 101));
        }

        // a) Mostrar lista original
        System.out.println("Lista generada: " + lista);

        // Ordenar lista
        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);

        // b) Pasar a TreeSet (elimina repetidos y ordena)
        Set<Integer> listaSinRepes = new TreeSet<Integer>(lista);

        // Mostrar resultado
        System.out.println("Lista sin repetidos (TreeSet): " + listaSinRepes);
    }
}