<%--
  Created by IntelliJ IDEA.
  User: Kostya
  Date: 12.06.2017
  Time: 17:17
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
    <div class="col-xs-4 centered">
        <h3>Информация о факультете:</h3>

        <c:url value="/faculty/edit" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <input type="hidden" name="id" value="${faculty.id}">

            <div class="form-group">
                <label for="name">Название:</label>
                <input id="name" type="text" class="form-control" name="name" value="${faculty.name}">
            </div>

            <div class="form-group">
                <label for="address">Адрес:</label>
                <input id="address" type="text" class="form-control" name="address" value="${faculty.address}"/>
            </div>

            <div class="form-group">
                <label for="letter">Буква:</label>
                <input id="letter" type="text" class="form-control" name="letter" value="${faculty.letter}">
            </div>
            <input type="submit" class="btn btn-success" value="Submit">
        </form>
    </div>
</div>
</body>
</html>
