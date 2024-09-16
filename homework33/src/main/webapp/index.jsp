<%@ page import="com.teachmeskills.dto.Movie" %>
<%--<%@ page import="com.teachmeskills.service.DbService" %>--%>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: solo
  Date: 05.07.2024
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="container w-25">
    <form action="/movie/home" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control"
                   aria-describedby="emailHelp" name="name"
                   id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Description
            </label>
            <input type="text" class="form-control" name="description"
                   id="exampleInputPassword1">
        </div>
        <div class="mb-3">
            <label for="release_date" class="form-label">Release date</label>
            <input type="number" class="form-control" id="release_date"
                   name="release_year">
        </div>

        <div class="mb-3 form-check">
            <input type="radio" class="form-check-input" id="not_viewed"
                   name="isView" value="false">
            <label class="form-check-label" for="not_viewed">not viewed</label>
            <br>
            <input type="radio" class="form-check-input" id="viewed"
                   name="isView" value="true">
            <label class="form-check-label" for="viewed">viewed</label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

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
                       href="<c:url value='/movie/edit?id=${movie.id}'/>">edit
                    </a>

                </td>
                <td>
                    <a class="btn btn-primary"
                       href="<c:url value='/movie/delete?id=${movie.id}'/>">delete
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
