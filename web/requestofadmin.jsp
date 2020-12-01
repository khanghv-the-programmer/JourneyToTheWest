<%-- 
    Document   : requestofadmin
    Created on : Jul 2, 2020, 9:37:39 PM
    Author     : USER
--%>

<%@page import="khanghv.daos.carts.ActorCrart"%>
<%@page import="khanghv.dtos.ASCartDTO"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Of Admin</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">

        <%
            String role = (String) session.getAttribute("ROLE");
            if (role.equals("admin")) {

        %>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Request Page</h1>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Fullname : ${sessionScope.FULLNAME}</h1>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Role : ${sessionScope.ROLE}</h1>
        <form action="admin.jsp" method="POST">
            <input type="submit" value="Back to admin Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        
        <%            ActorCrart cart = (ActorCrart) application.getAttribute("ACART");

            if (cart != null) {
                if (cart.getCart().size() != 0) {
                    int count = 0;

        %>
        <table border="2" style="background-color: white">
            <thead>
                <tr>
                    <th style="font-size: 18px; text-align: center">Number</th>
                    <th style="font-size: 18px; text-align: center">Id Cart</th>
                    <th style="font-size: 18px; text-align: center">Editor</th>
                    <th style="font-size: 18px; text-align: center">Username</th>
                    <th style="font-size: 18px; text-align: center">Id Scene</th>
                    <th style="font-size: 18px; text-align: center">Acting as</th>
                    <th style="font-size: 18px; text-align: center">Description</th>
                    <th style="font-size: 18px; text-align: center">Accept</th>
                    <th style="font-size: 18px; text-align: center">Decline</th>
                </tr>
            </thead>
            <tbody>




                <%                        for (ASCartDTO req : cart.getCart()) {
                        count++;
                %>
                <tr>
                    <td style="font-size: 18px; text-align: center"><%=count%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getId()%></td>



                    <td style="font-size: 18px; text-align: center"><%=req.getEditor()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getUsername()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getIdScene()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getActing()%></td>
                    <td style="font-size: 18px; text-align: center"><a href="<%=req.getDesc()%>">Description</a></td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="txtId" value="<%=req.getId()%>" />
                            <input type="hidden" name="txtDesc" value="<%=req.getDesc()%>" />
                            <input type="hidden" name="txtEd" value="<%=req.getEditor()%>" />
                            <input type="hidden" name="txtUs" value="<%=req.getUsername()%>" />
                            <input type="hidden" name="txtSc" value="<%=req.getIdScene()%>" />
                            <input type="hidden" name="number" value="<%=count%>" />
                            <input type="hidden" name="txtAct" value="<%=req.getActing()%>" />
                            <input type="submit" value="Accept" name="action" />
                        </form>
                    </td>
                    <td><form action="MainController" method="POST">
                            <input type="hidden" name="number" value="<%=count%>" />
                            <input type="hidden" name="txtEd" value="<%=req.getEditor()%>" />
                            <input type="hidden" name="txtId" value="<%=req.getId()%>" />
                            <input type="submit" value="Denied" name="action" />
                        </form></td>
                </tr>

                <%
                    }
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <h2 color="red">Empty Cart!</h2>
        <%
            }

        } else {%>
        <h1><font color="blue" style="background-color: white" >Cart has been remove or there is no Cart</font></h1>
            <%

                }
            } else if (role.equals("director")) {

            %>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Request Page</h1>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Fullname : ${sessionScope.FULLNAME}</h1>
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Role : ${sessionScope.ROLE}</h1>
        
        <form action="shoppingactor.jsp" method="POST">
            <input type="submit" value="Back to Actor & Scene Management Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
            <%            ActorCrart cart = (ActorCrart) application.getAttribute("ACART");
                if (cart != null) {
                    if (cart.getCart().size() != 0) {
                        int count = 0;

            %>
        <table  border="2" style="background-color: white">
            <thead>
                <tr>
                    <th style="font-size: 18px; text-align: center">Number</th>
                    <th style="font-size: 18px; text-align: center">Id Cart</th>
                    <th style="font-size: 18px; text-align: center">Editor</th>
                    <th style="font-size: 18px; text-align: center">Username</th>
                    <th style="font-size: 18px; text-align: center">Id Scene</th>
                    <th style="font-size: 18px; text-align: center">Casting as</th>
                    <th style="font-size: 18px; text-align: center">Description</th>
                    <th style="font-size: 18px; text-align: center">Delete</th>
                </tr>
            </thead>
            <tbody>




                <%                        for (ASCartDTO req : cart.getCart()) {
                        if (session.getAttribute("FULLNAME").equals(req.getEditor())) {

                            count++;
                %>
                <tr>
                    <td style="font-size: 18px; text-align: center"><%=count%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getId()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getEditor()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getUsername()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getIdScene()%></td>
                    <td style="font-size: 18px; text-align: center"><%=req.getActing()%></td>
                    <td style="font-size: 18px; text-align: center"><a href="<%=req.getDesc()%>">Description</a></td>
                    <td><form action="MainController" method="POST">
                            <input type="hidden" name="number" value="<%=count%>" />
                            <button type="submit" value="Denied" name="action">Delete</button>
                        </form></td>
                </tr>

                <%
                        }

                    }
                %>
            </tbody>
        </table>
        <br/><br/>
        <form action="AddControllerD" method="POST">

            <input type="submit" value="Go back"  style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>
        </form>
        <%
        } else {
        %>
        <h2 color="red">No Result!</h2>
        <%
            }
        } else {
        %>
        <h1><font color="blue" style="background-color: white">Cart has been remove or there is no Cart</font></h1>
            <%
                    }

                }


            %>


    </body>
</html>
