package HashMap.Eje03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {

        HashMap<String, String> diccionario = new HashMap<String, String>();
        final int NUMPALABRAS = 5;

        // Rellenar el diccionario
        diccionario.put("hola", "hello");
        diccionario.put("mesa", "table");
        diccionario.put("mientras", "while");
        diccionario.put("casa", "house");
        diccionario.put("sol", "sun");
        diccionario.put("luna", "moon");
        diccionario.put("ventana", "window");
        diccionario.put("lápiz", "pencil");
        diccionario.put("ratón", "mouse");
        diccionario.put("abrir", "open");
        diccionario.put("cerrar", "close");
        diccionario.put("comer", "eat");
        diccionario.put("correr", "run");
        diccionario.put("cantar", "sing");
        diccionario.put("leer", "read");
        diccionario.put("escribir", "write");
        diccionario.put("tamaño", "size");
        diccionario.put("pantalla", "screen");
        diccionario.put("blanco", "white");
        diccionario.put("árbol", "tree");

        ArrayList<String> seleccionadas = obtenerPalabras(diccionario, NUMPALABRAS);

        System.out.println("Indique cuál es la traducción al inglés de las siguientes palabras:");

        Scanner sc = new Scanner(System.in);
        int aciertos = 0;
        int fallos = 0;

        for (int i = 0; i < seleccionadas.size(); i++) {
            String palabraEsp = seleccionadas.get(i);
            System.out.print(palabraEsp + ": ");
            String respuesta = sc.nextLine();

            String correcta = diccionario.get(palabraEsp);

            if (correcta.equalsIgnoreCase(respuesta)) {
                System.out.println("Respuesta correcta.");
                aciertos++;
            } else {
                System.out.println("Error. La respuesta correcta es " + correcta);
                fallos++;
            }
        }

        System.out.println("Respuestas válidas: " + aciertos);
        System.out.println("Respuestas erróneas: " + fallos);

        sc.close();
    }

    /*
     * Devuelve una lista de tamaño indicado con palabras aleatorias
     * del diccionario, sin repetir.
     */
    private static ArrayList<String> obtenerPalabras(HashMap<String, String> diccionario, int num) {

        List<String> completa = new ArrayList<String>(diccionario.keySet());

        Collections.shuffle(completa);

        if (num > completa.size()) {
            num = completa.size();
        }

        return new ArrayList<String>(completa.subList(0, num));
    }
}