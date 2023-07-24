/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.FacebookUser;
import com.facebook.entities.Friend;
import com.facebook.processor.Notification;
import com.facebook.sessinbeans.FacebookUserFacadeLocal;
import com.facebook.sessinbeans.FriendFacadeLocal;
import java.io.IOException;
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
public class DashboardSesvlet extends HttpServlet {

    @EJB
    private FacebookUserFacadeLocal facebookUserFacade;

    @EJB
    private FriendFacadeLocal friendFacade;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        FacebookUser user = (FacebookUser)session.getAttribute("user");
        
           List<Friend> friends = friendFacade.findAll();
           
           List<Friend> friendRequests = new ArrayList<>();
           
           
            
        session.setAttribute("friendRequests", createNotifications(user, friends));
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    
    }
    
    private List<Notification> createNotifications(FacebookUser user,List<Friend> friends)
    {
        List<Notification> notifications = new ArrayList<>();
        for(Friend friendship : friends)
           {
               if(friendship.getFriend() == user.getId() && friendship.getFriendshipStatus().equalsIgnoreCase("waiting for approval"))
               {
                   notifications.add(new Notification(findSender(friendship.getUser()).getFirstName(), findSender(friendship.getUser()).getLastName(), friendship.getId(), 0));
               }
           }
        return notifications;
    }
    
    private FacebookUser findSender(long id)
    {
        return facebookUserFacade.find(id);
    }
    
    
}
