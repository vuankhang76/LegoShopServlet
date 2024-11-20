
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="legoshop.model.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.7.2/font/bootstrap-icons.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Navigation-->
<style>
    .navbar {
    padding: 1rem 1.5rem;
    background-color: #f8f9fa; /* Light background color */
}

/* Brand and Toggler */
.navbar-brand {
    font-size: 1.5rem;
    font-weight: bold;
}

/* Navbar Links */
.nav-link {
    font-size: 1rem;
    margin-right: 1rem;
    transition: color 0.3s ease-in-out;
}

.nav-link:hover {
    color: #007bff;
}

/* Dropdown Menu */
.dropdown-menu {
    padding: 0.5rem 0;
}

.dropdown-item {
    font-size: 0.9rem;
    padding: 0.5rem 1rem;
}

.dropdown-item:hover {
    background-color: #f1f1f1;
}

/* Search Bar */
.form-control {
    border-radius: 0.25rem;
}

.btn-outline-success {
    border-radius: 0.25rem;
}

/* Account and Cart Sections */
.navbar-nav.me-auto.mb-2.mb-lg-0.ms-lg-4 {
    display: flex;
    align-items: center;
}

.navbar-nav .nav-link {
    margin-right: 1.5rem;
}

.btn-outline-dark {
    display: flex;
    align-items: center;
}

.btn-outline-dark .bi-cart-fill {
    margin-right: 0.5rem;
}

.badge {
    margin-left: 0.5rem;
}

/* Media Queries for Responsiveness */
@media (max-width: 992px) {
    .navbar-nav .nav-link {
        margin-right: 1rem;
    }
}
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="./home">LegoShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <c:if test="${sessionScope.currentPage != 'profile'}">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home">Home</a></li>                            
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach items="${listC}" var="o">
                            <li><a class="dropdown-item" href="category?cid=${o.cid}">${o.cname}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <form class="d-flex me-auto" action="search" method="post">
                <input class="form-control me-2" value="${txtS}" type="text" placeholder="Search" aria-label="Search" name="txt">
                <button class="btn btn-outline-success" type="submit">
                    <i class="bi bi-search"></i>
                </button>
            </form>
            </c:if>    
            <div class="px-4 px-lg-5">
                <div>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <c:if test="${sessionScope.usersession.roleID == 1}">
                            <li class="nav-item"><a class="nav-link" href="managerProduct">Manager</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usersession != null}">
                            <li class="nav-item"><a class="nav-link" href="profile">Hello ${sessionScope.usersession.firstName}</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usersession != null}">
                            <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usersession == null}">
                            <li class="nav-item"><a class="nav-link" href="login.jsp">Account</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <form class="d-flex">
                <a class="btn btn-outline-dark" href="cart.jsp">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${cart_list.size()}</span>
                </a>
            </form>
        </div>
    </div>
</nav>
