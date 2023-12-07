<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/29/2023
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/update" method="post" enctype="multipart/form-data">
    <label for="productId">Mã sản phẩm</label>
    <input type="text" id="productId" name="productId" value="${productEdit.productId}" readonly/><br>
    <label for="productName">Tên sản phẩm</label>
    <input type="text" id="productName" name="productName" value="${productEdit.productName}"/><br>
    <label for="price">Giá sản phẩm</label>
    <input type="number" id="price" name="price" value="${productEdit.price}"/><br>
    <label for="title">Tiêu đề sản phẩm</label>
    <input type="text" id="title" name="title" value="${productEdit.title}"/><br>
    <label for="description">Mô tả sản phẩm</label>
    <input type="text" id="description" name="description" value="${productEdit.description}"/><br>
    <label for="catalog">Chọn tên danh mục</label>
    <select id="catalog" name="catalog.catalogId">
        <c:forEach items="${listCategories}" var="catalog">
            <option value="${catalog.catalogId}">${catalog.catalogName}</option>
        </c:forEach>
    </select><br>
    <p>Ảnh sản phẩm</p>
    <img src="${productEdit.image}" alt="${productEdit.productName}" style="max-width: 50px; max-height: 50px;"/>
      <input type="file" id="productImage" name="productImage"/><br>
    <p>Ảnh chi tiết</p><br>
    <c:forEach items="${listImage}" var="image">
        <img src="${image.imageUrl}" alt="Ảnh" id="otherImages" style="max-width: 50px; max-height: 50px;"/>
    </c:forEach>
    <br>
<%--      <input type="file" id="otherImages" name="otherImages" multiple/><br>--%>
    <label for="unit">Đơn vị sản phẩm (yến, kg, gram)</label>
    <input type="text" id="unit" name="unit" value="${productEdit.unit}"/><br>
    <label for="active">Trạng thái</label>
    <input type="radio" id="active" name="status" value="true" ${productEdit.status?'checked':''} /><label for="active">Hoạt
    động</label>
    <input type="radio" id="inactive" name="status" value="false" ${productEdit.status?'':'checked'}/><label
        for="inactive">Không hoạt động</label><br>
    <input type="submit" value="Cập nhập"/>
</form>
</body>
</html>
