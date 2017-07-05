<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Кафедра</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-md-6">
        <h3>Информация о кафедре:</h3>
        <h4>Название: ${cathedra.name}</h4>
        <h4>Факультет: ${faculty.name}</h4>

        <c:url value="/faculty/cathedra/edit?facultyId=${faculty.id}&cathedraId=${cathedra.id}" var="editUrl"/>
        <a href="${editUrl}" class="btn btn-primary" role="button">Изменить</a>
        <c:url value="/faculty/cathedra/delete?facultyId=${faculty.id}&cathedraId=${cathedra.id}" var="deleteUrl"/>
        <a href="${deleteUrl}" class="btn btn-danger" role="button">Удалить</a>
        <h3>Преподаватели:</h3>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>ФИО</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${teachers}" var="teacher" varStatus="count">
                <tr>
                    <th scope="row">${count.index+1}</th>
                    <td>${teacher.name}</td>
                    <c:url value="/faculty/cathedra/teacher/edit?teacherId=${teacher.id}&cathedraId=${cathedra.id}"
                           var="editUrl"/>
                    <td><a href="${editUrl}" class="btn btn-primary"
                           role="button">Изменить</a></td>

                    <c:url value="/faculty/cathedra/teacher/delete?teacherId=${teacher.id}&cathedraId=${cathedra.id}"
                           var="deleteUrl"/>
                    <td><a href="${deleteUrl}" class="btn btn-danger"
                           role="button">Удалить</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:url value="/faculty/cathedra/teacher/edit?cathedraId=${cathedra.id}&teacherId=${teacher.id}"
               var="addTeacherUrl"/>
        <a href="${addTeacherUrl}" class="btn btn-success" role="button">
            Добавить преподавателя</a>

        <c:url value="/faculty?id=${faculty.id}" var="allFacultiesUrl"/>
        <a href="${allFacultiesUrl}" class="btn btn-link" role="button">Все
            кафедры</a>
    </div>

</div>
</body>
</html>
