package controlador;

import conexion.Conexion;
import datos.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Cliente {

    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO cliente(idCliente, apellido, nombre, dni, celular, direccion) VALUES(?,?,?,?,?,?)";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, 0);
            ps.setString(2, objeto.getApellido());
            ps.setString(3, objeto.getNombre());
            ps.setString(4, objeto.getDni());
            ps.setString(5, objeto.getCelular());
            ps.setString(6, objeto.getDireccion());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        String sql = "UPDATE cliente SET apellido=?, nombre=?, dni=?, celular=?, direccion=? WHERE idCliente=?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, objeto.getApellido());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getDni());
            ps.setString(4, objeto.getCelular());
            ps.setString(5, objeto.getDireccion());
            ps.setInt(6, idCliente);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        String sql = "DELETE FROM cliente WHERE idCliente=?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return respuesta;
    }

    public DefaultTableModel buscar(String buscar) {
        DefaultTableModel model;
        String[] titulos = {"ID", "Apellido", "Nombre", "Dni", "Celular", "Direccion"};
        String[] registro = new String[6];
        model = new DefaultTableModel(null, titulos);

        String sql = "SELECT * FROM cliente WHERE dni LIKE ? ORDER BY idCliente";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + buscar + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("apellido");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("dni");
                registro[4] = rs.getString("celular");
                registro[5] = rs.getString("direccion");

                model.addRow(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar cliente: " + e.getMessage());
        }
        return model;
    }
}
