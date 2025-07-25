package dao;

import datos.Venta;
import datos.DetalleVenta;

public interface VentaDAO {
    int guardarYObtenerId(Venta venta);
    boolean registrarVenta(Venta venta);
    boolean registrarDetalleVenta(DetalleVenta detalle);
}
