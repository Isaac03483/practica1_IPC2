package com.mycompany.baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Insert {

    private Connection conexion;
    private PreparedStatement query;

    public Insert(Connection conexion) {
        this.conexion = conexion;
    }

    protected void insertarCliente(com.mycompany.objetos.ventas.Cliente cliente){

        try {

            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_CLIENTE);
            query.setString(1, cliente.getNit());
            query.setString(2, cliente.getNombre());
            query.setString(3, cliente.getDireccion());
            query.setString(4, cliente.getMunicipio());
            query.setString(5, cliente.getDepartamento());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected void insertarUsuario(com.mycompany.objetos.administracion.Usuario usuario) {

        try {

            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_USUARIO);
            query.setString(1, usuario.getNombreUsuario());
            query.setString(2, usuario.getPassword());
            query.setString(3, usuario.getTipoUsuario().getArea());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected void insertarCompra(com.mycompany.objetos.ventas.Compra compra) {

        try {
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_COMPRA);
            query.setString(1, compra.getNombreUsuario());
            query.setString(2, compra.getIdentificadorMueble());
            query.setString(3, compra.getNit());
            query.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(compra.getFecha())));
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    protected void insertarMueble(com.mycompany.objetos.fabrica.Mueble mueble) {

        try {
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_MUEBLE);
            query.setString(1, mueble.getNombreMueble());
            query.setBigDecimal(2, mueble.getPrecio());
            query.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    protected void insertarMuebleEnsamblado(com.mycompany.objetos.ventas.MuebleEnsamblado muebleE) {

        try {
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_MUEBLE_ENSAMBLADO);
            query.setString(1, muebleE.getIdentificadorUnico());
            query.setString(2, muebleE.getMuebleEnsamblar());
            query.setString(3, muebleE.getUsuarioEnsamblo());
            query.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(muebleE.getFechaEnsamble())));
            query.setBigDecimal(5, muebleE.getCosto());
            query.setString(6, muebleE.getEstadoMueble().getEstado());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void insertarPieza(com.mycompany.objetos.fabrica.Pieza pieza) {

        try {

            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_PIEZA);
            query.setString(1, pieza.getTipoPieza());
            query.setBigDecimal(2, pieza.getPrecio());
            query.setInt(3, pieza.getCantidad());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected void insertarEnsamble(com.mycompany.objetos.fabrica.EnsamblePieza ensamble) {

        try {

            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_ENSAMBLE_PIEZA);
            query.setString(1, ensamble.getNombreMueble());
            query.setString(2, ensamble.getTipoPieza());
            query.setInt(3, ensamble.getCantidadPieza());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected void insertarDevolucion(com.mycompany.objetos.ventas.Devolucion devolucion) {

        try {
            query = conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_DEVOLUCION);
            query.setInt(1, devolucion.getRegistroDevolucion());
            query.setString(2, devolucion.getIdentificadorMueble());
            query.setDate(3, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(devolucion.getFecha())));
            query.setBigDecimal(4, devolucion.getPerdida());
            query.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
