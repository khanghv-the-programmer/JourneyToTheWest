<%-- 
    Document   : erroradd
    Created on : Jul 4, 2020, 10:03:31 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR</h1>
        <h1>${requestScope.ERROR}</h1>
        <a href="director.jsp">Go back to director page</a>
    </body>
</html>
