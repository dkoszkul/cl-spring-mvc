<%--
  Created by IntelliJ IDEA.
  User: koszkul
  Date: 20.03.2020
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Multiply</title>
</head>
<body>
<table style="text-align: center;">
    
<c:forEach begin="0" end="${size}" step="1" var="counter" varStatus="status">
    <tr>

<%-- Pionowo --%>
    <c:choose>
        <%-- Jeśli 0 to wpisujemy znak 'x' --%>
        <c:when test="${counter==0}">
            <td style="width: 2em; height: 2em; background-color: gray">x</td>
        </c:when>
        <%-- Jeśli != 0 to wpisujemy wartość countera --%>
        <c:otherwise>
            <td style="width: 2em; height: 2em; background-color: gray">${counter}</td>
        </c:otherwise>
    </c:choose>

        <%-- Poziomo --%>
        <c:forEach begin="1" end="${size}" step="1" var="counter2">

            <c:choose>
<%--                Pierwsza linia to nasz counter (nie counter2)--%>
                <c:when test="${counter==0}">
                    <td style="width: 2em; height: 2em; background-color: gray">${counter2}</td>
                </c:when>
                <c:otherwise>
<%--                    Tutaj mamy wynik mnożenia--%>
                    <td style="width: 2em; height: 2em;"><c:out value="${counter * counter2}"/></td>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </tr>


</c:forEach>
</table>
</body>
</html>
