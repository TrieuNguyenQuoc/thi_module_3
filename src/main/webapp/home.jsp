
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #252585;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }

        header h1 {
            font-size: 24px;
            margin: 0;
        }

        header a img {
            width: 35px;
            height: 35px;
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #252585;
            color: #fff;
        }

        img {
            width: 80px;
            height: 120px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        a {
            text-decoration: none;
            color: #252585;
        }

        a:hover {
            color: #b80000;
        }

        .add-button {
            display: inline-block;
            background-color: #b80000;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            margin-top: 10px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .add-button:hover {
            background-color: #f44336;
        }

        /* Style for the font-awesome icons */
        .fa {
            margin-right: 5px;
        }

        /* Style for the "Edit" and "Delete" links */
        .edit-link, .delete-link {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 3px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #252585;
            transition: background-color 0.3s ease;
        }

        .edit-link:hover, .delete-link:hover {
            background-color: #4a4a9e;
        }

        /* Add spacing between "Edit" and "Delete" links */
        .edit-link {
            margin-right: 5px;
        }
        .add-link, .logout-link {
            display: inline-block;
            color: #fff;
            text-decoration: none;
            transition: opacity 0.3s ease;
        }

        .add-link .fa, .logout-link .fa {
            margin-right: 5px;
        }

        .add-link:hover, .logout-link:hover {
            opacity: 1;
        }
        /* Style for the "Search" link */
        .search-link {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 3px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #252585;
            transition: background-color 0.3s ease;
        }

        .search-link:hover {
            background-color: #4a4a9e;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<h1>Staff List</h1>
<a href="http://localhost:8080/staffs?action=create" class="add-button">
    <i class="fas fa-plus"></i>Add Staff
</a>
<form action="http://localhost:8080/staffs" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="nameSearch" placeholder="Tìm kiếm theo tên...">
    <button type="submit" class="search-link">
        <i class="fas fa-search"></i>
    </button>
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Birth</th>
        <th>Address</th>
        <th> Number</th>
        <th>Classroom</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${StudentList}" var="StudentList">
        <tr>
            <td>${StudentList.id}</td>
            <td>${StudentList.name}</td>
            <td>${StudentList.email}</td>
            <td>${StudentList.salary}</td>
            <td>${StudentList.address}</td>
            <td>${StudentList.phoneNumber}</td>
            <td>${StudentList.department.name}</td>
            <td>
                <a href="http://localhost:8080/staffs?action=edit&id=${StudentList.id}" class="edit-link" style="display: inline-block; padding: 5px 10px; border-radius: 3px; text-align: center; text-decoration: none; color: #fff; background-color: #252585;">
                    <i class="fas fa-edit"></i>Edit
                </a>
            </td>
            <td>
                <a href="http://localhost:8080/staffs?action=delete&id=${StudentList.id}" class="delete-link" style="display: inline-block; padding: 5px 10px; border-radius: 3px; text-align: center; text-decoration: none; color: #fff; background-color: #b80000;">
                    <i class="fas fa-trash-alt"></i>Delete
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
