package controlador;

import dao.StockDAO;
import dao.impl.StockDAOImpl;

public class Ctrl_Stock {

    private final StockDAO stockDAO;

    public Ctrl_Stock() {
        this.stockDAO = new StockDAOImpl();
    }

    // Crear stock con cantidad 0 al registrar un nuevo producto
    public boolean crearStockInicial(int idProducto) {
        return stockDAO.crearStockInicial(idProducto);
    }
    
    
    
    // Agregar una cantidad al stock existente
    public boolean agregarStock(int idProducto, int cantidad) {
        if (cantidad <= 0) {
            return false; // validación mínima
        }
        return stockDAO.agregarStock(idProducto, cantidad);
    }

    // Obtener el stock actual de un producto
    public int obtenerStockActual(int idProducto) {
        return stockDAO.obtenerStockActual(idProducto);
    }
}
