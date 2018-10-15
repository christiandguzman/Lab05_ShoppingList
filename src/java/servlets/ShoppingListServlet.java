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
        String user = (String) session.getAttribute("username");

        String action = request.getParameter("action");
        try {
            if (action.equalsIgnoreCase("logout")) {

                session.setAttribute("username", null);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
            }
        } catch (NullPointerException ex) {
            if (user != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                        .forward(request, response);
            }else{
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //put the username into the session

        String action = request.getParameter("action");

        switch (action) {

            case "register":
                String username = request.getParameter("username");

                if (username == null || username.equals("")) {

                    request.setAttribute("warning", "\nEnter a username");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                            .forward(request, response);
                    return;
                }
                session.setAttribute("username", username);
                break;

            case "add":

                //check session
                ArrayList<String> itemList = (ArrayList) session.getAttribute("list");
                if (itemList == null) {
                    itemList = new ArrayList<>();
                }

                String item = request.getParameter("itemName");
                if (item.equalsIgnoreCase("")) {
                    getServletContext()
                            .getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                            .forward(request, response);
                }
                itemList.add(item);
                session.setAttribute("list", itemList);
                break;

            case "delete":
                try {
                    itemList = (ArrayList) session.getAttribute("list");

                    String selected_button = request.getParameter("selected");
                   
                    for (String name : itemList) {
                        if (selected_button.equalsIgnoreCase(name)) {
                            itemList.remove(itemList.indexOf(name));
                            session.setAttribute("list", itemList);
                            getServletContext()
                            .getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                            .forward(request, response);
                            return;
                        }
                    }
                } catch (NullPointerException e) {

                    getServletContext()
                            .getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                            .forward(request, response);
                    
                }
                break;
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                .forward(request, response);
    }

}
