package com.mycompany.enums;

public enum EstadoMueble{
    
    ENSAMBLADO("ensamblado"),
    VENDIDO("vendido"),
    DEVUELTO("devuelto");

    private String estado;

    private EstadoMueble(String estado){
        this.estado=estado;
    }

    public String getEstado(){return this.estado;}


    public String toString(){return this.getEstado();}

    public static EstadoMueble evaluar(String dato){
        if(EstadoMueble.ENSAMBLADO.getEstado().equals(dato)){
            return EstadoMueble.ENSAMBLADO;
        } else if(EstadoMueble.VENDIDO.getEstado().equals(dato)){
            return EstadoMueble.VENDIDO;
        } else if(EstadoMueble.DEVUELTO.getEstado().equals(dato)){
            return EstadoMueble.DEVUELTO;
        } 
        return null;
    }
}
