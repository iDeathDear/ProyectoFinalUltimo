package datos;

public class Producto {
    private int idProducto;
    private String marca;
    private String almacenamiento;
    private String color;
    private double precio;
    private int stock;
    private String descripcion;

    // Constructor vacío
    public Producto() {}

    // Constructor completo (sin modelo)
    public Producto(int idProducto, String marca, String almacenamiento, String color, 
                   double precio, int stock, String descripcion) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.almacenamiento = almacenamiento;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    // Getters y Setters (elimina los de modelo)
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}