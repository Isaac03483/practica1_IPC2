package com.mycompany.enums;

public enum TipoRegistro {
    
    GANANCIA("ganacia"),
    PERDIDA("perdida");
    
    private String tipo;

    private TipoRegistro(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){return this.tipo;}
}
