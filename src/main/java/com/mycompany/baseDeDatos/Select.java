package com.mycompany.baseDeDatos;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;


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

    public ResultSet selectTodosMueblesEnsamblados(String orden){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES_ENSAMBLADOS+orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }
    
    public ResultSet selectCantidadPiezasOrdenadas(String orden){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_ORDENADAS+orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch blockquery.setString(1, orden);
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

    public ResultSet selectComprasDia(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_VENTAS_DEL_DIA);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCompras(String nit, String fechaInicial, String fechaFinal){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_COMPRAS_CLIENTE);
            query.setString(1, nit);
            query.setString(2, fechaInicial);
            query.setString(3, fechaFinal);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectDevoluciones(String nit, String fechaInicial, String fechaFinal){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_DEVOLUCION_FECHA);
            query.setString(1, nit);
            query.setString(2, fechaInicial);
            query.setString(3, fechaFinal);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCompra(int numeroCompra){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_COMPRA);
            query.setInt(1, numeroCompra);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
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

    public ResultSet selectMueble(String nombre_mueble){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE);
            query.setString(1, nombre_mueble);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    
    }

    public ResultSet selectPiezas(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS);
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

    public ResultSet selectUsuariosActivos(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_USUARIOS_ACTIVOS);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCliente(String nit){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CLIENTE);
            query.setString(1,nit);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectClientes(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CLIENTES);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectMuebleSeleccionado(String id){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_SELECCIONADO);
            query.setString(1, id);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectMueblesAll(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectReporteVentas(String fechaInicial, String fechaFinal){
        ResultSet resultado = null;
        System.out.println(fechaInicial+" "+fechaFinal);
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_VENTAS);
                query.setString(1, fechaInicial);
                query.setString(2, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_VENTAS_GENERAL);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }
    
    public ResultSet selectReporteDevolucion(String fechaInicial, String fechaFinal){
        ResultSet resultado = null;
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_DEVOLUCION);
                query.setString(1, fechaInicial);
                query.setString(2, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_DEVOLUCION_GENERAL);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }

    public ResultSet selectReporteGanancia(String fechaInicial, String fechaFinal){
        ResultSet resultado = null;
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_GANANCIAS);
                query.setString(1, fechaInicial);
                query.setString(2, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_GANANCIAS_GENERAL);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }

    public ResultSet selectReporteUsuarioGanancias(String fechaInicial, String fechaFinal){
        ResultSet resultado = null;
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_USUARIO_GANANCIAS);
                query.setString(1, fechaInicial);
                query.setString(2, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_USUARIO_GANANCIAS_GENERAL);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }

    public ResultSet selectReporteUsuarioVentas(String fechaInicial, String fechaFinal){
        ResultSet resultado = null;
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_USUARIO_VENTAS);
                query.setString(1, fechaInicial);
                query.setString(2, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_REPORTE_USUARIO_VENTAS_GENERAL);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }


    public ResultSet selectMuebleMasVendido(){
        ResultSet resultado = null;
        try {
            
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_MAS_VENDIDO);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }

    public ResultSet selectFacturaMuebleMasV(String nombreMueble, String fechaInicial, String fechaFinal){

        ResultSet resultado = null;
        try {
            if(fechaFinal !=null && fechaInicial != null){
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_FACTURA_MUEBLE_MAS_VENDIDO);
                query.setString(1, nombreMueble);
                query.setString(2, fechaInicial);
                query.setString(3, fechaFinal);
            } else {
                query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_FACTURA_MUEBLE_MAS_VENDIDO_GENERAL);
                query.setString(1, nombreMueble);
            }
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  resultado;
    }
}
