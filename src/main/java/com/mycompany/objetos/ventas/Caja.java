package com.mycompany.objetos.ventas;

import java.math.BigDecimal;
import java.util.Date;

public class Caja {
    
    private String identificadorMueble;
    private String nombreUsuario;
    private Date fechaRegistro;
    private com.mycompany.enums.TipoRegistro tipo;
    private BigDecimal ganancia;
    private BigDecimal perdida;

    {
        ganancia = new BigDecimal(0);
        perdida = new BigDecimal(0);
    }

    public Caja(String identificadorMueble, String nombreUsuario, Date fechaRegistro, com.mycompany.enums.TipoRegistro tipo, BigDecimal ganancia, BigDecimal perdida){
        this.identificadorMueble = identificadorMueble;
        this.nombreUsuario=nombreUsuario;
        this.fechaRegistro=fechaRegistro;
        this.tipo = tipo;
        this.ganancia=ganancia;
        this.perdida = perdida;
    }

    public String getUsuario(){return this.nombreUsuario;}

    public Date getFechaRegistro(){return this.fechaRegistro;}
    
    public String getIdentificador(){return this.identificadorMueble;}

    public com.mycompany.enums.TipoRegistro getTipoRegistro(){return this.tipo;}

    public BigDecimal getGanancia(){return this.ganancia;}

    public BigDecimal getPerdida(){return this.perdida;}
}



