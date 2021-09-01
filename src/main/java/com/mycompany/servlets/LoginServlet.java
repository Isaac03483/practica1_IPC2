package com.mycompany.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mycompany.baseDeDatos.Select;
import com.mycompany.enums.TipoUsuario;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login-servlet"})
public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        response.setContentType("text/html;charset=UTF-8");
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

                            String areaTrabajo = resultado.getString("tipo");
                            request.getSession().setAttribute("user", user);

                            switch(TipoUsuario.evaluar(areaTrabajo)){
                                case FABRICA:request.getRequestDispatcher("/fabrica/fabrica.jsp").forward(request, response);
                                break;
                                case VENTAS:request.getRequestDispatcher("/ventas/ventas.jsp").forward(request, response);
                                break;
                                case FINANCIERO:request.getRequestDispatcher("/administracion/administracion.jsp").forward(request, response);
                                break;
                                case CANCELADO: System.err.println("Este usuario ya no se encuentra vigente.");
                                break;
                                default:System.err.println("área no encontrada.");
                                break;
                            }

                            
                            
                        } else {
                            
                            response.sendRedirect(request.getContextPath()+"/index.jsp");
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Coden Bugs.", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        response.sendRedirect(request.getContextPath()+"/index.jsp");
                        JOptionPane.showMessageDialog(null, "usuario no encontrado.", "Coden Bugs.", JOptionPane.ERROR_MESSAGE);
                    }

                    System.out.println(request.getContextPath());
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
