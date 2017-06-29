<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Специальность</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-md-5">
        <h3>Информация о специальности:</h3>
        <h4>Название: ${speciality.name}</h4>
        <h4>Буква: ${speciality.letter}</h4>
        <h4>Факультет: ${faculty.name}</h4>

        <c:url value="/faculty/speciality/edit?facultyId=${faculty.id}&specialityId=${speciality.id}" var="editUrl"/>
        <a href="${editUrl}" class="btn btn-primary" role="button">Изменить</a>
        <c:url value="/faculty/speciality/delete?facultyId=${faculty.id}&specialityId=${speciality.id}" var="deleteUrl"/>
        <a href="${deleteUrl}" class="btn btn-danger" role="button">Удалить</a>
        <h3>Группы:</h3>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Название</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${groupMap}" var="groupItem" varStatus="count">
                <tr>
                    <th scope="row">${count.index+1}</th>
                    <td>
                        <c:url value="/faculty/speciality/group?groupId=${groupItem.key}"
                               var="groupUrl"/>
                        <a href="${groupUrl}">${groupItem.value}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:url value="/faculty/speciality/group/edit?specialityId=${speciality.id}&groupId=${group.id}"
               var="addGroupUrl"/>
        <a href="${addGroupUrl}" class="btn btn-success" role="button">
            Добавить группу</a>
        <c:url value="/faculty?id=${faculty.id}" var="allFacultiesUrl"/>
        <a href="${allFacultiesUrl}" class="btn btn-link" role="button">Все
            специальности</a>
    </div>

</div>
</body>
</html>
