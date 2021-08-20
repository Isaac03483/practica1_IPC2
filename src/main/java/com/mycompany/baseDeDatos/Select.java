package com.mycompany.baseDeDatos;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    
    private Connection conexion;
    private PreparedStatement query;

    public Select(Connection conexion){
        this.conexion = conexion;
    }

    public ResultSet selectMueblesDisponibles(String ensamblado){

        ResultSet resultado = null;
        try {
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_DISPONIBLE);
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
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES_ENSAMBLADOS);
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
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS);
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
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_ACABANDOSE);
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
}
