package com.mycompany.operaciones;

public class Constante {
    
    public static final String USR = "root";
    public static final String PASSWORD = "L@luz1414";
    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/coden_bugs";
    public static final String ASCENDENTE = "ASC";
    public static final String DESCENTENTE = "DESC";
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
    public static final String INSERT_COMPRA = "INSERT INTO compra (nombre_usuario, identificador_mueble, nit, fecha_compra) VALUES (?,?,?,?)";
    public static final String INSERT_MUEBLE = "INSERT INTO mueble (nombre_mueble, precio) VALUES (?,?)";
    public static final String INSERT_MUEBLE_ENSAMBLADO = "INSERT INTO mueble_ensamblado (identificador_unico, nombre_mueble, usuario_ensamblo, fecha_ensamble, costo, estado) VALUES (?,?,?,?,?,?)";
    public static final String INSERT_PIEZA = "INSERT INTO pieza (tipo_pieza, precio, cantidad) VALUES (?,?,?)";
    public static final String INSERT_ENSAMBLE_PIEZA = "INSERT INTO ensamble_pieza (nombre_mueble, tipo_pieza, cantidad_pieza) VALUES (?,?,?)";
    public static final String INSERT_DEVOLUCION = "INSERT INTO devolucion (registro_devolucion, identificador_mueble, fecha_devolucion, perdida) VALUES (?,?,?,?)";
    public static final String INSERT_CAJA ="INSERT INTO caja (identificador_mueble, tipo_registro, ganancia, perdida) VALUES (?,?,?,?)";
    public static final String UPDATE_MUEBLE_ENSAMBLADO = "UPDATE mueble_ensamblado SET estado = ? WHERE identificador_unico = ?";
    public static final String UPDATE_CANTIDAD_PIEZAS = "UPDATE pieza SET cantidad = cantidad - ? WHERE tipo_pieza = ? AND precio = ?";
    public static final String UPDATE_PIEZAS_AGOTADAS = "UPDATE pieza SET cantidad = ? WHERE tipo_pieza = ? AND precio = ?";
    public static final String SELECT_PIEZAS_INDIVIDUALES = "SELECT * FROM pieza WHERE tipo_pieza = ? AND precio = ?";
    public static final String SELECT_PIEZAS = "SELECT tipo_pieza, SUM(cantidad) AS Cantidad FROM pieza GROUP BY tipo_pieza ORDER BY Cantidad ?";
    public static final String SELECT_MUEBLES_ENSAMBLADOS = "SELECT * FROM mueble_ensamblado ORDER BY fecha_ensamble ?";
    public static final String SELECT_PIEZAS_ACABANDOSE = "SELECT tipo_pieza, SUM(cantidad) as total FROM pieza GROUP BY tipo_pieza HAVING total < 15";
    public static final String SELECT_COMPRA_FECHA = "SELECT * FROM compra WHERE fecha_compra BETWEEN ? AND ?";
    public static final String SELECT_DEVOLUCION_FECHA = "SELECT * FROM devolucion WHERE fecha_devolucion BETWEEN ? AND ?";
    public static final String SELECT_MUEBLE_DISPONIBLE = "SELECT * FROM mueble_ensamblado WHERE estado = ?";
    public static final String SELECT_DETALLES_COMPRA = "SELECT * FROM compra WHERE nit = ?";
    public static final String SELECT_VENTAS_DEL_DIA = "SELECT * FROM compra WHERE fecha_compra = CURDATE()";
    public static final String SELECT_CLIENTE = "SELECT * FROM cliente WHERE nit =?";
    public static final String DELETE_PIEZAS_AGOTADAS = "DELETE FROM pieza WHERE tipo_pieza = ? AND cantidad = 0";
}
