package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.objetos.ventas.MuebleEnsamblado;

@WebServlet(name="EnsamblarMuebleServlet", urlPatterns={"/fabrica/ensamblar-mueble-servlet"})
public class EnsamblarMuebleServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        request.setCharacterEncoding("UTF-8");
        String nombreMueble = request.getParameter("nombreMueble");
        String usuarioEnsambla = request.getParameter("txtusuario");

        try {
            Conexion.insertar(new MuebleEnsamblado(nombreMueble, usuarioEnsambla, new Date(), new BigDecimal(0)));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("/coden_bugs/fabrica/ensamblarMueble.jsp");
    }
}
