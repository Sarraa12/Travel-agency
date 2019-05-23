<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<h2>The list of all your trips</h2>
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
                    <th>Action</th>
                </tr>
                <c:forEach items="${userTrips}" var="userTrip">
                    <tr>
                        <td>${userTrip.id}</td>
                        <td>${userTrip.destinationCity}</td>
                        <td>${userTrip.destinationCountry}</td>
                        <td>${userTrip.departureDate}</td>
                        <td>${userTrip.returnDate}</td>
                        <td>${userTrip.price}</td>
                        <td>
                            <c:if test="${userTrip.returnDate.isBefore(LocalDate.now())}">
                                <p><a href=http://localhost:8080/opinion/add/${userTrip.id}>Add an opinion</a></p>
                            </c:if>
                            <c:if test="${!userTrip.returnDate.isBefore(LocalDate.now())}">
                                <p>Wait till the trip is over to add an opinion</p>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>