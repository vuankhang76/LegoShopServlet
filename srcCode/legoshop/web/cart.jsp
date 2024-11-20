<%@page import="java.util.List"%>
<%@page import="legoshop.utils.DBUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="legoshop.model.CartItem"%>
<%@page import="legoshop.dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("cart-list");
  List<CartItem> cartProduct = null;
  if (cart_list != null) {
    ProductDAO pDao = new ProductDAO(DBUtils.getConnection());
    cartProduct = pDao.getCartProducts(cart_list);
    double total = pDao.getTotalCartPrice(cart_list);
    request.setAttribute("cart_list", cart_list);
    request.setAttribute("total", total);
  }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Cart Page</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
            <div class="d-flex py-3">
                <h3>Total price: ${ (total>0)?total:0 }₫</h3>
                <a class="mx-3 btn btn-primary" href="checkout">Check Out</a>
            </div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col" class="text-center">Name</th>
                        <th scope="col" class="text-center">Price</th>
                        <th scope="col" class="text-center">Quantity</th>
                        <th scope="col" class="text-center">Buy Now</th>
                        <th scope="col" class="text-center">Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(cartProduct != null) {
                        for(CartItem c : cartProduct) { %>
                        <tr>
                            <td class="text-center"><%= c.getProductName() %></td>
                            <td><%= c.getPrice() %>₫</td>
                            <td>
                                <form method="post" action="/ordernow" class="form-inline d-flex justify-content-center align-items-center">
                                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-inline text-center">
                                    <div class="input-group d-flex justify-content-center align-items-center">
                                        <a type="button" class="btn btn-sm btn-outline-secondary text-center" href="quantitydec?action=dec&id=<%= c.getId() %>">
                                            <i class="bi bi-dash"></i>
                                        </a>
                                        <input type="text" name="quantity" class="form-control text-center" value="<%= c.getQuantity() %>" style="max-width: 60px;">
                                        <a type="button" class="btn btn-sm btn-outline-secondary text-center" href="quantitydec?action=inc&id=<%= c.getId() %>">
                                            <i class="bi bi-plus"></i>
                                        </a>
                                    </div>
                                    <td class="text-center">
                                        <button type="submit" class="btn btn-primary btn-sm mx-2">Buy</button>
                                    </td>
                                </form>         
                            </td>
                            <td class="text-center">
                                <a class="btn btn-danger btn-sm" href="removefromcart?id=<%= c.getId() %>">
                                    <i class="bi bi-trash"></i>
                                </a>
                            </td>
                        </tr>
                        <% } } %>
                </tbody>
            </table>
        </div>
        <%-- <jsp:include page="footer.jsp"></jsp:include> --%>
    </body>
</html>
