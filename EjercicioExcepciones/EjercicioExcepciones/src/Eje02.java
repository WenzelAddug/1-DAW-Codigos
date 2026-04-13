import java.util.InputMismatchException;
import java.util.Scanner;

public class Eje02 {

    public static final int LIMITE = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continuar;
        int num1, num2, resu;
        char operador;

        do {
            try {
                System.out.print("1º Valor: ");
                num1 = leerNumero(sc);

                System.out.print("2º Valor: ");
                num2 = leerNumero(sc);

                System.out.print("Introduce el operador [+-*/]: ");
                operador = leerOperador(sc);

                resu = operar(operador, num1, num2);
                comprobarRango(resu);

                System.out.println("Resultado = " + resu);

            } catch (DesbordamientoException e) {
                System.out.println("Error de desbordamiento: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: división entre 0");
            }

            System.out.print("¿Desea continuar? (S/N): ");
            continuar = sc.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');

        System.out.println("- Fin del programa -");
        sc.close();
    }

    static int leerNumero(Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = sc.nextInt();
                comprobarRango(numero);
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.print("Error: introduce un número entero. Inténtalo otra vez: ");
                sc.nextLine();
            } catch (DesbordamientoException e) {
                System.out.print("Error: " + e.getMessage() + ". Inténtalo otra vez: ");
            }
        } while (!correcto);

        return numero;
    }

    static char leerOperador(Scanner sc) {
        char letra;

        do {
            letra = sc.next().charAt(0);

            if (letra != '+' && letra != '-' && letra != '*' && letra != '/') {
                System.out.print("Operador incorrecto. Introduce [+-*/]: ");
            }

        } while (letra != '+' && letra != '-' && letra != '*' && letra != '/');

        return letra;
    }

    static int operar(char letra, int num1, int num2) {
        int resu = 0;

        switch (letra) {
            case '+':
                resu = num1 + num2;
                break;
            case '-':
                resu = num1 - num2;
                break;
            case '*':
                resu = num1 * num2;
                break;
            case '/':
                resu = num1 / num2;
                break;
        }

        return resu;
    }

    static void comprobarRango(int numero) throws DesbordamientoException {
        if (numero < -LIMITE || numero > LIMITE) {
            throw new DesbordamientoException("valor fuera del rango permitido [-99999, 99999]");
        }
    }
}