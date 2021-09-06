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

import com.mycompany.objetos.ventas.Caja;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name="ReporteGananciasServlet", urlPatterns = {"/administracion/reporte-ganancias-servlet"})
public class ReporteGananciasServlet extends HttpServlet{

    private String fechaInicial;
    private String fechaFinal;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        fechaInicial = request.getParameter("fechainicial");
        fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteGanancias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }

    public String getReporte(HttpServletRequest request) {
        
        List<Caja> listaCaja = (ArrayList<Caja>) new Obtencion().getReporteGanancia(fechaInicial,fechaFinal);
        
        String resultado = "";
        resultado+="Registro de la Ganancia, Nombre del Usuario, Identificador del Mueble, Fecha, Ganancia\n";
        for (Caja caja : listaCaja) {
            resultado+=caja.getRegistro()+","+caja.getUsuario()+","+caja.getIdentificador()+","+caja.getFechaRegistro()+","+caja.getGanancia().doubleValue()+"\n";
        }
        return resultado;
    }

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteGanancias.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
