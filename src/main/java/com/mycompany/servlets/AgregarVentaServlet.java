package com.mycompany.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.baseDeDatos.Select;
import com.mycompany.baseDeDatos.Update;
import com.mycompany.enums.EstadoMueble;
import com.mycompany.enums.TipoRegistro;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.ventas.Caja;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.MuebleEnsamblado;

@WebServlet(name="AgregarVentaServlet", urlPatterns={"/ventas/agregar-venta-servlet"})
public class AgregarVentaServlet extends HttpServlet{
 
    private MuebleEnsamblado mueble;
    private Cliente cliente;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nit = request.getParameter("txtnit");
        String id = request.getParameter("idmueble");

        if(nit != null && !nit.equals("")){
            cliente = new Select().getCliente(nit);

            if(cliente != null){
                request.setAttribute("nit", cliente.getNit());
                request.setAttribute("nombre", cliente.getNombre());
                request.setAttribute("direccion", cliente.getDireccion());
                request.setAttribute("municipio", cliente.getMunicipio());
                request.setAttribute("departamento", cliente.getDepartamento());
            } else {
                request.setAttribute("nit", nit);
                request.setAttribute("nombre", "");
                request.setAttribute("direccion", "");
                request.setAttribute("municipio", "");
                request.setAttribute("departamento", "");
            }
        } else {
            request.setAttribute("nit", nit);
            request.setAttribute("nombre", "");
            request.setAttribute("direccion", "");
            request.setAttribute("municipio", "");
            request.setAttribute("departamento", "");
        }

        if(id != null && !id.equals("")){
            mueble = new Select().getMuebleSelecionado(id);

            if(mueble != null){
                request.setAttribute("costo", mueble.getCosto());
            } else {
                request.setAttribute("costo", 0);
            }
        } else {
            request.setAttribute("costo", 0);
        }

        request.getRequestDispatcher("/ventas/agregarVenta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombreUsuario = (String) request.getSession().getAttribute("user");
        String nit = request.getParameter("nitcon");

        if(nit == null){
            nit = "cf";
        }
        
        if(!nit.equals("cf")){
            String nombre = request.getParameter("txtnombre");
            String direccion = request.getParameter("txtdir");
            String departamento = request.getParameter("txtdep");
            String municipio = request.getParameter("txtmun");

            if(cliente != null){
                
                actualizarInfoCliente(nombre, direccion, departamento, municipio);
            } else {
                agregarClienteNuevo(nit, nombre, direccion, departamento, municipio);
            }

        }

        if(mueble != null){
            new Update().updateEstadoMueble(EstadoMueble.VENDIDO, mueble.getIdentificadorUnico());
            guardarVenta(nombreUsuario, nit);
        }

        response.sendRedirect("/coden_bugs/ventas/agregarVenta.jsp");
    }

    private void guardarVenta(String nombreUsuario, String nit){
        Mueble muebleBuscado = new Select().getMueble(mueble.getMuebleEnsamblar());
        try {
            Conexion.insertar(new Compra(nombreUsuario, mueble.getIdentificadorUnico(), nit, new Date(), mueble.getCosto()));
            if(muebleBuscado.getPrecio().doubleValue() > mueble.getCosto().doubleValue()){
                double ganancia = muebleBuscado.getPrecio().doubleValue() - mueble.getCosto().doubleValue();
                Conexion.insertar(new Caja(mueble.getIdentificadorUnico(), TipoRegistro.GANANCIA, new BigDecimal(ganancia), new BigDecimal(0)));
            } else {
                double perdida = mueble.getCosto().doubleValue()-muebleBuscado.getPrecio().doubleValue();
                Conexion.insertar(new Caja(mueble.getIdentificadorUnico(), TipoRegistro.PERDIDA, new BigDecimal(0), new BigDecimal(perdida)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ERROR\n\n\n\n\n");
        }
    }

    private void actualizarInfoCliente(String nombre, String direccion, String departamento, String municipio){
        
        if(nombre == null){
            cliente.setNombre("");
        } else {
            cliente.setNombre(nombre);
        }

        if(departamento == null){
            cliente.setDepartamento("");
        } else {
            cliente.setDepartamento(departamento);
        }

        if(direccion == null){
            cliente.setDireccion("");
        } else {
            cliente.setDireccion(direccion);
        }

        if(municipio == null){
            cliente.setMunicipio("");
        } else {
            cliente.setMunicipio(municipio);
        }

        new Update().updateInformacionCliente(cliente);
    }

    private void agregarClienteNuevo(String nit, String nombre, String direccion, String departamento, String municipio){
        try {
            if(direccion.equalsIgnoreCase("ciudad")){
                Conexion.insertar(new Cliente(nombre, nit, direccion));
            } else {
                Conexion.insertar(new Cliente(nombre, nit, direccion, municipio, departamento));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
