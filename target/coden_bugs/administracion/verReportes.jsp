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

            <form>
                <div class="form-group text-center">
                    <label><strong>Reportes por fechas <%=request.getSession().getAttribute("user")%></strong></label><br><br>
                    <div class="form-group">
                        <a href="/coden_bugs/administracion/reporteVentas.jsp" class="btn btn-block">Reporte de ventas</a><br>
                        <a href="/coden_bugs/administracion/reporteMuebleVendido.jsp" class="btn btn-block">Reporte del mueble más vendido</a><br>
                        <a href="/coden_bugs/administracion/reporteDevoluciones.jsp" class="btn btn-block">Reporte de Devoluciones</a><br>
                        <a href="/coden_bugs/administracion/reporteGanancias.jsp" class="btn btn-block">Reporte de Ganancias</a><br>
                        <a href="/coden_bugs/administracion/reporteUsuarioGanancias.jsp" class="btn btn-block">Reporte de usuario que registra más Ganancias</a><br>
                        <a href="/coden_bugs/administracion/reporteUsuarioVentas.jsp" class="btn btn-block">Reporte de usuario que registra más Ventas</a><br>
                        <a href="/coden_bugs/administracion/administracion.jsp" class="btn btn-block">Volver</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>