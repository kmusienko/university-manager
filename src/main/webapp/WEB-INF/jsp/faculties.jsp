<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kostya
  Date: 11.06.2017
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculties</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="col-md-4">
        <h3>Факультеты</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Название</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${faculties}" var="faculty" varStatus="count">
                <tr>
                    <th scope="row">${count.index + 1}</th>
                    <td>
                        <c:url value="/faculty?id=${faculty.id}"
                               var="facultyUrl"/>
                        <a href="${facultyUrl}"> ${faculty.name}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:url value="/faculty/edit" var="createUrl"/>
        <a href="${createUrl}" class="btn btn=success" role="button">Добавить факультет</a>
    </div>

</div>
</body>
</html>
