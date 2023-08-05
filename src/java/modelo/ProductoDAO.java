package modelo;

import config.DBConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FullFontJ
 */
public class ProductoDAO extends DBConexion{
    
    public List<Producto> ListarProductos(){
        try {
            List<Producto> lista = new ArrayList<>();
            getConnection();
            PreparedStatement ps = getConexion().prepareStatement("SELECT * FROM producto;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                Producto producto = new Producto(id, existencia, codigo, nombre, precio);
                
                lista.add(producto);
            }
            
            return lista;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
    }
    
    
    public Producto mostrarProducto(int _id){
        try {
            Producto producto = null;
            getConnection();
            PreparedStatement ps = getConexion().prepareStatement("SELECT * FROM producto WHERE id=? LIMIT 1");
            ps.setInt(1, _id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                producto = new Producto(id, existencia, codigo, nombre, precio);
            }
            
            return producto;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;

        } finally {
            closeConnection();
        }
    }
    
    
    public boolean agregarProducto(Producto producto){
        try {
            getConnection();
            PreparedStatement ps = getConexion().prepareStatement("INSERT INTO producto (codigo, nombre, precio, existencia) VALUES (?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        } finally {
            closeConnection();
        }
    }
    
    
    public boolean actualizarProducto(Producto producto){
        try {
            getConnection();
            PreparedStatement ps = getConexion().prepareStatement("UPDATE producto SET codigo=?, nombre=?, precio=?, existencia=? WHERE id=?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getId());
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        } finally {
            closeConnection();
        }
    }
    
    public boolean eliminarProducto(int _id){
        try {
            getConnection();
            PreparedStatement ps = getConexion().prepareStatement("DELETE FROM producto WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        } finally {
            closeConnection();
        }
    }
    
}
