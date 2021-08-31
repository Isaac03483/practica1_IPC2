package com.mycompany.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.operaciones.CargaDatos;

@WebServlet(name="CargaServlet", urlPatterns={"/carga-servlet"})
public class CargaServlet extends HttpServlet{
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String path = request.getParameter("myfile");
        System.out.println("\n\n\n\n\n\n\n\n"+path);
        CargaDatos carga = new CargaDatos(new File(path));
        try{
            List<String> errores = carga.leerArchivo();
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("errores.jsp").forward(request, response);
        } catch(IOException e){
            System.err.println("error");
        }
        
    }
}
