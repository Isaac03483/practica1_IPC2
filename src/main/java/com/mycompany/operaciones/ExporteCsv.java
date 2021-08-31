package com.mycompany.operaciones;

import java.util.List;
import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.ventas.Caja;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.Devolucion;

public class ExporteCsv{
    
    public static void escribirCsv(String nombre, List<Object> lista){

        if(lista.get(0) instanceof Cliente){
            exportarCliente(lista);
        } else if(lista.get(0) instanceof Compra){
            exportarCliente(lista);
        } else if(lista.get(0) instanceof Devolucion){
            exportarCliente(lista);
        } else if(lista.get(0) instanceof Usuario){
            exportarCliente(lista);
        } else if(lista.get(0) instanceof Mueble){
            exportarCliente(lista);
        } else if(lista.get(0) instanceof Caja){
            exportarCliente(lista);
        }
    }

    private static void exportarCliente(List<Object> lista){
        
    }
}
