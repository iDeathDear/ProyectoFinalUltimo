package controlador;

import conexion.Conexion;
import datos.DetalleVenta;
import datos.Venta;
import java.sql.*;
import javax.swing.JOptionPane;

public class Ctrl_RegistrarVenta {

    // Variable para almacenar el ID de la última venta registrada
    public static int idVentaRegistrada;

    // Método para guardar la venta principal
    public boolean guardar(Venta objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO venta (idVenta, idCliente, total, fecha) VALUES (?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar(); 
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, 0); // ID autoincremental
            ps.setInt(2, objeto.getIdCliente());
            ps.setDouble(3, objeto.getValorPagar());
            ps.setString(4, objeto.getFechaVenta());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idVentaRegistrada = rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar venta: " + e.getMessage());
        }

        return respuesta;
    }

    // Método para guardar el detalle de la venta
    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO detalle_venta (idDetalle, idVenta, idProducto, cantidad, precio_unitario, subtotal, descuento, igv, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar(); 
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, 0); // ID autoincremental
            ps.setInt(2, idVentaRegistrada);
            ps.setInt(3, objeto.getIdproducto());
            ps.setInt(4, objeto.getCantidad());
            ps.setDouble(5, objeto.getPreUnitario());
            ps.setDouble(6, objeto.getSubTotal());
            ps.setDouble(7, objeto.getDescuento());
            ps.setDouble(8, objeto.getIgv());
            ps.setDouble(9, objeto.getTotalpagar());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta: " + e.getMessage());
        }

        return respuesta;
    }
}
