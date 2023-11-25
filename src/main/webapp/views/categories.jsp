<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/20/2023
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoriesController/findCatalog" method="get">
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalogName}" placeholder="Input catalog Name"/>
    <input type="submit" value="Search"/>
</form>
<select id="sortBy" name="sortBy" onchange="changeSortBy()">
    <option value="catalogId" ${sortBy.equals("catalogId")?'selected':''}>Catalog Id</option>
    <option value="catalogName" ${sortBy.equals("catalogName")?'selected':''}>Catalog Name</option>
    <option value="price" ${sortBy.equals("price")?'selected':''}>Price</option>
</select>
<select id="direction" name="direction" onchange="changeDirection()">
    <option value="ASC" ${direction.equals("ASC")?'selected':''}>Ascending</option>
    <option value="DESC" ${direction.equals("DESC")?'selected':''}>Descending</option>
</select>
<a href="<%=request.getContextPath()%>/categoriesController/initCreate">Create New Catalog</a>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Created</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="stt" value="0" scope="page"/>
    <c:forEach items="${listCatalog}" var="catalog">
        <c:set var="stt" value="${stt+1}" scope="page"/>
        <tr>
            <td>${stt}</td>
            <td>${catalog.catalogId}</td>
            <td>${catalog.catalogName}</td>
            <td><fmt:formatDate value="${catalog.created}" pattern="dd/MM/yyyy"/></td>
            <td>${catalog.status?"Active":"Inactive"}</td>
            <td>
                <a href="">Update</a>
                <a href="">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach items="${listPages}" var="page">
    <a href="<%=request.getContextPath()%>/categoriesController/findCatalog?page=${page}">${page}</a>
</c:forEach>
<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
</body>
</html>
