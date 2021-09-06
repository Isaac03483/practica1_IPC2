<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>
        <div class="container col-lg-3">

            <form action="agregar-devolucion-servlet">
                <div class="form-group">
                    <center><label><strong>Ingreso de Devolución</strong></label></center>

                    <div class="form-group">
                        <label>Ingrese número de Compra:</label>
                        <input type="text" name="numero_compra" required>
                    </div>

                    <input type="submit" class="btn btn-block" value="Buscar Información">
                </div>
            </form>

            <form action="agregar-devolucion-servlet" method="post">
                <div class="form-group">
                    <div class="form-group">
                        <label>Identificador del Mueble:</label>
                        <input type="text" class="form-control" value="<%=request.getAttribute("identificadorUnico")%>" readonly required>
                    </div>
                    <div class="form-group">
                        <label>Fecha:</label>
                        <input type="date" class="form-control" value="<%=request.getAttribute("fechaCompra")%>" readonly required>
                    </div>
                    <div class="form-group">
                        <label>Total:</label>
                        <input type="text" class="form-control" value="<%=request.getAttribute("total")%>" readonly required>
                    </div>
                </div>
                <input type="submit" class="btn btn-block" value="Agregar Devolución">
            </form>
            <br>
            <a href="/coden_bugs/ventas/ventas.jsp" class="btn btn-block">Volver</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>