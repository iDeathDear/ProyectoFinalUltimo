package controlador;

import dao.VentaDAO;
import dao.DetalleVentaDAO;
import dao.impl.VentaDAOImpl;
import dao.impl.DetalleVentaDAOImpl;
import datos.Venta;
import datos.DetalleVenta;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;

public class Ctrl_RegistrarVenta {

    private final VentaDAO ventaDAO;
    private final DetalleVentaDAO detalleVentaDAO;
    

    public Ctrl_RegistrarVenta() {
        this.ventaDAO = new VentaDAOImpl();
        this.detalleVentaDAO = new DetalleVentaDAOImpl();
    }

    /**
     * Guarda la venta general (solo total y fecha).
     * Retorna el ID generado si es exitoso, o -1 si falla.
     */
    
    public int guardar(Venta venta) {
    int idGenerado = -1;
    String sql = "INSERT INTO venta (fechaVenta, total) VALUES (?, ?)";

    try (Connection cn = Conexion.conectar();
         PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, venta.getFechaVenta());
        ps.setDouble(2, venta.getValorPagar());

        int filas = ps.executeUpdate();
        if (filas > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al guardar venta: " + e.getMessage());
    }

    return idGenerado;
}

   public int guardarYObtenerId(Venta venta) {
    return this.guardar(venta); // ya lo estás haciendo tú aquí mismo
}


    /**
     * Guarda los detalles de una venta
     */
    public boolean guardarDetalle(DetalleVenta detalle) {
        try {
            return detalleVentaDAO.guardarDetalle(detalle);
        } catch (Exception e) {
            System.err.println("Error al registrar detalle de venta: " + e.getMessage());
            return false;
        }
    }

    /**
     * Guarda venta y sus detalles juntos
     */
    public boolean guardarVentaCompleta(Venta venta, List<DetalleVenta> detalles) {
        int idVenta = this.guardar(venta);

        if (idVenta != -1) {
            for (DetalleVenta detalle : detalles) {
                detalle.setIdVenta(idVenta);
                if (!guardarDetalle(detalle)) {
                    return false; // Si falla un detalle, se detiene todo
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
