package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.objetos.fabrica.Pieza;

@WebServlet(name="AgregarPiezaServlet", urlPatterns={"/fabrica/agregar-pieza-servlet"})
public class AgregarPiezaServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        String nombrePieza = request.getParameter("txtnombre");
        String precio = request.getParameter("txtprecio");
        String unidades = request.getParameter("txtunidades");

        try{
            Conexion.insertar(new Pieza(nombrePieza, new BigDecimal(precio), Integer.parseInt(unidades)));
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Los campos precio y unidades solo aceptan datos tipo numérico.", "Coden Bugs", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("/coden_bugs/fabrica/agregarPieza.jsp");
    }
}
