<%-- 
    Document   : addfailed
    Created on : Jul 2, 2020, 9:17:14 PM
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
        <font color="red">
        <h1>ERROR!</h1><br/>
        <h2>E to the R to the R to the O to the R<br/>
            ${requestScope.ERROR}
        </h2>
        <a href="director.jsp">Back to the Director page</a>
        </font>
    </body>
</html>
