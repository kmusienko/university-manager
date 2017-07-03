<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Изменение группы</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="col-xs-5 centered">
        <h3>Информация о группе:</h3>

        <c:url value="/faculty/speciality/group/edit?groupId=${group.id}&specialityId=${speciality.id}" var="editUrl"/>
        <form action="${editUrl}" method="post">

            <input type="hidden" name="id" value="${group.id}"/>

            <div class="form-group">
                <label for="name">Год поступления:</label>
                <input id="name" type="text" class="form-control" name="yearEntered" value="${group.yearEntered}"/>
            </div>

            <div class="form-group">
                <label for="number">Номер группы:</label>
                <input id="number" type="text" class="form-control" name="groupNumber" value="${group.groupNumber}"/>
            </div>
            <div class="form-group">
                <label for="curator">Куратор</label>
                <input id="curator" type="text" class="form-control" name="curatorName" value="${group.curator.name}"/>
            </div>
            <input type="hidden" name="specialityId" value="${speciality.id}">

            <input type="submit" class="btn btn-success" value="Подтвердить">
        </form>
    </div>
</div>
</body>
</html>
