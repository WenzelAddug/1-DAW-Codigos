public class NumerosPescaderia {

    private int contador;
    private int maximo;

    public NumerosPescaderia(int maximo) {
        this.maximo = maximo;
        this.contador = 0;
    }

    public int cogerNumero() throws EstoySaturaoException {
        if (contador >= maximo) {
            throw new EstoySaturaoException("No se pueden dar más números. Pescadería saturada");
        }

        contador++;
        return contador;
    }

    public void dejarNumero() {
        if (contador > 0) {
            contador--;
        }
    }

    public int getContador() {
        return contador;
    }
}