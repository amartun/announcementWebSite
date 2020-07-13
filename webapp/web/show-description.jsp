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
        <br>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Date Published</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="announcement" items="${listAnnouncement}">
                <tr>
                    <td>
                        <c:out value="${announcement.announcement_title}" />
                    </td>
                    <td>
                        <c:out value="${announcement.announcement_description}" />
                    </td>
                    <td>
                        <c:out value="${announcement.announcement_date}" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
            </tr>
            </thead>

            <h3 class="text-center">Similar Announcement</h3>

            <br>
            <tbody>
            <c:forEach var="announcement" items="${listAnnouncementToCompare}">
                <tr>
                    <td>
                        <c:out value="${announcement.announcement_title}" />
                    </td>
                    <td>
                        <c:out value="${announcement.announcement_description}" />
                    </td>
                    <td>
                        <c:out value="${announcement.announcement_date}" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>