<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.baseDeDatos.Select"%>
<%@page import="com.mycompany.objetos.ventas.MuebleEnsamblado"%>
<%@page import="com.mycompany.enums.EstadoMueble"%>

<%
    List<MuebleEnsamblado> listaMuebles = (ArrayList<MuebleEnsamblado>)new Select().getMueblesDisponibles(EstadoMueble.ENSAMBLADO.getEstado());
%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>
        <div class="container lateral">

            <table style="width:100%">
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
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>