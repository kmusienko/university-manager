<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Информация о студенте</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-xs-5 centered">
        <h3>Информация о студенте:</h3>

        <c:url value="/faculty/speciality/group/student/edit?studentId=${student.id}&groupId=${group.id}" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <input type="hidden" name="id" value="${student.id}">

            <div class="form-group">
                <label for="lastName">Фамилия:</label>
                <input id="lastName" type="text" class="form-control" name="lastName" value="${student.lastName}">
            </div>
            <div class="form-group">
                <label for="firstName">Имя:</label>
                <input id="firstName" type="text" class="form-control" name="firstName" value="${student.firstName}">
            </div>
            <div class="form-group">
                <label for="address">Адрес:</label>
                <input id="address" type="text" class="form-control" name="address" value="${student.address}">
            </div>
            <div class="form-group">
                <label for="birthdayDate">Дата рождения:</label>
                <input id="birthdayDate" type="text" class="form-control" name="dateString" value="${student.birthdayDate}">
            </div>
            <div class="form-group">
                <label for="inn">ИНН:</label>
                <input id="inn" type="text" class="form-control" name="indNumber" value="${student.indNumber}">
            </div>

            <%--<input type="hidden" name="faculty_id" value="${faculty.id}">--%>

            <input type="submit" class="btn btn-success" value="Подтвердить">
        </form>
    </div>
</div>
</body>
</html>
