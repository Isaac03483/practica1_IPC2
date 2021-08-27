package com.mycompany.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.baseDeDatos.Select;
import com.mycompany.enums.TipoUsuario;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login-servlet"})
public class LoginServlet extends HttpServlet{
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        String user = request.getParameter("txtus");
        String pass=request.getParameter("txtcontra");
        Select select = new Select();
        System.out.println("Entrando...");

        if(!user.equals("") && user != null){
            if(!pass.equals("") && pass != null){
                try{
                    ResultSet resultado = select.selectUsuario(user);

                    if(resultado.next()){
                        
                        if(resultado.getString("password").equals(pass)){

                            request.getSession().setAttribute("user", user);

                            if(resultado.getString("tipo").equals(TipoUsuario.FABRICA.getArea())){

                                response.sendRedirect("/coden_bugs/fabrica/fabrica.jsp");

                            } else if(resultado.getString("tipo").equals(TipoUsuario.VENTAS.getArea())){

                                response.sendRedirect("/coden_bugs/ventas/ventas.jsp");

                            } else if(resultado.getString("tipo").equals(TipoUsuario.FINANCIERO.getArea())){

                                response.sendRedirect("/coden_bugs/administracion/administracion.jsp");

                            } else if(resultado.getString("tipo").equals(TipoUsuario.CANCELADO.getArea())){

                                System.err.println("Este usuario ya no se encuentra vigente.");
                                
                            } else {
                                System.err.println("área no encontrada.");
                            }
                        } else {
                            System.out.println("Contraseña incorrecta.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                } catch(SQLException e){
                    e.printStackTrace();
                } catch(NullPointerException e){
                    System.err.println("Error 1");
                }
            } else {
                System.out.println("Contraseña vacía.");
            }
        } else {
            System.out.println("Campo vacío.");
        }
    }
}
