<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/index.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/font.css"/>
    </head>
    <body>
        <h1>Productos</h1>
        <a class="btn-registro" href="producto?accion=nuevo">Nuevo registro</a>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Existencia</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${lista}">
                    <tr>
                        <td><c:out value="${producto.codigo}" /></td>
                        <td><c:out value="${producto.nombre}" /></td> 
                        <td><c:out value="${producto.precio}" /></td> 
                        <td><c:out value="${producto.existencia}" /></td> 
                        <td><a href="producto?accion=modificar&id=<c:out value="${producto.id}" />">Modificar</a></td> 
                        <td><a href="producto?accion=eliminar&id=<c:out value="${producto.id}" />">Eliminar</a></td> 
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>

    </body>
</html>
