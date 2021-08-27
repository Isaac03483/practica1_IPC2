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
}
