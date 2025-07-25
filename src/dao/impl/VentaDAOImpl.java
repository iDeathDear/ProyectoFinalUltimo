package dao.impl;

import conexion.Conexion;
import dao.VentaDAO;
import datos.Venta;
import datos.DetalleVenta;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public boolean registrarVenta(Venta venta) {
        String sql = "INSERT INTO venta (valor_pagar, fecha_venta) VALUES (?, ?)";
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, venta.getValorPagar());
            ps.setString(2, venta.getFechaVenta());

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    venta.setIdVenta(rs.getInt(1)); // Guardar el ID generado
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar venta: " + e);
        }
        return false;
    }
    
    
    @Override
    public int guardarYObtenerId(Venta venta) {
    String sql = "INSERT INTO venta (valor_pagar, fecha_venta) VALUES (?, ?)";
    int idGenerado = 0;

    try (Connection cn = Conexion.conectar();
         PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setDouble(1, venta.getValorPagar());
        ps.setString(2, venta.getFechaVenta());
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al guardar venta: " + e.getMessage());
    }

    return idGenerado;
}

    
    @Override
    public boolean registrarDetalleVenta(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario, subtotal, descuento, igv, total_pagar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, detalle.getIdVenta());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPreUnitario());
            ps.setDouble(5, detalle.getSubTotal());
            ps.setDouble(6, detalle.getDescuento());
            ps.setDouble(7, detalle.getIgv());
            ps.setDouble(8, detalle.getTotalpagar());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al registrar detalle venta: " + e);
        }
        return false;
    }
}
