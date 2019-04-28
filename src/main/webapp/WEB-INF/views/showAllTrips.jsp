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
The list of all trips
<br>
<div>
    <table style="display: inline-block; width: 100%; height: 50px">
        <tr>
            <th>Id</th>
            <th>City</th>
            <th>Country</th>
            <th>Date of departure</th>
            <th>Date of return</th>
            <th>Price</th>
            <th>Hotel</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${tripsList}" var="trip">
            <tr>
                <th>${trip.id}</th>
                <th>${trip.destinationCity}</th>
                <th>${trip.destinationCountry}</th>
                <th>${trip.departureDate}</th>
                <th>${trip.returnDate}</th>
                <th>${trip.price}</th>
                <th>${trip.hotel}</th>
                <th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <p><a href=http://localhost:8080/delete/${trip.id}>Delete</a></p>
                        <p><a href=http://localhost:8080/update/${trip.id}>Update</a></p>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                    <c:if test="${!userTrips.contains(trip)}">
                    <p><a href=http://localhost:8080/book/${trip.id}>Book</a></p></th>
                    </c:if>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>