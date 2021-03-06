package com.mycompany.operaciones;

public class Constante {
    
    /**
     * Clase que contiene todas las constantes.
     */
    
    public static final String USR = "usuario";
    public static final String PASSWORD = "ConTr@.34";
    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/coden_bugs";
    public static final String ASCENDENTE = "ASC";
    public static final String DESCENDENTE = "DESC";
    public static final String FORMATO_FECHA_CARGA ="dd/mm/yyyy";
    public static final String FORMATO_FECHA_SQL = "yyyy-MM-dd";
    public static final String USUARIO = "USUARIO";
    public static final String PIEZA = "PIEZA";
    public static final String MUEBLE = "MUEBLE";
    public static final String ENSAMBLE_PIEZAS = "ENSAMBLE_PIEZAS";
    public static final String ENSAMBLAR_MUEBLE ="ENSAMBLAR_MUEBLE";
    public static final String CLIENTE = "CLIENTE";
    public static final String INSERT_CLIENTE = "INSERT INTO cliente (nit, nombre, direccion, municipio, departamento) VALUES (?,?,?,?,?)";
    public static final String INSERT_USUARIO = "INSERT INTO usuario (nombre_usuario, password, tipo) VALUES (?,?,?)";
    public static final String INSERT_COMPRA = "INSERT INTO compra (nombre_usuario, identificador_mueble, nit, fecha_compra, total) VALUES (?,?,?,?,?)";
    public static final String INSERT_MUEBLE = "INSERT INTO mueble (nombre_mueble, precio) VALUES (?,?)";
    public static final String INSERT_MUEBLE_ENSAMBLADO = "INSERT INTO mueble_ensamblado (identificador_unico, nombre_mueble, usuario_ensamblo, fecha_ensamble, costo, estado) VALUES (?,?,?,?,?,?)";
    public static final String INSERT_PIEZA = "INSERT INTO pieza (tipo_pieza, precio, cantidad) VALUES (?,?,?)";
    public static final String INSERT_ENSAMBLE_PIEZA = "INSERT INTO ensamble_pieza (nombre_mueble, tipo_pieza, cantidad_pieza) VALUES (?,?,?)";
    public static final String INSERT_DEVOLUCION = "INSERT INTO devolucion (registro_devolucion, identificador_mueble, fecha_devolucion, perdida, nit) VALUES (?,?,?,?,?)";
    public static final String INSERT_CAJA ="INSERT INTO caja (identificador_mueble, nombre_usuario, tipo_registro, ganancia, perdida, fecha_registro) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_MUEBLE_ENSAMBLADO = "UPDATE mueble_ensamblado SET estado = ? WHERE identificador_unico = ?";
    public static final String UPDATE_CANTIDAD_PIEZAS = "UPDATE pieza SET cantidad = cantidad - ? WHERE tipo_pieza = ? AND precio = ?";
    public static final String UPDATE_AUMENTAR_CANTIDAD = "UPDATE pieza SET cantidad = cantidad + ? WHERE tipo_pieza = ? AND precio = ?";
    public static final String UPDATE_INFORMACION_PIEZAS = "UPDATE pieza SET tipo_pieza= ?, precio = ?, cantidad = ? WHERE tipo_pieza = ? AND precio = ? AND cantidad = ?";
    public static final String UPDATE_INFORMACION_CLIENTE = "UPDATE cliente SET nombre = ?, direccion = ?, departamento =?, municipio=? WHERE nit =?";
    public static final String UPDATE_PIEZAS_AGOTADAS = "UPDATE pieza SET cantidad = ? WHERE tipo_pieza = ? AND precio = ?";
    public static final String UPDATE_TIPO_USUARIO = "UPDATE usuario SET tipo = ? WHERE nombre_usuario = ?";
    public static final String UPDATE_PASSWORD_USUARIO = "UPDATE usuario SET password =? WHERE nombre_usuario =? AND password=?";
    public static final String SELECT_PIEZAS_INDIVIDUALES = "SELECT * FROM pieza WHERE tipo_pieza = ? AND precio = ?";
    public static final String SELECT_PIEZAS_PARA_ENSAMBLE = "SELECT * FROM pieza WHERE tipo_pieza = ?";
    public static final String SELECT_PIEZAS_ORDENADAS = "SELECT tipo_pieza, SUM(cantidad) AS Cantidad FROM pieza GROUP BY tipo_pieza ORDER BY Cantidad ";
    public static final String SELECT_ENSAMBLE_PIEZAS = "SELECT nombre_mueble, tipo_pieza, cantidad_pieza FROM ensamble_pieza WHERE nombre_mueble = ?";
    public static final String SELECT_MUEBLES_ENSAMBLADOS = "SELECT * FROM mueble_ensamblado ORDER BY fecha_ensamble ";
    public static final String SELECT_MUEBLE_SELECCIONADO = "SELECT * FROM mueble_ensamblado WHERE identificador_unico= ?";
    public static final String SELECT_MUEBLES="SELECT * FROM mueble";
    public static final String SELECT_MUEBLE = "SELECT * FROM mueble WHERE nombre_mueble=?";
    public static final String SELECT_PIEZAS="SELECT * FROM pieza WHERE cantidad > 0";
    public static final String SELECT_CLIENTES = "SELECT * FROM cliente";
    public static final String SELECT_PIEZAS_ACABANDOSE = "SELECT tipo_pieza, SUM(cantidad) as total FROM pieza GROUP BY tipo_pieza HAVING total < 15";
    public static final String SELECT_CANTIDAD_PIEZAS = "SELECT SUM(cantidad) as total FROM pieza GROUP BY tipo_pieza HAVING total >= ?";
    public static final String SELECT_COMPRA_FECHA = "SELECT * FROM compra WHERE nit = ? AND fecha_compra BETWEEN ? AND ?";
    public static final String SELECT_COMPRAS_CLIENTE = "SELECT * FROM compra WHERE nit = ? AND fecha_compra BETWEEN ? AND ?";
    public static final String SELECT_COMPRA= "SELECT * FROM compra WHERE registro_compra =?";
    public static final String SELECT_DEVOLUCION_FECHA = "SELECT * FROM devolucion WHERE nit=? AND fecha_devolucion BETWEEN ? AND ?";
    public static final String SELECT_MUEBLE_DISPONIBLE = "SELECT * FROM mueble_ensamblado WHERE estado = ?";
    public static final String SELECT_DETALLES_COMPRA = "SELECT * FROM compra WHERE nit = ?";
    public static final String SELECT_VENTAS_DEL_DIA = "SELECT * FROM compra WHERE fecha_compra = CURDATE()";
    public static final String SELECT_REPORTE_VENTAS = "SELECT * FROM compra WHERE fecha_compra BETWEEN ? AND ?";
    public static final String SELECT_REPORTE_VENTAS_GENERAL = "SELECT * FROM compra";
    public static final String SELECT_REPORTE_DEVOLUCION = "SELECT * FROM devolucion WHERE fecha_devolucion BETWEEN ? AND ?";
    public static final String SELECT_REPORTE_DEVOLUCION_GENERAL = "SELECT * FROM devolucion";
    public static final String SELECT_REPORTE_GANANCIAS = "SELECT nombre_usuario, registro_caja, fecha_registro, ganancia , identificador_mueble FROM caja WHERE tipo_registro = 'ganancia' AND fecha_registro BETWEEN ? AND ?";
    public static final String SELECT_REPORTE_GANANCIAS_GENERAL = "SELECT nombre_usuario, registro_caja, fecha_registro, ganancia , identificador_mueble FROM caja WHERE tipo_registro = 'ganancia'";
    public static final String SELECT_REPORTE_USUARIO_VENTAS_GENERAL  = "SELECT compra.registro_compra, compra.nombre_usuario, mueble_ensamblado.nombre_mueble, compra.total, compra.fecha_compra FROM compra INNER JOIN mueble_ensamblado WHERE compra.identificador_mueble = mueble_ensamblado.identificador_unico  AND compra.nombre_usuario = (SELECT nombre_usuario FROM compra GROUP BY nombre_usuario ORDER BY COUNT(nombre_usuario) DESC LIMIT 1)";
    public static final String SELECT_REPORTE_USUARIO_VENTAS = "SELECT compra.registro_compra, compra.nombre_usuario, mueble_ensamblado.nombre_mueble, compra.total, compra.fecha_compra FROM compra INNER JOIN mueble_ensamblado WHERE compra.identificador_mueble = mueble_ensamblado.identificador_unico AND compra.fecha_compra BETWEEN ? AND ? AND compra.nombre_usuario = (SELECT nombre_usuario FROM compra GROUP BY nombre_usuario ORDER BY COUNT(nombre_usuario) DESC LIMIT 1)";
    public static final String SELECT_REPORTE_USUARIO_GANANCIAS = "SELECT caja.registro_caja, caja.nombre_usuario, mueble_ensamblado.nombre_mueble, caja.ganancia, caja.fecha_registro FROM caja INNER JOIN mueble_ensamblado WHERE caja.identificador_mueble = mueble_ensamblado.identificador_unico AND caja.fecha_registro BETWEEN ? AND ? AND caja.tipo_registro = 'ganancia' AND caja.nombre_usuario = (SELECT nombre_usuario FROM caja GROUP BY nombre_usuario ORDER BY COUNT(nombre_usuario) DESC LIMIT 1)";
    public static final String SELECT_REPORTE_USUARIO_GANANCIAS_GENERAL = "SELECT caja.registro_caja, caja.nombre_usuario, mueble_ensamblado.nombre_mueble, caja.ganancia, caja.fecha_registro FROM caja INNER JOIN mueble_ensamblado WHERE caja.identificador_mueble = mueble_ensamblado.identificador_unico AND caja.tipo_registro = 'ganancia' AND caja.nombre_usuario = (SELECT nombre_usuario FROM caja GROUP BY nombre_usuario ORDER BY COUNT(nombre_usuario) DESC LIMIT 1)";
    public static final String SELECT_MUEBLE_MAS_VENDIDO = "SELECT nombre_mueble, COUNT(nombre_mueble) AS cantidad from mueble_ensamblado WHERE estado='vendido' GROUP BY nombre_mueble ORDER BY cantidad DESC LIMIT 1";
    public static final String SELECT_MUEBLE_MENOS_VENDIDO = "SELECT nombre_mueble, COUNT(nombre_mueble) AS cantidad from mueble_ensamblado WHERE estado='vendido' GROUP BY nombre_mueble ORDER BY cantidad ASC LIMIT 1";
    public static final String SELECT_FACTURA_MUEBLE_VENDIDO= "SELECT compra.registro_compra, compra.nombre_usuario, compra.identificador_mueble, compra.nit, compra.fecha_compra, compra.total FROM compra INNER JOIN mueble_ensamblado WHERE compra.identificador_mueble = mueble_ensamblado.identificador_unico AND mueble_ensamblado.estado='vendido' AND mueble_ensamblado.nombre_mueble = ? AND compra.fecha_compra BETWEEN ? AND ?";
    public static final String SELECT_FACTURA_MUEBLE_VENDIDO_GENERAL= "SELECT compra.registro_compra, compra.nombre_usuario, compra.identificador_mueble, compra.nit, compra.fecha_compra, compra.total FROM compra INNER JOIN mueble_ensamblado WHERE compra.identificador_mueble = mueble_ensamblado.identificador_unico AND mueble_ensamblado.estado='vendido' AND mueble_ensamblado.nombre_mueble = ?";
    public static final String SELECT_CLIENTE = "SELECT * FROM cliente WHERE nit =?";
    public static final String SELECT_USUARIO = "SELECT password, tipo FROM usuario WHERE nombre_usuario =?";
    public static final String SELECT_USUARIOS_ACTIVOS = "SELECT * FROM usuario WHERE tipo != 'cancelado'";
    public static final String DELETE_PIEZAS_AGOTADAS = "DELETE FROM pieza WHERE tipo_pieza = ? AND cantidad = 0";
    
}
