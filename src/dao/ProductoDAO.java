package dao;

import datos.Producto;
import datos.ProductoConStock;
import java.util.List;

public interface ProductoDAO {
    boolean crear(Producto producto);
    boolean actualizar(Producto producto, int idProducto);
    boolean eliminar(int idProducto);
    List<Producto> buscar(String filtro);
    List<Producto> obtenerTodos(); // <- Este método es necesario
    Producto obtenerProductoPorDetalle(String modelo, String marca, String almacenamiento, String color);
    List<ProductoConStock> obtenerProductosConStock();
}
