<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Студенты</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-md-4">
            <h3> Студенты</h3>
            <%--<h3>Планы</h3>--%>
            <table class="table table-striped" align="center">
                <thead>
                <tr>
                    <th>#</th>
                    <th align="center">Фамилия</th>
                    <th>Имя</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student" varStatus="count">
                    <tr>
                        <th scope="row">${count.index + 1}</th>
                        <c:url value="/faculty/speciality/group/student?studentId=${student.id}&groupId=${student.group.id}"
                               var="studentUrl"/>
                        <td><a href="${studentUrl}">${student.lastName}</a></td>
                        <c:url value="/faculty/speciality/group/student?studentId=${student.id}&groupId=${student.group.id}"
                               var="studentUrl"/>
                        <td><a href="${studentUrl}">${student.firstName}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
