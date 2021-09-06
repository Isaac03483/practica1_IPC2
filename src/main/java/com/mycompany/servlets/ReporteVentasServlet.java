package com.mycompany.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name = "ReporteVentasServlet", urlPatterns = { "/administracion/reporte-ventas-servlet" })
public class ReporteVentasServlet extends HttpServlet {

    String fechaInicial;
    String fechaFinal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        fechaInicial = request.getParameter("fechainicial");
        fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteVentas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }


    public String getReporte(HttpServletRequest request) {

        List<Compra> listaCompras = (ArrayList<Compra>) new Obtencion().getReporteVentas(fechaInicial,fechaFinal);

        String resultado = "";
        resultado+="Registro de Compra, Nombre del Usuario, Identificador del Mueble, Nit, Fecha de la Compra, Total\n";
        for (Compra compra : listaCompras) {
            resultado+=compra.getRegistroCompra()+","+compra.getNombreUsuario()+","+compra.getIdentificadorMueble()+","+compra.getNit()+","+compra.getFecha()+","+compra.getTotal().doubleValue()+"\n";
        }
        return resultado;
    }
    

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteVentas.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
