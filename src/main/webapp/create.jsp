
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h1 {
            background-color: #252585;
            color: #fff;
            padding: 10px;
        }

        form {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: inline-block;
            width: 120px;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="tel"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #252585;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4a4a9e;
        }

        select {
            width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .fa {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<h1>Create Student</h1>
<form action="/students" method="post">
    <input type="hidden" name="action" value="create">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>Date of Birth:</label>
    <input type="date" name="dateOfBirth" required><br>
    <label>Address:</label>
    <input type="text" name="address" required><br>
    <label>Phone Number:</label>
    <input type="tel" name="phoneNumber" required><br>
    <label for="inputState">Class:</label>
    <select id="inputState" class="form-control" name="className">
        <c:forEach items="${classes}" var="classObj">
            <option value="${classObj.id}">${classObj.name}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Create">
    <a href="http://localhost:8080/students?action=findAll" class="back-button">Quay lại</a>
</form>
</body>
</html>