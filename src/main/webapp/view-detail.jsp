<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/27/2022
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Detail</h1>
<p>Id: ${product.getId()}</p>
<p>Name: ${product.getName()}</p>
<p>Price: ${product.getPrice()}</p>
<p>Quantity: ${product.getQuantity()}</p>
<p>Description: ${product.getDescription()}</p>
</body>
</html>
