<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.time.LocalDate" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>All trips</title>
</head>
<body>
<%@include file="home.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<style>
    table {
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid black;
    }
</style>
<h2>The list of all trips</h2>
<br>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <table class="table">

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
                        <td>${trip.id}</td>
                        <td>${trip.destinationCity}</td>
                        <td>${trip.destinationCountry}</td>
                        <td>${trip.departureDate}</td>
                        <td>${trip.returnDate}</td>
                        <td>${trip.price}</td>
                        <td>${trip.hotel.name}</td>
                        <td>
                            <sec:authorize access="hasRole('ADMIN')">
                            <p><a href=http://localhost:8080/trips/delete/${trip.id}>Delete</a></p>
                            <p><a href=http://localhost:8080/trips/update/${trip.id}>Update</a></p>
                            </sec:authorize>
                            <c:if test="${!trip.departureDate.isBefore(LocalDate.now())}">
                            <sec:authorize access="hasRole('USER')">
                            <c:if test="${!userTrips.contains(trip)}">
                            <p><a href=http://localhost:8080/booking/${trip.id}>Book</a></p>
                            </c:if>
                            </sec:authorize>
                            </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>