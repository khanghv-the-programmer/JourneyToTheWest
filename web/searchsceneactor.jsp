<%-- 
    Document   : searchsceneactor
    Created on : Jul 4, 2020, 3:26:44 PM
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
        <h1 style="color: #e84a5f; font-size: 5em">Search Scene & Actor assigned</h1>
        <form action="shoppingactor.jsp" method="POST" >
            <input type="submit" value="Go back" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
        <form action="MainControllerD" method="POST" style ="width: 600px; height: 400px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Search: <input type="text" name="txtSearch" value="" /> (You just need to type (a) letter(s) contained in the name of actor/scene)<br/><br/>
            Search by: <select name="cbxSearch">
                <option>Name of actor</option>
                <option>Name of scene</option> 
            </select>
            
                <input type="submit" value="Search" name="action" /><br/><br/>
            </form><br/>
            <h2><font color="red" style="font-size: 30px; background-color: white">${EMPTY}</font></h2>
            <br/>
        
        <c:if test="${requestScope.ACLIST != null}">
            <c:if test="${not empty requestScope.ACLIST}" var="notEmpty">
                <table border="1" style="background-color: white">
                    <thead>
                        <tr>
                            <th style="font-size: 18px; text-align: center">Number</th>
                            <th style="font-size: 18px; text-align: center">Scene ID</th>
                            <th style="font-size: 18px; text-align: center">Scene Name</th>
                            <th style="font-size: 18px; text-align: center">Username</th>
                            <th style="font-size: 18px; text-align: center">Full name</th>
                            <th style="font-size: 18px; text-align: center">Location</th>
                            <th style="font-size: 18px; text-align: center">Casting as</th>
                            <th style="font-size: 18px; text-align: center">Character Description</th>
                            <th style="font-size: 18px; text-align: center">Role</th>
                            <th style="font-size: 18px; text-align: center">Actor Image</th>
                            <th style="font-size: 18px; text-align: center">Last Update Time</th>
                            <th style="font-size: 18px; text-align: center">Delete<th/>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.ACLIST}" var="dto" varStatus="counter">
                        <tr>
                            <td style="font-size: 18px; text-align: center">${counter.count}</td>
                            <td style="font-size: 18px; text-align: center">${dto.idsc}</td>
                            <td style="font-size: 18px; text-align: center">${dto.scname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.username}</td>
                            <td style="font-size: 18px; text-align: center">${dto.fullname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.loc}</td>
                            <td style="font-size: 18px; text-align: center">${dto.acting}</td>
                            <td style="font-size: 18px; text-align: center"><a href="${dto.desc}">Click here</a></td>
                            <td style="font-size: 18px; text-align: center">${dto.role}</td>
                            <td><img src="${dto.img}" width="100" height="100"/></td>
                            <td style="font-size: 18px; text-align: center">${dto.time}</td>
                            <td> <form action="MainControllerD" method="POST">
                                    <input type="submit" name="action" value="Delete" class="btn-search"style="height: 50px; width: 110px; font-size: 30px"/>
                                    <input type="hidden" name="idscene" value="${dto.idsc}"/>
                                    <input type="hidden" name="username" value="${dto.username}"/>
                                    <input type="hidden" name="Search" value="${param.txtSearch}" />
                                    <input type="hidden" name="By" value="${param.cbxSearch}" />

                                </form></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!notEmpty}">
                <font color="red" style="font-size: 30px; background-color: white"><h2>No result!</h2></font>
            </c:if>
        </c:if>
    
    </body>
</html>
