<%-- 
    Document   : viewhistory
    Created on : Jul 11, 2020, 3:24:05 PM
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
        <h1 style="color: #e84a5f; font-size: 5em">View Completed Scene</h1>
        <form action="actor.jsp" method="POST">
            <input type="submit" value="Go Back" name="action" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form><br/><br/>
        <c:if test="${requestScope.HISTORY != null}">
            <c:if test="${not empty requestScope.HISTORY}" var="isNotEmpty">
                <table border="1" style="background-color: white">
                    <thead>
                        <tr>
                            <th style="font-size: 18px; text-align: center">Number</th>
                            <th style="font-size: 18px; text-align: center">ID Scene</th>
                            <th style="font-size: 18px; text-align: center">Scene Name</th>
                            <th style="font-size: 18px; text-align: center">Location</th>
                            <th style="font-size: 18px; text-align: center">Start Time</th>
                            <th style="font-size: 18px; text-align: center">End Time</th>
                            <th style="font-size: 18px; text-align: center">Takes</th>
                            <th style="font-size: 18px; text-align: center">Username</th>
                            <th style="font-size: 18px; text-align: center">Full name</th>
                            <th style="font-size: 18px; text-align: center">Acting As</th>
                            <th style="font-size: 18px; text-align: center">Image</th>
                            <th style="font-size: 18px; text-align: center">Description</th>
                            <th style="font-size: 18px; text-align: center">Last Update</th>
                            <th style="font-size: 18px; text-align: center">Download Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.HISTORY}" var="dto" varStatus="counter">
                        <tr>
                            <td style="font-size: 18px; text-align: center">${counter.count}</td>
                            <td style="font-size: 18px; text-align: center">${dto.idsc}</td>
                            <td style="font-size: 18px; text-align: center">${dto.scname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.loc}</td>
                            <td style="font-size: 18px; text-align: center">${dto.start}</td>
                            <td style="font-size: 18px; text-align: center">${dto.end}</td>
                            <td style="font-size: 18px; text-align: center">${dto.takes}</td>
                            <td style="font-size: 18px; text-align: center">${dto.username}</td>
                            <td style="font-size: 18px; text-align: center">${dto.fullname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.acting}</td>
                            <td style="font-size: 18px; text-align: center"><img src="${dto.img}" width="100" height="100"/></td>
                            <td style="font-size: 18px; text-align: center"><a href="${dto.desc}">Description</a></td>
                            <td style="font-size: 18px; text-align: center">${dto.time}</td>
                            <td>
                                    <form action="MainControllerA" method="POST">
                                        <input type="submit" value="Download" name="action" class="btn-search"style="height: 50px; width: 200px; font-size: 30px" />
                                    </form>
                                </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!isNotEmpty}">
                <h2><font color="blue" style="font-size: 30px; background-color: white">Hmmm...Looks like you haven't attended any scenes before</font></h2>
            </c:if>
        </c:if>
    </body>
</html>
