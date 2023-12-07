<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 10/11/2023
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/create" method="post" enctype="multipart/form-data">
    <label for="productId">Mã sản phẩm</label>
    <input type="text" id="productId" name="productId"/><br>
    <label for="productName">Tên sản phẩm</label>
    <input type="text" id="productName" name="productName"/><br>
    <label for="price">Giá sản phẩm</label>
    <input type="number" id="price" name="price"/><br>
    <label for="catalog">Chọn tên danh mục</label>
    <select id="catalog" name="catalog.catalogId">
        <c:forEach items="${listCategories}" var="catalog">
            <option value="${catalog.catalogId}">${catalog.catalogName}</option>
        </c:forEach>
    </select><br>
    <label for="title">Tiêu đề sản phẩm</label>
    <input type="text" id="title" name="title"/><br>
    <label for="description">Mô tả sản phẩm</label>
    <input type="text" id="description" name="description"/><br>
    <label for="productImage">Ảnh sản phẩm</label>
    <input type="file" id="productImage" name="productImage"/><br>
    <label for="otherImages">Ảnh chi tiết</label>
    <input type="file" id="otherImages" name="otherImages" multiple/><br>
    <label for="unit">Đơn vị sản phẩm (yến, kg, gram)</label>
    <input type="text" id="unit" name="unit"/><br>
    <label for="active">Trạng thái</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Hoạt động</label>
    <input type="radio" id="inactive" name="status" value="false"/><label for="inactive">Không hoạt động</label><br>
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
