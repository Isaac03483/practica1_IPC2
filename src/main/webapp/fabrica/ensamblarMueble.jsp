<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%@page import="com.mycompany.objetos.fabrica.Mueble"%>

<%
    List<Mueble> listaMuebles = (ArrayList<Mueble>)new Obtencion().getMuebles();
%>
<html>

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        
        <title>Coden_bugs</title>

    <body>

        <div class="container col-lg-3">

            <form method="post" action="ensamblar-mueble-servlet">

                <div class="form-group">

                    <center><strong>Ensamblar Mueble</strong></center>
                    <div class="form-group">
                        <label>Nombre del Mueble</label>
                        <input type="text" name="nombreMueble" class="form-control" placeholder="Ingrese el nombre del Mueble" required>
                    </div>
                    <div class="form-group">
                        <label>Usuario que ensambla:</label>
                        <input type="text" name="txtusuario" class="form-control" placeholder="Ingrese el nombre del usuario" value="<%=request.getSession().getAttribute("user")%>" readonly required>
                    </div>
                    <input class="btn btn-block" type="submit" name="accion" value="Ingresar"><br>
                    <a href="/coden_bugs/fabrica/fabrica.jsp" class="btn btn-block">Volver</a>
                </div>
                
            </form>

            <br>
        </div>

        <div class ="container col-lg-3">
            <center><label><strong>Muebles disponibles para ensamble</strong></label></center><br>
            <table style="width:50%">
                <tr>
                    <th>Nombre del mueble</th>
                    <th>precio</th>
                </tr>
                <%
                    for(Mueble mueble: listaMuebles){
                        out.print("<tr>");
                        out.print("<td>"+mueble.getNombreMueble()+"</td>");
                        out.print("<td>"+mueble.getPrecio()+"</td>");
                        out.print("</tr>");
                    }
                %>
            </table>  
        </div>
              
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
    </body>
</html>