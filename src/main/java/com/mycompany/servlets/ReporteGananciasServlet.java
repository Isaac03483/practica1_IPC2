package com.mycompany.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ReporteGananciasServlet", urlPatterns = {"/administracion/reporte-ganancias-servlet"})
public class ReporteGananciasServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String fechaInicial = request.getParameter("fechainicial");
        String fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteGanancias.jsp").forward(request, response);
    }
}
