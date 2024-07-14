<%--
  Created by IntelliJ IDEA.
  User: solo
  Date: 06.07.2024
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container w-25">
    <form action="/edit" method="post">
        <input type="hidden" name="id" value="${movie.id}">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control"
                   aria-describedby="emailHelp" name="name"
                   id="exampleInputEmail1" value="${movie.name}">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Description
            </label>
            <input type="text" class="form-control" name="description"
                   id="exampleInputPassword1" value="${movie.description}">
        </div>
        <div class="mb-3">
            <label for="release_date" class="form-label">Release date</label>
            <input type="number" class="form-control" id="release_date"
                   name="release_year" value="${movie.releaseYear}">
        </div>

        <div class="mb-3 form-check">
            <input type="radio" class="form-check-input" id="not_viewed"
                   name="isView" value="false"
            <c:if test="${!movie.isView}">
                    checked
            </c:if> >
            <label class="form-check-label" for="not_viewed">not viewed</label>
            <br>
            <input type="radio" class="form-check-input" id="viewed"
                   name="isView" value="true"
            <c:if test="${movie.isView}">
                   checked
            </c:if> >
            <label class="form-check-label" for="viewed">viewed</label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
