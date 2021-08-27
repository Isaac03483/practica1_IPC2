package com.mycompany.baseDeDatos;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    
    private PreparedStatement query;

    public Select(){
        Conexion conexion = new Conexion();
    }

    public ResultSet selectMueblesDisponibles(String ensamblado){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_DISPONIBLE);
            query.setString(1, ensamblado);
            resultado = query.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectTodosMuebles(String orden){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES_ENSAMBLADOS);
            query.setString(1, orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }
    
    public ResultSet selectCantidadPiezas(String orden){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS);
            query.setString(1, orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectPiezasPorAcabar(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_ACABANDOSE);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCompras(Date fechaInicial, Date fechaFinal){

        return null;
    }

    public ResultSet selectPiezasIndividuales(String tipoPieza, BigDecimal precio){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_INDIVIDUALES);
            query.setString(1, tipoPieza);
            query.setBigDecimal(2, precio);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectEnsamblePiezas(String nombre_mueble){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_ENSAMBLE_PIEZAS);
            query.setString(1, nombre_mueble);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    
    }

    public ResultSet selectPiezasParaEnsamble(String tipo_pieza){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_PARA_ENSAMBLE);
            query.setString(1, tipo_pieza);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCantidadTotalPiezas(int cantidadPiezas){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CANTIDAD_PIEZAS);
            query.setInt(1, cantidadPiezas);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectUsuario(String usuario){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_USUARIO);
            query.setString(1, usuario);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }
}
