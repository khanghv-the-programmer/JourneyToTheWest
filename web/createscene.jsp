<%-- 
    Document   : createscene
    Created on : Jul 1, 2020, 6:01:32 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(https://img.8wallpapers.com/uploads/2018/09/a348b7f275a140119d11b3d1.jpg); background-size: cover">
        <h1 style="color: red; font-size: 40px;border-radius:12px; text-align: center">Create Scene</h1>
        <form action="scenemanagement.jsp" method="POST" >
            <input type="submit" value="Go back to Scene Manager Page" style="width: 700px; height: 50px; font-size: 25px;border-radius:12px; background-color: rgba(180, 180, 180, 0.5);  border-color: yellow; border: 2px solid #f9d56e; color: white "/>    
        </form>
        <form action="MainControllerS" method="POST" style="width: 800px; height: 900px; background-color: white; padding: 80px; font-size: 25px; font-family: sans-serif; margin: 100px">
            Name*: <input type="text" name="txtSName" value="${requestScope.NAME}" /><br/>
            <font color="red">${requestScope.INVALID.nameError}</font><br/>
            Description*: <input type="text" name="txtSDesc" value="${requestScope.DESC}" /><br/>
            <font color="red">${requestScope.INVALID.descError}</font><br/>
            Location*: <input type="text" name="txtSLoc" value="${requestScope.LOC}" /><br/>
            <font color="red">${requestScope.INVALID.locError}</font><br/>
            Start Time*:   Date <input type="text" name="txtDate" value="${requestScope.DATES}" maxlenght="4" size="4%" /> / Month <input type="text" name="txtMonth" value="${requestScope.MONTHS}" maxlength="4" size="4" /> / Year <input type="text" name="txtYear" value="${requestScope.YEARS}" maxlength="4" size="4" /><br/>
            <font color="red">${requestScope.INVALID.startError}</font>&nbsp;<font color="red">${requestScope.DATEERR}</font><br/>
            End Time*:   Date <input type="text" name="txtDateE" value="${requestScope.DATEE}" maxlenght="4" size="4%" /> / Month <input type="text" name="txtMonthE" value="${requestScope.MONTHE}" maxlength="4" size="4" /> / Year <input type="text" name="txtYearE" value="${requestScope.YEARE}" maxlength="4" size="4" /><br/>
            <font color="red">${requestScope.INVALID.dateError}</font>&nbsp;<font color="red">${requestScope.INVALID.endError}</font>&nbsp;<font color="red">${requestScope.ERR}</font><br/>
            Time Takes*: <input type="text" name="txtTake" value="${requestScope.TAKE}" /><br/>
            <font color="red">${requestScope.INVALID.takeError}</font><br/>
            <input type="hidden" name="txtSearch" value="${requestScope.SEARCHH}" />
            <input type="submit" value="Create" name="action" /><br/><br/>
            * : necessary

        </form>
    </body>
</html>
