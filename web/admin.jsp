<%-- 
    Document   : admin
    Created on : Jun 20, 2020, 10:45:30 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" />
        <title>Admin Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <br/><br/><h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Hello ${sessionScope.FULLNAME} (Admin)</h1><br/><br/>

        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action" style="width: 200px; height: 50px; font-size: 25px;border-radius:12px; background-color:rgba(180, 180, 180, 0.5); border-color: yellow;  border: 2px solid #f9d56e; color: white " />
        </form><br/><br/>
        
        
    <center>
        <form action="actormanagement.jsp" method="POST">
            <input type="submit" value="Manage Accounts" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
        <form action="toolmanagement.jsp" method="POST">
            <input type="submit" value="Manage Tools" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5); border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
        
        <form action="scenemanagement.jsp" method="POST">
            <input type="submit" value="Manage Scenes"  style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5); border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
    
        <form action="requestofadmin.jsp" method="POST">
            <input type="submit" value="Get Request Scene And Actor" style="width: 700px; height: 50px; font-size:25px;border-radius: 12px; background-color: rgba(180, 180, 180, 0.5);border-color: yellow; border: 2px solid #f9d56e; color: white"/>
        </form><br/><br/>
        <form action="viewtoolsceneorder.jsp" method="POST">
            <input type="submit" value="Get Request Tool And Scene" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
        
        <form action="searcheverything.jsp" method="POST">
            <input type="submit" value="Search Tools, Actors that are assigned to Scenes" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background: rgba(180, 180, 180, 0.5); border-color: yellow; border: 2px solid #f9d56e; color: white " />    
        </form><br/><br/>
        </center>
        
        
    </body>
</html>
