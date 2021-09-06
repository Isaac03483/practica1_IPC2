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

@WebServlet(name="ReporteMuebleMenosServlet", urlPatterns = {"/administracion/reporte-mueble-menos-servlet"})
public class ReporteMuebleMenosServlet extends HttpServlet{

    private String fechaInicial;
    private String fechaFinal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        fechaInicial = request.getParameter("fechainicial");
        fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteMuebleVendido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }

    public String getReporte(HttpServletRequest request) {
        System.out.println(request.getParameter("nombreMueble"));
        List<Compra> listaCompra = (ArrayList<Compra>) new Obtencion().getFacturaMuebleV(request.getParameter("nombreMueble"), fechaInicial,fechaFinal);

        String resultado = "";
        if(listaCompra.size() > 0){
            resultado+="Nombre Del Mueble\n"
            +request.getParameter("nombreMueble")+"\n\n"
            +"Registro de la Compra, Nombre del Usuario, Identificador del Mueble, Nit, Fecha, Total\n";
            for (Compra compra : listaCompra) {
                resultado+=compra.getRegistroCompra()+","+compra.getNombreUsuario()+","+compra.getIdentificadorMueble()+","+compra.getNit()+","+compra.getFecha()+","+compra.getTotal().doubleValue()+"\n";
            }
        }
        return resultado;
    }

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteMuebleMenosVendido.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}