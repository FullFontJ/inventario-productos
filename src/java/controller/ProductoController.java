package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author FullFontJ
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/"})
public class ProductoController extends HttpServlet {
    ProductoDAO productos = new ProductoDAO();
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "listar" -> mostrarListaProductos(request, response);
            case "eliminar" -> eliminarProducto(request, response);
            case "modificar" -> mostrarFormularioEdicion(request, response);
            case "nuevo" -> nuevoFormularioAgregar(request, response);
            default -> mostrarListaProductos(request, response);
        } 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "agregar" -> agregarProducto(request, response);
            case "nuevo" -> nuevoFormularioAgregar(request, response);
            case "actualizar" -> actualizarProducto(request, response);
            default -> mostrarListaProductos(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
    private void mostrarListaProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> listaProductos = productos.ListarProductos();
        request.setAttribute("lista", listaProductos);
        request.getRequestDispatcher("/index.jsp").forward(request, response);    
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        // Lógica para obtener el producto con el id proporcionado desde la fuente de datos (por ejemplo, una base de datos)
        Producto producto = productos.mostrarProducto(id);

        request.setAttribute("producto", producto);
        request.getRequestDispatcher("/Productos/modificar.jsp").forward(request, response);        
    }
    
    private void nuevoFormularioAgregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/Productos/nuevo.jsp").forward(request, response);    
    }

    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos del formulario de agregar producto
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        Double precio = Double.valueOf(request.getParameter("precio"));
        int existencia = Integer.parseInt(request.getParameter("existencia"));

        // Crear un nuevo producto
        Producto nuevoProducto = new Producto(existencia, codigo, nombre, precio); 

        // Lógica para guardar el nuevo producto en la fuente de datos (por ejemplo, una base de datos)
        productos.agregarProducto(nuevoProducto);

        // Redirigir a la lista de productos actualizada
        response.sendRedirect(request.getContextPath() + "/");        
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos del formulario de edición
        int id = Integer.parseInt(request.getParameter("id"));
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        Double precio = Double.valueOf(request.getParameter("precio"));
        int existencia = Integer.parseInt(request.getParameter("existencia"));
        // Actualizar los datos del producto
        Producto producto = new Producto(id, existencia, codigo, nombre, precio);

        // Lógica para actualizar el producto en la fuente de datos (por ejemplo, una base de datos)
        productos.actualizarProducto(producto);

        // Redirigir a la lista de productos actualizada
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        // Lógica para eliminar el producto con el id proporcionado desde la fuente de datos (por ejemplo, una base de datos)
        productos.eliminarProducto(id);

        // Redirigir a la lista de productos actualizada
        response.sendRedirect(request.getContextPath() + "/");
    }
}
