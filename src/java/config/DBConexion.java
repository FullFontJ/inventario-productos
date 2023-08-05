package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConexion {
    private static Connection conexion;
    private static String url = "jdbc:mysql://localhost/almacen";
    private static String usuario = "root";
    private static String contraseña = "";

    public static Connection getConexion() {
        return conexion;
    }
    
    
    public static void getConnection() {
        try {
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        }catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
            }
        }
    }
}
