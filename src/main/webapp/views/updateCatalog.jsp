<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/27/2023
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoriesController/update" method="post">
    <label for="catalogId">Mã danh mục</label>
    <input type="text" id="catalogId" name="catalogId" value="${catalogEdit.catalogId}" readonly/><br>
    <label for="catalogName">Tên danh mục</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalogEdit.catalogName}"/><br>
    <label for="description">Mô tả danh mục</label>
    <input type="text" id="description" name="description" value="${catalogEdit.description}"><br>
    <label for="active">Trạng thái</label>
    <input type="radio" id="active" name="status" value="true" ${catalogEdit.status?'checked':''} /><label for="active">Hoạt động</label>
    <input type="radio" id="inactive" name="status" value="false" ${catalogEdit.status?'':'checked'}/><label
        for="inactive">Không hoạt động</label><br>
    <input type="submit" value="Cập nhập"/>
</form>
</body>
</html>
