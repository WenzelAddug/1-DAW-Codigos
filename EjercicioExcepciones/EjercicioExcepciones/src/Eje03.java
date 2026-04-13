public class Eje03 {

    public static void main(String[] args) {
        int numero;
        int contadorSeis = 0;

        try {
            while (true) {
                numero = (int) (Math.random() * 10) + 1;
                System.out.println("Número generado: " + numero);

                if (numero == 6) {
                    contadorSeis++;
                } else {
                    contadorSeis = 0;
                }

                if (contadorSeis == 3) {
                    throw new DevilException("Han aparecido tres veces seguidas el número 6");
                }

                Thread.sleep(500);
            }
        } catch (DevilException e) {
            System.out.println("DevilException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error en la espera del programa");
        }
    }
}