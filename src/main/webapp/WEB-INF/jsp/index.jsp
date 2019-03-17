<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="actionUrl" value="/user-add"/>
<html>
<body>
<h1>User CRUD Operation</h1>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>


<div class="container">
    <form:form action="${actionUrl}" modelAttribute="user" method="POST" acceptCharset="UTF-8">
        <div class="form-group">
            <form:label path="id">ID</form:label>
            <form:input path="id" readonly="true" class="form-control"/>
        </div>


        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:input path="name" class="form-control"/>
        </div>

        <div class="form-group">
            <form:label path="address">
                Address</form:label>
            <form:input path="address" class="form-control"/>
        </div>

        <input type="submit" value="Submit"/>

    </form:form>

</div>
<table class="table">

    <c:if test="${not empty users}">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="col">${user.id}</th>
                <td>${user.name}</td>
                <td>${user.address}</td>
                <td><a href="edit/${user.id}" class="btn btn-info">Edit</a></td>
                <td><a href="delete/${user.id}" class="btn btn-danger">Delete</a></td>
            </tr>

        </c:forEach>

    </c:if>

</table>
</body>
</html>