/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.Friend;
import com.facebook.sessinbeans.FriendFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andil
 */
public class ApproveOrDeleteFriend extends HttpServlet {

    @EJB
    private FriendFacadeLocal friendFacade;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApproveOrDeleteFriend</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApproveOrDeleteFriend at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String results = request.getParameter("request button");
        takeAction(results);
        
        response.sendRedirect("DashboardSesvlet.com");
    }
    
    private void takeAction(String results)throws IndexOutOfBoundsException
    {
        String[] resultSplit = results.split(":");
        Friend friendship = friendFacade.find(Long.parseLong(resultSplit[1]));
        if(resultSplit[0].equalsIgnoreCase("Confirm"))
        {
            friendship.setFriendshipStatus("Friends");
            friendFacade.edit(friendship);
        }else
        {
            friendFacade.remove(friendship);
        }
    }

}
