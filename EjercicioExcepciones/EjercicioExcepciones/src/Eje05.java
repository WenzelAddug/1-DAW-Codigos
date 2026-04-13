import java.util.InputMismatchException;
import java.util.Scanner;

public class Eje05 {

    public static void main(String argv[]) {

        try {
            metodoQueFalla();

        } catch (InputMismatchException e) {
            System.out.println("Error: debes introducir un número entero");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: la posición indicada está fuera del array");

        } catch (NullPointerException e) {
            System.out.println("Error: en esa posición no hay ningún objeto Cosa");

        } catch (ExceptionCero e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Este metodo puede generar muchas excepciones
     */
    static void metodoQueFalla() {

        Cosa tcosas[] = new Cosa[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un valor:");
        int num = sc.nextInt();

        tcosas[0] = new Cosa(num++);
        tcosas[2] = new Cosa(num++);
        tcosas[4] = new Cosa(num++);

        System.out.println("Introduce una posición:");
        int pos = sc.nextInt();

        System.out.println("El valor en la posicion " + pos +
                " es " + tcosas[pos].getValor());
    }
}

class Cosa {
    private int valor;

    Cosa(int valor) {
        if (valor == 0)
            throw new ExceptionCero();
        this.valor = valor;
    }

    int getValor() {
        return valor;
    }
}

class ExceptionCero extends RuntimeException {

    ExceptionCero() {
        super("No me gusta el valor 0");
    }
}