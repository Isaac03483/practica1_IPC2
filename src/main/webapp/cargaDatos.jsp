<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Coden_bugs</title>
    </head>
    <body>

        <div class="container col-lg-3">

            <form method="post" action="carga-servlet">

                <div class="form-group text-center">
                    <h1>Bienvenido a la carga de datos</h1><br>
                    <label for="myfile">Seleccione el archivo a cargar:</label><br>
                    <input type="file" id="myfile" name="myfile" size = "5" required><br><br>
                    <input type="submit" value="Subir" class="btn btn-block"><br>
                    <a href="/coden_bugs/index.jsp" class="btn btn-block">Volver</a>
                </div>
        </form>
        </div>
        
    </body>

</html>