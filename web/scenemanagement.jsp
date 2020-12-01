<%-- 
    Document   : scenemanagement
    Created on : Jun 30, 2020, 3:09:19 PM
    Author     : USER
--%>

<%@ taglib prefix="khang" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="author" content="colorlib.com">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
        <link href="css/main.css" rel="stylesheet" />
        <title>Management Scene</title>
    </head>
    <body style="background-color:#7fdbda">

        <khang:if test="${sessionScope.ROLE eq 'admin'}">
        <center><h1 style="color: #e84a5f; font-size: 5em">Scene Management Page</h1></center><br/><br/><br/>
        <center>
            <form action="admin.jsp" >

                <div class="input-field second-wrap" >
                    <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back to Admin Page" width="100" height="20"/>
                </div>
            </form><br/><br/>

            <form action="createscene.jsp">

                <div class="input-field second-wrap">
                    <input type="submit" class="btn-search"style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px"  value="Create new Scene" width="100" height="20"/>
                </div>
            </form><br/><br/>
        </center>




        <div class="s130">
            <form action="MainControllerS" method="POST">
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                            </svg>
                        </div>
                        <input type="text" name="txtSearch" value="${requestScope.SEARCH}" id="search" placeholder="Input any words contained in an actor's name" /><br/>
                        <font color="red">
                        ${requestScope.INVALID}
                        </font><br/><br/>
                    </div>
                    <div class="input-field second-wrap">
                        <input type="submit" value="Search" name="action" class="btn-search"/></div>
                </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Ton Ngo Khong, Ngo, N, Ton,...</span>
            </form> 
        </div><br/><br/>





        <khang:if test="${requestScope.SCENE != null}">
            <khang:if test="${not empty requestScope.SCENE}" var="notEmpty">
                <center><table border="1" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">ID</th>
                                <th style="font-size: 18px; text-align: center">Scene Name</th>
                                <th style="font-size: 18px; text-align: center">Description</th>
                                <th style="font-size: 18px; text-align: center">Location</th>
                                <th style="font-size: 18px; text-align: center">Start Time</th>
                                <th style="font-size: 18px; text-align: center">End Time</th>
                                <th style="font-size: 18px; text-align: center">Takes</th>
                                <th style="font-size: 18px; text-align: center">Edit</th>
                                <th style="font-size: 18px; text-align: center">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <khang:forEach items="${requestScope.SCENE}" var="dto" varStatus="counter">
                                <tr>
                                    <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.id}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.name}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.location}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.start}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.end}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.take}</td>
                                    <td>
                                        <form action="MainControllerS" method="POST">
                                            <input type="hidden" name="name" value="${dto.name}" />
                                            <input type="hidden" name="searchh" value="${param.txtSearch}" />
                                            <input type="submit" value="Edit" name="action" class="btn-search"style="height: 50px; width: 110px; font-size: 30px" />
                                        </form>
                                    </td>
                                    <td>
                                        <form action="MainControllerS" method="POST">
                                            <input type="hidden" name="txtId" value="${dto.id}" />
                                            <input type="hidden" name="search" value="${param.txtSearch}" />
                                            <input type="submit" value="Delete" name="action" class="btn-search"style="height: 50px; width: 100px; font-size: 30px" />
                                        </form>

                                    </td>
                                </tr>
                            </khang:forEach>
                        </tbody>
                    </table></center>

            </khang:if>
            <khang:if test="${!notEmpty}">
                <font color="red">
                <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
                </font><br/><br/>
            </khang:if>
        </khang:if>
    </khang:if>





    <khang:if test="${sessionScope.ROLE eq 'director'}">
        <center><h1 style="color: #e84a5f; font-size: 5em">Search Scenes Page</h1></center><br/><br/><br/>
        <form action="director.jsp" >
            <div class="input-field second-wrap" >
                <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back" width="100" height="20"/>
            </div>
        </form><br/><br/>
        <div class="s130">
            <form action="MainControllerS" method="POST">
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                            </svg>
                        </div>
                        <input type="text" name="txtSearch" value="${requestScope.SEARCH}" id="search" placeholder="Input any words contained in an actor's name" /><br/>
                        <font color="red">
                        ${requestScope.INVALID}
                        </font><br/><br/>
                    </div>
                    <div class="input-field second-wrap">
                        <input type="submit" value="Search" name="action" class="btn-search"/></div>
                </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Ton Ngo Khong, Ngo, N, Ton,...</span>
            </form> 
        </div><br/><br/>





        <khang:if test="${requestScope.SCENE != null}">
            <khang:if test="${not empty requestScope.SCENE}" var="notEmpty">
                <center><table border="1" style="background-color: white">
                        <thead>
                            <tr>
                                <th style="font-size: 18px; text-align: center">Number</th>
                                <th style="font-size: 18px; text-align: center">ID</th>
                                <th style="font-size: 18px; text-align: center">Scene Name</th>
                                <th style="font-size: 18px; text-align: center">Description</th>
                                <th style="font-size: 18px; text-align: center">Location</th>
                                <th style="font-size: 18px; text-align: center">Start Time</th>
                                <th style="font-size: 18px; text-align: center">End Time</th>
                                <th style="font-size: 18px; text-align: center">Takes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <khang:forEach items="${requestScope.SCENE}" var="dto" varStatus="counter">
                                <tr>
                                    <td style="font-size: 18px; text-align: center">${counter.count}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.id}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.name}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.location}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.start}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.end}</td>
                                    <td style="font-size: 18px; text-align: center">${dto.take}</td>
                                </tr>
                            </khang:forEach>
                        </tbody>
                    </table></center>

            </khang:if>
            <khang:if test="${!notEmpty}">
                <font color="red">
                <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
                </font><br/><br/>
            </khang:if>
        </khang:if>
    </khang:if>

</body>
</html>
