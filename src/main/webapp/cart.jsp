<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/27/2022
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 600px;
            border: 1px solid;
            border-collapse: collapse;
        }

        td {
            width: 15%;
            border: 1px solid;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>Cart</h1>
<button><a href="/home">Back to home</a></button>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity of cart</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope['carts']}" var="cart">
        <tr>
            <td>${cart.getProduct().getName()}</td>
            <td>${cart.getProduct().getPrice()}</td>
            <td>${cart.getQuantity()}</td>
            <td><button><a href="/home?action=deleteCart&id=${cart.getProduct().getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
<button><a href="/home?action=pay">Pay Money</a></button>
<c:if test="${requestScope['money'] != null}">
    <script>
        alert("Số tiền phải trả là: " + ${requestScope['money']})
    </script>
</c:if>
</body>
</html>
