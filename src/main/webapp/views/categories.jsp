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
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/dashboard.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/categories.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,700;0,800;0,900;1,100;1,200;1,300;1,700;1,800&family=Readex+Pro:wght@500&family=Roboto:ital,wght@0,400;0,500;0,700;1,500;1,700&display=swap"
          rel="stylesheet"/>
    <title>List Categories</title>
</head>
<body>
<section class="dashboard">
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 15%; height: 100vh">
        <div class="wrapper-img"><img src="<%=request.getContextPath()%>/resources/assets/Fruit.jpg" alt=""/></div>
        <a href="#" class="text-white text-decoration-none fs-4 text-center">Trái Cây Miền Tây</a>
        <hr/>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="<%=request.getContextPath()%>/dashboardController/dashboard"
                   class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                    <i class="fa-solid fa-house"></i>Bảng điều khiển</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/categoriesController/findCatalog"
                   class="nav-link active text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                <i class="fa-solid fa-house-user"></i>Quản trị danh mục</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/productController/findProduct"
                   class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                    <i class="fa-solid fa-school"></i>Quản trị sản phẩm</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/accountController/findAccount"
                   class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                    <i class="fa-solid fa-graduation-cap"></i>Quản lý tài khoản</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/billController/findBill"
                   class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                    <i class="fa-solid fa-file-invoice"></i>Quản lý đơn hàng</a>
            </li>
            <li>
                <a href="#"
                   class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center">
                    <i class="fa-solid fa-file-invoice"></i>Đơn hàng chi tiết</a>
            </li>
        </ul>
        <hr/>
    </div>
    <div class="dashboard-right">
        <div class="dashboard-right-header">
            <p>Trái Cây Luôn Tươi Sạch, với châm ngôn khách hàng là thượng đế</p>
            <div class="action-header">
                <button class="btn btn-bell">
                    <i class="fa-regular fa-bell" style="color: #080808; font-size: 25px"></i>
                </button>
                <button class="btn btn-primary"><a id="log-out" href="#">Đăng xuất</a></button>
            </div>
        </div>
        <div class="wrapper-header-content">
            <div class="centered-text">
                <h1 class="title">Chào mừng đến trang quản trị, <br/>Trái Cây Miền Tây</h1>
            </div>
            <div class="content-bottom">
                <p class="title-text">Cần Thơ - Tiền Giang - Hồ Chí Minh</p>
            </div>
        </div>
        <div class="categoriesManagement">
            <div class="control">
                <!-- Button trigger modal -->
                <!--Div item gồm: div(button) + div(form)-->
                <div class="item">
                    <div class="button">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#newCatalog"
                                id="btnOpenModal">
                            Thêm mới danh mục
                        </button>
                    </div>
                    <div class="form">
                        <form action="<%=request.getContextPath()%>/categoriesController/findCatalog" method="get">
                            <label for="catalogNameSearch">Tên Danh Mục</label>
                            <input type="text" placeholder="Nhập tên danh mục tìm kiếm" aria-label="Username"
                                   aria-describedby="basic-addon1" id="catalogNameSearch" name="catalogName"
                                   value="${catalogName}"/>
                            <input type="submit" value="Tìm kiếm" class="btn btn-primary"/>
                        </form>
                        <label for="sortBy">Sắp xếp</label>
                        <select aria-label="Default select example" id="sortBy" name="sortBy" onchange="changeSortBy()">
                            <option value="catalogId" ${sortBy.equals("catalogId")?'selected':''}>Mã danh mục</option>
                            <option value="catalogName" ${sortBy.equals("catalogName")?'selected':''}>Tên danh mục
                            </option>
                        </select>
                        <select aria-label="Default select example" id="direction" name="direction"
                                onchange="changeDirection()">
                            <option value="ASC" ${direction.equals("ASC")?'selected':''}>Sắp xếp tăng dần</option>
                            <option value="DESC" ${direction.equals("DESC")?'selected':''}>Sắp xếp giảm dần</option>
                        </select>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="newCatalog" tabindex="-1"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="new-update">Thêm mới danh mục</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="<%=request.getContextPath()%>/categoriesController/create" method="post"
                                      enctype="multipart/form-data">
                                    <label for="catalogName">Tên danh mục</label>
                                    <input type="text" id="catalogName" name="catalogName"/><br>
                                    <label for="description">Mô tả danh mục</label>
                                    <input type="text" id="description" name="description"/><br>
                                    <label for="active">Trạng thái</label>
                                    <input type="radio" id="active" name="status" value="true" checked/><label
                                        for="active">Hoạt động</label>
                                    <input type="radio" id="inactive" name="status" value="false"/><label
                                        for="inactive">Không hoạt động</label><br>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng
                                        </button>
                                        <button type="submit" class="btn btn-primary" id="btnSave">Thêm mới</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Mã danh mục</th>
                    <th scope="col">Tên danh mục</th>
                    <th scope="col">Mô tả danh mục</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Hành động</th>
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
                        <td>${catalog.description}</td>
                        <td>${catalog.status?"Hoạt động":"Không hoạt động"}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/categoriesController/initUpdate?catalogId=${catalog.catalogId}">Cập
                                nhập
                            </a>
                            <a href="<%=request.getContextPath()%>/categoriesController/delete?catalogId=${catalog.catalogId}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example" class="page">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <c:forEach items="${listPages}" var="page">
                        <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>
                            /categoriesController/findCatalog?page=${page}">${page}</a></li>
                    </c:forEach>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>

        </div>
        <div class="dashboard-right-footer text-center">
            <p>Copyright:Trái Cây Miền Tây - Hồ Chí Minh</p>
        </div>
    </div>
</section>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"
></script>
<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
</body>
</html>
