<%-- 
    Document   : createaccount
    Created on : Jun 22, 2020, 4:57:57 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Create Account Page</h1>
        <form action="actormanagement.jsp" method="POST">
            <input type="submit" value="Go back to Account Manager Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        <form action="MainController" method="POST" style="width: 800px; height: 900px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Username*: <input type="text" name="txtUsername" value="${requestScope.USERNAME}" /><br/><font color="red">
            ${requestScope.INVALID.usernameError}
            ${requestScope.DUP}
            </font>
            
            <br/>
            Password*: <input type="password" name="txtPassword" value="" /><br/><font color="red">
            ${requestScope.INVALID.passwordError}</font><br/>
            Confirm Password*: <input type="password" name="txtConfirm" value="" /><br/>
            <font color="red">${requestScope.INVALID.confError}</font><br/>
            Role*: <select name="cbxRole" style="font-size: 20px; width: 300px">
                <option>actor</option>
                <option>director</option>
            </select><br/><br/>
            Full name*: <input type="text" name="txtFullname" value="${requestScope.FULLNAME}" /><br/>
            <font color="red">${requestScope.INVALID.fullNameError}</font><br/>
            Description*: <input type="text" name="txtDesc" value="${requestScope.DESC}" /><br/>
            <font color="red">${requestScope.INVALID.desError}</font><br/>
            Phone*: <input type="text" name="txtPhone" value="${requestScope.PHONE}" /><br/>
            <font color="red">${requestScope.INVALID.phoneError}</font><br/>
            Email*: <input type="text" name="txtEmail" value="${requestScope.EMAIL}" /><select name="cbxTailEmail" style="font-size: 20px; width: 300px">
                <option>@gmail.com</option>
                <option>@fpt.edu.vn</option>
                <option>@gmail.com.vn</option>
                <option>@yahoo.com</option>
                <option>@yahoo.com.vn</option>
                
            </select><br/><br/>
            <font color="red">${requestScope.INVALID.emailError}</font><br/>
            Image (a link): <input type="text" name="txtImg" value="${requestScope.IMG}" /><br/><br/>

            <input type="submit" value="Create Account" name="action" /><br/><br/>
            * : necessary
        </form>
    
    </body>
</html>
