/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.FacebookMessage;
import com.facebook.entities.FacebookUser;
import static com.facebook.entities.FacebookUser_.friends;
import com.facebook.entities.Friend;
import com.facebook.entities.Post;
import com.facebook.sessinbeans.FacebookUserFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
public class SignupServlet extends HttpServlet {

    @EJB
    private FacebookUserFacadeLocal facebookUserFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("surname");
        String birthDay = request.getParameter("day");
        String birthMonth = request.getParameter("month");
        String birthYear = request.getParameter("year");
        String gender = request.getParameter("gender");
        String mobileORemail = request.getParameter("mobileORemail");
        String password = request.getParameter("password");
        Date date = new Date(Integer.parseInt(birthYear),Integer.parseInt(birthMonth),Integer.parseInt(birthDay));
        
        FacebookUser user = createUser(firstName, lastName, gender, date, password, mobileORemail);
        
        facebookUserFacade.create(user);
        session.setAttribute(lastName, date);
        
    }
    private FacebookUser createUser(String firstname,String lastName,String gender,Date dateofBirth,String password,String emailOrPassword)
    {
        List<FacebookMessage> messages = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Friend> friends = new ArrayList<>();
        FacebookUser user = new FacebookUser();
        
        user.setFirstName(firstname);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setDateOfBirth(dateofBirth);
        user.setPassword(password);
        user.setFriends(friends);
        user.setPosts(posts);
        user.setMessages(messages);
        if(isCellphoneNumber(emailOrPassword))
        {
           user.setCellphoneNumber(Long.parseLong(emailOrPassword));
        }else
        {
            user.setEmailAdddress(emailOrPassword);
        }
        
        return user;
    }
    private boolean isCellphoneNumber(String mobileOrCellphone)
    {
        boolean isCellNo = false;
        
        int length = mobileOrCellphone.length();
        if(mobileOrCellphone.length() == 10)
        {
            for(int i = 0; i < length; i++)
            {
                if(Character.isDigit(mobileOrCellphone.charAt(i)))
                {
                    isCellNo = true;
                }
                else
                {
                    isCellNo = false;
                    break;
                }
            }
        }else
        {
            isCellNo = false;
        }
        
        return isCellNo;
    }

}
