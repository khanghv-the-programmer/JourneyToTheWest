<%-- 
    Document   : addsceneactor
    Created on : Jul 2, 2020, 1:35:36 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">ADD ACTORS TO SCENES</h1>
        <br/><br/>
        <form action="shoppingactor.jsp" method="POST">
            <input type="submit" value="Go back" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white " />    
        </form><br/><br/>
        <form action="MainControllerD" method="POST" style="width: 1000px; height: 400px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Actor: <c:if test="${requestScope.ADTO != null}">
                <select name="cbxActor">
                    <c:if test="${not empty requestScope.ADTO}" var="isNotEmpty">

                        <c:forEach items="${requestScope.ADTO}" var="adto">
                            <option>${adto.username} - ${adto.fullname}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${!isNotEmpty}">
                        Nothing here . . .
                    </c:if>
                </select>

            </c:if> 
            &nbsp; &nbsp;
            Scene: <c:if test="${requestScope.SDTO != null}">
                <select name="cbxScene">
                    <c:if test="${not empty requestScope.SDTO}" var="isNotEmpty">

                        <c:forEach items="${requestScope.SDTO}" var="sdto">
                            <option>${sdto.id} - ${sdto.name}"</option>

                        </c:forEach>
                    </c:if>
                    <c:if test="${!isNotEmpty}">
                        <option>Nothing here . . .</option>
                    </c:if>
                </select>

            </c:if>

            <br/><br/>
            Description (a link, you can skip): <input type="text" name="txtDesc" value="" /><br/><br/>
            Cast as : <input type="text" name="txtCast" value="" /><br/>
            <h2><font color="red">${requestScope.CAST}</font></h2>
            <br/>
            <input type="hidden" name="txtEditor" value="${requestScope.NAME}" />
            <input type="submit" value="Confirm" name="action" />
            <h2><font color="red" style="background-color: white">${requestScope.INVALID}</font></h2><h2><font color="green" style="background-color: white">${requestScope.DONE}</font></h2><br/>
            
        </form>


        <form action="requestofadmin.jsp" method="POST">
            <input type="submit" value="View your orders" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form>

    </body>
</html>
