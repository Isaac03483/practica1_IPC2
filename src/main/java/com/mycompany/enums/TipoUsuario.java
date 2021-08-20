package com.mycompany.enums;

public enum TipoUsuario {
    
    FABRICA("fabrica"),
    VENTAS("ventas"),
    ADMINISTRACION("administracion"),
    CANCELADO("cancelado");

    private String area;

    private TipoUsuario(String area){
        this.area = area;
    }

    public String getArea(){return this.area;}
}
