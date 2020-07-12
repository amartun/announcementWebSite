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
        <h3 class="text-center">Starting Page</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/list-announcements" class="btn btn-info">List of Announcements</a>
        </div>
    </div>
</div>
</div>
</body>
</html>