<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.objetos.ventas.Caja"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%
    String fechaInicial = (String) request.getAttribute("fechaInicial");
    String fechaFinal = (String) request.getAttribute("fechaFinal");
    List<Caja> listaCaja = (ArrayList<Caja>) new Obtencion().getReporteGanancia(fechaInicial, fechaFinal);

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
            <form action="reporte-ganancias-servlet">

                <div class="form-group">
                    <center><label><strong>Reporte de Ganancias</strong></label></center><br>
                    <div class="form-group">
                        <label>Fecha inicial:</label>
                        <input type="date" class="form-control" value="<%=fechaInicial%>" name="fechainicial">
                    </div>
                    <div class="form-group">
                        <label>Fecha final:</label>
                        <input type="date" class="form-control" value="<%=fechaFinal%>" name="fechafinal">
                    </div>
                    <input type="submit" class="btn btn-block" value="Buscar"><br>
                    <a href="/coden_bugs/administracion/verReportes.jsp" class="btn btn-block">Volver</a>
                </div>

            </form>
            <form action="reporte-ganancias-servlet" method="post">
                <input type="submit" class="btn btn-block" value="Exportar (Formato CSV)">
            </form>
        </div>

        <div class="container lateral">

            <table class="table table-bordered"style="width:100%">

                <tr>
                    <th>Registro</th>
                    <th>Nombre del usuario</th>
                    <th>Identificador del Mueble</th>
                    <th>Fecha del registro</th>
                    <th>Ganancia</th>
                </tr>
                <%
                
                    if(listaCaja != null){
                        for(Caja caja: listaCaja){
                                
                            out.print("<tr>");
                            out.print("<td>"+caja.getRegistro()+"</td>");
                            out.print("<td>"+caja.getUsuario()+"</td>");
                            out.print("<td>"+caja.getIdentificador()+"</td>");
                            out.print("<td>"+caja.getFechaRegistro()+"</td>");
                            out.print("<td>"+caja.getGanancia()+"</td>");
                            out.print("</tr>");
                        }
                    }
                
                %>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>