<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="container lg-col-3">

            <form method="post" action="/coden_bugs/cerrar-sesion-servlet">
                <div class="form-group text-center">
                    <label><strong>Bienvenido al área de administrativa <%=request.getSession().getAttribute("user")%></strong></label><br><br>
                    <div class="form-group">
                        <a href="/coden_bugs/administracion/agregarMueble.jsp" class="btn btn-block">Agregar nuevo Mueble</a><br>
                        <a href="/coden_bugs/administracion/agregarUsuario.jsp" class="btn btn-block">Agregar nuevo Usuario</a><br>
                        <a href="/coden_bugs/administracion/modificarUsuario.jsp" class="btn btn-block">Modificar Usuario existente</a><br>
                        <a href="/coden_bugs/administracion/verReportes.jsp" class="btn btn-block">Reportes</a><br>
                        <input type="submit" class="btn btn-block" value="Cerrar Sesión">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>