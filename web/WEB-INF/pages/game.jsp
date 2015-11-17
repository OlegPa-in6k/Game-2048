<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/12/15
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <sec:csrfMetaTags/>
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
                /*  case 27:
                 direction = "new";
                 break;*/
                default:
                    direction = "no_direction";
            }
            var data = 'direction=' + direction;

            var headers = {};
            var csrfHeader = $("meta[name='_csrf_header']").attr("content");
            var csrfToken = $("meta[name='_csrf']").attr("content");
            headers[csrfHeader] = csrfToken;
            $.ajax({
                url: "/game",
                data: data,
                type: "POST",
                headers: headers,
                acync: true,
                success: function (response) {
                    var values = response.split(",");
                    for (var i = 0; i < 16; i++) {
                        document.getElementsByClassName("cell")[i].innerHTML = values[i];
                    }
                    document.getElementById("score").innerHTML = "Score: " + values[16];
                }
            });
        });
    </script>
</head>
<body>

<div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name}
            Your previous Score =
        </h2>
    </c:if>

    <h2 id="score"></h2>
    <table border=1 style="table-layout: fixed; width: 200px; height: 100px">
        <tr>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
        </tr>
        <tr>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
        </tr>
        <tr>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
        </tr>
        <tr>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
            <td class="cell"></td>
        </tr>

    </table>

    <br>

    <p>

    <form method="post" action="/new">
        <input type="submit" value="New Game">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>


</body>
</html>
