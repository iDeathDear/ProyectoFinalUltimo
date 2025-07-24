package dao;

public interface StockDAO {
    boolean crearStockInicial(int idProducto);
    boolean agregarStock(int idProducto, int cantidad);
    int obtenerStockActual(int idProducto);
}
