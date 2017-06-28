<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Группа</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-md-5">
        <h3>Информация о группе:</h3>
        <h4>Название: <b>${groupName}</b></h4>
        <h4>Куратор: ${group.curator.name}</h4>
        <h4>Год поступления: ${group.yearEntered}</h4>
        <h4>Специальность: ${group.speciality.name}</h4>

        <c:url value="/faculty/speciality/group/edit?groupId=${group.id}"
               var="editUrl"/>
        <a href="${editUrl}" class="btn btn-primary" role="button">Изменить</a>
        <c:url value="/faculty/speciality/group/delete?groupId=${group.id}"
               var="deleteUrl"/>
        <a href="${deleteUrl}" class="btn btn-danger" role="button">Удалить</a>
        <h3>Студенты:</h3>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Фамилия</th>
                <th>Имя</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student" varStatus="count">
                <tr>
                    <th scope="row">${count.index+1}</th>

                    <td>
                        <c:url value="/faculty/speciality/group/student?studentId=${student.id}"
                               var="studentUrl"/>
                        <a href="${studentUrl}">${student.lastName}</a>
                    </td>
                    <td>
                        <c:url value="/faculty/speciality/group/student?studentId=${student.id}"
                               var="studentUrl"/>
                        <a href="${studentUrl}">${student.firstName}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:url value="/faculty/speciality/group/student/edit?studentId=${student.id}"
               var="addGroupUrl"/>
        <a href="${addGroupUrl}" class="btn btn-success" role="button">
            Добавить студента</a>
        <c:url value="/faculty/speciality?id=${group.speciality.id}&facultyId=${group.speciality.faculty.id}"
               var="allfacultiesUrl"/>
        <a href="${allfacultiesUrl}" class="btn btn-link" role="button">Все
            группы</a>
    </div>

</div>
</body>
</html>
