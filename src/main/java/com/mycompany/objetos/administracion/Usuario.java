package com.mycompany.objetos.administracion;

public class Usuario {
    
    private String nombreUsuario;
    private String password;
    private com.mycompany.enums.TipoUsuario tipoUsuario;

    public Usuario (String nombreUsuario, String password, com.mycompany.enums.TipoUsuario tipoUsuario){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;

    }

    public String getNombreUsuario(){return this.nombreUsuario;}

    public String getPassword(){return this.password;}

    public com.mycompany.enums.TipoUsuario getTipoUsuario(){return this.tipoUsuario;}
}
