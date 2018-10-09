<%-- 
    Document   : shoppinglist
    Created on : Oct 9, 2018, 12:11:03 PM
    Author     : 683676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} 
        <a href="<c:url value='shoppinglist?action=logout'/>">Logout</a>
        <br>
        
        <h2>List</h2>
        
        <form type="post" action="register" >
            Add item:
            <input type="text" name="item">            
            <input type="button" value="add" >

            <br>
            <c:forEach items ="${list}" var="item">
                <li>
                    <input type="radio" name="${item}">
                    ${item}
                </li>
            </c:forEach>
                
            <br>
            <br>
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="delete">

        </form>
    </body>
</html>
