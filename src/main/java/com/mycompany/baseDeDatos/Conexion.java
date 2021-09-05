package com.mycompany.baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.objetos.fabrica.EnsamblePieza;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.fabrica.Pieza;
import com.mycompany.objetos.ventas.Caja;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.Devolucion;
import com.mycompany.objetos.ventas.MuebleEnsamblado;

public class Conexion {

    
    protected static Connection conexion=null;

    public Conexion(){
        conectar();
        conectar();
    }

    public void conectar(){

        try {

            if(conexion != null){
                System.out.println("Conexión aún vigente.");
            } else if(conexion == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(com.mycompany.operaciones.Constante.URL_MYSQL, com.mycompany.operaciones.Constante.USR, com.mycompany.operaciones.Constante.PASSWORD);

                System.out.println("Conexión establecida.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void desconectar(){

        conexion = null;

        if(conexion != null){
            System.out.println("Error al desconectar la conexión a la base de datos.");
        } else {
            System.out.println("Se ha desconectado la conexión a la base de datos.");
        }

    }

    /**
     * s
     * @param objeto
     * @throws SQLException
     */
    public static void insertar(Object objeto) throws SQLException{

        Insert insert = new Insert();

            if(objeto instanceof Cliente){
                insert.insertarCliente((Cliente) objeto);
            } else if(objeto instanceof Usuario){
                insert.insertarUsuario((Usuario) objeto);
            } else if (objeto instanceof EnsamblePieza){
                insert.insertarEnsamble((EnsamblePieza) objeto);
            } else if (objeto instanceof Mueble){
                insert.insertarMueble((Mueble) objeto);
            } else if (objeto instanceof Pieza){
                insert.insertarPieza((Pieza) objeto);
            } else if(objeto instanceof Compra){
                insert.insertarCompra((Compra) objeto);
            } else if(objeto instanceof Devolucion){
                insert.insertarDevolucion((Devolucion) objeto);
            } else if(objeto instanceof MuebleEnsamblado){
                insert.insertarMuebleEnsamblado((MuebleEnsamblado) objeto);
            } else if(objeto instanceof Caja){
                insert.insertarCaja((Caja) objeto);
            }
    }

    public static Connection getConexion(){return Conexion.conexion;}
}
