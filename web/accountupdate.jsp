<%-- 
    Document   : accountupdate
    Created on : Jun 23, 2020, 7:27:42 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Edit Account Page</h1>
        <form action="actormanagement.jsp" method="POST">
            <input type="submit" value="Go back to Account Manager Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        <br/><br/>
        <form action="MainController" method="POST" style="width: 800px; height: 900px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Username: <input type="text" name="txtUsername" value="${requestScope.DTO.username}${requestScope.USERNAME}" readonly="true" /><br/>
            <br/>
            Password: <input type="password" name="txtPassword" value="" /><br/><font color="red">
            ${requestScope.INVALID.passwordError}</font><br/>
            Confirm Password: <input type="password" name="txtConfirm" value="" /><br/>
            <font color="red">${requestScope.INVALID.confError}</font><br/>
            Role: <select name="cbxRole">
                <option <c:if test="${requestScope.DTO.role eq 'actor'}"> selected="true"</c:if>">actor</option>
                <option <c:if test="${requestScope.DTO.role eq 'director'}"> selected="true"</c:if>>director</option>
            </select><br/><br/>
            Full name: <input type="text" name="txtFullname" value="${requestScope.DTO.fullname}${requestScope.FULLNAME}" /><br/>
            <font color="red">${requestScope.INVALID.fullNameError}</font><br/>
            Description: <input type="text" name="txtDesc" value="${requestScope.DTO.desc}${requestScope.DES}" /><br/>
            <font color="red">${requestScope.INVALID.desError}</font><br/>
            Phone: <input type="text" name="txtPhone" value="${requestScope.DTO.phone}${requestScope.PHONE}" /><br/>
            <font color="red">${requestScope.INVALID.phoneError}</font><br/>
            Email: <input type="text" name="txtEmail" value="${requestScope.DTO.email}${requestScope.EMAIL}" /><select name="cbxTailEmail">
                <option>@gmail.com</option>
                <option>@fpt.edu.vn</option>
                <option>@gmail.com.vn</option>
                <option>@yahoo.com</option>
                <option>@yahoo.com.vn</option>
                
            </select><br/>
            <font color="red">${requestScope.INVALID.emailError}</font><br/>
            Image: <input type="text" name="txtImg" value="${requestScope.DTO.img}${requestScope.IMG}" /><br/><br/>
            <input type="hidden" name="txtSearch" value="${requestScope.SEARCH}" />
            <input type="submit" value="Update" name="action" />
            
        </form>
    </body>
</html>
