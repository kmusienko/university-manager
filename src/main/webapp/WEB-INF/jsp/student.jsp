<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Студент</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-md-5">
        <h3>Информация о студенте:</h3>
        <h4>Фамилия: <b>${student.lastName}</b></h4>
        <h4>Имя: ${student.firstName}</h4>
        <h4>Адрес: ${student.address}</h4>
        <h4>Дата рождения: ${student.birthdayDate}</h4>
        <h4>ИНН: ${student.indNumber}</h4>
        <h4>Группа: ${groupName}</h4>

        <c:url value="/faculty/speciality/group/student/edit?studentId=${student.id}&groupId=${group.id}"
               var="editUrl"/>
        <a href="${editUrl}" class="btn btn-primary" role="button">Изменить</a>
        <c:url value="/faculty/speciality/group/student/delete?studentId=${student.id}&groupId=${group.id}"
               var="deleteUrl"/>
        <a href="${deleteUrl}" class="btn btn-danger" role="button">Удалить</a>

        <c:url value="/faculty/speciality/group?groupId=${group.id}"
               var="allStudentsUrl"/>
        <a href="${allStudentsUrl}" class="btn btn-link" role="button">Все
            студенты</a>
    </div>

</div>
</body>
</html>
