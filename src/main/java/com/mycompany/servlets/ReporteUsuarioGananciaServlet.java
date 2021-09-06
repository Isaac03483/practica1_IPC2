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

@WebServlet(name="ReporteUsuarioGananciaServlet", urlPatterns = {"/administracion/reporte-usuario-ganancias-servlet"})
public class ReporteUsuarioGananciaServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String fechaInicial = request.getParameter("fechainicial");
        String fechaFinal = request.getParameter("fechafinal");

        request.setAttribute("fechaInicial", fechaInicial);
        request.setAttribute("fechaFinal", fechaFinal);

        request.getRequestDispatcher("/administracion/reporteUsuarioGanancias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        reporte(response, getReporte(request));
    }

    public String getReporte(HttpServletRequest request) {

        List<Caja> listaGanancias = (ArrayList<Caja>) new Obtencion().getReporteUsuarioGanancias((String)request.getAttribute("fechaInicial"),(String)request.getAttribute("fechaFinal"));

        String resultado = "";
        if(listaGanancias.size() > 0){
            resultado+="Nombre Del Usuario,Ganancias Generadas\n"
            +listaGanancias.get(0).getUsuario()+","+request.getParameter("ganancia")+"\n\n"
            +"Registro de la Ganancia, Nombre del Usuario, Fecha de la venta,Nombre del Mueble, Ganancia\n";
            for (Caja caja : listaGanancias) {
                resultado+=caja.getRegistro()+","+caja.getUsuario()+","+caja.getFechaRegistro()+","+caja.getNombreMueble()+","+caja.getGanancia().doubleValue()+"\n";
            }
        }
        return resultado;
    }

    public void reporte(HttpServletResponse response, String reporte){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attatchment; filename=reporteUsuarioGanancias.csv");

        try (PrintWriter print = response.getWriter()) {
            print.write(reporte);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
