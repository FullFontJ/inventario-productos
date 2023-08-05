<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/formulario.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resource/css/font.css"/>
        <title>Alamacen</title>
    </head>
    <body>
        <h1>Nuevo registro</h1>
        
        <main>
            <form action="producto?accion=agregar" method="POST" autocomplete="off">
                <div>
                    <label>Código:</label>
                    <input id="codigo" name="codigo" type="text"/>
                </div>
                <div>
                    <label>Nombre:</label>
                    <input id="nombre" name="nombre" type="text"/>
                </div>
                <div>
                    <label>Precio:</label>
                    <input id="precio" name="precio" type="number"/>
                </div>
                <div>
                    <label>Existencia</label>
                    <input id="existencia" name="existencia" type="number"/>
                </div>
                <input type="submit" value="Guardar" name="guardar" />
            </form>
        </main>
    </body>
</html>
