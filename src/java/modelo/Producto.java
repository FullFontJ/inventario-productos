package modelo;

/**
 *
 * @author FullFontJ
 */
public class Producto {
    private int id, existencia;
    private String codigo, nombre;
    private Double precio;

    public Producto(int id, int existencia, String codigo, String nombre, Double precio) {
        this.id = id;
        this.existencia = existencia;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(int existencia, String codigo, String nombre, Double precio) {
        this.existencia = existencia;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
