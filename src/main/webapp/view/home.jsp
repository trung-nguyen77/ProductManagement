<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 27/12/2021
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer Page</title>
    <style>
        td, th {
            padding: 5px 5px;
        }

        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 23px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .createButton {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
        }

        .createButton:hover {
            background-color: #4CAF50;
            color: white;
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }

        .custom-select {
            position: relative;
            font-family: Arial;
        }

        .custom-select select {
            display: none; /*hide original SELECT element:*/
        }

        .select-selected {
            background-color: DodgerBlue;
        }

        /*style the arrow inside the select element:*/
        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*point the arrow upwards when the select box is open (active):*/
        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*style the items (options), including the selected item:*/
        .select-items div, .select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/
        .select-items {
            position: absolute;
            background-color: #008CBA;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*hide the items when the select box is closed:*/
        .select-hide {
            display: none;
        }

        .select-items div:hover, .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
        }

        .deleteButton {
            background-color: white;
            color: black;
            border: 2px solid #f44336;
        }

        .deleteButton:hover {
            background-color: #f44336;
            color: white;
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }

        .editButton {
            background-color: white;
            color: black;
            border: 2px solid violet;
        }

        .editButton:hover {
            background-color: violet;
            color: white;
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }


    </style>
</head>
<body>
<h1>Welcome Customer Page</h1>

<div class="custom-select" style="width:150px;">
    <select class="select findButton">
        <option value="0">Find Product:</option>
        <option value="1">Find By Id</option>
        <option value="2">Find By Name</option>
    </select>
</div>

<a class="button createButton" href="/home?action=create">Create Product</a>
<form action="/home?action=search" method="post">
    <input type="text" name="find" value="Search">
    <input type="submit" value="search">
</form>
<table border="1">
    <tr>
        <th>#</th>
        <th>name</th>
        <th>price</th>
        <th>quantity</th>
        <th>color</th>
        <th>description</th>
        <th>category</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${list}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.getName()}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.color}</td>
            <td>${p.description}</td>
            <td>${p.category}</td>
            <td>
                    <a href="/home?action=edit&&id=${p.idProduct}" class="button editButton">Edit</a>
            </td>
            <td>
                    <a href="/home?action=delete&&id=${p.idProduct}" class="button deleteButton">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
