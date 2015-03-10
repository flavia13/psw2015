/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sflesca
 */
public class HelloWorld extends HttpServlet {

    int cont=0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        String strCont = config.getInitParameter("paramContatore");
        cont= Integer.parseInt(strCont);
    }

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Cookie cok =  new Cookie("name", new Integer(cont).toString());
            cok.setMaxAge(-1);
            response.addCookie(cok);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            out.println("<h2>Lanciato il "+new Date()+" </h2>");
            out.println("<p>Chiamato "+ ++cont + " volte</p>");
            out.println("<p>Chiamato con metodo "+ request.getMethod() + "</p>");
            out.println("<p>Chiamato con query "+ request.getQueryString()+ "</p>");
            out.println("<p>Chiamato con parametro xxx="+ request.getParameter("xxx")+ "</p>");
            out.println("<p>Chiamato con parametro yyy="+ request.getParameter("yyy")+ "</p>");
            out.println("<h1>Cookie della richiesta</h1>");
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
            for(int i=0; i<cookies.length; i++) {
		Cookie c = cookies[i];
		if (c.getName().equals("name")) {
			out.println("<h1>Valore del cookie cont"+c.getValue()+"</h1>");
		break;
		}
	}
}

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
