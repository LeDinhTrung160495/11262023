<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/25/2023
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,700;0,800;0,900;1,100;1,200;1,300;1,700;1,800&family=Readex+Pro:wght@500&family=Roboto:ital,wght@0,400;0,500;0,700;1,500;1,700&display=swap"
            rel="stylesheet"
    />
</head>
<body>
<div class="container">
    <img
            src="<%=request.getContextPath()%>/resources/assets/S_geolocation.png"
            alt="hình ảnh"
            srcset="<%=request.getContextPath()%>/resources/assets/S_geolocation.png 2x"
    />
    <img
            src="<%=request.getContextPath()%>/resources/assets/S_community.png"
            alt="hình ảnh"
            srcset="<%=request.getContextPath()%>/resources/assets/S_community.png 2x"
    />
    <section class="section-login">
        <h3>Đăng Nhập</h3>
        <p>Xin chào, Admin!</p>
        <form id="form-login" method="POST">
            <label for="email">Email</label>
            <input type="email" name="email" id="email"/>
            <label for="password">Password</label>
            <input type="password" name="password" id="password"/>
            <button type="submit" id="btnSubmit">Đăng nhập để vào Admin</button>
        </form>
    </section>
<%--    <script src="<%=request.getContextPath()%>/resources/js/login.js"></script>--%>
</div>
</body>
</html>
