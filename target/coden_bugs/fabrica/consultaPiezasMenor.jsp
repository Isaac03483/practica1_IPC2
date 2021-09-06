<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%@page import="com.mycompany.objetos.fabrica.Pieza"%>
<%@page import="com.mycompany.operaciones.Constante"%>

<%
    List<Pieza> listaPiezas = (ArrayList<Pieza>)new Obtencion().getPiezasOrdenadas(Constante.DESCENDENTE);
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

            <a href="/coden_bugs/fabrica/consultaPiezasMayor.jsp" class="btn btn-block">Ordenar de forma Ascendente</a><br>
            <a href="/coden_bugs/fabrica/fabrica.jsp" class="btn btn-block">Volver</a><br>
            <center><label>Lista de Piezas Orden: Descendente</label></center><br>
            <table class="table table-bordered" style="width:80%">

                <tr>
                    <th>Pieza</th>
                    <th>Cantidad</th>
                </tr>

                <%
                
                for(Pieza pieza: listaPiezas){

                    out.print("<tr>");
                    out.print("<td>"+pieza.getTipoPieza()+"</td>");
                    out.print("<td>"+pieza.getCantidad()+"</td>");
                    out.print("</tr>");
                }
                
                %>
            </table>
        </div>
    </body>
</html>