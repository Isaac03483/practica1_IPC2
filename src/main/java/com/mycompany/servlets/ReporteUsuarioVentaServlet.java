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

import com.mycompany.objetos.ventas.Compra;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name="ReporteUsuarioVentaServlet", urlPatterns = {"/administracion/reporte-usuario-ventas-servlet"})
public class ReporteUsuarioVentaServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String fechaInicial = request.getParameter("fechainicial");
        String fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteUsuarioVentas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }

    public String getReporte(HttpServletRequest request) {

        List<Compra> listaCompra = (ArrayList<Compra>) new Obtencion().getReporteUsuarioVentas((String)request.getAttribute("fechaInicial"),(String)request.getAttribute("fechaFinal"));

        String resultado = "";
        if(listaCompra.size() > 0){
            resultado+="Nombre Del Usuario\n"
            +listaCompra.get(0).getNombreUsuario()+"\n\n"
            +"Registro de la Compra, Fecha, Nombre del Mueble, Total\n";
            for (Compra compra : listaCompra) {
                resultado+=compra.getRegistroCompra()+","+compra.getFecha()+","+compra.getNombreMueble()+","+compra.getTotal().doubleValue()+"\n";
            }
        }
        return resultado;
    }

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteUsuarioVentas.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
