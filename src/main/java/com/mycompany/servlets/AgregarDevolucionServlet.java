package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.baseDeDatos.Select;
import com.mycompany.baseDeDatos.Update;
import com.mycompany.enums.EstadoMueble;
import com.mycompany.enums.TipoRegistro;
import com.mycompany.objetos.ventas.Caja;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.Devolucion;
import com.mycompany.objetos.ventas.MuebleEnsamblado;

@WebServlet(name ="AgregarDevolucionServlet", urlPatterns = {"/ventas/agregar-devolucion-servlet"})
public class AgregarDevolucionServlet extends HttpServlet{
    
    private int numeroCompra;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        numeroCompra = Integer.parseInt(request.getParameter("numero_compra"));
        Compra resultadoBusqueda = new Select().getCompra(numeroCompra);

        if(resultadoBusqueda != null){
            request.setAttribute("identificadorUnico", resultadoBusqueda.getIdentificadorMueble());
            request.setAttribute("fechaCompra", resultadoBusqueda.getFecha());
            request.setAttribute("total", resultadoBusqueda.getTotal());
            
        } else {
           JOptionPane.showMessageDialog(null, "Número de compra no encontrada.", "Coden_bugs", JOptionPane.ERROR_MESSAGE);
        }
        request.getRequestDispatcher("/ventas/agregarDevolucion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        Compra resultadoBusqueda = new Select().getCompra(numeroCompra);
        if(resultadoBusqueda != null){
            if(garantiaActiva(resultadoBusqueda.getFecha())){
                System.out.println("No han pasado 10 días");
    
                MuebleEnsamblado muebleEnsamblado = new Select().getMuebleSelecionado(resultadoBusqueda.getIdentificadorMueble());
    
                if(muebleEnsamblado.getEstadoMueble() == EstadoMueble.VENDIDO){
                    double perdida = muebleEnsamblado.getCosto().doubleValue() / 3;
    
                    guardarDevolucion(resultadoBusqueda.getRegistroCompra(), resultadoBusqueda.getNit(),resultadoBusqueda.getNombreUsuario(),resultadoBusqueda.getIdentificadorMueble(), perdida);
                } else if(muebleEnsamblado.getEstadoMueble() == EstadoMueble.DEVUELTO){
    
                    System.err.println("ESTE MUEBLE YA HA SIDO DEVUELTO.");
                } else if(muebleEnsamblado.getEstadoMueble() == EstadoMueble.ENSAMBLADO){
    
                    System.err.println("ESTE MUEBLE AÚN NO SE HA VENDIDO.");
                }
            } else {
                System.out.println("Garantía expirada");
    
            }
        } else {
            System.err.println("No se pudo agregar la devolución");
        }

        response.sendRedirect("/coden_bugs/ventas/agregarDevolucion.jsp");
    }

    private boolean garantiaActiva(java.util.Date fecha){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVerificar = Instant.ofEpochMilli(fecha.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        if(fechaActual.getDayOfYear() - fechaVerificar.getDayOfYear() < 8){
            System.out.println(fechaActual.getDayOfYear() - fechaVerificar.getDayOfYear());
            return true;
        }
        return false;
    }

    private void guardarDevolucion(int registroDevolucion, String nit, String nombreUsuario,String identificadorMueble, double perdida){
        
        try {
            Conexion.insertar(new Caja(identificadorMueble, nombreUsuario, new Date(), TipoRegistro.PERDIDA, new BigDecimal(0), new BigDecimal(perdida)));
            Conexion.insertar(new Devolucion(registroDevolucion,nit , identificadorMueble, new Date(), new BigDecimal(perdida)));
            new Update().updateEstadoMueble(EstadoMueble.ENSAMBLADO, identificadorMueble);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
