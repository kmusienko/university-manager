<%--
  Created by IntelliJ IDEA.
  User: Kostya
  Date: 14.06.2017
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>Информация о специальности:</h3>
    <h4>Название: ${speciality.name}</h4>
    <h4>Буква: ${speciality.letter}</h4>
    <h4>Факультет: ${faculty.name}</h4>

    <c:url value="/faculty/speciality?id=${speciality.id}" var="editUrl"/>
    <a href="${editUrl}" class="btn btn-primary" role="button">Изменить</a>
    <c:url value="/faculty/speciality/delete?id=${speciality.id}" var="deleteUrl"/>
    <a href="${deleteUrl}" class="btn btn-danger" role="button">Удалить</a>
</div>
</body>
</html>
