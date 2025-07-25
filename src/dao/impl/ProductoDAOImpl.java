package dao.impl;

import conexion.Conexion;
import dao.ProductoDAO;
import datos.Producto;
import datos.ProductoConStock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public boolean crear(Producto producto) {
        String sql = "INSERT INTO producto (modelo, marca, almacenamiento, color, precio) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = Conexion.conectar(); 
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, producto.getModelo());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getAlmacenamiento());
            ps.setString(4, producto.getColor());
            ps.setDouble(5, producto.getPrecio());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                // Obtener el ID generado
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);

                    // Crear stock inicial
                    dao.impl.StockDAOImpl stockDAO = new dao.impl.StockDAOImpl();
                    stockDAO.crearStockInicial(idGenerado);
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Producto producto, int idProducto) {
        String sql = "UPDATE producto SET modelo=?, marca=?, almacenamiento=?, color=?, precio=? WHERE idProducto=?";
        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, producto.getModelo());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getAlmacenamiento());
            ps.setString(4, producto.getColor());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, idProducto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
            return false;
        }
    }

    @Override
    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM producto WHERE idProducto=?";
        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
            return false;
        }
    }
    @Override
public List<Producto> obtenerTodos() {
    List<Producto> lista = new ArrayList<>();
    String sql = "SELECT * FROM producto";

    try (Connection cn = Conexion.conectar(); 
         Statement st = cn.createStatement(); 
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Producto p = new Producto();
            p.setIdProducto(rs.getInt("idProducto"));
            p.setModelo(rs.getString("modelo"));
            p.setMarca(rs.getString("marca"));
            p.setAlmacenamiento(rs.getString("almacenamiento"));
            p.setColor(rs.getString("color"));
            p.setPrecio(rs.getDouble("precio"));
            lista.add(p);
        }

    } catch (SQLException e) {
        System.out.println("Error en obtenerTodos producto: " + e.getMessage());
    }

    return lista;
}

    @Override
    public List<Producto> buscar(String filtro) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE "
                   + "LOWER(TRIM(modelo)) LIKE LOWER(TRIM(?)) OR "
                   + "LOWER(TRIM(marca)) LIKE LOWER(TRIM(?)) OR "
                   + "LOWER(TRIM(almacenamiento)) LIKE LOWER(TRIM(?)) OR "
                   + "LOWER(TRIM(color)) LIKE LOWER(TRIM(?))";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            String filtroLike = "%" + filtro + "%";
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, filtroLike);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setModelo(rs.getString("modelo"));
                p.setMarca(rs.getString("marca"));
                p.setAlmacenamiento(rs.getString("almacenamiento"));
                p.setColor(rs.getString("color"));
                p.setPrecio(rs.getDouble("precio"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error en buscar producto: " + e);
        }
        return lista;
    }

    public List<ProductoConStock> obtenerProductosConStock() {
        List<ProductoConStock> lista = new ArrayList<>();
        String sql = "SELECT p.*, IFNULL(s.cantidad, 0) AS stock FROM producto p LEFT JOIN stock s ON p.idProducto = s.id_producto";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProductoConStock pcs = new ProductoConStock();
                pcs.setIdProducto(rs.getInt("idProducto"));
                pcs.setModelo(rs.getString("modelo"));
                pcs.setMarca(rs.getString("marca"));
                pcs.setAlmacenamiento(rs.getString("almacenamiento"));
                pcs.setColor(rs.getString("color"));
                pcs.setPrecio(rs.getDouble("precio"));
                pcs.setStock(rs.getInt("stock")); // cantidad
                lista.add(pcs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Producto obtenerProductoPorDetalle(String modelo, String marca, String almacenamiento, String color) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE "
                   + "LOWER(TRIM(modelo)) = LOWER(TRIM(?)) AND "
                   + "LOWER(TRIM(marca)) = LOWER(TRIM(?)) AND "
                   + "LOWER(TRIM(almacenamiento)) = LOWER(TRIM(?)) AND "
                   + "LOWER(TRIM(color)) = LOWER(TRIM(?))";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, modelo.trim());
            ps.setString(2, marca.trim());
            ps.setString(3, almacenamiento.trim());
            ps.setString(4, color.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setModelo(rs.getString("modelo"));
                producto.setMarca(rs.getString("marca"));
                producto.setAlmacenamiento(rs.getString("almacenamiento"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar producto por combinación: " + e.getMessage());
        }

        return producto;
    }
}
