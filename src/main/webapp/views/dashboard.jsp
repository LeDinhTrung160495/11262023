<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 11/26/2023
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"
    ></script>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,700;0,800;0,900;1,100;1,200;1,300;1,700;1,800&family=Readex+Pro:wght@500&family=Roboto:ital,wght@0,400;0,500;0,700;1,500;1,700&display=swap"
            rel="stylesheet"
    />
    <title>Dashboard</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/dashboard.css"/>
</head>
<body>
<section class="dashboard">
    <div
            class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
            style="width: 15%; height: 100vh"
    >
        <div class="wrapper-img">
            <img
                    src="<%=request.getContextPath()%>/resources/assets/Fruit.jpg"
                    alt=""
            />
        </div>
        <a href="#" class="text-white text-decoration-none fs-4 text-center"
        >Trái Cây Miền Tây
        </a>

        <hr/>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a
                        href="<%=request.getContextPath()%>/dashboardController/dashboard"
                        class="nav-link active text-center d-flex justify-content-center gap-2 d-flex align-items-center"
                ><i class="fa-solid fa-house"></i>
                    Bảng điều khiển
                </a>
            </li>
            <li>
                <a
                        href="<%=request.getContextPath()%>/categoriesController/findCatalog"
                        class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center"
                ><i class="fa-solid fa-house-user"></i>
                    Quản trị danh mục
                </a>
            </li>
            <li>
                <a
                        href="<%=request.getContextPath()%>/productController/findProduct"
                        class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center"
                ><i class="fa-solid fa-school"></i>
                    Quản trị sản phẩm
                </a>
            </li>
            <li>
                <a
                        href="<%=request.getContextPath()%>/accountController/findAccount"
                        class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center"
                ><i class="fa-solid fa-graduation-cap"></i>
                    Quản lý tài khoản
                </a>
            </li>
            <li>
                <a
                        href="<%=request.getContextPath()%>/billController/findBill"
                        class="nav-link text-white text-center d-flex justify-content-center gap-2 d-flex align-items-center"
                ><i class="fa-solid fa-file-invoice"></i>
                    Quản lý đơn hàng
                </a>
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
            <p>
                Trái Cây Luôn Tươi Sạch, với châm ngôn khách hàng là thượng đế
            </p>
            <div class="action-header">
                <button class="btn btn-bell">
                    <i
                            class="fa-regular fa-bell"
                            style="color: #080808; font-size: 25px"
                    ></i>
                </button>
                <button class="btn btn-primary">
                    <a id="log-out" href="#">Đăng xuất</a>
                </button>
            </div>
        </div>
        <div class="wrapper-header-content">
            <div class="centered-text">
                <h1 class="title">
                    Chào mừng đến trang quản trị, <br/>
                    Trái Cây Miền Tây
                </h1>
            </div>
            <div class="content-bottom">
                <p class="title-text">Cần Thơ - Tiền Giang - Hồ Chí Minh</p>
            </div>
        </div>
        <div class="statistic">
            <div>
                <div class="course d-flex gap-2">
                    <i class="fa-solid fa-house-user"></i>
                    <h5 class="statistic-item">Thống kê số lượng tài khoản</h5>
                </div>
                <div class="course1">
                    <p>Tổng tài khoản</p>
                    <p id="allAccount">${allAccount}</p>
                </div>
                <div class="course1">
                    <p>Tài khoản hoạt động</p>
                    <p id="activeAccount">${accStatusTrue}</p>
                </div>
                <div class="course1">
                    <p>Tài khoản không hoạt động</p>
                    <p id="inactiveAccount">${accStatusFalse}</p>
                </div>
            </div>
            <div>
                <div class="course d-flex gap-2">
                    <i class="fa-solid fa-school"></i>
                    <h5 class="statistic-item">Thống kê số lượng sản phẩm</h5>
                </div>
                <div class="course1">
                    <p>Tổng sản phẩm</p>
                    <p id="allProduct">${allProduct}</p>
                </div>
                <div class="course1">
                    <p>Sản phẩm hoạt động</p>
                    <p id="activeProduct">${productStatusTrue}</p>
                </div>
                <div class="course1">
                    <p>Số phẩm không hoạt động</p>
                    <p id="inactiveProduct">${productStatusFalse}</p>
                </div>
            </div>
            <div>
                <div class="course d-flex gap-2">
                    <i class="fa-solid fa-graduation-cap"></i>
                    <h5 class="statistic-item">Thống kê số lượng đơn hàng</h5>
                </div>
                <div class="course1">
                    <p>Tổng đơn hàng</p>
                    <p id="allBill">${allBill}</p>
                </div>
                <div class="course1">
                    <p>Đã bị hủy</p>
                    <p id="cancelledBill">${canceledBill}</p>
                </div>
                <div class="course1">
                    <p>Đang chờ</p>
                    <p id="waitingBill">${waitingBill}</p>
                </div>
                <div class="course1">
                    <p>Đã được duyệt</p>
                    <p id="approvedBill">${approvedBill}</p>
                </div>
                <div class="course1">
                    <p>Đang giao hàng</p>
                    <p id="deliveringBill">${deliveringBill}</p>
                </div>
                <div class="course1">
                    <p>Đã nhận hàng</p>
                    <p id="receivedBill">${receivedBill}</p>
                </div>
            </div>
            <div>
                <div class="course d-flex gap-2">
                    <i class="fa-solid fa-graduation-cap"></i>
                    <h4 class="statistic-item">Thống kê doanh thu</h4>
                </div>
                <div class="course1">
                    <p>Ngày hiện tại</p>
                    <p id="today"><fmt:formatNumber type="number" pattern="###,###vnd" value="${revenueInDay}"/></p>
                </div>
                <div class="course1">
                    <p>Tháng hiện tại</p>
                    <p id="currentMonth"><fmt:formatNumber type="number" pattern="###,###vnd" value="${revenueInMonth}"/></p>
                </div>
                <div class="course1">
                    <p>Năm hiện tại</p>
                    <p id="currentYear"><fmt:formatNumber type="number" pattern="###,###vnd" value="${revenueInYear}"/></p>
                </div>
            </div>
        </div>
        <div class="dashboard-right-footer text-center">
            <p>Copyright:Trái Cây Miền Tây - Hồ Chí Minh</p>
        </div>
    </div>
</section>
</body>
</html>
