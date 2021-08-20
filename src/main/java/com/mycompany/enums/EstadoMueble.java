package com.mycompany.enums;

public enum EstadoMueble {
    
    ENSAMBLADO("ensamblado"),
    VENDIDO("vendido"),
    DEVUELTO("devuelto");

    private String estado;

    private EstadoMueble(String estado){
        this.estado=estado;
    }

    public String getEstado(){return this.estado;}
}
