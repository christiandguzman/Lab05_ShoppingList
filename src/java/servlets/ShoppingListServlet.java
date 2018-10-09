/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 683676
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //variables
        HttpSession session = request.getSession();
        ArrayList<String> listItems= new ArrayList<>();
        
        if(session.getAttribute("username")!=null){
            listItems = (ArrayList)session.getAttribute("list");
            request.setAttribute("list", listItems);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                    .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        //put the username into the session
        
        
        String action = request.getParameter("action");
        
        switch(action){
            case "logout":
                
                break;
            case "delete":
                
                break;
            case "register":
                String username = request.getParameter("username");
                session.setAttribute("username", username);

                if (username == null || username.equals("")) {
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                            .forward(request, response);
                }
                break;
                  
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                    .forward(request, response);
        
        
    } 

}
