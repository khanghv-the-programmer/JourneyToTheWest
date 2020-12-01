<%-- 
    Document   : toolscenemanagement
    Created on : Jul 6, 2020, 2:57:07 PM
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

        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">DIRECTOR'S WORKSPACE</h1><br/><br/><br/>
        <form action="director.jsp" method="POST">
            <input type="submit" value="Back to Director Page" 
                   style="width: 300px; height: 50px; font-size: 25px;border-radius:12px; background-color:rgba(180, 180, 180, 0.5); border-color: yellow;  border: 2px solid #f9d56e; color: white " />    
        </form><br/><br/><br/><br/>
    <center>
        <form action="MainControllerTS" method="POST">
            <input type="submit" value="Sign tools to scenes" name="action" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white"/><br/><br/>
            <input type="hidden" name="txtFullname" value="${sessionScope.FULLNAME}" />
        </form><br/><br/>

        <form action="searchscenetool.jsp" method="POST">
            <input type="submit" value="Search tools and scenes" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white"/><br/><br/>
        </form><br/><br/>
        
        <form action="toolmanagement.jsp" method="POST">
            <button type="submit" value="Manage Tools" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5); border-color: yellow; border: 2px solid #f9d56e; color: white ">Search Tools</button>    
        </form><br/><br/>
        
        </center>

    </body>
</html>
