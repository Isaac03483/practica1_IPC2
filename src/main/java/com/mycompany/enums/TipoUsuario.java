package com.mycompany.enums;

public enum TipoUsuario {
    
    FABRICA("Fábrica"),
    VENTAS("punto de venta"),
    FINANCIERO("financiero"),
    CANCELADO("cancelado");

    private String area;

    private TipoUsuario(String area){
        this.area = area;
    }

    public String getArea(){return this.area;}

    public String toString(){return this.getArea();}

    public static TipoUsuario evaluar(String dato){
        if(TipoUsuario.FABRICA.getArea().equals(dato)){
            return TipoUsuario.FABRICA;
        } else if(TipoUsuario.VENTAS.getArea().equals(dato)){
            return TipoUsuario.VENTAS;
        } else if(TipoUsuario.FINANCIERO.getArea().equals(dato)){
            return TipoUsuario.FINANCIERO;
        } else if(TipoUsuario.CANCELADO.getArea().equals(dato)){
            return TipoUsuario.CANCELADO;
        } 
        return null;
    }
}
