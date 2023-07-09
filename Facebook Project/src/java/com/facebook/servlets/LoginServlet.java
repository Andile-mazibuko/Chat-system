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
    
        System.out.println(emailOrMobile);
        //System.out.println(findMatchingUser(emailOrMobile));
        
    }
    private List<FacebookUser> findMatchingUser(String emailOrPassword)
    {
        List<FacebookUser> allUsers = facebookUserFacade.findAll();
        List<FacebookUser> matchingAccounts = new ArrayList<>();
        
        
            for(int i = 0; i < allUsers.size(); i++)
            {
                
                    if(allUsers.get(i).getEmailAdddress().equalsIgnoreCase(emailOrPassword))
                    {
                        matchingAccounts.add(allUsers.get(i));
                    }
                
            }
        return matchingAccounts;
    }
    
    

}
