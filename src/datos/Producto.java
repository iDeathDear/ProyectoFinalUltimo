package datos;

public class Producto {
    private int idProducto;
    private String modelo;
    private String marca;
    private String almacenamiento;
    private String color;
    private double precio;

    public Producto() {}

    public Producto(int idProducto, String modelo, String marca, String almacenamiento, String color, double precio) {
        this.idProducto = idProducto;
        this.modelo = modelo;
        this.marca = marca;
        this.almacenamiento = almacenamiento;
        this.color = color;
        this.precio = precio;
    }

    // Getters y Setters (incluye modelo)
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
