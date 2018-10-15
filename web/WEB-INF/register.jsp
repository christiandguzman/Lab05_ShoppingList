<%-- 
    Document   : register
    Created on : Oct 9, 2018, 12:14:43 PM
    Author     : 683676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="shoppinglist">
            <input type="hidden" name="action" value="register">
            Username: <input type="text" name="username">
            <input type="submit" value="Register Name">
            <br>
            ${warning}
            <br>
        </form>
    </body>
</html>
