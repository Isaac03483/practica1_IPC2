package com.mycompany.operaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.enums.TipoUsuario;
import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.objetos.fabrica.EnsamblePieza;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.fabrica.Pieza;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.MuebleEnsamblado;


public class CargaDatos {
    
    private File archivoAProcesar;
    private Conexion conexion;
    private List<String> errores = new ArrayList<>();
    /**
     * constructor que almacena el archivo y la ventana que contiene la carga de archivos
     * @param archivoAProcesar
     * @param ventana
     */
    public CargaDatos(File archivoAProcesar){

        this.archivoAProcesar = archivoAProcesar;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"+archivoAProcesar.getAbsolutePath());
        Conexion conexion = new Conexion();
        
    }

    /**
     * método que ira recorriendo el archivo almacenado y creando distintos archivos binarios dependiendo del caso
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     */
    public List<String> leerArchivo() throws IOException{

        BufferedReader lector = new BufferedReader(new FileReader(this.archivoAProcesar));

        String auxiliar = lector.readLine();
        int posicion;
        String auxiliarUno, auxiliarDos, datos[];
        int numeroLinea = 1;
        while(auxiliar != null){

            posicion = auxiliar.indexOf("(");
            auxiliarUno = auxiliar.substring(0, posicion);
            auxiliarDos = auxiliar.substring(posicion);
            datos = quitarParentesis(auxiliarDos);
            try{
                
                switch(auxiliarUno){
                    
                    case com.mycompany.operaciones.Constante.CLIENTE:
                    if(!datos[1].contains("-")){
                        if(datos.length == 5){
                            Conexion.insertar(new Cliente(quitarComillas(datos[0]), quitarComillas(datos[1]), quitarComillas(datos[2]), quitarComillas(datos[3]), quitarComillas(datos[4])));
                        } else {
                            Conexion.insertar(new Cliente(quitarComillas(datos[0]), quitarComillas(datos[1]), quitarComillas(datos[2])));
                        }
                    } else {
                        errores.add("Valor invalido '-' en línea "+auxiliar);
                    }
                    break;
    
                    case com.mycompany.operaciones.Constante.MUEBLE:
                    Conexion.insertar(new Mueble(quitarComillas(datos[0]), new BigDecimal(datos[1])));
                    break;
    
                    case com.mycompany.operaciones.Constante.ENSAMBLE_PIEZAS:
                    Conexion.insertar(new EnsamblePieza(quitarComillas(datos[0]), quitarComillas(datos[1]), Integer.valueOf(datos[2])));
                    break;
                    
                    case com.mycompany.operaciones.Constante.ENSAMBLAR_MUEBLE:

                    java.util.Date fecha = CargaDatos.formatoFecha(quitarComillas(datos[2]), com.mycompany.operaciones.Constante.FORMATO_FECHA_CARGA);                        
                    if(fecha != null){
                        Conexion.insertar(new MuebleEnsamblado(quitarComillas(datos[0]), quitarComillas(datos[1]), fecha, new BigDecimal(0)));  
                    } else {
                        System.err.println("Formato de fecha inválido.");
                    }            
        
                    break;
    
                    case  com.mycompany.operaciones.Constante.PIEZA:

                    Conexion.insertar(new Pieza(quitarComillas(datos[0]), new BigDecimal(datos[1]), 1));
                    
                    break;
    
                    case com.mycompany.operaciones.Constante.USUARIO:
                    switch (Integer.valueOf(datos[2])){
                        case 1:
                        Conexion.insertar(new Usuario(quitarComillas(datos[0]), quitarComillas(datos[1]), TipoUsuario.FABRICA));
                        break;
                        case 2:
                        Conexion.insertar(new Usuario(quitarComillas(datos[0]), quitarComillas(datos[1]), TipoUsuario.VENTAS));
                        break;
                        case 3:
                        Conexion.insertar(new Usuario(quitarComillas(datos[0]), quitarComillas(datos[1]), TipoUsuario.FINANCIERO));
                        break;
                        default:
                    }
                    
                    break;

                    default:
                    errores.add("Formato inválido. "+auxiliar);
                    break;
                }
            } catch(NumberFormatException e){
                errores.add("Error en el ingreso de datos en el campo de tipo número en la línea: "+numeroLinea+"\n"+auxiliar);
                e.printStackTrace();
            } catch(ParseException e){
                errores.add("Error en el ingreso de datos en el campo de tipo número en la línea: "+numeroLinea+"\n"+auxiliar);
                e.printStackTrace();
            } catch(ArrayIndexOutOfBoundsException e){
                errores.add("Error por falta de información en la línea: "+numeroLinea+"\n"+auxiliar);
                e.printStackTrace();
            } catch (SQLException e) {
                errores.add("Error al intentar guardar la información de la línea: "+numeroLinea+"\n"+auxiliar);
                e.printStackTrace();
            }
            numeroLinea++;
            auxiliar = lector.readLine();

        }

        System.out.println("Carga completa.");
        lector.close();

        return errores;
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
     * 
     * @param dato
     * @return
     */
    private String quitarComillas(String dato){
        return dato.substring(1, dato.length()-1);
    }

    /**
     * método que cambia un String y retorna una objeto de tipo Date
     * @param texto
     * @return
     */
    public static java.util.Date formatoFecha(String texto, String formatoFecha) throws ParseException{
        
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        java.util.Date fecha;

        fecha = formato.parse(texto);
        return fecha;

    }
}
    
