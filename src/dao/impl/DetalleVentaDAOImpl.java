package dao.impl;

import dao.DetalleVentaDAO;
import datos.DetalleVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;

public class DetalleVentaDAOImpl implements DetalleVentaDAO {

    
    @Override
    public boolean guardarDetalle(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle_venta (codVenta, idProducto, cantidad, preUnitario, subtotal, descuento, igv, totalpagar) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

        } catch (SQLException e) {
            System.out.println("Error al guardar detalle venta: " + e.getMessage());
            return false;
        }
    }

 @Override
public List<DetalleVenta> listarPorIdVenta(int idVenta) {
    throw new UnsupportedOperationException("Método no implementado aún.");
}
  
    public List<DetalleVenta> obtenerPorVenta(int codVenta) {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta WHERE codVenta = ?";
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, codVenta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalle(rs.getInt("idDetalle"));
                detalle.setIdVenta(rs.getInt("codVenta"));
                detalle.setIdProducto(rs.getInt("idProducto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPreUnitario(rs.getDouble("preUnitario"));
                detalle.setSubTotal(rs.getDouble("subtotal"));
                detalle.setDescuento(rs.getDouble("descuento"));
                detalle.setIgv(rs.getDouble("igv"));
                detalle.setTotalpagar(rs.getDouble("totalpagar"));

                lista.add(detalle);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener detalles por venta: " + e.getMessage());
        }

        return lista;
    }
}
