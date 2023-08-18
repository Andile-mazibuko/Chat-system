/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.servlets;

import com.facebook.entities.Post;
import com.facebook.sessinbeans.PostFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author andil
 */
@MultipartConfig
public class PostServlet extends HttpServlet {

    @EJB
    private PostFacadeLocal postFacade;


   /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        Part part = request.getPart("post-file");
        String caption = request.getParameter("post-content");
                
        InputStream is = part.getInputStream();
        
        byte[] postFile = new byte[is.available()];
        is.read(postFile);
        
        Post post = makePost(caption, postFile,part.getSubmittedFileName());
        //String fileName = part.getSubmittedFileName();
        //post.setFileName( post.getId()+ ""+ fileName.substring(fileName.length()-4, fileName.length()));
        postFacade.create(post);
        
        response.sendRedirect("DashboardSesvlet.com");
    }

    private Post makePost(String caption,byte[] file,String fileName)
    {
        Post post = new Post();
        post.setCaption(caption);
        post.setIsProfilePicture(false);
        post.setPostMedia(file);
        post.setFileName(fileName);
        
        return post;
    }
}
