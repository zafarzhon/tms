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
<div class="container w-25">
    <sp:form action="/app/movies/add" method="post" modelAttribute="movieDto">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <sp:input path="name" type="text" class="form-control"
                      aria-describedby="emailHelp" name="name"
                      id="exampleInputEmail1"/>
            <sp:errors path="name" class="alert-danger"/>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Description
            </label>
            <sp:input path="description" type="text" class="form-control"
                      name="description"
                      id="exampleInputPassword1"/>
            <sp:errors path="description" class="alert-danger"/>
        </div>
        <div class="mb-3">
            <label for="release_date" class="form-label">Release date</label>
            <sp:input path="releaseYear" type="number" class="form-control"
                      id="release_date"
                      name="releaseYear"/>
            <sp:errors path="releaseYear" class="alert-danger"/>
        </div>
        <div class="mb-3 form-check">
            <sp:radiobutton path="isView" class="form-check-input"
                            id="not_viewed"
                            name="isView" value="false" checked="checked"/>
            <label class="form-check-label" for="not_viewed">not viewed</label>
            <br>
            <sp:radiobutton path="isView" class="form-check-input"
                            id="viewed"
                            name="isView" value="true"/>
            <label class="form-check-label" for="viewed">viewed</label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </sp:form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>