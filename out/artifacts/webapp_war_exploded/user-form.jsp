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
            <a href="<%=request.getContextPath()%>/list" class="navbar-brand"> School Management App </a>
        </div>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${announcement != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${announcement == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${announcement != null}">
                                Edit Announcement
                            </c:if>
                            <c:if test="${announcement == null}">
                                Add New Announcement
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${announcement != null}">
                        <input type="hidden" name="id" value="<c:out value='${announcement.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Announcement Title</label> <input type="text" value="<c:out value='${announcement.announcement_title}' />" class="form-control" name="Title" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Announcement Description</label> <input type="text" value="<c:out value='${announcement.announcemnt_description}' />" class="form-control" name="Description">
                    </fieldset>


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>