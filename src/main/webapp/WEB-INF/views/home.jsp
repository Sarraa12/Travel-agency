<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 26.04.19
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
Welcome to our home page!
<p><a href=http://localhost:8080/showAll>See all available trips</a></p>
<p><a href=http://localhost:8080/find>Find a trip you're looking for</a></p>

<sec:authorize access="hasRole('ADMIN')">
    <p><a href=http://localhost:8080/addTrip>Click here to add a new trip </a></p>
    <p><a href=http://localhost:8080/update/${trip.id}>Update</a></p>
</sec:authorize>
</body>
</html>
