package com.mycompany.enums;

public enum TipoRegistro {
    
    GANANCIA("ganancia"),
    PERDIDA("perdida");
    
    private String tipo;

    private TipoRegistro(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){return this.tipo;}

    public String toString(){return this.getTipo();}

    public static TipoRegistro evaluar(String dato){
        if(TipoRegistro.GANANCIA.getTipo().equalsIgnoreCase(dato)){
            return TipoRegistro.GANANCIA;
        } else if(TipoRegistro.PERDIDA.getTipo().equalsIgnoreCase(dato)){
            return TipoRegistro.PERDIDA;
        }
        return null;
    }
}
