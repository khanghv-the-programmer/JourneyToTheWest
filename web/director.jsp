<%-- 
    Document   : director
    Created on : Jun 20, 2020, 10:46:06 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>

    
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Hello ${sessionScope.FULLNAME} the Director!</h1><br/><br/><br/>
        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action" style="width: 200px; height: 50px; font-size: 25px;border-radius:12px; background-color:rgba(180, 180, 180, 0.5); border-color: yellow;  border: 2px solid #f9d56e; color: white " />
        </form><br/><br/><br/><br/>
    <center><h2 style="width: 400px; height: 50px; background-color: white;border-radius: 12px; font-size: 30px; text-align: center; border: 3px solid orange"><font color="blue">What are you gonna do?</font></h2><br/><br/><br/><br/>
        <c:if test="${applicationScope.NOTIFICATION != null}">
        <c:if test="${not empty applicationScope.NOTIFICATION}">
            <c:forEach items="${applicationScope.NOTIFICATION}" var="notify" varStatus="counter">
                <c:if test="${sessionScope.FULLNAME eq notify.receiver}">
                    <form action="MainControllerA" style="width:500px; height: 70px; background-color: white; text-align: center;">
                        <h3 style="color: #e84a5f">${notify.content}</h3>
                        <input type="submit" value="Close" name="action" style="height: 25px; width: 200px; font-size: 20px" />
                    </form>

                </c:if>
            </c:forEach>
        </c:if>
    </c:if><br/><br/>
        <form action="shoppingactor.jsp" method="POST">  
            <input type="submit" value="Manage Actors With Scenes" name="action" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form><br/><br/>
        <form action="toolscenemanagement.jsp" method="POST">
            <input type="submit" value="Manage Tools With Scenes" name="action" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form><br/><br/>


        <form action="scenemanagement.jsp" method="POST">
            <button type="submit" value="Manage Scenes"  style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5); border-color: yellow; border: 2px solid #f9d56e; color: white ">Search Scenes</button>    
        </form><br/><br/>

    </body>
</html>
