package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.baseDeDatos.Update;
import com.mycompany.objetos.fabrica.Pieza;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name="ModificarPiezaServlet", urlPatterns = {"/fabrica/modificar-pieza-servlet"})
public class ModificarPiezaServlet extends HttpServlet{
    
    private Pieza pieza;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String informacionPieza = request.getParameter("tipo_pieza").toLowerCase();
        System.out.println(informacionPieza);

        String[] informacionSeparada = dividirInformacion(informacionPieza);

        List<Pieza> listaPiezas = new Obtencion().getPiezasSeparadas();

        pieza = encontrarPieza(informacionSeparada[0], new BigDecimal(informacionSeparada[1]), listaPiezas);
        System.out.println(informacionSeparada[0]+" "+informacionSeparada[1]);

        if(pieza != null){
            System.out.println(pieza.getPrecio()+" "+pieza.getCantidad());
            request.setAttribute("nombre", pieza.getTipoPieza());
            request.setAttribute("precio", pieza.getPrecio());
            request.setAttribute("unidades", pieza.getCantidad());
        } else {
            System.err.println("Piezas no encontradas");
        }
        request.getRequestDispatcher("modificarPieza.jsp").forward(request, response);
        
    }

    private String[] dividirInformacion(String informacion){

        return  informacion.split("Λ");
    }

    private Pieza encontrarPieza(String nombre, BigDecimal precio, List<Pieza> listaPiezas){

        for(Pieza pieza: listaPiezas){
            if(pieza.getTipoPieza().equalsIgnoreCase(nombre)){
                System.out.println("aqui no");
                if(pieza.getPrecio().equals(precio)){
                    return pieza;
                }
            }
        }

        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        Update update = new Update();
        String nombre = request.getParameter("textonombre");
        String unidades = request.getParameter("textounidades");
        String precio = request.getParameter("textoprecio");

        update.updateInformacionPieza(pieza, new Pieza(nombre.toLowerCase(), new BigDecimal(precio), Integer.parseInt(unidades)));
        System.out.println(pieza.getTipoPieza()+" "+pieza.getCantidad()+" "+pieza.getPrecio());
        response.sendRedirect("/coden_bugs/fabrica/modificarPieza.jsp");
    }
}
