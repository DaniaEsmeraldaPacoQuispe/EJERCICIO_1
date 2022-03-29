
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESMERALDA
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje="Visitado";
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null)
        {
            for(Cookie C : cookies){
                if(C.getName().equals("visita")){
                    request.getRequestDispatcher("salidas.jsp").forward(request, response);
                }else{
                    Cookie Caux = new Cookie("visita",mensaje);
                    Caux.setMaxAge(30);
                    response.addCookie(Caux);
                    request.getRequestDispatcher("salida.jsp").forward(request, response);
                }
            }
        }else{
            response.sendRedirect("index.jsp");
        }

    }
}