package dao.impl;

import dao.StockDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockDAOImpl implements StockDAO {

    @Override
    public boolean crearStockInicial(int idProducto) {
        Connection conn = Conexion.conectar();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO stock (id_producto, cantidad) VALUES (?, 0)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    @Override
    public boolean agregarStock(int idProducto, int cantidad) {
        Connection conn = Conexion.conectar();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE stock SET cantidad = cantidad + ? WHERE id_producto = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    @Override
    public int obtenerStockActual(int idProducto) {
        Connection conn = Conexion.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int stock = 0;
        try {
            String sql = "SELECT cantidad FROM stock WHERE id_producto = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                stock = rs.getInt("cantidad");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return stock;
    }
}
