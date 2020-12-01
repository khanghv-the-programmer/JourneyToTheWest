<%-- 
    Document   : searchscenetool
    Created on : Jul 6, 2020, 3:03:00 PM
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
        <h1 style="color: #e84a5f; font-size: 5em">Search Tools & Scenes</h1>
        <form action="toolscenemanagement.jsp" method="POST">
            <input type="submit" value="Go back" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white " />    
        </form>
        <form action="MainControllerD" method="POST" style ="width: 600px; height: 300px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Search:   <input type="text" name="txtSearch" value="" /> (You just need to type (a) letter(s) contained in the name of tool/scene)
            &nbsp;
            <select name="cbxHow">
                <option>Search By Scene</option>
                <option>Search By Tool</option>
            </select><br/><br/>
            <input type="submit" value="Find" name="action" />
        </form><br/><br/>
        <br/><h2><font color="red" style="font-size: 30px; background-color: white">${EMPTY}</font></h2><br/>
            <c:if test="${requestScope.TOOLSCENE != null}">
                <c:if test="${not empty requestScope.TOOLSCENE}" var="listNotNull">
                <table border="1" style="background-color: white">
                    <thead>
                        <tr>
                            <th style="font-size: 18px; text-align: center">Number</th>
                            <th style="font-size: 18px; text-align: center">Cart ID</th>
                            <th style="font-size: 18px; text-align: center">Scene ID</th>
                            <th style="font-size: 18px; text-align: center">Scene Name</th>
                            <th style="font-size: 18px; text-align: center">Tool's quantity Need</th>
                            <th style="font-size: 18px; text-align: center">Tool ID</th>
                            <th style="font-size: 18px; text-align: center">Tool Name</th>
                            <th style="font-size: 18px; text-align: center">Tool's quantity Had</th>
                            <th style="font-size: 18px; text-align: center">Start Time</th>
                            <th style="font-size: 18px; text-align: center">End Time</th>
                            <th style="font-size: 18px; text-align: center">Last Update Time</th>
                            <th style="font-size: 18px; text-align: center">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.TOOLSCENE}" var="dto" varStatus="counter">
                            <tr>
                                <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                <td style="font-size: 18px; text-align: center">${dto.cartid}</td>       
                                <td style="font-size: 18px; text-align: center">${dto.sid}</td>
                                <td style="font-size: 18px; text-align: center">${dto.scenename}</td>
                                <td style="font-size: 18px; text-align: center">${dto.quantityget}</td>
                                <td style="font-size: 18px; text-align: center">${dto.tid}</td>
                                <td style="font-size: 18px; text-align: center">${dto.toolname}</td>
                                <td style="font-size: 18px; text-align: center">${dto.quantityhad}</td>
                                <td style="font-size: 18px; text-align: center">${dto.starttime}</td>
                                <td style="font-size: 18px; text-align: center">${dto.endtime}</td>
                                <td style="font-size: 18px; text-align: center">${dto.time}</td>
                                <td><form action="MainControllerD" method="POST">
                                        <button type="submit" name="action" value="Remove" class="btn-search"style="height: 50px; width: 110px; font-size: 30px">Delete</button>
                                        <input type="hidden" name="idscene" value="${dto.sid}"/>
                                        <input type="hidden" name="tool" value="${dto.tid}"/>
                                        <input type="hidden" name="Search" value="${param.txtSearch}" />
                                        <input type="hidden" name="By" value="${param.cbxHow}" />

                                    </form></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!listNotNull}">
                <h2><font color="red" style="font-size: 30px; background-color: white">No Result!</font></h2>
                </c:if>
            </c:if>
    </body>
</html>
