<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="/coden_bugs/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>

    <body>

        <div class="container col-log-3">
            <form method="post" action="agregar-pieza-servlet">
                <div class="form-group">
                    <center><strong>Ingreso de Piezas</strong></center>
                
                    <div class="form-group">
                        <label>Nombre de la pieza:</label>
                        <input class="form-control" type="text" name="txtnombre" placeholder="Ingrese Nombre" required>
                    </div>
                    <div class="form-group">
                        <label>Precio:</label>
                        <input type="number" name="txtprecio" step="any" class="form-control" required>

                    </div>
                    <div class="form-group">
                        <label>Unidades:</label>
                        <input type="number" name="txtunidades" class="form-control" required>
                    </div>
                    <input class="btn btn-block" type="submit" name="accion" value="Agregar"><br>
                    <a href="/coden_bugs/fabrica/fabrica.jsp" class="btn btn-block">Volver</a>
                </div>
                
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>