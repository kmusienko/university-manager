<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-md-5">
            <h3>Факультет:</h3>
            <h4>Название: ${faculty.name}</h4>
            <h4>Адрес: ${faculty.address}</h4>
            <h4>Буква: ${faculty.letter}</h4>

            <c:url value="/faculty/edit?id=${faculty.id}" var="editUrl"/>
            <a href="${editUrl}" class="btn btn-primary"
               role="button">Изменить</a>
            <c:url value="/faculty/delete?id=${faculty.id}" var="deleteUrl"/>
            <a href="${deleteUrl}" class="btn btn-danger"
               role="button">Удалить</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5">
            <h3>Специальности:</h3>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Название</th>
                    <th>Буква</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${specialities}" var="speciality"
                           varStatus="count">
                    <tr>
                        <th scope="row">${count.index+1}</th>

                        <td>
                            <c:url value="/faculty/speciality?id=${speciality.id}&facultyId=${faculty.id}"
                                   var="specialityUrl"/>
                            <a href="${specialityUrl}">${speciality.name}</a>
                        </td>
                        <td>${speciality.letter}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:url value="/faculty/speciality/edit?facultyId=${faculty.id}&specialityId=${speciality.id}"
                   var="addSpecialityUrl"/>
            <a href="${addSpecialityUrl}" class="btn btn-success" role="button">
                Добавить специальность</a>

            <c:url value="/faculties" var="allfacultiesUrl"/>
            <a href="${allfacultiesUrl}" class="btn btn-link" role="button">Все
                факультеты</a>
        </div>
        <div class="col-md-5">
            <h3>Кафедры:</h3>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Название</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cathedras}" var="cathedra"
                           varStatus="count">
                    <tr>
                        <th scope="row">${count.index+1}</th>

                        <td>
                            <c:url value="/faculty/cathedra?cathedraId=${cathedra.id}&facultyId=${faculty.id}"
                                   var="cathedraUrl"/>
                            <a href="${cathedraUrl}">${cathedra.name}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:url value="/faculty/cathedra/edit?facultyId=${faculty.id}&cathedraId=${cathedra.id}"
                   var="addSpecialityUrl"/>
            <a href="${addSpecialityUrl}" class="btn btn-success" role="button">
                Добавить кафедру</a>
    </div>
</div>

</body>
</html>
