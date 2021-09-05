<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.objetos.ventas.MuebleEnsamblado"%>
<%@page import="com.mycompany.objetos.ventas.Caja"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%
    String fechaInicial = (String) request.getAttribute("fechaInicial");
    String fechaFinal = (String) request.getAttribute("fechaFinal");
    List<Caja> listaGanancias = (ArrayList<Caja>) new Obtencion().getReporteUsuarioGanancias(fechaInicial, fechaFinal);
    double gananciasTotales=0;

    for(Caja caja: listaGanancias){
        gananciasTotales += caja.getGanancia().doubleValue();
    }
    
    request.setAttribute("gananciasTotales", gananciasTotales);
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
            <form action="reporte-usuario-ganancias-servlet" method="post">
                <center><label><strong>Reporte del Usuario que Genera más Ganancias</strong></label></center><br>
                    <div class="form-group">
                        <label>Nombre del usuario:</label>
                        <input type="text" name="usuario" class="form-control" value="<%if(listaGanancias.size() > 0){%><%=listaGanancias.get(0).getUsuario()%><%}%>" readonly>
                    </div>
                    <div class="form-group">
                        <label>Ganancias Totales:</label>
                        <input type="text" name="ganancia" class="form-control" value="<%=gananciasTotales%>">
                    </div>
                <input type="submit" class="btn btn-block" value="Exportar (Formato CSV)">
            </form>
            <form action="reporte-usuario-ganancias-servlet">

                <div class="form-group">
                    <div class="form-group">
                        <label>Fecha inicial:</label>
                        <input type="date" name="fechainicial" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Fecha final:</label>
                        <input type="date" name="fechafinal" class="form-control">
                    </div>
                    <input type="submit" class="btn btn-block" value="Buscar"><br>
                    <a href="/coden_bugs/administracion/verReportes.jsp" class="btn btn-block">Volver</a>
                </div>

            </form>
            
        </div>

        <div class="container lateral">

            <table style="width:100%">

                <tr>
                    
                    <th>Registro de Ganancia</th>
                    <th>Nombre de usuario</th>
                    <th>Fecha de la Venta</th>
                    <th>Nombre del mueble</th>
                    <th>Ganancias</th>
                    
                </tr>
                <%
                
                    if(listaGanancias != null){
                        for(Caja ganancia: listaGanancias){
                                
                            out.print("<tr>");
                            out.print("<td>"+ganancia.getRegistro()+"</td>");
                            out.print("<td>"+ganancia.getUsuario()+"</td>");
                            out.print("<td>"+ganancia.getFechaRegistro()+"</td>");
                            out.print("<td>"+ganancia.getNombreMueble()+"</td>");
                            out.print("<td>"+ganancia.getGanancia()+"</td>");
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