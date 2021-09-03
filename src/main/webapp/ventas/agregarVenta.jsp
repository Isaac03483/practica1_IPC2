<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.objetos.ventas.MuebleEnsamblado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>

<%
    List<MuebleEnsamblado> listaMuebles = (ArrayList<MuebleEnsamblado>) new Obtencion().getMueblesDisponibles("ensamblado");
%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="container col-lg-3">
            <form action="agregar-venta-servlet">
                <div class="form-group">
                    <center><label><strong>Agregar Nueva Venta</strong></label></center>

                    <div class="form-group">
                        <label>Usuario que registra la venta:</label>
                        <input type="text" class="form-control" name="txtuser" value ="<%=request.getSession().getAttribute("user")%>" readonly required>
                    </div>

                    <div class="form-group">
                        <label>Identificador del Mueble:</label>
                        <select name="idmueble" class="custom-select d-block w-100" id="idmueble" required>

                            <%
                                for(MuebleEnsamblado mueble: listaMuebles){
                                    out.print("<option value="+"\""+mueble.getIdentificadorUnico()+"\">"+mueble.getIdentificadorUnico()+"</option>");
                                }
                            %>
                        </select><br>
                    </div>

                    <div class="form-group">
                        <label>Nit:</label>
                        <input type="text" class="form-control" name="txtnit" placehole="ingrese Nit" required>
                    </div>

                    <input type="submit" class="btn btn-block" value="Buscar información">
                </div>
            </form>
            <form method="post" action="agregar-venta-servlet">
                <div class="form-group">
                    <label>Nit:</label>
                    <input type="text" class="form-control" name="nitcon" value ="<%=request.getAttribute("nit")%>" readonly required>
                </div>
                <div class="form-group">
                    <label>Nombre Cliente:</label>
                    <input type="text" class="form-control" name="txtnombre" value ="<%=request.getAttribute("nombre")%>" >
                </div>
                <div class="form-group">
                    <label>Dirección:</label>
                    <input type="text" class="form-control" name="txtdir" value ="<%=request.getAttribute("direccion")%>">
                </div>
                <div class="form-group">
                    <label>Departamento:</label>
                    <input type="text" class="form-control" name="txtdep" value ="<%=request.getAttribute("departamento")%>">
                </div>
                <div class="form-group">
                    <label>Municipio:</label>
                    <input type="text" class="form-control" name="txtmun" value ="<%=request.getAttribute("municipio")%>">
                </div>
                <div class="form-group">
                    <label>Costo:</label>
                    <input type="number" class="form-control" name="txtcosto" step="any" value ="<%=request.getAttribute("costo")%>" readonly required>
                </div>
                <input type="submit" class="btn btn-block" value="Agregar Compra">
                <a href="/coden_bugs/ventas/ventas.jsp" class="btn btn-block">Volver</a>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>