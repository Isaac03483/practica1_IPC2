package com.mycompany.objetos.fabrica;

public class EnsamblePieza {
    
    private String nombreMueble;
    private String tipoPieza;
    private int cantidadPieza;

    public EnsamblePieza(String nombreMueble, String tipoPieza, int cantidadPieza){
        this.nombreMueble = nombreMueble;
        this.tipoPieza = tipoPieza;
        this.cantidadPieza = cantidadPieza;
    }

    public String getNombreMueble(){return this.nombreMueble;}

    public String getTipoPieza(){return this.tipoPieza;}

    public int getCantidadPieza(){return this.cantidadPieza;}
}
