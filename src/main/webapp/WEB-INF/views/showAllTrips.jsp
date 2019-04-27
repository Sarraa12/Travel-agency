<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        <tr><th>City</th>
        <th>Country</th>
            <th>Date of departure</th></tr>
        <c:forEach items="${tripsList}" var="tripsList">
            <tr>
                <th>${tripsList.destinationCity}</th>
                <th>${tripsList.destinationCountry}</th>
                <th>${tripsList.departureDate}</th>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

<%--@Column(nullable = false)--%>
<%--private String destinationCity;--%>
<%--@Column(nullable = false)--%>
<%--private String destinationCountry;--%>
<%--@Column(nullable = false)--%>
<%--private LocalDateTime departureDate;--%>
<%--@Column(nullable = false)--%>
<%--private LocalDateTime returnDate;--%>
<%--@Column(nullable = false)--%>
<%--private Integer placeLimit;--%>
<%--@Column(nullable = false)--%>
<%--private LocalDateTime bookingDeadline;--%>
<%--@Column(nullable = false)--%>
<%--private BigDecimal price;--%>