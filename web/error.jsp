<%-- 
    Document   : error
    Created on : Jun 20, 2020, 10:19:33 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body style="background: url(https://wallpaperaccess.com/full/737751.jpg); background-size: cover">
      
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center; background-color: white">ERROR!</h1>
        <h2 style="background-color: white; color: red; font-size: 40px;border-radius:12px; text-align: center">
            ${requestScope.ERROR}
        </h2>
        <form action="index.jsp" method="POST">
                <input type="submit" value="Back to the login page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
            </form>
        
        
    </body>
</html>
