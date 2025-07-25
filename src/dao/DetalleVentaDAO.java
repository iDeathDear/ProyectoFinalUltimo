package dao;

import datos.DetalleVenta;
import java.util.List;

public interface DetalleVentaDAO {
    boolean guardarDetalle(DetalleVenta detalle);
    List<DetalleVenta> listarPorIdVenta(int idVenta); // opcional, para futura vista de historial
    
}
