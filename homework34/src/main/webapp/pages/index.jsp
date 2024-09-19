<%--<%@ page import="com.teachmeskills.service.DbService" %>--%>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: solo
  Date: 05.07.2024
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/app/home">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/app/movies">List movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/app/movies/add">Add movie</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container justify-content-center w-75">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Release year</th>
            <th scope="col">Is view</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="movie" items="${movies}" varStatus="status">
            <tr>
                <th scope="row">${status.index+1}</th>
                <td>${movie.name}</td>
                <td>${movie.description}</td>
                <td>${movie.releaseYear}</td>
                <td>${movie.isView}</td>
                <td>
                    <a class="btn btn-primary"
                       href="<c:url
                       value='/app/movies/edit?id=${movie.id}'/>">edit
                    </a>

                </td>
                <td>
                    <a class="btn btn-primary"
                       href="<c:url
                       value='/app/movies/delete?id=${movie.id}'/>">delete
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>