package com.mycompany.objetos.ventas;

import java.math.BigDecimal;
import java.util.Date;

public class MuebleEnsamblado {
    
    private String idenficadorUnico;
    private String muebleEnsamblar;
    private String usuarioEnsamblo;
    private Date fechaEnsamble;
    private BigDecimal costo;
    private com.mycompany.enums.EstadoMueble estado;
    private int cantidad;

    public MuebleEnsamblado(String muebleEnsamblar, int cantidad){
        this.muebleEnsamblar = muebleEnsamblar;
        this.cantidad = cantidad;
    }
    
    public MuebleEnsamblado(String muebleEnsamblar,String usuarioEnsamblo, Date fechaEnsamble, BigDecimal costo){

        this.idenficadorUnico = com.mycompany.operaciones.Generador.generador();
        this.muebleEnsamblar = muebleEnsamblar;
        this.usuarioEnsamblo=usuarioEnsamblo;
        this.fechaEnsamble=fechaEnsamble;
        this.costo = costo;
        this.estado = com.mycompany.enums.EstadoMueble.ENSAMBLADO;
    }

    public MuebleEnsamblado(String identificadorUnico, String muebleEnsamblar, String usuarioEnsamblo, Date fechaEnsamble, BigDecimal costo, com.mycompany.enums.EstadoMueble estado){
        
        this.idenficadorUnico=identificadorUnico;
        this.muebleEnsamblar = muebleEnsamblar;
        this.usuarioEnsamblo=usuarioEnsamblo;
        this.fechaEnsamble=fechaEnsamble;
        this.costo = costo;
        this.estado = estado;
    }

    public String getIdentificadorUnico(){return this.idenficadorUnico;}
    
    public String getUsuarioEnsamblo(){return this.usuarioEnsamblo;}

    public BigDecimal getCosto(){return this.costo;}

    public Date getFechaEnsamble(){return this.fechaEnsamble;}

    public com.mycompany.enums.EstadoMueble getEstadoMueble(){return this.estado;}

    public String getMuebleEnsamblar(){return this.muebleEnsamblar;}

    public int getCantidad(){return this.cantidad;}
}
