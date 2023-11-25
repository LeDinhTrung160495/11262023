<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 08/11/2023
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link href="<%=request.getContextPath()%>/resources/css/product.css" rel="stylesheet"/>
</head>
<body>
    <form action="<%=request.getContextPath()%>/productController/findProduct" method="get">
        <label for="productName">Product Name</label>
        <input type="text" id="productName" name="productName" value="${productName}" placeholder="Input product Name"/>
        <input type="submit" value="Search"/>
    </form>
    <select id="sortBy" name="sortBy" onchange="changeSortBy()">
        <option value="productId" ${sortBy.equals("productId")?'selected':''}>Product Id</option>
        <option value="productName" ${sortBy.equals("productName")?'selected':''}>Product Name</option>
        <option value="price" ${sortBy.equals("price")?'selected':''}>Price</option>
    </select>
    <select id="direction" name="direction" onchange="changeDirection()">
        <option value="ASC" ${direction.equals("ASC")?'selected':''}>Ascending</option>
        <option value="DESC" ${direction.equals("DESC")?'selected':''}>Descending</option>
    </select>
    <a href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Catalog Name</th>
                <th>Title</th>
                <th>Description</th>
                <th>Unit</th>
                <th>Image</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="stt" value="0" scope="page"/>
            <c:forEach items="${listProducts}" var="product">
                <c:set var="stt" value="${stt+1}" scope="page"/>
                <tr>
                    <td>${stt}</td>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.catalog.catalogName}</td>
                    <td>${product.title}</td>
                    <td>${product.description}</td>
                    <td>${product.unit}</td>
                    <td><img src="${product.image}" alt="${product.productName}" width="50" height="50"/></td>
                    <td>${product.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="">Update</a>
                        <a href="">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:forEach items="${listPages}" var="page">
        <a href="<%=request.getContextPath()%>/productController/findProduct?page=${page}">${page}</a>
    </c:forEach>
    <script src="<%=request.getContextPath()%>/resources/js/product.js"></script>
</body>
</html>
