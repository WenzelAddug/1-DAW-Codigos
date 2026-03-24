package ArrayList.Eje02;

public class Libro {

    int id;
    String titulo;
    String autor;
    Genero genero;
    int edicion;

    public Libro(int id, String titulo, String autor, Genero genero, int edicion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return titulo + ", " + autor + ", " + genero + ", " + edicion + ".";
    }
}