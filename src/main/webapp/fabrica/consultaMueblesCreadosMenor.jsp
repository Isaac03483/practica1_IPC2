<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%@page import="com.mycompany.objetos.ventas.MuebleEnsamblado"%>
<%@page import="com.mycompany.operaciones.Constante"%>

<%
    List<MuebleEnsamblado> listaMuebles = (ArrayList<MuebleEnsamblado>)new Obtencion().getMueblesCreados(Constante.DESCENDENTE);
%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="container">

            <div id="lateral txt-center">
            
                <a href="/coden_bugs/fabrica/consultaMueblesCreadosMayor.jsp" class="btn btn-block">Ordenar de forma Ascendente</a><br>
                <a href="/coden_bugs/fabrica/fabrica.jsp" class="btn btn-block">Volver</a><br>
                <center><label>Lista de Muebles creados Orden: Descendente</label></center><br>

                <table class="table table-bordered" style="width:100%">

                    <tr>
                        <th>Identificador Unico</th>
                        <th>Nombre del mueble</th>
                        <th>Usuario que ensamblo</th>
                        <th>Fecha de ensamble</th>
                        <th>Costo</th>
                        <th>Estado</th>
                    </tr>

                    <%
                    
                        for(MuebleEnsamblado mueble: listaMuebles){

                            out.print("<tr>");
                            out.print("<td>"+mueble.getIdentificadorUnico()+"</td>");
                            out.print("<td>"+mueble.getMuebleEnsamblar()+"</td>");
                            out.print("<td>"+mueble.getUsuarioEnsamblo()+"</td>");
                            out.print("<td>"+mueble.getFechaEnsamble()+"</td>");
                            out.print("<td>"+mueble.getCosto()+"</td>");
                            out.print("<td>"+mueble.getEstadoMueble()+"</td>");
                            out.print("</tr>");
                        }
                    
                    %>
                </table>
            </div>
        </div>
        
    </body>
</html>