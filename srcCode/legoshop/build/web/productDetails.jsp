<%-- 
    Document   : productDetails
    Created on : Jul 10, 2024, 1:34:23 PM
    Author     : LEGION
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <style>
        .display-5 {
            font-size: 2.5rem;
            font-weight: 700;
            margin-bottom: 1rem;
        }
        .fs-5 {
            font-size: 1.25rem;
            color: #28a745;
            font-weight: 600;
        }/* Image styles */
        .card-img-top {
            border-radius: 0.5rem;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

    </style>
    <jsp:include page="menu.jsp"></jsp:include>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${detail.images}" alt="..." /></div>
                <div class="col-md-6">
                    <h1 class="display-5 fw-bolder">${detail.productName}</h1>
                    <div class="fs-5 mb-5"> 
                        <span>${detail.price}₫</span>
                    </div>
                    <p class="lead">${detail.description}</p>
                    <div class="d-flex">
                        <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                        <a class="btn btn-outline-dark flex-shrink-0" href="addtocart?pid=${detail.id}">
                            <i class="bi-cart-fill me-1"></i>
                            Add to cart
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Related items section-->
    <section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">Related products</h2>
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach items="${relatedProducts}" var="product">
                        <div class="col mb-5">
                            <div class="card h-100">
                                <img class="card-img-top" src="${product.images}" alt="..." />
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <h5 class="fw-bolder"><a href="detail?pid=${product.id}" title="View product">${product.productName}</a></h5>
                                        ${product.price}₫
                                    </div>
                                </div>
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="addtocart?pid=${product.id}">Add to cart</a></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    </body>
</html>

