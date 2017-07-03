<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-12" align="center">
    <nav class="navbar navbar-default" style="margin-top: 10px">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">University manager</a>
            </div>
            <ul class="nav navbar-nav">
                <c:url value="/faculties" var="allFacultiesUrl"/>
                <li class="active"><a href=${allFacultiesUrl}>Факультеты</a></li>
                <c:url value="/plan" var="planUrl"/>
                <li><a href=${planUrl}>План</a></li>
            </ul>
            <c:url value="/faculty" var="searchFacultyUrl"/>
            <form class="navbar-form navbar-left" action="${searchFacultyUrl}" method="get">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Название факультета">
                </div>
                <button type="submit" class="btn btn-default">Найти</button>
            </form>
            <c:url value="/faculty/speciality/group/student" var="searchFacultyUrl"/>
            <form class="navbar-form navbar-left" action="${searchFacultyUrl}" method="get">
                <div class="form-group">
                    <input type="text" name="lastName" class="form-control" placeholder="Фамилия студента">
                </div>
                <button type="submit" class="btn btn-default">Найти</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Войти</a></li>
            </ul>
        </div>
    </nav>
</div>
