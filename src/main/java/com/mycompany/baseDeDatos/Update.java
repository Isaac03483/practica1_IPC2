package com.mycompany.baseDeDatos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    
    private PreparedStatement query;
    
    public Update(){
        Conexion conexion = new Conexion();
    }

    public void updateEstadoMueble(com.mycompany.enums.EstadoMueble estado, String identificadorUnico){

        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.UPDATE_MUEBLE_ENSAMBLADO);
            query.setString(1, estado.getEstado());
            query.setString(2, identificadorUnico);
            query.executeUpdate();

        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void updateAumentarCantidad(int cantidad, String tipo_pieza, BigDecimal precio){
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.UPDATE_AUMENTAR_CANTIDAD);
            query.setInt(1, cantidad);
            query.setString(2, tipo_pieza);
            query.setBigDecimal(3, precio);
            query.executeUpdate();
        } catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateCantidadPiezas(int cantidad, String tipo_pieza, BigDecimal precio){
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.UPDATE_PIEZAS_AGOTADAS);
            query.setInt(1, cantidad);
            query.setString(2, tipo_pieza);
            query.setBigDecimal(3, precio);
            query.executeUpdate();
        } catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateTipoUsuario(com.mycompany.enums.TipoUsuario tipoUsuario, String nombreUsuario){
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.UPDATE_TIPO_USUARIO);
            query.setString(1, tipoUsuario.getArea());
            query.setString(2, nombreUsuario);
            query.executeUpdate();
        } catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateInformacionPieza(com.mycompany.objetos.fabrica.Pieza piezaAntigua, com.mycompany.objetos.fabrica.Pieza piezaNueva){
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.UPDATE_INFORMACION_PIEZAS);
            query.setString(1, piezaNueva.getTipoPieza());
            query.setBigDecimal(2, piezaNueva.getPrecio());
            query.setInt(3, piezaNueva.getCantidad());
            query.setString(4, piezaAntigua.getTipoPieza());
            query.setBigDecimal(5, piezaAntigua.getPrecio());
            query.setInt(6, piezaAntigua.getCantidad());
            query.executeUpdate();
        } catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
