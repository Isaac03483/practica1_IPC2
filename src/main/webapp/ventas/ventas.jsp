<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="container col-lg-3">
            <form action="/coden_bugs/cerrar-sesion-servlet" method="post">
                <div class="form-group text-center">
                    <div class="form-group">
                        <label><strong>Bienvenido al área de ventas <%=request.getSession().getAttribute("user")%></strong></label><br><br>
                        
                        <a href="/coden_bugs/ventas/agregarVenta.jsp" class="btn btn-block">Agregar nueva venta</a><br>
                        <a href="/coden_bugs/ventas/agregarDevolucion.jsp" class="btn btn-block">Agregar nueva devolución</a><br>
                        <a href="/coden_bugs/ventas/consultaCompraCliente.jsp" class="btn btn-block">Consultar compras de cliente </a><br>
                        <a href="/coden_bugs/ventas/consultaDevolucion.jsp" class="btn btn-block">Consultar devoluciones de cliente</a><br>
                        <a href="/coden_bugs/ventas/consultaMueblesDisponibles.jsp" class="btn btn-block">Consultar Muebles Disponibles</a><br>
                        <a href="/coden_bugs/ventas/consultaVentasDia.jsp" class="btn btn-block">Consultar ventas del Día</a><br>
                        <input type="submit" class="btn btn-block" value="Cerrar Sesión">
                    </div>
                </div>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>