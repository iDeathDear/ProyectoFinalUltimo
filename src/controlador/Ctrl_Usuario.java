package controlador;

import datos.Usuario;
import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexion.Conexion;
import java.util.List;

public class Ctrl_Usuario {

    private final UsuarioDAO usuarioDAO;

    public Ctrl_Usuario() {
        this.usuarioDAO = new UsuarioDAOImpl(); // Usa el patrón DAO
    }

    public boolean loginUser(Usuario objeto) {
        try {
            return usuarioDAO.loginUser(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean crear(Usuario objeto) {
        try {
            if (!usuarioDAO.existeUsuario(objeto.getUsuario())) {
                return usuarioDAO.crear(objeto);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Usuario objeto, int idUsuario) {
        try {
            return usuarioDAO.actualizar(objeto, idUsuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Usuario> buscarFiltrado(Usuario filtro) {
    return usuarioDAO.buscarFiltrado(filtro);
    }


    public boolean eliminar(int idUsuario) {
        try {
            return usuarioDAO.eliminar(idUsuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeUsuario(String nombreUsuario) {
    String sql = "SELECT COUNT(*) FROM usuario WHERE usuario = ?";
    try (Connection conexion = Conexion.conectar();
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        stmt.setString(1, nombreUsuario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
}
}