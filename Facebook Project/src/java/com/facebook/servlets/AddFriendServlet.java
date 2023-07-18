/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.FacebookUser;
import com.facebook.entities.Friend;
import com.facebook.processor.ProcessorLocal;
import com.facebook.sessinbeans.FacebookUserFacadeLocal;
import com.facebook.sessinbeans.FriendFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddFriendServlet extends HttpServlet {

    @EJB
    private FacebookUserFacadeLocal facebookUserFacade;

    @EJB
    private FriendFacadeLocal friendFacade;

    @EJB
    private ProcessorLocal processor;



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddFriendServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddFriendServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        FacebookUser user = (FacebookUser)session.getAttribute("user");
        Long friendId = Long.parseLong(request.getParameter("friendId"));
           
        Friend friendship = processor.createFacebookFriendship(user.getId(),friendId);
        friendFacade.create(friendship);
        //user.getFriends().add(friendship);
        
        facebookUserFacade.edit(user);
        response.sendRedirect("DashboardSesvlet.com");
    }
   
}
