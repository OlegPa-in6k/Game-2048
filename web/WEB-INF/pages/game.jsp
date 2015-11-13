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
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>
        jQuery(document).bind('keydown', function (evt) {
            var direction;
            switch (evt.which) {
                case 37:
                    direction = "left";
                    break;
                case 38:
                    direction = "up";
                    break;
                case 39:
                    direction = "right";
                    break;
                case 40:
                    direction = "down";
                    break;
                default:
                    direction = "no_direction";
            }
            var data = 'direction=' + direction;
            $.ajax({
                url: "/game",
                data: data,
                type: "POST",
                acync: true,
                success: function (response) {
                    document.getElementById("test").innerHTML = response;
                }
            });
        });
    </script>
</head>
<body>

<%--<% GameField gameFieldMain = (GameField) request.getAttribute("gameField");%>
<%Cell[][] gameField = gameFieldMain.gameField;%>
<table align="center" width="30%">
        <% for (int i = 0; i < 4; i++) {%>
    <tr>
        <% for (int j = 0; j < 4; j++) { %>
        <td style="font-size: 25px;"><%=gameField[i][j].getValue()%>
        </td>
        <%}%>
    </tr>
        <%}%>--%>

<div id="test"></div>

</body>
</html>
