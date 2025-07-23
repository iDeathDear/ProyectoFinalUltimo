package dao.impl;

import conexion.Conexion;
import datos.Usuario;
import dao.UsuarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private final Connection conexion;

    public UsuarioDAOImpl() {
        this.conexion = Conexion.conectar();
    }

    @Override
    public Usuario obtenerPorUsuario(String usuarioInput) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuarioInput);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setDni(rs.getString("dni"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCategoria(rs.getString("categoria"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    
    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (apellido, nombre, dni, celular, direccion, categoria, usuario, clave) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getApellido());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getCelular());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCategoria());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getClave());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setApellido(rs.getString("apellido"));
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getString("dni"));
                u.setCelular(rs.getString("celular"));
                u.setDireccion(rs.getString("direccion"));
                u.setCategoria(rs.getString("categoria"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
public boolean eliminar(int idUsuario) {
    boolean eliminado = false;
    String sql = "DELETE FROM usuario WHERE idUsuario = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idUsuario);
        eliminado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return eliminado;
}

@Override
public boolean actualizar(Usuario usuario, int idUsuario) {
    boolean actualizado = false;
    String sql = "UPDATE usuario SET apellidos=?, nombres=?, celular=?, categoria=?, usuario=?, clave=? WHERE idUsuario=?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setString(1, usuario.getApellido());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getCelular());
        ps.setString(4, usuario.getCategoria());
        ps.setString(5, usuario.getUsuario());
        ps.setString(6, usuario.getClave());
        ps.setInt(7, idUsuario);

        actualizado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return actualizado;
}

   

@Override
public boolean loginUser(Usuario usuario) {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean existe = false;

    try {
        con = Conexion.conectar();
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getClave());

        rs = ps.executeQuery();
        if (rs.next()) {
            existe = true;
        }

    } catch (SQLException e) {
        System.err.println("Error en loginUser: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Error cerrando recursos: " + e.getMessage());
        }
    }

    return existe;
}



    @Override
    public boolean crear(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeUsuario(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
