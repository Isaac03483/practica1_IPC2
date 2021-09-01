<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    List<String> errores = (ArrayList<String>) request.getAttribute("errores");
%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="Container lateral">
            <center><label><strong>Errores al cargar Archivo</strong></label></center><br>
            <%
                for(String error: errores){
                    out.print("<label>"+error+"</label>");
                }
            %>

            <a href="/coden_bugs/index.jsp" class="btn btn-block">Volver al Inicio de sesión</a>
            <a href="/coden_bugs/cargaDatos.jsp" class="btn btn-block">Vovler al menú de Carga de datos</a>
        </div> 
    </body>
</html>