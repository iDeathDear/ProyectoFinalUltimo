package datos;

public class DetalleVenta {

    private int idDetalle;
    private int idVenta;
    private int idProducto;

    private String marca;
    private String almacenamiento;
    private String color;

    private int cantidad;
    private double preUnitario;
    private double subTotal;
    private double descuento;
    private double igv;
    private double totalPagar;

    // Constructor vacío
    public DetalleVenta() {}

    // Constructor completo
    public DetalleVenta(int idDetalle, int idVenta, int idProducto, String marca, String modelo, String almacenamiento, String color,
                        int cantidad, double preUnitario, double subTotal, double descuento, double igv, double totalPagar) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.marca = marca;
        this.almacenamiento = almacenamiento;
        this.color = color;
        this.cantidad = cantidad;
        this.preUnitario = preUnitario;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.igv = igv;
        this.totalPagar = totalPagar;
    }

    // Getters y Setters
    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }


    public String getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPreUnitario() { return preUnitario; }
    public void setPreUnitario(double preUnitario) { this.preUnitario = preUnitario; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    public double getIgv() { return igv; }
    public void setIgv(double igv) { this.igv = igv; }

    public double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle=" + idDetalle +
                ", idVenta=" + idVenta +
                ", idProducto=" + idProducto +
                ", marca='" + marca + '\'' +
                ", almacenamiento='" + almacenamiento + '\'' +
                ", color='" + color + '\'' +
                ", cantidad=" + cantidad +
                ", preUnitario=" + preUnitario +
                ", subTotal=" + subTotal +
                ", descuento=" + descuento +
                ", igv=" + igv +
                ", totalPagar=" + totalPagar +
                '}';
    }

    public int getIdproducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getTotalpagar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdproducto(int idproducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setTotalpagar(double totalpagar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

