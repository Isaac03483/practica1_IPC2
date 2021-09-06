<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.objetos.fabrica.Pieza"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.operaciones.Obtencion"%>

<%
    List<Pieza> listaPiezas = (ArrayList<Pieza>) new Obtencion().getPiezasSeparadas();
%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="/coden_bugs/js/funcion.js"></script>
        <title>Coden_bugs</title>
    </head>

    <body>

        <div class="container col-lg-3">

            <form action="modificar-pieza-servlet">

                <div class="form-group">

                    <div class="form-group">
                        <center><strong><label>Modificar pieza existente</label></strong></center>

                        <div class="form-group">
                            <label>pieza a modificar:</label>
                            <select name="tipo_pieza" class="custom-select d-block w-100" id="selectpieza" required>

                                <%
                                    for(int i = 0; i < listaPiezas.size(); i++){
                                        out.print("<option value=\""+listaPiezas.get(i).getTipoPieza()+"#"+listaPiezas.get(i).getPrecio()+"\">"+listaPiezas.get(i).getTipoPieza()+" "+listaPiezas.get(i).getPrecio()+"</option>");
                                    }
                                %>
                            </select><br>
                        </div>
                        <input type="submit" class="btn btn-block" value="obtener información"><br><br>
                    </div>
                </div>
            </form>
                            
            <form method="post" action="modificar-pieza-servlet">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="textonombre" id="textonombre" value ="<%=request.getAttribute("nombre")%>" readonly required><br>
                </div>
                <div class="form-group">
                    <label>Unidades:</label>
                    <input type="number" name="textounidades" id="textounidades" min="1" value ="<%=request.getAttribute("unidades")%>" required><br>
                </div>
                <div class="form-group">
                    <label>Precio:</label>
                    <input type="number" name="textoprecio" id="textoprecio" min="1" step="any" value ="<%=request.getAttribute("precio")%>" required><br>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-block" value="Aplicar cambios">
                </div>

                <a href="/coden_bugs/fabrica/fabrica.jsp" class="btn btn-block">Volver</a>
            </form>
        </div>
        
    </body>
</html>