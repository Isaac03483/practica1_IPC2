package com.mycompany.objetos.fabrica;

import java.math.BigDecimal;

public class Pieza {
    
    private String tipoPieza;
    private BigDecimal precio;
    private int cantidad;

    public Pieza(String tipoPieza, BigDecimal precio, int cantidad){
        this.tipoPieza = tipoPieza;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTipoPieza(){return this.tipoPieza;}

    public BigDecimal getPrecio(){return this.precio;}

    public int getCantidad(){return this.cantidad;}

    public void setCantidad(int cantidad){this.cantidad = cantidad;}
}
