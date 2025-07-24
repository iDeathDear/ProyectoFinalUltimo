package dao;

import datos.Usuario;
import java.util.List;

public interface UsuarioDAO {
    boolean loginUser(Usuario usuario);
    boolean crear(Usuario usuario);
    boolean existeUsuario(String usuario);
    boolean actualizar(Usuario usuario, int idUsuario);
    boolean eliminar(int idUsuario);
    Usuario obtenerPorUsuario(String usuario); // para casos más detallados
    List<Usuario> listarTodos(); // si usas una tabla en JFrame
    List<Usuario> buscarFiltrado(Usuario filtro);
}
