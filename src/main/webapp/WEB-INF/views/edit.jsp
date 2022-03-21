<%--
  Created by IntelliJ IDEA.
  User: gurov
  Date: 21.03.2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<head>
    <title>Редактирование темы</title>
</head>
<body>
<div class="row">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/index">На главную</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/logout"> Выйти </a>
        </li>
    </ul>
</div>
<br>
<div class="card" style="width: 100%">
    <div class="card-header">
        Редактирование темы.
    </div>
    <div class="card-body">
        <form action="<c:url value='/save'/>" method='POST'>
            <input type='text' hidden name='id' value="${post.id}">
            <table>
                <tr>
                    <td>Название:</td>
                    <td><input type='text' name='name' value="${post.name}"></td>
                </tr>
                <tr>
                    <td>Описание:</td>
                    <td><input type='text' name='text' value="${post.description}"></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
