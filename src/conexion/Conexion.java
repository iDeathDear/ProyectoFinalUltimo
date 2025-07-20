//package conexion;

//import java.sql.*;

//public class Conexion {

  //  public static Connection conectar() {

    //    try {
      //      Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventa", "root", "");
        //    return cn;
       // } catch (SQLException e) {
         //   System.out.println("Error de conexion " + e);
       // }
       // return null;
   // }

//    public String driver = "con.mysql.cj.jdbc.Driver";
//    public String cadena = "jdbc:mysql://localhost:3306/sistemaventa";
//    public String usuario = "root";
//    public String clave = "";
//    public Connection cn;
//
//    public Connection conectar() {
//        try {
//            Class.forName(driver);
//            cn = DriverManager.getConnection(cadena, usuario, clave);
//        } catch (ClassNotFoundException e1) {
//            System.out.println("Error en el driver " + e1);
//        } catch (SQLException e2) {
//            System.out.println("Error en la conexion " + e2);
//        }
//        return cn;
//    }

package conexion;
//Prueba de que funciona el git 3
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    // Datos de conexión (podrías moverlos a un archivo de configuración)
    private static final String URL = "jdbc:mysql://localhost:3307/sistemaventa";
    private static final String USER = "root";
    private static final String PASSWORD = "1552";
    
    public static Connection conectar() {
        try {
            // Registrar el driver (opcional desde JDBC 4.0, pero recomendado)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer conexión
            Connection cn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Verificar conexión exitosa
            if (cn != null) {
                System.out.println("Conexión establecida correctamente");
                return cn;
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el driver MySQL", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al conectar con la base de datos:\n" + e.getMessage(), 
                "Error de conexión", 
                JOptionPane.ERROR_MESSAGE);
            System.err.println("Error SQL: " + e.getMessage());
        }
        
        return null;
    }
    
    // Método para cerrar conexión (buena práctica)
    public static void cerrar(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}