<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="legoshop.model.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%
  ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("cart-list");
  if (cart_list != null) {
    request.setAttribute("cart_list", cart_list);
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Login and Registration Form</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            justify-content: center;
            align-items: center;
            
        }
        .container {
            display: flex;
            justify-content: center;
            max-width: 1000px;
            width: 100%;
        }
        .form-container {
            margin-top: 50px;
            background: #f8f9fa!important;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .toggle-link {
            cursor: pointer;
            color: #007bff;
        }
        .toggle-link:hover {
            text-decoration: underline;
        }
        .error-message {
            font-size: 0.9em;
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>            
<div class="container">
    <!-- Login Form -->
    <div id="login-form" class="form-container">
        <h3 class="text-center">Login</h3>
        <form action="./login" method="POST">
            <p class="text-danger">${error}</p>
            <div class="form-group">
                <label for="user">Username</label>
                <input type="text" class="form-control" name="user" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="pass" placeholder="********">
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe">
                <label class="form-check-label" for="rememberMe">Remember me</label>
            </div>
            <input value="Login" class="btn btn-primary btn-block" type="submit">
            <div class="text-center mt-3">
                <a href="./login">Forgot password?</a>
            </div>
            <div class="text-center mt-3">
                <span class="toggle-link" onclick="showSignup()">Don't have an account? Sign up</span>
            </div>
        </form>
    </div>
    <!-- Registration Form -->
    <div id="signup-form" class="form-container" style="display: none;">
        <h3 class="text-center">Register</h3>
        <form action="./signup" method="POST">
            <div class="form-group">
                <label for="user">Username</label>
                <input type="text" class="form-control" name="user" placeholder="Username" required>
            </div>
            <div class="form-group">
                <label for="reg-email">Email</label>
                <input type="email" class="form-control" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <label for="reg-password">Password</label>
                <input type="password" class="form-control" name="password" placeholder="********" required>
            </div>
            <div class="form-group">
                <label for="re-password">Retype Password</label>
                <input type="password" class="form-control" name="repassword" placeholder="********" required>   
            </div>
            <input value="Sign up" class="btn btn-primary btn-block" type="submit">
            <div class="text-center mt-3">
                <span class="toggle-link" onclick="showLogin()">Already have an account? Login</span>
            </div>
        </form>
    </div>
</div>
<script>
    function showSignup() {
        document.getElementById('login-form').style.display = 'none';
        document.getElementById('signup-form').style.display = 'block';
    }

    function showLogin() {
        document.getElementById('signup-form').style.display = 'none';
        document.getElementById('login-form').style.display = 'block';
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
