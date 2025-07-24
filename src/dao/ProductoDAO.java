package dao;

import datos.Producto;
import datos.ProductoConStock;
import java.util.List;

public interface ProductoDAO {
    boolean crear(Producto producto);
    boolean actualizar(Producto producto, int idProducto);
    boolean eliminar(int idProducto);
    List<Producto> buscar(String filtro); // filtrado general
    List<Producto> obtenerTodos();
    List<ProductoConStock> obtenerProductosConStock();
}
