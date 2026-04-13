import java.util.Scanner;

public class Eje04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumerosPescaderia pescaderia = new NumerosPescaderia(3);
        int opcion;

        do {
            System.out.println("\n1. Coger número");
            System.out.println("2. Dejar número");
            System.out.println("3. Ver clientes en espera");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        int turno = pescaderia.cogerNumero();
                        System.out.println("Tu turno es el número " + turno);
                    } catch (EstoySaturaoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    pescaderia.dejarNumero();
                    System.out.println("Se ha atendido a un cliente");
                    break;

                case 3:
                    System.out.println("Clientes esperando: " + pescaderia.getContador());
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}