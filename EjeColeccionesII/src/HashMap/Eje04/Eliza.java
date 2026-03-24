package HashMap.Eje04;

import java.util.HashMap;
import java.util.Scanner;

public class Eliza {

    public static void main(String[] args) {

        HashMap<String, String> respuestas = new HashMap<String, String>();

        // Palabras normales
        respuestas.put("hola", "Hola, ¿qué tal?");
        respuestas.put("encantado", "Encantado de conocerte yo también");
        respuestas.put("adiós", "Adiós, espero volverte a ver pronto");
        respuestas.put("adios", "Adiós, espero volverte a ver pronto");
        respuestas.put("hora", "Lo siento, no llevo reloj");
        respuestas.put("nombre", "Mi nombre es Eliza");

        // Insultos (mejora)
        respuestas.put("tonto", "No hace falta faltar al respeto 😡");
        respuestas.put("idiota", "Por favor, hablemos con respeto");
        respuestas.put("imbecil", "No me gusta que me insulten");
        respuestas.put("estúpido", "Intenta expresarte mejor");
        respuestas.put("feo", "No es muy amable decir eso");
        respuestas.put("callate", "No tienes que ser grosero");

        Scanner sc = new Scanner(System.in);

        System.out.println("ELIZA iniciada. Escribe una frase:");

        while (true) {
            System.out.print("> ");
            String frase = sc.nextLine().toLowerCase();

            boolean encontrada = false;

            for (String clave : respuestas.keySet()) {
                if (frase.contains(clave)) {
                    System.out.println(respuestas.get(clave));
                    encontrada = true;

                    // salir si dice adiós
                    if (clave.equals("adiós") || clave.equals("adios")) {
                        sc.close();
                        return;
                    }

                    break;
                }
            }

            if (!encontrada) {
                System.out.println("Lo siento, no te comprendo");
            }
        }
    }
}