<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Информация о плане</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-xs-5 centered">
        <h3>Информация о плане:</h3>

        <c:url value="/plan/edit?planId=${plan.id}" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <%--<input type="hidden" name="id" value="${plan.id}">--%>

            <div class="form-group">
                <label for="teacher">Преподаватель:</label>
                <input id="teacher" type="text" class="form-control"
                       name="teacherName" value="${planDTO.teacherName}">
            </div>
            <div class="form-group">
                <label for="group">Группа:</label>
                <input id="group" type="text" class="form-control"
                       name="groupName" value="${planDTO.groupName}"/>
            </div>
            <div class="form-group">
                <label for="subject">Предмет:</label>
                <input id="subject" type="text" class="form-control"
                       name="subjectName" value="${planDTO.subjectName}">
            </div>
            <div class="form-group">
                <label for="hours">Часы:</label>
                <input id="hours" type="text" class="form-control"
                       name="hours" value="${planDTO.hours}">
            </div>
            <div class="form-group">
                <label for="semesterNumber">Семестр:</label>
                <input id="semesterNumber" type="text" class="form-control"
                       name="semesterNumber" value="${planDTO.semesterNumber}">
            </div>
            <div class="form-group">
                <label for="semesterNumber">Контроль:</label>
                <input id="controlName" type="text" class="form-control"
                       name="controlName" value="${planDTO.controlName}">
            </div>
            <input type="submit" class="btn btn-success" value="Подтвердить">
        </form>
    </div>
</div>
</body>
</html>
