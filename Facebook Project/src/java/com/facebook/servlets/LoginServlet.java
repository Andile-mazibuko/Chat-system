/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.FacebookUser;
import com.facebook.processor.ProcessorLocal;
import com.facebook.sessinbeans.FacebookUserFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andil
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private ProcessorLocal processor;

    @EJB
    private FacebookUserFacadeLocal facebookUserFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script>"
                    + "window.sessionStorage.setItem(\"pass\", \"incorrect\");"
                    + "alert('hi');"
                    + "setTimeout(() => {\n" +
"            window.location.href = 'index.html';\n" +
"         }, 0);"
                    + "</script>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession(true);
        String emailOrMobile = request.getParameter("email_or_phone");
        String password = request.getParameter("password");

        FacebookUser user = processor.findCorrectUser(processor.findMatchingUsers(emailOrMobile), password);
        if(user == null)
        {
            processRequest(request, response);
        }else{
            session.setAttribute("user", user);
            response.sendRedirect("DashboardSesvlet.com");
    
        }
    }
    

}
