<%-- 
    Document   : confirmation
    Created on : Jul 15, 2024, 1:14:06 AM
    Author     : ACER
--%>

<%@page import="legoshop.utils.DBUtils"%>
<%@page import="legoshop.dao.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="legoshop.model.CartItem"%>
<%@page import="legoshop.model.CartItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>
    <div class="container">
        <h2>Order Confirmation</h2>
        <p>Thank you for your order!</p>
        <p>Total Price: ${ total }₫</p>

        <h3>Your Order Details</h3>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                </tr>
            </thead>
                <tbody>
                <%
                    ArrayList<CartItem> cartList = (ArrayList<CartItem>) request.getSession().getAttribute("cart-list");
                    if (cartList != null && !cartList.isEmpty()) {
                        ProductDAO pDao = new ProductDAO(DBUtils.getConnection());
                        List<CartItem> cartItems = pDao.getCartProducts(cartList); // Lấy sản phẩm từ DAO
                        for (CartItem item : cartItems) {
                %>
                <tr>
                    <td><%= item.getProductName() %></td>
                    <td><%= item.getPrice() %>₫</td>
                    <td><%= item.getQuantity() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="3" class="text-center">No items in the cart.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
                
        </table>

        <a href="home.jsp" class="btn btn-primary">Continue Shopping</a>
    </div>
</body>
</html>