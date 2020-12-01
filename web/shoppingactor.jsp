<%-- 
    Document   : shoppingactor
    Created on : Jul 2, 2020, 2:19:57 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" />
        <title>Actor Scene Management Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">DIRECTOR'S WORKSPACE</h1>
        <form action="director.jsp" method="POST">
            <input type="submit" value="Back to Director Page" style="width: 300px; height: 50px; font-size: 25px;border-radius:12px; background-color:rgba(180, 180, 180, 0.5); border-color: yellow;  border: 2px solid #f9d56e; color: white " /><br/><br/>  
        </form><br/><br/><br/><br/><br/>
    <center>
        <form action="MainControllerD" method="POST">
            <input type="submit" value="Sign actors to scenes" name="action" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white"/><br/><br/>
            <input type="hidden" name="txtFullname" value="${sessionScope.FULLNAME}" />
        </form><br/><br/>

        <form action="searchsceneactor.jsp" method="POST">
            <input type="submit" value="Search actors and scenes" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white"/><br/><br/>
        </form><br/><br/>
        
        <form action="actormanagement.jsp" method="POST">
            <button type="submit" value="Manage Accounts" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white ">Search Accounts</button>    
        </form><br/><br/>
        
    </center>


</body>
</html>
