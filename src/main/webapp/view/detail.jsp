<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Detail product</h1>
<h2 class="button">
    <button>
        <a href="/home">Back</a>
    </button>
</h2>
<form method="post" class="form-check-label">
    <h3>Product name</h3>
    <p>${requestScope["product"].name_sp}</p>
    <h3>Product price</h3>
    <p>${requestScope["product"].price}</p>
    <h3>Product quantity</h3>
    <p>${requestScope["product"].quantity}</p>
    <h3>Product color</h3>
    <p>${requestScope["product"].color}</p>
    <h3>Product description</h3>
    <p>${requestScope["product"].mota_sp}</p>
    <h3>Category</h3>
    <p>${requestScope["product"].name_category}</p>
</form>
</body>
</html>