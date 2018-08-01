<%-- 
    Document   : update
    Created on : 14 Jun, 2018, 12:14:11 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="update" action="display.do">
            <h1>Update Employee Details</h1>
            <input type="text" value="update" name="method" style="display:none">
            <input type="text" value="${i}" name="id" style="display:none">
            <table>
                <tr><th>Name:</th><th><input type="text" name="name" value="${n}"></th></tr>
                <tr><th>Mobile Number:</th><th><input type="text" name="mob" value="${m}"></th></tr>
                <tr><th>Email:</th><th><input type="text" name="email" value="${e}"></th></tr>
                <tr><th>Role:</th><th><input type="text" name="role" value="${r}"></th></tr>
                <tr><th><button parameter="method" type="submit" value="update" name="update">Update</button></th></tr>
            </table>
        </form>
    </body>
</html>
