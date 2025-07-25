package controlador;
import conexion.Conexion;
import dao.ProductoDAO;
import datos.ProductoConStock;
import dao.impl.ProductoDAOImpl;
import datos.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ctrl_Producto {

    private final ProductoDAO productoDAO;

    public Ctrl_Producto() {
        this.productoDAO = new ProductoDAOImpl(); // Implementación DAO
    }

    public boolean crear(Producto producto) {
        return productoDAO.crear(producto);
    }

    public boolean actualizar(Producto producto, int idProducto) {
        return productoDAO.actualizar(producto, idProducto);
    }

    public boolean eliminar(int idProducto) {
        return productoDAO.eliminar(idProducto);
    }
    
    public DefaultTableModel buscar(String filtro) {
        String[] columnas = {"ID", "Modelo", "Marca", "Almacenamiento", "Color", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        List<Producto> lista = productoDAO.buscar(filtro);
        for (Producto p : lista) {
            Object[] fila = {
                p.getIdProducto(),
                p.getModelo(),
                p.getMarca(),
                p.getAlmacenamiento(),
                p.getColor(),
                p.getPrecio()
            };
            modelo.addRow(fila);
        }
        return modelo;
    }
    
   public Producto obtenerProductoPorDetalle(String modelo, String marca, String almacenamiento, String color) {
    return productoDAO.obtenerProductoPorDetalle(modelo, marca, almacenamiento, color);
}


    public DefaultTableModel obtenerTodos() {
    String[] columnas = {"ID", "Modelo", "Marca", "Almacenamiento", "Color", "Precio"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);

    List<Producto> lista = productoDAO.obtenerTodos();
    for (Producto p : lista) {
        Object[] fila = {
            p.getIdProducto(),
            p.getModelo(),
            p.getMarca(),
            p.getAlmacenamiento(),
            p.getColor(),
            p.getPrecio()
        };
        modelo.addRow(fila);
    }
    return modelo;
}
    
    public List<Producto> obtenerListaProductos() {
    return productoDAO.obtenerTodos();
    }
    
    public List<ProductoConStock> obtenerVistaStock() {
        return productoDAO.obtenerProductosConStock(); // este método lo crearás en el DAO
}

    public int obtenerStockActual(int idProducto) {
    int stock = 0;
    String sql = "SELECT cantidad FROM stock WHERE id_producto = ?";

    try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, idProducto);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            stock = rs.getInt("cantidad");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener stock actual: " + e.getMessage());
    }
    return stock;
}
    
    
}
