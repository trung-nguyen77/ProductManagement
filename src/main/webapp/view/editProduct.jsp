<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 29/12/2021
  Time: 9:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        td, th{
            padding: 5px 5px;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .editButton {
            background-color: white;
            color: black;
            border: 2px solid violet;
        }

        .editButton:hover {
            background-color: violet;
            color: white;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
</head>
<body>
<div class="container">
    <h2> Edit Product</h2>
    <form method="post" >
        <table class="table table-striped">
            <tr>

                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
            </tr>
            <tr>
                <td><input type="text" name="name" value="${product.name}" placeholder="Products Name"></td>
                <td><input type="text" name="price" value="${product.price}" placeholder="Products Price"></td>
                <td><input type="text" name="quantity" value="${product.quantity}" placeholder="Quantity"></td>
                <td><input type="text" name="color value="${requestScope["product"].color}""></td>
                <td><input type="text" name="description" value="${product.description}" placeholder="Description"></td>
                <td>
                    <select name="category">
                        <option value="1">Laptop</option>
                        <option value="2">PC</option>
                    </select>
                </td>
            </tr>
        </table>
        <label><button class="button editButton" type="submit" value="Add">Edit</button></label>
    </form>

</div>
</body>
</html>
