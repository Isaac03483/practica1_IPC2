package com.mycompany.servlets;

import java.io.File;
import java.io.IOException;
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

        if(path != null){
            CargaDatos carga = new CargaDatos(new File(path));
            try{
                carga.leerArchivo();
            } catch(IOException e){
                System.err.println("error");
            } catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        } else {
            System.err.println("Valor nulo.");
        }
    }
}
