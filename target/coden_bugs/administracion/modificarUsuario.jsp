<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.baseDeDatos.Select"%>
<%@page import="com.mycompany.objetos.administracion.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    List<Usuario> listaUsuarios= (ArrayList<Usuario>) new Select().getUsuariosActivos();
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
            <form action="modificar-usuario-servlet" method="post">
                <div class="form-group">
                    <center><label><strong>Modificar Usuario existente</strong></label></center><br>
                    <div class="form-group">
                        <label>Seleccione al Usuario</label>
                        <select name="nombre_usuario" class="custom-select d-block w-100" id="nombre_usuario" required>

                            <%
                                for(int i = 0; i < listaUsuarios.size(); i++){
                                    out.print("<option value="+"\""+listaUsuarios.get(i).getNombreUsuario()+"\">"+listaUsuarios.get(i).getNombreUsuario()+"</option>");
                                }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Campos a modificar</label><br>
                        <label><input type="checkbox" name="cbox2" id="cbox2" value="0" onclick="habilitarInput(this)">Cambiar contraseña</label><br>
                        <label><input type="checkbox" name="cbox3" id="cbox3" value="0" onclick="habilitarSelect(this)">Cambiar Área de trabajo (cancelar usuario)</label><br>
                    
                        <div class="form-group">
                            <label>Contraseña Antigüa</label>
                            <input type="password" name="txtpass" id="textocontraAntigua" class="form-control" placeholder="Ingrese su contraseña" minlenght="8" disabled="disabled">
                        
                            <label>Contraseña nueva</label>
                            <input type="password" name="txtver1" id="textocontraNueva"  class="form-control" placeholder="Ingrese su nueva contraseña" minlenght="8" disabled="disabled">
                        
                            <label>Verificar Contraseña nueva</label>
                            <input type="password" name="txtver2" id="textocontraVerificacion" class="form-control" placeholder="Ingrese su contraseña nuevamente" minlenght="8" disabled="disabled">
                        
                            <label>Área de Trabajo</label>
                            <select name="tipo_usuario" id="area_usuario" class="custom-select d-block w-100" disabled="disabled" required>

                                <option value="Fábrica" selected>Fábrica</option>
                                <option value="punto de venta">punto de venta</option>
                                <option value="financiero">financiero</option>
                                <option value="cancelado">cancelado</option>
                            </select>
                        </div>
                    </div>

                    <input type="submit" class="btn btn-block" name ="agregar" value="Aplicar cambios"><br>
                    <a href="/coden_bugs/administracion/administracion.jsp" class="btn btn-block">Volver</a>
                </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>