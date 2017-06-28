<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-12" align="center">
    <nav class="navbar navbar-default" style="margin-top: 10px">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">University manager</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/faculties">Факультеты</a></li>
                <li><a href="#">Page 1</a></li>
                <li><a href="#">План</a></li>
            </ul>
            <c:url value="/faculty" var="searchFacultyUrl"/>
            <form class="navbar-form navbar-left" action="${searchFacultyUrl}" method="get">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Имя студента">
                </div>
                <button type="submit" class="btn btn-default">Найти</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>
</div>
