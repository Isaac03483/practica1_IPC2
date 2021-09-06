package com.mycompany.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mycompany.operaciones.CargaDatos;

@WebServlet(name="CargaServlet", urlPatterns={"/carga-servlet"})
@MultipartConfig(location = "/tmp")
public class CargaServlet extends HttpServlet{
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");
        Part path = request.getPart("myfile");
        CargaDatos carga = new CargaDatos(path.getInputStream());
        try{
            List<String> errores = carga.leerArchivo();
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("errores.jsp").forward(request, response);
        } catch(IOException e){
            System.err.println("error");
        }
        
    }
}
