package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mycompany.baseDeDatos.Conexion;
import com.mycompany.enums.TipoUsuario;
import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.operaciones.Obtencion;

@WebServlet(name = "AgregarUsuarioServlet", urlPatterns = {"/administracion/agregar-usuario-servlet"})
public class AgregarUsuarioServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("txtnombre");

        Obtencion obtencion = new Obtencion();
        
        
        if(obtencion.getUsuario(nombre) == null){

            String password = request.getParameter("txtpass");
            String verificacion = request.getParameter("txtver");

            if(verificarPassword(password,verificacion)){

                String area = request.getParameter("tipo_usuario");

                if(TipoUsuario.evaluar(area) != null){

                    agregarUsuario(nombre, password, area);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Área de trabajo no encontrada.", "Coden_bugs", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña y la verificación deben ser iguales.", "Coden_bugs", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre.", "Coden_bugs", JOptionPane.ERROR_MESSAGE);

        }

        response.sendRedirect("/coden_bugs/administracion/agregarUsuario.jsp");
    }

    public static boolean verificarPassword(String password, String verificacion){
        return password.equals(verificacion) && password!=null;
    }

    private void agregarUsuario(String nombre, String password, String area){
        try {
            Conexion.insertar(new Usuario(nombre, password, TipoUsuario.evaluar(area)));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
