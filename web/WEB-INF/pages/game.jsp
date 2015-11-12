<%@ page import="field.Cell" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/12/15
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<% Cell[][] gameField = (Cell[][]) request.getAttribute("gameField");%>
<table border=1>
        <% for (int i = 0; i < 4; i++) {%>
    <tr>
        <% for (int j = 0; j < 4; j++) { %>
        <td><%=gameField[i][j].getValue()%>
        </td>
        <%}%>
    </tr>
        <%}%>


</body>
</html>
