package controlador;

import conexion.Conexion;
import datos.Producto;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Producto {

    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        // QUITAR 'modelo' de la consulta
        String sql = "INSERT INTO producto (marca, almacenamiento, color, precio, stock, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, objeto.getMarca());
            ps.setString(2, objeto.getAlmacenamiento());
            ps.setString(3, objeto.getColor());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getStock());
            ps.setString(6, objeto.getDescripcion());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        // QUITAR 'modelo' de la consulta
        String sql = "UPDATE producto SET marca=?, almacenamiento=?, color=?, precio=?, stock=?, descripcion=? WHERE idProducto=?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, objeto.getMarca());
            ps.setString(2, objeto.getAlmacenamiento());
            ps.setString(3, objeto.getColor());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getStock());
            ps.setString(6, objeto.getDescripcion());
            ps.setInt(7, idProducto);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean buscarProducto(Producto objeto) {
        boolean respuesta = false;
        // QUITAR 'modelo' de la consulta
        String sql = "SELECT marca, almacenamiento, color, precio, stock, descripcion FROM producto WHERE idProducto = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, objeto.getIdProducto());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objeto.setMarca(rs.getString("marca"));
                objeto.setAlmacenamiento(rs.getString("almacenamiento"));
                objeto.setColor(rs.getString("color"));
                objeto.setPrecio(rs.getDouble("precio"));
                objeto.setStock(rs.getInt("stock"));
                objeto.setDescripcion(rs.getString("descripcion"));
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar producto: " + e.getMessage());
        }
        return respuesta;
    }

    public DefaultTableModel buscar(String buscar) {
        DefaultTableModel model;
        // QUITAR 'Modelo' de los títulos
        String[] titulos = {"ID", "Marca", "Almacenamiento", "Color", "Precio", "Stock", "Descripcion"};
        String[] registro = new String[7]; // Cambiar a 7 elementos
        model = new DefaultTableModel(null, titulos);

        // Cambiar la búsqueda a por marca en lugar de modelo
        String sql = "SELECT * FROM producto WHERE marca LIKE ? ORDER BY idProducto";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + buscar + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("marca");
                registro[2] = rs.getString("almacenamiento");
                registro[3] = rs.getString("color");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("stock");
                registro[6] = rs.getString("descripcion");

                model.addRow(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar productos: " + e.getMessage());
        }
        return model;
    }

    // El método eliminar puede permanecer igual
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        String sql = "DELETE FROM producto WHERE idProducto=?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idProducto);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
        return respuesta;
    }
}