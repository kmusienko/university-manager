<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Планы</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-md-8">
        <h3>Планы</h3>
        <table class="table table-striped" align="center">
            <thead>
            <tr>
                <th>#</th>
                <th align="center">Преподаватель</th>
                <th>Группа</th>
                <th>Предмет</th>
                <th>Часы</th>
                <th>Семестр</th>
                <th>Контроль</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${plansDTO}" var="planDTO" varStatus="count">
                <tr>
                    <th scope="row">${count.index + 1}</th>
                    <td>${planDTO.teacher.name}</td>
                    <td>${planDTO.groupName}</td>
                    <td>${planDTO.subject.name}</td>
                    <td>${planDTO.hours}</td>
                    <td>${planDTO.semesterNumber}</td>
                    <td>${planDTO.control.name()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:url value="/faculty/edit" var="createUrl"/>
        <a href="${createUrl}" class="btn btn-success" role="button">
            Добавить план</a>
    </div>


</body>
</html>
