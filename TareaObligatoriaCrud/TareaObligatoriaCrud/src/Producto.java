public class Producto {
    private int codigo;
    private String nombre;
    private int stock;
    private int stockMin;
    private float precio;

    public Producto(int codigo, String nombre, int stock, int stockMin, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.stockMin = stockMin;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Nombre: " + nombre +
               " | Stock: " + stock +
               " | Stock mínimo: " + stockMin +
               " | Precio: " + precio;
    }
}