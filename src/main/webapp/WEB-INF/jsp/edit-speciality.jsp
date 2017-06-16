<%--
  Created by IntelliJ IDEA.
  User: Kostya
  Date: 14.06.2017
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="col-xs-5 centered">
        <h3>Информация о специальности:</h3>

        <c:url value="/faculty/speciality/edit?facultyId=${faculty.id}&specialityId=${speciality.id}" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <input type="hidden" name="id" value="${speciality.id}">

            <div class="form-group">
                <label for="name">Название:</label>
                <input id="name" type="text" class="form-control" name="name" value="${speciality.name}">
            </div>

            <div class="form-group">
                <label for="address">Буква:</label>
                <input id="address" type="text" class="form-control" name="letter" value="${speciality.letter}"/>
            </div>
            <input type="hidden" name="faculty_id" value="${faculty.id}">

            <input type="submit" class="btn btn-success" value="Подтвердить">
        </form>
    </div>
</div>
</body>
</html>
