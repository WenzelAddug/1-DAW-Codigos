import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Versión básica de una calculadora
 * 
 * @author Wenzel
 * @version 1.0
 */
public class Eje01{

    public static void main(String argv[]) {

        int num1;
        int num2;
        int resu = 0;
        char operador, continuar;
        boolean error = false;
        Scanner sc = new Scanner(System.in);

        do {
            error = false;

            System.out.print("1º Valor: ");
            num1 = leerNumero(sc);

            System.out.print("2º Valor: ");
            num2 = leerNumero(sc);

            System.out.print("Introduce el operador [+-*/]: ");
            operador = leerOperador(sc);

            try {
                resu = operar(operador, num1, num2);
            } catch (ArithmeticException e) {
                error = true;
                System.out.println("Error: no se puede dividir entre 0");
            }

            if (!error) {
                System.out.println("Resultado = " + resu);
            }

            System.out.print("¿Desea continuar? (S/N): ");
            continuar = sc.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');

        System.out.println("- Fin del programa -");
        sc.close();
    }

    /**
     * Lee número entero, si el valor es erróneo lo solicita de nuevo hasta que sea
     * correcto
     * 
     * @param sc Scanner desde donde se leer el valor.
     * @return número entero leído.
     */
    static int leerNumero(Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = sc.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.print("Error: debes introducir un número entero. Inténtalo otra vez: ");
                sc.nextLine(); // limpiar buffer
            }
        } while (!correcto);

        return numero;
    }

    /**
     * Leer un caracter hasta que sea +,-,* o /
     * 
     * @param sc Scanner desde donde se lee.
     * @return caracter leído
     */
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

    /**
     * Realiza la operación según el caracter indicado
     * 
     * @param letra operador +,-,*,/
     * @param num1  primer número
     * @param num2  segundo número
     * @return resultado de la operación
     */
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
                resu = num1 / num2; // aquí puede saltar ArithmeticException
                break;
        }

        return resu;
    }
}