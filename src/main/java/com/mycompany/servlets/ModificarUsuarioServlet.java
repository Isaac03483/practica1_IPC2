package com.mycompany.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.baseDeDatos.Update;
import com.mycompany.enums.TipoUsuario;

@WebServlet(name="ModificarUsuarioServlet", urlPatterns = {"/administracion/modificar-usuario-servlet"})
public class ModificarUsuarioServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String opcionContra = request.getParameter("cbox2");
        String opcionArea = request.getParameter("cbox3");
        String nombreUsuario = request.getParameter("nombre_usuario");
        
        if(opcionArea != null){
            String tipoUsuario = request.getParameter("tipo_usuario");
            System.out.println(tipoUsuario);
            new Update().updateTipoUsuario(TipoUsuario.evaluar(tipoUsuario), nombreUsuario);
        }

        if(opcionContra != null){
            String passwordVieja = request.getParameter("txtpass");
            String passwordNueva = request.getParameter("txtver1");
            String verificacion = request.getParameter("txtver2");
            if(AgregarUsuarioServlet.verificarPassword(passwordNueva, verificacion)){
                new Update().updatePasswordUsuario(passwordNueva, nombreUsuario, passwordVieja);
            }
        }

        response.sendRedirect("/coden_bugs/administracion/modificarUsuario.jsp");
    }
}
