package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.objetos.fabrica.EnsamblePieza;

@WebServlet(name="AgregarEnsamblePiezaServlet", urlPatterns = {"/administracion/agregar-ensamble-pieza-servlet"})
public class AgregarEnsamblePiezaServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String nombreMueble = request.getParameter("nombreMueble");
        String tipoPieza = request.getParameter("tipo_pieza");
        
        if(nombreMueble != null && tipoPieza != null){
            try {
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                Conexion.insertar(new EnsamblePieza(nombreMueble, tipoPieza, cantidad));
            } catch (NumberFormatException e) {
                //TODO: handle exception
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        response.sendRedirect("/coden_bugs/administracion/agregarEnsamblePieza.jsp");
    }
}
