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
<div>
    <c:forEach items="${cart.cartItems}" var="item">
        ${item.quantity} : ${item.product.name} (${item.product.price})<br/>
    </c:forEach>
</div>

<br/>----------------------------- <br/>

<div>
    W koszyku jest ${cart.cartItems.size()} pozycji. <br/>
    W koszyku jest ${cart.getProductsAmount()} produktów. <br/>
    Wartość koszyka to: ${cart.getAllPrice()}.<br/>
</div>
</body>
</html>
