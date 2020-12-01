<%-- 
    Document   : searcheverything
    Created on : Jul 10, 2020, 4:14:27 PM
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
        <h1 style="color: #e84a5f; font-size: 5em">Search Everything Page</h1>
        <form action="admin.jsp" method="POST" >
            <input type="submit" value="Go back to admin page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form><br/><br/>
        <form name="action" action="MainController" method="POST" style ="width: 600px; height: 400px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Search: <input type="text" name="txtSearch" value="" />&nbsp; (You just need to type (a) letter(s) contained in the name of actor/scene/tool)&nbsp;
            Search By: <select name="cbxHow">
                <option>Search By Scene</option>
                <option>Search By Actor</option>
                <option>Search By Tool</option>
            </select>&nbsp;&nbsp;
            <input type="submit" value="Look Up" name="action"/>
        </form><br/><h2><font color="red" style="font-size: 30px; background-color: white">${EMPTY}</font></h2><br/>
        
            <c:if test="${requestScope.LIST != null}">
                <c:if test="${not empty requestScope.LIST}" var="isNotEmpty">
                <table border="2" width="1" cellspacing="1" cellpadding="2" style="background-color: white">
                    <thead>
                        <tr>
                            <th style="font-size: 18px; text-align: center">Number</th>
                            <th style="font-size: 18px; text-align: center">ID Scene</th>
                            <th style="font-size: 18px; text-align: center">Scene Name</th>
                            <th style="font-size: 18px; text-align: center">Start Time</th>
                            <th style="font-size: 18px; text-align: center">End Time</th>
                            <th style="font-size: 18px; text-align: center">Time Takes</th>
                            <th style="font-size: 18px; text-align: center">Username</th>
                            <th style="font-size: 18px; text-align: center">Full name</th>
                            <th style="font-size: 18px; text-align: center">Email</th>
                            <th style="font-size: 18px; text-align: center">Phone</th>
                            <th style="font-size: 18px; text-align: center">Actor's Image</th>
                            <th style="font-size: 18px; text-align: center">Role</th>
                            <th style="font-size: 18px; text-align: center">Acting As</th>
                            <th style="font-size: 18px; text-align: center">Tool Name</th>
                            <th style="font-size: 18px; text-align: center">Quantity Available</th>
                            <th style="font-size: 18px; text-align: center">Quantity Need For The Scene</th>
                            <th style="font-size: 18px; text-align: center">Tool's Image</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LIST}" var="dto" varStatus="counter">
                            <tr>
                                <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                <td style="font-size: 18px; text-align: center">${dto.sid}</td>
                                <td style="font-size: 18px; text-align: center">${dto.sname}</td>
                                <td style="font-size: 18px; text-align: center">${dto.start}</td>
                                <td style="font-size: 18px; text-align: center">${dto.end}</td>
                                <td style="font-size: 18px; text-align: center">${dto.takes}</td>
                                <td style="font-size: 18px; text-align: center">${dto.username}</td>
                                <td style="font-size: 18px; text-align: center">${dto.fullname}</td>
                                <td style="font-size: 18px; text-align: center">${dto.email}</td>
                                <td style="font-size: 18px; text-align: center">${dto.phone}</td>
                                <td><img src="${dto.aimg}" width="100" height="100"/></td>
                                <td style="font-size: 18px; text-align: center">${dto.role}</td>
                                <td style="font-size: 18px; text-align: center">${dto.acting}</td>
                                <td style="font-size: 18px; text-align: center">${dto.tname}</td>
                                <td style="font-size: 18px; text-align: center">${dto.qhad}</td>
                                <td style="font-size: 18px; text-align: center">${dto.qneed}</td>
                                <td><img src="${dto.timg}" width="100" height="100"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!isNotEmpty}">
                <font color="red" style="font-size: 30px; background-color: white"><h2>No result!</h2></font>
            </c:if>
        </c:if>
    </body>
</html>
