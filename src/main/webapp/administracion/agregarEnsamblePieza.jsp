<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>
<%@page import="com.mycompany.objetos.fabrica.Mueble"%>
<%@page import="com.mycompany.objetos.fabrica.Pieza"%>

<%
    List<Mueble> listaMuebles = (ArrayList<Mueble>)new Obtencion().getMuebles();
    List<Pieza> listaPiezas = (ArrayList<Pieza>) new Obtencion().getPiezasSeparadas();

%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <div class="container col-lg-3">

            <form method="post" action="agregar-ensamble-pieza-servlet">
                <div class="form-group">
                    <center><label><strong>Ingreso de piezas necesarias para el ensamble del mueble.</strong><label></center>
                
                    <div class="form-group">
                        <label>Nombre del Mueble:</label>
                        <select name="nombreMueble" class="custom-select d-block w-100" id="selectpieza" required>

                            <%
                                for(int i = 0; i < listaMuebles.size(); i++){
                                    
                                    out.print("<option value=\""+listaMuebles.get(i).getNombreMueble()+"\">"+listaMuebles.get(i).getNombreMueble()+"</option>");

                                    
                                }
                            %>
                        </select><br>
                    </div>
                    <div class="form-group">
                        <label>Nombre de la Pieza:</label>
                        <select name="tipo_pieza" class="custom-select d-block w-100" id="selectpieza" required>

                            <%
                                for(int i = 0; i < listaPiezas.size(); i++){
                                    
                                    out.print("<option value=\""+listaPiezas.get(i).getTipoPieza()+"\">"+listaPiezas.get(i).getTipoPieza()+"</option>");
                                    
                                }
                            %>
                        </select><br>

                    </div>
                    <div class="form-group">
                        <label>Cantidad:</label>
                        <input type="number" class="form-control" name="cantidad" min="1" required>
                    </div>
                    <input class="btn btn-block" type="submit" name="accion" value="Agregar"><br>
                    <a href="/coden_bugs/administracion/administracion.jsp" class="btn btn-block">Volver</a>
                </div>
                
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>