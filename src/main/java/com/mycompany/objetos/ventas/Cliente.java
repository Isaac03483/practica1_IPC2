package com.mycompany.objetos.ventas;

public class Cliente {
    
    private String nit;
    private String nombre;
    private String direccion;
    private String municipio;
    private String departamento;

    {
        this.municipio = "";
        this.departamento = "";
    }

    public Cliente(String nombre, String nit, String direccion){
        this.nit = nit;
        this.nombre= nombre;
        this.direccion=direccion;
    }

    public Cliente(String nombre, String nit, String direccion, String municipio, String departamento){
        this.nit = nit;
        this.nombre= nombre;
        this.direccion=direccion;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public String getNit(){return this.nit;}

    public String getNombre(){return this.nombre;}

    public String getDireccion(){return this.direccion;}

    public String getMunicipio(){return this.municipio;}

    public String getDepartamento(){return this.departamento;}
}
