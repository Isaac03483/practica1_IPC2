package com.mycompany.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CargaDatos {
    
    private File archivoAProcesar;
    private Connection conexion;

    /**
     * constructor que almacena el archivo y la ventana que contiene la carga de archivos
     * @param archivoAProcesar
     * @param ventana
     */
    public CargaDatos(File archivoAProcesar, Connection conexion){

        this.archivoAProcesar = archivoAProcesar;
        this.conexion = conexion;
    }

    /**
     * método que ira recorriendo el archivo almacenado y creando distintos archivos binarios dependiendo del caso
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     */
    private void leerArchivo() throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException{

        BufferedReader lector = new BufferedReader(new FileReader(this.archivoAProcesar));

        String auxiliar = lector.readLine();
        int posicion;
        String auxiliarUno, auxiliarDos, datos[];
        
        while(auxiliar != null){
            
            posicion = auxiliar.indexOf("(");
            auxiliarUno = auxiliar.substring(0, posicion);
            auxiliarDos = auxiliar.substring(posicion);
            datos = quitarParentesis(auxiliarDos);
            try{
                switch(auxiliarUno){
                    case com.mycompany.operaciones.Constante.CLIENTE:
                    
                    break;
    
                    case com.mycompany.operaciones.Constante.MUEBLE:
                    
                    break;
    
                    case com.mycompany.operaciones.Constante.ENSAMBLE_PIEZAS:
                    
                    break;
                    
                    case com.mycompany.operaciones.Constante.ENSAMBLAR_MUEBLE:
                    
                    break;
    
                    case  com.mycompany.operaciones.Constante.PIEZA:
                    
                    break;
    
                    case com.mycompany.operaciones.Constante.USUARIO:
                    break;

                    default:
                    System.out.println("Formato inválido. "+auxiliar);
                    break;
                }
            } catch(NumberFormatException e){
                System.err.println("Error en el ingreso de datos en el campo de tipo número en la línea: "+auxiliar);
                e.printStackTrace();
            }
            
            
            auxiliar = lector.readLine();

        }
        
        lector.close();
    }

    /**
     * método que quita los paréntesis extra colocados en el formato del archivo de texto
     * @param auxiliarDos
     * @return
     */
    private String[] quitarParentesis(String auxiliarDos){

        int posicion = auxiliarDos.lastIndexOf(")");
        String textoDatos = auxiliarDos.substring(1, posicion);
        String[] datos = textoDatos.split(",");

        return datos;
    }

    /**
     * método que cambia un String y retorna una objeto de tipo Date
     * @param texto
     * @return
     */
    private Date formatoFecha(String texto, String formatoFecha){
        
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        Date fecha;
        try {
            fecha = formato.parse(texto);
            return fecha;
            
       } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
