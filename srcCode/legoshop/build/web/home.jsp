
<%@page import="legoshop.utils.DBUtils"%>
<%@page import="legoshop.dao.ProductDAO"%>
<%@page import="legoshop.model.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="legoshop.model.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
        <style>
            .head-back {
                background-image: url('img/background.jpg');
                height: 500px; /* Điều chỉnh chiều cao theo ý muốn của bạn */
                background-size: cover;
                background-position: center;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center; /* Đảm bảo văn bản được căn giữa theo chiều ngang */
            }
            .breadcrumb {
                background-color: #f8f9fa;
                padding: 0.75rem 1rem;
                border-radius: 0.25rem;
                margin-bottom: 1rem;
            }
            .breadcrumb-item + .breadcrumb-item::before {
                content: ">";
                color: #6c757d;
            }
            .breadcrumb-item a {
                color: #007bff;
                text-decoration: none;
            }
            .breadcrumb-item a:hover {
                text-decoration: underline;
            }
            .breadcrumb-item.active {
                color: #6c757d;
            }
            .sticky-top {
                position: sticky;
                top: 0;
                z-index: 1000;
            }
            .product-name a {
                text-decoration: none;
                color: #000; /* Màu đen hoặc màu sắc bạn muốn */
            }
            .product-name a:hover {
                color: #007bff; /* Màu sắc khi hover, bạn có thể thay đổi */
                text-decoration: none; /* Nếu bạn muốn thêm gạch chân khi hover */
            }
            .product-name {
                font-size: 1.25rem; /* Kích thước chữ */
                font-weight: bold; /* Đậm chữ */
            }
            .card h5 {
                margin-bottom: 0.5rem; /* Khoảng cách dưới */
            }
            .btn-outline-red {
                background-color: #fff;
                color: #dc3545;
                border-color: #dc3545;
            }
            .btn-outline-red:hover {
                background-color: #dc3545;
                color: #fff;
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>            
            <!-- Header-->
            <header class="head-back bg-dark py-5">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-white">
                        <h1 class="display-4 fw-bolder">LegoShop</h1>
                        <p class="lead fw-normal text-white-50 mb-0">The best lego shop</p>
                    </div>
                </div>
            </header>
            <!-- Section-->
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="./home">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach items="${listP}" var="o">
                        <div class="col mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="${o.images}" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder product-name"><a href="detail?pid=${o.id}" title="View product">${o.productName}</a></h5>
                                        <!-- Product price-->
                                        ${o.price}₫
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="mt-3 d-flex justify-content-center">
                                        <a class="btn btn-outline-dark mt-auto" href="addtocart?pid=${o.id}">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>                  

        </section>
        <!-- Newest Product Section -->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4 text-center">Newest Product</h2>
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${p.images}" alt="Newest Product" />
                            <!-- Product details-->
                            <div class="card-body p-4 text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${p.productName}</h5>
                                <!-- Product description-->
                                <p>${p.description}</p>
                                <!-- Product price-->
                                <span>${p.price}</span>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="addtocart?pid=${p.id}">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
