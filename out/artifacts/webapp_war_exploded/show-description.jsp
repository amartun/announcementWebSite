<%@ page import="models.Announcement" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h3 class="text-center">Announcement Description</h3>
        <hr>
        <br>

        <c:forEach var="announcement" items="${listAnnouncement}">
            <c:out value="${announcement.announcement_description}"/>
        </c:forEach>


    </div>
</div>
</body>
</html>