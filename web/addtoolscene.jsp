<%-- 
    Document   : addtoolscene
    Created on : Jul 6, 2020, 3:21:57 PM
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
    <body  style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Tool-Scene Request Page</h1>
        <form action="toolscenemanagement.jsp" method="POST">
            <input type="submit" value="Go Back" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form><br/><br/>
        <form action="MainControllerTS" method="POST" style="width: 1000px; height: 400px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Scene:  <c:if test="${requestScope.SLIST != null}">
                <select name="cbxScene">
                    <c:if test="${not empty requestScope.SLIST}" var="sListNotNull">
                        <c:forEach items="${requestScope.SLIST}" var="sList">
                            <option>${sList.id} - ${sList.name}</option>
                        </c:forEach>
                    </c:if>

                    <c:if test="${!sListNotNull}">
                        <option>Nothing here . . .</option>
                    </c:if> &nbsp;(ID Scene - Scene Name)
                    &nbsp;
                </select>(ID Scene - Scene Name) &nbsp;
            </c:if> <br/><br/>
            Tool:  <c:if test="${requestScope.TLIST != null}">
                <select name="cbxTool">
                    <c:if test="${not empty requestScope.TLIST}" var="tListNotNull">
                        <c:forEach items="${requestScope.TLIST}" var="tList">
                            <option>${tList.id} - ${tList.name} - ${tList.quantity}</option>
                        </c:forEach>
                    </c:if> 

                    <c:if test="${!tListNotNull}">
                        <option>Nothing here . . .</option>
                    </c:if>
                </select> (ID Tool - Tool Name - Quantity in repository)
            </c:if>
            &nbsp;<br/><br/>
            Quantity: <input type="text" name="txtQuantity" value="" />
            <h2><font color="red">${requestScope.QUAN}</font></h2><h2><font color="green">${requestScope.DONE}</font></h2>  

            <input type="submit" value="Assign" name="action" />
        </form><br/><br/><br/>
        
        
        <form action="viewtoolsceneorder.jsp" method="POST">
            <input type="submit" value="View your cart" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form><br/><br/>

    </body>
</html>
