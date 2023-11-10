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
        <label for="productName">Product Name</label>
        <input type="text" id="productName" name="productName"/><br>
        <label for="price">Price</label>
        <input type="text" id="price" name="price"/><br>
        <label for="title">Title</label>
        <input type="text" id="title" name="title"/><br>
        <label for="productImage">Image</label>
        <input type="file" id="productImage" name="productImage"/><br>
        <label for="otherImages">Image</label>
        <input type="file" id="otherImages" name="otherImages" multiple/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" checked/><label for="active">Active</label>
        <input type="radio" id="inactive" name="status"/><label for="inactive">Inactive</label><br>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
