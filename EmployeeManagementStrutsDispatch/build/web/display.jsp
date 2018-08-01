<%-- 
    Document   : display
    Created on : 14 Jun, 2018, 12:13:38 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
    function loadinsert()
    {
        testwindow = window.open("http://localhost:8080/EmployeeManagementStruts1/insert.jsp", "mywindow", "location=1,resizable=1,status=1,scrollbars=1,width=400,height=300");
    }
    </script>
    <body>
            <table style="width:100%">
                <tr>
                        <td><h3>Name</h3></td>
                        <td><h3>Mobile Number</h3></td>
                        <td><h3>Email</h3></td>
                        <td><h3>Role</h3></td>
                </tr> 
                <c:forEach items="${res}" var="emp">
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.mob}</td>
                        <td>${emp.email}</td>
                        <td>${emp.role}</td>
                        <td>
                            <form name="update" action="display.do">
                                <input type="text" value="updateform" name="method" style="display:none">
                                <input type="text" value="${emp.id}" name="id" style="display:none">
                                <input type="submit" property="method" value="Update" />
                            </form>
                        </td>
                        <td>
                            <form name="delete" action="display.do">
                                <input type="text" value="delete" name="method" style="display:none">
                                <input type="text" value="${emp.id}" name="id" style="display:none">
                                <input type="submit" property="method" value="Delete" />
                            </form>
                        </td>
                    </tr>        
                </c:forEach>
            </table>
            <form name="insert" action="display.do">
                <input type="text" value="insertform" name="method" style="display:none">
                <div align="middle"><button parameter="method" type="submit" value="insertform" name="insertform" onclick="javascript: loadinsert()">Insert</button></div>
            </form>
    </body>
</html>
