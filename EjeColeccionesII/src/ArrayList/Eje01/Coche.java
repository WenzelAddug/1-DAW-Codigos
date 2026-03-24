package ArrayList.Eje01;

public class Coche {
    // Atributos
    private String modelo;
    private boolean motor;
    private int velocidad;
    private int velocidadMax;
    public int distanciaParcial;
    public int distanciaTotal;

    // Constructor
    public Coche(String modelo, int velocidadMax) {
        this.modelo = modelo;
        this.distanciaParcial = 0;
        this.distanciaTotal = 0;
        this.velocidad = 0;
        this.velocidadMax = velocidadMax;
        this.motor = false;
    }

    // Arranca el motor
    public boolean arrancar() {
        if (motor) {
            infoError("Motor ya arrancado");
            return false;
        } else {
            motor = true;
            return true;
        }
    }

    // Para el motor
    public boolean parar() {
        if (!motor) {
            infoError("Motor ya esta parado");
            return false;
        }
        if (velocidad != 0) {
            infoError("No se puede parar con el vehiculo en marcha");
            return false;
        }

        motor = false;
        distanciaParcial = 0;
        return true;
    }

    // Acelera
    public boolean acelera(int cantidad) {
        if (motor) {
            velocidad = velocidad + cantidad;
            if (velocidad > velocidadMax) {
                velocidad = velocidadMax;
            }
            return true;
        } else {
            infoError("Motor parado. No se puede acelerar");
            return false;
        }
    }

    // Frena
    public boolean frena(int cantidad) {
        if (motor) {
            velocidad = velocidad - cantidad;
            if (velocidad < 0) {
                velocidad = 0;
            }
            return true;
        } else {
            infoError("Motor parado. No se puede frenar");
            return false;
        }
    }

    // Recorre distancia según la velocidad
    public boolean recorre() {
        if (motor) {
            distanciaParcial += velocidad;
            distanciaTotal += velocidad;
            return true;
        } else {
            infoError("Motor parado. No se puede avanzar");
            return false;
        }
    }

    // Información completa
    public String info() {
        return modelo + " Motor encendido: " + motor +
               " km: " + distanciaParcial +
               " Velocidad: " + velocidad;
    }

    // Información gráfica
    public String infog() {
        StringBuilder msg = new StringBuilder();
        msg.append(String.format("%-15s:", modelo));
        for (int i = 1; i <= distanciaParcial / 10; i++) {
            msg.append("*");
        }
        return msg.toString();
    }

    // Devuelve la distancia recorrida
    public int getKilometros() {
        return distanciaParcial;
    }

    // Muestra errores
    private void infoError(String mensaje) {
        System.err.println(mensaje);
    }
}