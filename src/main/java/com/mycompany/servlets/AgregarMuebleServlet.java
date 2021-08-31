package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.objetos.fabrica.Mueble;

@WebServlet(name="AgregarMuebleServlet", urlPatterns = {"/administracion/agregar-mueble-servlet"})
public class AgregarMuebleServlet extends HttpServlet{
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
  
        try{
            String nombreMueble = request.getParameter("txtnombre");
            BigDecimal precio = new BigDecimal(request.getParameter("txtprecio"));
            Conexion.insertar(new Mueble(nombreMueble, precio));
            response.sendRedirect("/coden_bugs/fabrica/agregarMueble.jsp");
            System.out.println("Mueble agregado");
        } catch(Exception e){
            System.out.println("Error al querer ingresar un nuevo mueble, por favor verifique");
            response.sendRedirect("/coden_bugs/fabrica/agregarMueble.jsp");
        }


    }
}
