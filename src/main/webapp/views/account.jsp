<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/23/2023
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Account</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/accountController/findAccount" method="get">
    <label for="userName">UserName</label>
    <input type="text" id="userName" name="userName" value="${userName}" placeholder="Input userName"/>
    <input type="submit" value="Search"/>
</form>
<select id="sortBy" name="sortBy" onchange="changeSortBy()">
    <option value="userName" ${sortBy.equals("userName")?'selected':''}>UserName</option>
    <option value="created" ${sortBy.equals("created")?'selected':''}>Created</option>
</select>
<select id="direction" name="direction" onchange="changeDirection()">
    <option value="ASC" ${direction.equals("ASC")?'selected':''}>Ascending</option>
    <option value="DESC" ${direction.equals("DESC")?'selected':''}>Descending</option>
</select>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Account Id</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Created</th>
        <th>Permission</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="stt" value="0" scope="page"/>
    <c:forEach items="${listAccount}" var="account">
        <c:set var="stt" value="${stt+1}" scope="page"/>
        <tr>
            <td>${stt}</td>
            <td>${account.accountId}</td>
            <td>${account.userName}</td>
            <td>${account.password}</td>
            <td><fmt:formatDate value="${account.created}" pattern="dd/MM/yyyy"/></td>
            <td>${account.permission?"Admin":"Customer"}</td>
            <td>${account.accountStatus?"Active":"Inactive"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach items="${listPages}" var="page">
    <a href="<%=request.getContextPath()%>/accountController/findAccount?page=${page}">${page}</a>
</c:forEach>
<script src="<%=request.getContextPath()%>/resources/js/account.js"></script>
</body>
</html>
