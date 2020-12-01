<%-- 
    Document   : updatetool
    Created on : Jun 26, 2020, 1:02:19 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Update Tool</h1>
        <form action="toolmanagement.jsp" method="POST">
            <input type="submit" value="Go back to Tool Manager Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        <br/><br/>
        <form action="MainControllerT" method="POST" style="width: 800px; height: 900px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            ID Tool*: <input type="text" name="txtIdT" value="${requestScope.TOOLDTO.id}${requestScope.ID}" readonly="readonly" /><br/><br/>
            Tool name*: <input type="text" name="txtName" value="${requestScope.TOOLDTO.name}${requestScope.NAME}" /><br/>
            <font color="red">${requestScope.INVALID.nameError}</font><br/>
            Tool Description*: <input type="text" name="txtDesc" value="${requestScope.TOOLDTO.desc}${requestScope.DESC}" /><br/>
            <font color="red">${requestScope.INVALID.descError}</font><br/>
            Quantity*: <input type="text" name="txtQuantity" value="${requestScope.TOOLDTO.quantity}${requestScope.QUAN}" /><br/>
            <font color="red">${requestScope.INVALID.quanError}</font><br/>
            Image: <input type="text" name="txtImg" value="${requestScope.TOOLDTO.image}${requestScope.IMG}" /><br/><br/>
                <input type="hidden" name="txtToolSearch" value="${requestScope.SEARCH}" />
            <input type="submit" value="Submit" name="action" />
            
        </form>
    </body>
</html>
