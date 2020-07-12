<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Announcement Board</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: darkblue">
        <div>
            <a href="<%=request.getContextPath()%>/list" class="navbar-brand"> Announcement Board </a>
        </div>
    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of Announcements</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-info">Add New Announcement</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="announcement" items="${listAnnouncement}">
                <tr>
                    <td>
                        <c:out value="${announcement.id}" />
                    </td>
                    <td>
                        <c:out value="${announcement.announcement_title}" />
                    </td>
                    <td><a href="edit?id=<c:out value='${announcement.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${announcement.id}' />">Delete</a>
                                <a href="showDescription?id=<c:out value='${announcement.id}' />">Show Description</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>