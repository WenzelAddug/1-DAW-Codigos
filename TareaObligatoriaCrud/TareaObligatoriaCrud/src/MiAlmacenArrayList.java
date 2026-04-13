import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MiAlmacenArrayList {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Producto> almacen = new ArrayList<Producto>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    nuevoProducto();
                    break;
                case 2:
                    consultaProducto();
                    break;
                case 3:
                    borrarProducto();
                    break;
                case 4:
                    modificarPrecio();
                    break;
                case 5:
                    compraProductos();
                    break;
                case 6:
                    ventaProductos();
                    break;
                case 7:
                    listadoCompleto();
                    break;
                case 8:
                    listadoStockInferiorMinimo();
                    break;
                case 9:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);
    }

    public static void mostrarMenu() {
        System.out.println("\n----- MENÚ ALMACÉN ARRAYLIST -----");
        System.out.println("1. Nuevo producto");
        System.out.println("2. Consulta producto");
        System.out.println("3. Borrar producto");
        System.out.println("4. Modificar precio");
        System.out.println("5. Compra de productos");
        System.out.println("6. Venta de productos");
        System.out.println("7. Listado completo de productos");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar");
    }

    public static int leerOpcion() {
        int opcion = -1;
        boolean error;

        do {
            error = false;
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero.");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return opcion;
    }

    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean error;

        do {
            error = false;
            try {
                System.out.print(mensaje);
                valor = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero.");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return valor;
    }

    public static float leerPrecio(String mensaje) {
        float precio = 0;
        boolean error;

        do {
            error = false;
            try {
                System.out.print(mensaje);
                precio = sc.nextFloat();
                if (precio <= 0) {
                    System.out.println("Error: el precio debe ser mayor que 0.");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número decimal correcto.");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return precio;
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : almacen) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static void nuevoProducto() {
        int codigo = leerEntero("Introduce código: ");

        if (buscarProducto(codigo) != null) {
            System.out.println("Error: ya existe un producto con ese código.");
            return;
        }

        System.out.print("Introduce nombre: ");
        String nombre = sc.nextLine();

        int stock;
        do {
            stock = leerEntero("Introduce stock: ");
            if (stock <= 0) {
                System.out.println("Error: el stock debe ser mayor que 0.");
            }
        } while (stock <= 0);

        int stockMin;
        do {
            stockMin = leerEntero("Introduce stock mínimo: ");
            if (stockMin <= 0) {
                System.out.println("Error: el stock mínimo debe ser mayor que 0.");
            }
        } while (stockMin <= 0);

        float precio = leerPrecio("Introduce precio: ");

        Producto nuevo = new Producto(codigo, nombre, stock, stockMin, precio);
        almacen.add(nuevo);

        System.out.println("Producto añadido correctamente.");
    }

    public static void consultaProducto() {
        int codigo = leerEntero("Introduce código: ");
        Producto p = buscarProducto(codigo);

        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(p);
        }
    }

    public static void borrarProducto() {
        int codigo = leerEntero("Introduce código: ");
        Producto p = buscarProducto(codigo);

        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println("Producto encontrado:");
            System.out.println(p);

            System.out.print("¿Confirmar eliminación? (s/n): ");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                almacen.remove(p);
                System.out.println("Producto borrado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        }
    }

    public static void modificarPrecio() {
        int codigo = leerEntero("Introduce código: ");
        Producto p = buscarProducto(codigo);

        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println("Producto encontrado:");
            System.out.println(p);

            float nuevoPrecio = leerPrecio("Introduce nuevo precio: ");
            p.setPrecio(nuevoPrecio);

            System.out.println("Precio modificado correctamente.");
        }
    }

    public static void compraProductos() {
        int codigo = leerEntero("Introduce código: ");
        Producto p = buscarProducto(codigo);

        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            int cantidad;
            do {
                cantidad = leerEntero("Introduce cantidad comprada: ");
                if (cantidad <= 0) {
                    System.out.println("Error: la cantidad debe ser mayor que 0.");
                }
            } while (cantidad <= 0);

            p.setStock(p.getStock() + cantidad);
            System.out.println("Compra realizada correctamente.");
            System.out.println(p);
        }
    }

    public static void ventaProductos() {
        int codigo = leerEntero("Introduce código: ");
        Producto p = buscarProducto(codigo);

        if (p == null) {
            System.out.println("Producto no encontrado.");
        } else {
            int cantidad;
            do {
                cantidad = leerEntero("Introduce cantidad vendida: ");
                if (cantidad <= 0) {
                    System.out.println("Error: la cantidad debe ser mayor que 0.");
                } else if (cantidad > p.getStock()) {
                    System.out.println("Error: no se pueden vender más productos de los que hay en stock.");
                    cantidad = -1;
                }
            } while (cantidad <= 0);

            p.setStock(p.getStock() - cantidad);
            System.out.println("Venta realizada correctamente.");
            System.out.println(p);
        }
    }

    public static void listadoCompleto() {
        if (almacen.isEmpty()) {
            System.out.println("No hay productos en el almacén.");
        } else {
            System.out.println("\n----- LISTADO COMPLETO -----");
            System.out.printf("%-8s %-20s %-8s %-12s %-10s%n",
                    "CODIGO", "NOMBRE", "STOCK", "STOCK_MIN", "PRECIO");

            for (Producto p : almacen) {
                System.out.printf("%-8d %-20s %-8d %-12d %-10.2f%n",
                        p.getCodigo(), p.getNombre(), p.getStock(), p.getStockMin(), p.getPrecio());
            }
        }
    }

    public static void listadoStockInferiorMinimo() {
        boolean hayProductos = false;

        System.out.println("\n----- PRODUCTOS CON STOCK INFERIOR AL MÍNIMO -----");
        System.out.printf("%-8s %-20s %-8s %-12s %-10s%n",
                "CODIGO", "NOMBRE", "STOCK", "STOCK_MIN", "PRECIO");

        for (Producto p : almacen) {
            if (p.getStock() < p.getStockMin()) {
                System.out.printf("%-8d %-20s %-8d %-12d %-10.2f%n",
                        p.getCodigo(), p.getNombre(), p.getStock(), p.getStockMin(), p.getPrecio());
                hayProductos = true;
            }
        }

        if (!hayProductos) {
            System.out.println("No hay productos con stock inferior al mínimo.");
        }
    }
}