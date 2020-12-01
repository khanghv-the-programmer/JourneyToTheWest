<%-- 
    Document   : actormanagement
    Created on : Jun 20, 2020, 12:20:18 PM
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
        <title>JSP Page</title>
    </head>
    <body style="background-color:#7fdbda">
        <c:if test="${sessionScope.ROLE eq 'admin'}">
    <center><h1 style="color: #e84a5f; font-size: 5em">Actor Management Page</h1></center><br/><br/><br/>

    <center>
        <form action="admin.jsp" >

            <div class="input-field second-wrap" >
                <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back to Admin Page" width="100" height="20"/>
            </div>
        </form><br/><br/>

        <form action="createaccount.jsp">

            <div class="input-field second-wrap">
                <input type="submit" class="btn-search"style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px"  value="Create Account" width="100" height="20"/>
            </div>
        </form>
    </center>
<br/><br/>
<div class="s130">
    <form action="MainController" method="POST">
        <div class="inner-form">
            <div class="input-field first-wrap">
                <div class="svg-wrapper">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                    <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                    </svg>
                </div>
                <input type="text" name="txtSearch" value="${requestScope.SEARCH}" id="search" placeholder="Input any words contained in an actor's name" /><br/>
                <font color="red">
                ${requestScope.INVALID.fullNameError}
                </font><br/><br/>
            </div>
            <div class="input-field second-wrap">
                <input type="submit" value="Search" class="btn-search" name="action" /></div>
        </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Luc Tieu Linh Dong, L, Luc,...</span>

    </form>
</div><br/><br/>


<h2><font color="green">${requestScope.DONE}</font></h2>
    <c:if test="${requestScope.INFO != null}">
        <c:if test="${not empty requestScope.INFO}" var="checkList">
        <center>
            <table border="2" style="background-color: white">
                <thead>
                    <tr>
                        <th style="font-size: 18px; text-align: center">Number</th>
                        <th style="font-size: 18px; text-align: center">Username</th>
                        <th style="font-size: 18px; text-align: center">Full name</th>
                        <th style="font-size: 18px; text-align: center">Role</th>
                        <th style="font-size: 18px; text-align: center">Description</th>
                        <th style="font-size: 18px; text-align: center">Image</th>
                        <th style="font-size: 18px; text-align: center">Phone</th>
                        <th style="font-size: 18px; text-align: center">Email</th>
                        <th style="font-size: 18px; text-align: center">Delete</th>
                        <th style="font-size: 18px; text-align: center">Edit</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                        <tr>
                            <td style="font-size: 18px; text-align: center">${counter.count}</td>
                            <td style="font-size: 18px; text-align: center">${dto.username}</td>
                            <td style="font-size: 18px; text-align: center">${dto.fullname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.role}</td>
                            <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                            <td><img src="${dto.img}" alt="${dto.fullname}" width="100" height="100"/></td>
                            <td style="font-size: 18px; text-align: center">${dto.phone}</td>
                            <td style="font-size: 18px; text-align: center">${dto.email}</td>
                            <td><form action="MainController" method="POST">
                                    <input type="submit" name="action" value="Delete" class="btn-search"style="height: 50px; width: 110px; font-size: 30px"/>
                                    <input type="hidden" name="id" value="${dto.username}"/>
                                    <input type="hidden" name="Search" value="${param.txtSearch}" />

                                </form>
                                
                            <td><form action="MainController" method="POST">
                                    <input type="hidden" name="search" value="${param.txtSearch}" />
                                    <input type="hidden" name="username" value="${dto.username}" />
                                    <input type="submit" value="Edit" name="action" class="btn-search"style="height: 50px; width: 70px; font-size: 30px"/>
                                </form></td>

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </center>


    </c:if>
    <br/><br/>
    <c:if test="${!checkList}">
        <font color="red">
        <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
        </font><br/><br/>
    </c:if>
</c:if>
        </c:if>
        
        
        
        
        
        
        
        
        
    <c:if test="${sessionScope.ROLE eq 'director'}">
        
        <center><h1 style="color: #e84a5f; font-size: 5em">Actor Management Page</h1></center><br/><br/><br/>
        <form action="shoppingactor.jsp" >
            <div class="input-field second-wrap" >
                <input type="submit" class="btn-search" style="height: 50px; width: 500px; font-size: 2em; border-radius: 12px" value="Go back" width="100" height="20"/>
            </div>
        </form><br/><br/>
        <div class="s130">
    <form action="MainController" method="POST">
        <div class="inner-form">
            <div class="input-field first-wrap">
                <div class="svg-wrapper">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                    <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                    </svg>
                </div>
                <input type="text" name="txtSearch" value="${requestScope.SEARCH}" id="search" placeholder="Input any words contained in an actor's name" /><br/>
                <font color="red">
                ${requestScope.INVALID.fullNameError}
                </font><br/><br/>
            </div>
            <div class="input-field second-wrap">
                <input type="submit" value="Search" class="btn-search" name="action" /></div>
        </div>
                <span class="info" style="color: #e84a5f;background-color: #7fdbda; font-size: 20px">Ex. Ton Ngo Khong, Ngo, N, Ton,...</span>

    </form>
</div><br/><br/>


<h2><font color="green">${requestScope.DONE}</font></h2>
    <c:if test="${requestScope.INFO != null}">
        <c:if test="${not empty requestScope.INFO}" var="checkList">
        <center>
            <table border="2" style="background-color: white">
                <thead>
                    <tr>
                        <th style="font-size: 18px; text-align: center">Number</th>
                        <th style="font-size: 18px; text-align: center">Username</th>
                        <th style="font-size: 18px; text-align: center">Full name</th>
                        <th style="font-size: 18px; text-align: center">Role</th>
                        <th style="font-size: 18px; text-align: center">Description</th>
                        <th style="font-size: 18px; text-align: center">Image</th>
                        <th style="font-size: 18px; text-align: center">Phone</th>
                        <th style="font-size: 18px; text-align: center">Email</th>
                        

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                        <tr>
                            <td style="font-size: 18px; text-align: center">${counter.count}</td>
                            <td style="font-size: 18px; text-align: center">${dto.username}</td>
                            <td style="font-size: 18px; text-align: center">${dto.fullname}</td>
                            <td style="font-size: 18px; text-align: center">${dto.role}</td>
                            <td style="font-size: 18px; text-align: center">${dto.desc}</td>
                            <td><img src="${dto.img}" alt="${dto.fullname}" width="100" height="100"/></td>
                            <td style="font-size: 18px; text-align: center">${dto.phone}</td>
                            <td style="font-size: 18px; text-align: center">${dto.email}</td>
                            

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </center>


    </c:if>
    <br/><br/>
    <c:if test="${!checkList}">
        <font color="red">
        <center><span class="info" style="font-size: 30px"><h2>No result!</h2></span></center>
        </font><br/><br/>
    </c:if>
        
    </c:if>
    </c:if>

<script src="js/extention/choices.js"></script>
</body>
</html>
