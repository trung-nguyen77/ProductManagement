<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 27/12/2021
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Form</title>
    <style>
        td, th{
            padding: 5px 5px;
        }
        .button {
            background-color: #4CAF50;
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
        .createButton {
            background-color: white;
            color: black;
            border: 2px solid violet;
        }

        .createButton:hover {
            background-color: violet;
            color: white;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
</head>
<body>
<h2>
    <button>
        <a href="/home">Back</a>
    </button>
</h2>
<form method="post">
    <table border="1">
        <tr>
            <th>Product name</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>description</th>
            <th>Category</th>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="name"></td>
            <td><input type="text" name="price" placeholder="USD"></td>
            <td><input type="text" name="quantity" placeholder="quantity"></td>
            <td><input type="text" name="color" placeholder="color"></td>
            <td><input type="text" name="description" placeholder="Product description"></td>
            <td>
                <select name="category">
                    <option value="1">Laptop</option>
                    <option value="2">PC</option>
                </select>
            </td>
        </tr>
    </table>
    <button class="button createButton" type="submit" value="Add">Create</button>
</form>
</body>
</html>
