<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All trips</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid black;
    }
</style>
The list of all hotels
<br>
<div>
    <table style="display: inline-block; width: 100%; height: 50px">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>City</th>
            <th>Country</th>
            <th>Number of rooms</th>
        </tr>
        <c:forEach items="${hotelsList}" var="hotel">
            <tr>
                <th>${hotel.id}</th>
                <th>${hotel.name}</th>
                <th>${hotel.locationCity}</th>
                <th>${hotel.locationCountry}</th>
                <th>${hotel.numberOfRooms}</th>

                <th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <p><a href=http://localhost:8080/hotel/delete/${hotel.id}>Delete</a></p>
                        <p><a href=http://localhost:8080/hotel/update/${hotel.id}>Update</a></p>
                    </sec:authorize></th>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>