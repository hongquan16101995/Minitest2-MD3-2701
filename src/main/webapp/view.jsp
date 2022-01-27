<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/27/2022
  Time: 3:24 PM
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
<h1>All Product</h1>
<button><a href="/home?action=sortGreat">SortGreat</a></button>&ensp;
<button><a href="/home?action=sortLess">SortLess</a></button>&ensp;
<button><a href="/home?action=cart">Cart</a></button>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>
            <a <c:if test="${product.getQuantity() == 0} "> style="color: red" </c:if>
                    href="/home?action=detail&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getDescription()}</td>
            <td>
                <button><a href="/home?action=addToCart&id=${product.getId()}">Add</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
