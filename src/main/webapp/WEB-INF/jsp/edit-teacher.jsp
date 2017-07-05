<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Преподаватель</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-xs-5 centered">
        <h3>Информация о преподавателе:</h3>

        <c:url value="/faculty/cathedra/teacher/edit?cathedraId=${cathedra.id}&teacherId=${teacher.id}" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <input type="hidden" name="id" value="${teacher.id}">

            <div class="form-group">
                <label for="name">ФИО:</label>
                <input id="name" type="text" class="form-control" name="name" value="${teacher.name}">
            </div>
            <input type="hidden" name="faculty_id" value="${cathedra.id}">

            <input type="submit" class="btn btn-success" value="Подтвердить">
        </form>
    </div>
</div>
</body>
</html>
