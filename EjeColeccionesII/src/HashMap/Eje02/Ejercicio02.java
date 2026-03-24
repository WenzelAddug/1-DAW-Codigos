package HashMap.Eje02;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {

        HashMap<String, String> usuarios = new HashMap<String, String>();

        // Datos de usuarios (usuario -> contraseña)
        usuarios.put("admin", "admin");
        usuarios.put("maria", "1234");
        usuarios.put("root", "root");

        final int MAX_INTENTOS = 3;
        int intentos = 0;
        boolean acceso = false;

        Scanner sc = new Scanner(System.in);

        while (intentos < MAX_INTENTOS && !acceso) {

            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            String clave = sc.nextLine();

            // Comprobación
            String contraseñaGuardada = usuarios.get(usuario);

            if (contraseñaGuardada != null && contraseñaGuardada.equals(clave)) {
                acceso = true;
            } else {
                System.out.println("Datos incorrectos");
            }

            intentos++;
        }

        if (acceso) {
            System.out.println("Ha accedido al área restringida");
        } else {
            System.out.println("Lo siento, no tiene acceso al área restringida");
        }

        sc.close();
    }
}