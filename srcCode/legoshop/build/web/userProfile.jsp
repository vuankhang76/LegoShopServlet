<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
        <title>User Profile</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 20px;
            }
            .container {
                background-color: white;
                border-radius: 8px;
                padding: 20px;
                max-width: 800px;
                margin: 0 auto;
                display: flex;
            }
            .sidebar {
                width: 200px;
                margin-right: 20px;
            }
            .main-content {
                flex-grow: 1;
            }
            .avatar {
                width: 100%;
                border: 2px solid #4CAF50;
                border-radius: 8px;
            }
            .menu-item {
                background-color: #4CAF50;
                color: white;
                padding: 10px;
                text-align: center;
                margin-top: 10px;
                border-radius: 4px;
                cursor: pointer;
            }
            .menu-item.active {
                background-color: #45a049;
            }
            h2 {
                color: #333;
            }
            .form-group {
                margin-bottom: 15px;
            }
            label {
                display: block;
                margin-bottom: 5px;
                color: #666;
            }
            input[type="text"], input[type="email"] {
                width: 100%;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 4px;
                background-color: #f8f8f8;
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
            <div class="sidebar">
                <img src="${user.avatar}" alt="User Avatar" class="avatar">
                <div class="text-center"><h3>Avatar</h3></div>
            </div>
            <div class="main-content">
                <h2>Account Details</h2>
                <form action="profile" method="post">
                    <input type="hidden" name="action" value="update">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" id="username" value="${user.userName}" readonly>
                    </div>
                    <c:if test="${sessionScope.usersession.roleID == 1}">
                    <div class="form-group">
                        <label for="role">Role</label>
                        <input type="text" id="role" value="${user.roleID == 1 ? 'Admin' : 'Customer'}" readonly>
                    </div>
                    </c:if>
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input type="text" id="firstName" name="firstName" value="${user.firstName}">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" id="lastName" name="lastName" value="${user.lastName}">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" value="${user.email}">
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" value="${user.address}">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" id="phone" name="phone" value="${user.phone}">
                    </div>
                    <button type="submit" class="menu-item">Update Profile</button>
                </form>
                <c:if test="${updateSuccess}">
                    <p style="color: green;">Profile updated successfully!</p>
                </c:if>
                <c:if test="${updateFailed}">
                    <p style="color: red;">Profile update failed. Please try again.</p>
                </c:if>
            </div>
        </div>
    </body>
</html>
