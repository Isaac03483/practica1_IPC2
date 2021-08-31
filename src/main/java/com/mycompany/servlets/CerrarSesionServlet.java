package com.mycompany.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.baseDeDatos.Conexion;

@WebServlet(name="CerrarSesionServlet", urlPatterns ={"/cerrar-sesion-servlet"})
public class CerrarSesionServlet extends HttpServlet{
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        Conexion conexion = new Conexion();
        conexion.desconectar();
        response.sendRedirect("/coden_bugs/index.jsp");
    }
}
