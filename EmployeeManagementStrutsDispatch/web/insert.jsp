<%-- 
    Document   : insert
    Created on : 14 Jun, 2018, 12:13:49 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
    function unloadinsert()
    {
        window.opener.location.reload(true);
        window.close();
    }
    </script>
    <body onunload="javascript: unloadinsert()">
        <form name="insert" action="display.do">
            <h1>Enter Employee Details</h1>
            <input type="text" value="insert" name="method" style="display:none">
            <table>
                <tr><th>Name:</th><th><input type="text" name="name" value=""></th></tr>
                <tr><th>Mobile Number:</th><th><input type="text" name="mob" value=""></th></tr>
                <tr><th>Email:</th><th><input type="text" name="email" value=""></th></tr>
                <tr><th>Role:</th><th><input type="text" name="role" value=""></th></tr>
                <tr><th><button parameter="method" type="submit" value="insert" name="insert">Insert</button></th></tr>
            </table>
        </form>
    </body>
</html>
