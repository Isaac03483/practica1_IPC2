package com.mycompany.objetos.ventas;

import java.math.BigDecimal;
import java.util.Date;

public class Devolucion {
    
    private int registroDevolucion;
    private String nit;
    private String identificadorMueble;
    private Date fechaDevolucion;
    private BigDecimal perdida;

    public Devolucion(int registroDevolucion, String nit, String identificadorMueble, Date fechaDevolucion, BigDecimal perdida){
        this.registroDevolucion=registroDevolucion;
        this.nit= nit;
        this.identificadorMueble=identificadorMueble;
        this.fechaDevolucion=fechaDevolucion;
        this.perdida=perdida;
    }

    public String getNit(){return this.nit;}

    public int getRegistroDevolucion(){return this.registroDevolucion;}

    public String getIdentificadorMueble(){return this.identificadorMueble;}

    public Date getFecha(){return this.fechaDevolucion;}

    public BigDecimal getPerdida(){return this.perdida;}
}
