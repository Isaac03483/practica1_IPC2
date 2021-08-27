<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Coden Bug's</title>
    </head>
    <body>

        <h1><center>Bienvenido a la carga de datos</center></h1>
        <br>
        <form method="post" action="carga-servlet">
            <label for="myfile">Seleccione el archivo a cargar:</label>
            <input type="file" id="myfile" name="myfile" size = "5">
            <input type="submit" value="Subir">
        </form>
        <br>
        <label><center><a href="index.jsp">Volver</a></center></label>
    </body>

</html>