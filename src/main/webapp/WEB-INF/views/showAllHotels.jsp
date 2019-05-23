<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All trips</title>
</head>
<body>
<%@include  file="home.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<style>
    table {
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid black;
    }
</style>
<h2>The list of all hotels</h2>
<br>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <table class="table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>City</th>
            <th>Country</th>
            <th>Number of rooms</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${hotelsList}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.locationCity}</td>
                <td>${hotel.locationCountry}</td>
                <td>${hotel.numberOfRooms}</td>

                <td>
                    <sec:authorize access="hasRole('ADMIN')">
                        <p><a href=http://localhost:8080/hotels/delete/${hotel.id}>Delete</a></p>
                        <p><a href=http://localhost:8080/hotels/update/${hotel.id}>Update</a></p>
                    </sec:authorize></td>
            </tr>
        </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>