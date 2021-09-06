package com.mycompany.objetos.fabrica;

import java.math.BigDecimal;

public class Mueble {
    
    private String nombreMueble;
    private BigDecimal precio;

    public Mueble(String nombreMueble, BigDecimal precio){
        this.nombreMueble =nombreMueble;
        this.precio=precio;
    }

    public String getNombreMueble(){return this.nombreMueble;}

    public BigDecimal getPrecio(){return this.precio;}
}
