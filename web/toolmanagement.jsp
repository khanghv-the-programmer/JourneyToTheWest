<%-- 
    Document   : toolmanagement
    Created on : Jun 25, 2020, 11:30:20 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="author" content="colorlib.com">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
        <link href="css/main.css" rel="stylesheet" />
        <title>Tool Search Management</title>
    </head>
    <body style="background-color:#7fdbda">
        <c:if test="${sessionScope.ROLE eq 'admin'}">
        <center><h1 style="color: #e84a5f; font-size: 5em">Tool Management Page</h1></center><br/><br/><br/>
        <center>
            <form action="admin.jsp" >

                <div class="input-field second-wrap" >
                    <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back to Admin Page" width="100" height="20"/>
                </div>
            </form><br/><br/>
            <form action="createtool.jsp">

                <div class="input-field second-wrap">
                    <input type="submit" class="btn-search"style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px"  value="Create new tool" width="100" height="20"/>
                </div>
            </form><br/><br/><br/>
        </center>
        <div class="s130">
            <form action="MainControllerT" method="POST">
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                            </svg>
                        </div>
                        <input type="text" name="txtToolSearch" value="${requestScope.search}${param.txtToolSearch}" id="search" placeholder="Input any words contained in a tool's name" /><br/>
                        <font color="red">${requestScope.EMPTY}</font>
                        <br/></div>
                    <div class="input-field second-wrap">
                        <input type="submit" value="Find Tools" name="action" class="btn-search"/></div>
                </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Umbrella, lla, l, umb,...</span>

            </form><br/><br/>
        </div><br/><br/>

        <h2><font color="green">${requestScope.DONE}</font></h2>

        <c:if test="${requestScope.TOOLS != null}">
            <c:if test="${not empty requestScope.TOOLS}" var="isNotEmpty">
                <center>
                    <table border="2" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">ID</th>
                                <th style="font-size: 18px; text-align: center">Tool name</th>
                                <th style="font-size: 18px; text-align: center">Description</th>
                                <th style="font-size: 18px; text-align: center">Quantity</th>
                                <th style="font-size: 18px; text-align: center">Image</th>
                                <th style="font-size: 18px; text-align: center">Status</th>
                                <th style="font-size: 18px; text-align: center">Delete</th>
                                <th style="font-size: 18px; text-align: center">Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.TOOLS}" var="dto" varStatus="counter">
                                <tr>
                                    <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.id}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.name}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.quantity}</td>
                                    <td><img src="${dto.image}" height="100" width="100" alt="${dto.name}"/></td>
                                    <td style="font-size: 18px; text-align: center">${dto.status}</td>
                                    <td><form action="MainControllerT" method="POST" >
                                            <input type="hidden" name="delTool" value="${dto.id}" />
                                            <input type="hidden" name="txtToolSearch" value="${param.txtToolSearch}" />
                                            <input type="submit" value="Delete" name="action" class="btn-search"style="height: 50px; width: 110px; font-size: 30px" />
                                        </form></td>
                                    <td><form action="MainControllerT" method="POST">
                                            <input type="hidden" name="findTool" value="${dto.id}" />
                                            <input type="hidden" name="search" value="${param.txtToolSearch}" />
                                            <input type="submit" value="Update" name="action" class="btn-search"style="height: 50px; width: 110px; font-size: 30px"/>    
                                        </form></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </center>
            </c:if>
            <c:if test="${!isNotEmpty}">
                <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
                </c:if>
            </c:if>
        </c:if>










    <c:if test="${sessionScope.ROLE eq 'director'}">
        <center><h1 style="color: #e84a5f; font-size: 5em">Tool Search Page</h1></center><br/><br/><br/>
        <center>
            <form action="toolscenemanagement.jsp" >

                <div class="input-field second-wrap" >
                    <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back" width="100" height="20"/>
                </div>
            </form><br/><br/>
        <div class="s130">
            <form action="MainControllerT" method="POST">
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                            </svg>
                        </div>
                        <input type="text" name="txtToolSearch" value="${requestScope.search}${param.txtToolSearch}" id="search" placeholder="Input any words contained in a tool's name" /><br/>
                        <font color="red">${requestScope.EMPTY}</font>
                        <br/></div>
                    <div class="input-field second-wrap">
                        <input type="submit" value="Find Tools" name="action" class="btn-search"/></div>
                </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Umbrella, lla, l, umb,...</span>

            </form><br/><br/>
        </div><br/><br/>

        <h2><font color="green">${requestScope.DONE}</font></h2>

        <c:if test="${requestScope.TOOLS != null}">
            <c:if test="${not empty requestScope.TOOLS}" var="isNotEmpty">
                <center>
                    <table border="2" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">ID</th>
                                <th style="font-size: 18px; text-align: center">Tool name</th>
                                <th style="font-size: 18px; text-align: center">Description</th>
                                <th style="font-size: 18px; text-align: center">Quantity</th>
                                <th style="font-size: 18px; text-align: center">Image</th>
                                <th style="font-size: 18px; text-align: center">Status</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.TOOLS}" var="dto" varStatus="counter">
                                <tr>
                                    <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.id}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.name}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.quantity}</td>
                                    <td><img src="${dto.image}" height="100" width="100" alt="${dto.name}"/></td>
                                    <td style="font-size: 18px; text-align: center">${dto.status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </center>
            </c:if>
            <c:if test="${!isNotEmpty}">
                <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
                </c:if>
            </c:if>
        </c:if>
    <script src="js/extention/choices.js"></script>
</body>
</html>







