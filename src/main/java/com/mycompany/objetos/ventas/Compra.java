package com.mycompany.objetos.ventas;

import java.math.BigDecimal;
import java.util.Date;

public class Compra {
    
    private int registroCompra;
    private String nombreUsuario;
    private String identificadorMueble;
    private String nit;
    private Date fechaCompra;
    private BigDecimal total;

    public Compra(String nombreUsuario, String identificadorMueble, String nit, Date fechaCompra, BigDecimal total){
        this.nombreUsuario=nombreUsuario;
        this.identificadorMueble=identificadorMueble;
        this.nit=nit;
        this.fechaCompra=fechaCompra;
        this.total=total;
    }

    public Compra(int registroCompra, String nombreUsuario, String identificadorMueble, String nit, Date fechaCompra, BigDecimal total){
        
        this.registroCompra=registroCompra;
        this.nombreUsuario=nombreUsuario;
        this.identificadorMueble=identificadorMueble;
        this.nit=nit;
        this.fechaCompra=fechaCompra;
        this.total=total;
    }

    public int getRegistroCompra(){return this.registroCompra;}

    public String getNombreUsuario(){return this.nombreUsuario;}

    public String getIdentificadorMueble(){return this.identificadorMueble;}

    public String getNit(){return this.nit;}

    public Date getFecha(){return this.fechaCompra;}

    public BigDecimal getTotal(){return this.total;}
}
