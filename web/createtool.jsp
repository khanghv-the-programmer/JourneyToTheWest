<%-- 
    Document   : createtool
    Created on : Jun 27, 2020, 12:07:32 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Create tool</h1>
        <form action="toolmanagement.jsp" method="POST">
            <input type="submit" value="Go back to Tool Manager Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        <form action="MainControllerT" method="POST" style="width: 600px; height: 700px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Tool Name*:  <input type="text" name="txtToolName" value="${requestScope.NAME}" /><br/>
            <font color="red">${requestScope.INVALID.nameError}</font><br/>
            Description*: <input type="text" name="txtDesc" value="${requestScope.DESC}" /><br/>
            <font color="red">${requestScope.INVALID.descError}</font><br/>
            Quantity*: <input type="text" name="txtQuantity" value="${requestScope.QUAN}" /><br/>
            <font color="red">${requestScope.INVALID.quanError}</font><br/>
            Image (a link): <input type="text" name="txtImg" value="${requestScope.IMG}" /><br/><br/>
            <input type="submit" value="Create Tool" name="action"/> <br/><br/>
            * : necessary
        </form>
        
    </body>
</html>
