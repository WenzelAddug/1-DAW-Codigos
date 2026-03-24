package ArrayList.Eje03;

import java.util.ArrayList;
import java.util.Iterator;

public class Eje03_ArrayList {
    public static void main(String[] args) {

        // Tamaño aleatorio entre 10 y 20
        int nelementos = (int)(Math.random() * 11 + 10);

        ArrayList<Integer> lista = new ArrayList<Integer>();

        // Rellenar la lista con valores aleatorios entre 0 y 100
        for (int i = 0; i < nelementos; i++) {
            lista.add((int)(Math.random() * 101));
        }

        // a) Mostrar contenido
        System.out.println("Contenido inicial: " + lista);

        // b) Calcular suma
        int suma = 0;
        for (int valor : lista) {
            suma += valor;
        }
        System.out.println("La suma total es: " + suma);

        // c) Borrar los números pares
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }

        System.out.println("Lista sin pares: " + lista);

        // d) Reemplazar divisibles por 3 con 0
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 3 == 0) {
                lista.set(i, 0);
            }
        }

        System.out.println("Lista reemplazando divisibles por 3 por 0: " + lista);

        // e) Insertar 555 antes de cada valor divisible por 5
        for (int i = 0; i < lista.size(); i++) {
            int valor = lista.get(i);
            if (valor != 0 && valor % 5 == 0) {
                lista.add(i, 555);
                i++; // saltar el 555 insertado
            }
        }

        System.out.println("Lista final insertando 555 antes de divisibles por 5: " + lista);
    }
}