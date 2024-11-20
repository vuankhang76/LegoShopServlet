<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Edit Product</h2>
        <form action="EditProductController" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${product.productName}" required>
            </div>
            <div class="form-group">
                <label for="image">Image</label>
                <input type="text" class="form-control" id="image" name="image" value="${product.images}" required>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="text" class="form-control" id="price" name="price" value="${product.price}" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required>${product.description}</textarea>
            </div>
            <div class="form-group">
                <label for="stock">Stock</label>
                <input type="text" class="form-control" id="stock" name="stock" value="${product.stock}" required>
            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <select class="form-control" id="category" name="category" required>
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.cid}" <c:if test="${category.cid == product.categoryId}">selected</c:if>>${category.cname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="discount">Discount</label>
                <input type="text" class="form-control" id="discount" name="discount" value="${product.discount}" required>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
    </div>
</body>
</html>
