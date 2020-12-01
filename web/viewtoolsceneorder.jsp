<%-- 
    Document   : viewtoolsceneorder
    Created on : Jul 7, 2020, 5:45:14 PM
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
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Tool Scene Order Page</h1>
        <h2 style="color: red; font-size: 40px;border-radius:12px; text-align: center">You are a/an ${sessionScope.ROLE}</h2>
        <h2><font color="green">${requestScope.DONE}</font></h2>
        <h2><font color="red">${requestScope.FAILED}</font></h2>
            <c:if test="${sessionScope.ROLE eq 'admin'}">
                <c:if test="${applicationScope.TCART.cart != null}" var="isNotNull">
                    <c:if test="${not empty applicationScope.TCART.cart}" var="notEmptyTool">

                    <table border="1" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">Id Cart</th>
                                <th style="font-size: 18px; text-align: center">Id Scene</th>
                                <th style="font-size: 18px; text-align: center">Id Tool</th>
                                <th style="font-size: 18px; text-align: center">Quantity</th>
                                <th style="font-size: 18px; text-align: center">Editor</th>
                                <th>Accept</th>
                                <th>Decline</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${applicationScope.TCART.cart}" var="dto" varStatus="counter">

                                <tr>
                                    <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.cId}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.sid}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.tid}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.quantity}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.editor}</td>
                                    <td><form action="MainController" method="POST">
                                            <input type="hidden" name="number" value="${counter.count}" />
                                            <input type="submit" value="Assign Tool" name="action"/>
                                        </form></td>
                                    <td><form action="MainController" method="POST">
                                            <input type="hidden" name="number" value="${counter.count}" />
                                            <input type="hidden" name="editor" value="${dto.editor}" />
                                            <input type="hidden" name="idcart" value="${dto.cId}" />
                                            <input type="submit" value="Decline Tool" name="action"/>
                                        </form></td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>
                <c:if test="${!notEmptyTool}">
                    No result, empty cart!
                </c:if>

            </c:if>
            <c:if test="${!isNotNull}">
                <h1><font color="blue" style="background-color: white" >Cart has been remove or there is no Cart</font></h1>
                </c:if>
            <form action="admin.jsp" method="POST">
                <input type="submit" value="Back to admin Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
            </form>
        </c:if>
        <c:if test="${sessionScope.ROLE eq 'director'}">
            <h2><font color="red">${applicationScope.DECLINE}</font></h2>
            <h2><font color="green">${applicationScope.OK}</font></h2>
                <c:if test="${applicationScope.TCART.cart != null}" var="isNotEmpty">
                    <c:if test="${not empty applicationScope.TCART.cart}" var="notEmptyTool">
                    <table border="1" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">Id Cart</th>
                                <th style="font-size: 18px; text-align: center">Id Scene</th>
                                <th style="font-size: 18px; text-align: center">Id Tool</th>
                                <th style="font-size: 18px; text-align: center">Quantity</th>
                                <th style="font-size: 18px; text-align: center">Editor</th>
                                <th style="font-size: 18px; text-align: center">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${applicationScope.TCART.cart}" var="dto" varStatus="counter">
                                <c:if test="${sessionScope.FULLNAME eq dto.editor}">
                                    <tr>
                                        <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                        <td style="font-size: 18px; text-align: center">${dto.cId}</td>
                                        <td style="font-size: 18px; text-align: center">${dto.sid}</td>
                                        <td style="font-size: 18px; text-align: center">${dto.tid}</td>
                                        <td style="font-size: 18px; text-align: center">${dto.quantity}</td>
                                        <td style="font-size: 18px; text-align: center">${dto.editor}</td>
                                        <td><form action="MainController" method="POST">
                                            <input type="hidden" name="number" value="${counter.count}" />
                                            <button type="submit" value="Decline Tool" name="action">Delete</button>
                                        </form></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>
                <c:if test="${!notEmptyTool}">
                    No result, empty cart!
                </c:if>
            </c:if>
            <c:if test="${!isNotEmpty}">
                <h1><font color="blue"  style="background-color: white">Cart has been remove or there is no Cart</font></h1>
                </c:if>
                <br/><br/>
            <form action="toolscenemanagement.jsp" method="POST">
                <input type="submit" value="Back to Tool Scene Management Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
            </form>
        </c:if>

    </body>
</html>
