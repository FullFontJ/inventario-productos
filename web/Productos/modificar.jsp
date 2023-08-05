<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/formulario.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/font.css"/>
        <title>Alamacen</title>
    </head>
    <body>
        <h1>Editar Registro</h1>
        <main>
            <form action="producto?accion=actualizar" method="POST" autocomplete="off">
                <input id="id" name="id" type="hidden" value="<c:out value="${producto.id}"/>"/>
                <div>
                    <label>Código:</label>
                    <input id="codigo" name="codigo" type="text" value="<c:out value="${producto.codigo}"/>" />
                </div>
                <div>
                    <label>Nombre:</label>
                    <input id="nombre" name="nombre" type="text" value="<c:out value="${producto.nombre}"/>" />
                </div>
                <div>
                    <label>Precio:</label>
                    <input id="precio" name="precio" type="number" value="<c:out value="${producto.precio}"/>" />
                </div>
                <div>
                    <label>Existencia</label>
                    <input id="existencia" name="existencia" type="number" value="<c:out value="${producto.existencia}"/>" />
                </div>
                <input type="submit" value="Guardar" name="guardar" />
            </form>
        </main>
    </body>
</html>
