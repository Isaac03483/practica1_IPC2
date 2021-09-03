package com.mycompany.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ReporteMuebleVendidoServlet", urlPatterns = {"/administracion/reporte-mueble-vendido-servlet"})

public class ReporteMuebleVendidoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String fechaInicial = request.getParameter("fechainicial");
        String fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteMuebleVendido.jsp").forward(request, response);
    }
}
