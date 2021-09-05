package com.mycompany.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.objetos.ventas.Devolucion;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name="ReporteDevolucionesServlet", urlPatterns = {"/administracion/reporte-devoluciones-servlet"})

public class ReporteDevolucionesServlet extends HttpServlet{
    
    String fechaInicial;
    String fechaFinal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        fechaInicial = request.getParameter("fechainicial");
        fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteDevoluciones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }

    public String getReporte(HttpServletRequest request) {

        List<Devolucion> listaDevoluciones = (ArrayList<Devolucion>) new Obtencion().getReporteDevolucion((String)request.getAttribute("fechaInicial"),(String)request.getAttribute("fechaFinal"));
        
        String resultado = "";
        resultado+="Registro de la Devolucion, Identificador del Mueble, Nit, Fecha, Pérdida\n";
        for (Devolucion devolucion : listaDevoluciones) {
            resultado+=devolucion.getRegistroDevolucion()+","+devolucion.getIdentificadorMueble()+","+devolucion.getNit()+","+devolucion.getFecha()+","+devolucion.getPerdida().doubleValue()+"\n";
        }
        return resultado;
    }

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteDevolucion.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
