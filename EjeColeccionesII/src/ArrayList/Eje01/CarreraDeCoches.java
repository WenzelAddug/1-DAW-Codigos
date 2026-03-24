package ArrayList.Eje01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarreraDeCoches {

    public static void main(String[] args) {

        Random valor = new Random();
        final int META = 500;

        // ArrayList de coches
        List<Coche> parrilla = new ArrayList<Coche>();

        parrilla.add(new Coche("Ferrari", 300));
        parrilla.add(new Coche("600", 100));
        parrilla.add(new Coche("BMW", 220));
        parrilla.add(new Coche("Seat", 150));
        parrilla.add(new Coche("La Cabra", 10));

        // Pruebas de errores
        Coche c1 = parrilla.get(0);
        Coche c2 = parrilla.get(1);

        c1.acelera(10);
        c2.frena(20);
        c1.parar();
        c2.recorre();

        // Arrancar todos los coches
        for (Coche c : parrilla) {
            c.arrancar();
        }

        // Carrera
        do {
            for (Coche c : parrilla) {
                c.acelera(valor.nextInt(40));
                c.recorre();
                c.frena(valor.nextInt(10));
                System.out.println(c.infog());
            }
            System.out.println("----------------------------------------");

        } while (!alcanzarMeta(parrilla, META));

        // Ordenar clasificación de mayor a menor distancia
        parrilla.sort((x, y) -> y.getKilometros() - x.getKilometros());

        // Mostrar clasificación
        for (int i = 0; i < parrilla.size(); i++) {
            System.out.println((i + 1) + "º Clasificado " + parrilla.get(i).info());
        }
    }

    // Método auxiliar
    public static boolean alcanzarMeta(List<Coche> parrilla, int distancia) {
        boolean fin = false;

        for (Coche c : parrilla) {
            if (c.getKilometros() >= distancia) {
                fin = true;
                break;
            }
        }

        return fin;
    }
}
