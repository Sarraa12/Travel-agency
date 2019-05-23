<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<div class="">
    <ul class="navbar-nav nav nav-pills nav-fill">
        <li class="nav-item active mx-1">
            <a class="nav-link btn btn-outline-info" role="button" href="/"><span
                    class="text-lg-left"><i class="fa fa-home"></i>Home</span></a>
        </li>
        <li class="nav-item active mx-1">
            <a class="nav-link btn btn-outline-info" role="button" href="/trips/showAll"><span
                    class="text-lg-left"><i class="fa fa-sun"></i>See all trips</span></a>
        </li>
        <sec:authorize access="hasRole('USER')">

            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/trips/find"><span
                        class="text-lg-left"><i class="fa fa-search"></i>Search</span></a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/trips/add"><span
                        class="text-lg-left"><i class="fa fa-plus"></i>Add a trip</span></a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/hotels/add"><span
                        class="text-lg-left"><i class="fa fa-plus"></i>Add a hotel</span></a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/hotels/showAll"><span
                        class="text-lg-left"><i class="fa fa-hotel"></i>See all hotels</span></a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('USER')">
            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/user/showAll"><span
                        class="text-lg-left"><i class="fa fa-route"></i>Your trips</span></a>
            </li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li class="form-inline mt-3" method="post">
                <a class="nav-link btn btn-outline-info" role="button" href="/logout"><span
                        class="text-lg-left"><i class="fa fa-sign-out-alt"></i>Logout</span></a>
                <sec:csrfInput/>
            </li>
        </sec:authorize>
    </ul>
</div>
<%--<div style="padding-top:75.000%;position:relative;">--%>
    <%--<iframe src="https://www.webintravel.com/wp-content/uploads/2016/10/travel-EnnessyiStock.jpg"--%>
            <%--width="100%" height="100%" style="position:absolute;top:0;left:0;"--%>
            <%--frameBorder="0" allowFullScreen></iframe></div>--%>
        <%--<img src="/images/Przechwytywanie.png" width="100%" height="60%" style="position:absolute;top:0;left:0;"--%>
             <%--frameBorder="0" allowFullScreen>--%>