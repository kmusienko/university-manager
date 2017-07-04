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
    <div class="row">
        <div class="col-md-4">
            <h3 align="center"> Планы</h3>
        </div>
        <div class="col-md-4">
            <c:url value="/plans" var="searchGroupUrl"/>
            <form class="navbar-form navbar-left" action="${searchGroupUrl}" method="get">
                <div class="form-group">
                    <input type="text" name="groupName" class="form-control" placeholder="Фильтр по группе">
                </div>
                <button type="submit" class="btn btn-default">Применить</button>
            </form>
        </div>
    </div>
    <div class="col-md-11">
        <%--<h3>Планы</h3>--%>
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
                    <td>${planDTO.teacherName}</td>
                    <td>${planDTO.groupName}</td>
                    <td>${planDTO.subjectName}</td>
                    <td>${planDTO.hours}</td>
                    <td>${planDTO.semesterNumber}</td>
                    <td>${planDTO.controlName}</td>
                    <c:url value="/plan/edit?planId=${planDTO.id}"
                           var="editUrl"/>
                    <td><a href="${editUrl}" class="btn btn-primary"
                           role="button">Изменить</a></td>

                    <c:url value="/plan/delete?planId=${planDTO.id}"
                           var="deleteUrl"/>
                    <td><a href="${deleteUrl}" class="btn btn-danger"
                            role="button">Удалить</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:url value="/plan/edit" var="createUrl"/>
        <a href="${createUrl}" class="btn btn-success" role="button">
            Добавить план</a>
    </div>


</body>
</html>
