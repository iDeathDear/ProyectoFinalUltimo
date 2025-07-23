package controlador;

import datos.Usuario;
import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;

import javax.swing.JOptionPane;

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

    public boolean eliminar(int idUsuario) {
        try {
            return usuarioDAO.eliminar(idUsuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeUsuario(String usuario) {
        try {
            return usuarioDAO.existeUsuario(usuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean Crear(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
