/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import legoshop.model.CategoryDTO;
import legoshop.model.ProductDTO;
import legoshop.model.UserDTO;
import legoshop.utils.DBUtils;
import legoshop.model.CartItem;

/**
 *
 * @author LEGION
 */
public class ProductDAO extends DBUtils {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ProductDAO() {
    }

    public ProductDAO(Connection conn) {
        this.conn = conn;
    }

    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price FROM Products ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    int categoryId = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setCategoryId(categoryId);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    list.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ProductDTO getLast() {
        String sql = "SELECT TOP 1 id, productname, categoryid, description, stock, images, discount, price FROM Products\n"
                + "ORDER BY id DESC ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    return product;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductDTO> getProductByCID(String cid) {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price FROM Products\n"
                + "WHERE categoryid = ? ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cid);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    list.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ProductDTO getProductByID(String idd) {
        String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price FROM Products\n"
                + "WHERE id = ? ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idd);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    return product;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ProductDTO> getRelateProduct() {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price "
                + "FROM Products "
                + "WHERE categoryid = (SELECT categoryid FROM Products WHERE id = ?) "
                + "AND id != ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    list.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProductDTO> searchProductByName(String txtSearch) {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price "
                + "FROM Products "
                + "WHERE productname LIKE ? OR description LIKE ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + txtSearch + "%");
            stmt.setString(2, "%" + txtSearch + "%");
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    list.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CartItem> getCartProducts(List<CartItem> cartList) {
        List<CartItem> products = new ArrayList<CartItem>();
        try {
            System.out.println("DEBUG: In getCartProducts, cartList size: " + cartList.size());
            if (cartList.size() > 0) {
                for (CartItem item : cartList) {
                    String sql = "SELECT id, productname, categoryid, description, stock, images, discount, price FROM Products WHERE id = ? ";
                    conn = DBUtils.getConnection();
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, item.getId());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        CartItem row = new CartItem();
                        row.setId(rs.getInt("id"));
                        row.setProductName(rs.getString("productName"));
                        row.setPrice(rs.getDouble("price"));
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                        System.out.println("DEBUG: Added product to list: " + row.getProductName());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("DEBUG: Exception in getCartProducts: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("DEBUG: Returning products list size: " + products.size());
        return products;
    }

    public double getTotalCartPrice(ArrayList<CartItem> cartList) {
        double sum = 0;

        try {
            if (cartList.size() > 0) {
                for (CartItem item : cartList) {
                    String sql = "SELECT price FROM Products WHERE id = ? ";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, item.getId());
                    rs = stmt.executeQuery();

                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public double getProductPrice(int id) throws SQLException {
        double price = 0.0;
        String sql = "SELECT price FROM Products WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    public List<ProductDTO> getProductBySellID(int sid) {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        String sql = "SELECT * FROM Orders WHERE order_id = ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    String images = rs.getString("images");
                    float discount = rs.getFloat("discount");
                    double price = rs.getDouble("price");

                    ProductDTO product = new ProductDTO();
                    product.setId(id);
                    product.setProductName(productName);
                    product.setDescription(description);
                    product.setStock(stock);
                    product.setImages(images);
                    product.setDiscount(discount);
                    product.setPrice(price);

                    list.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addProduct(ProductDTO product) {
        String sql = "INSERT INTO Products (productname, categoryid, description, stock, images, discount, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getCategoryId());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, product.getStock());
            stmt.setString(5, product.getImages());
            stmt.setDouble(6, product.getDiscount());
            stmt.setDouble(7, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(ProductDTO product) {
        String sql = "UPDATE Products SET productname=?, categoryid=?, description=?, stock=?, images=?, discount=?, price=? WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getCategoryId());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, product.getStock());
            stmt.setString(5, product.getImages());
            stmt.setDouble(6, product.getDiscount());
            stmt.setDouble(7, product.getPrice());
            stmt.setInt(8, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int id) {
        String sql = "DELETE FROM Products WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ProductDTO getProductById(int id) {
        ProductDTO product = null;
        String sql = "SELECT * FROM Products WHERE id = ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                product = new ProductDTO();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("productname"));
                product.setCategoryId(rs.getInt("categoryid"));
                product.setDescription(rs.getString("description"));
                product.setStock(rs.getInt("stock"));
                product.setImages(rs.getString("images"));
                product.setDiscount(rs.getFloat("discount"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    public List<ProductDTO> getRelatedProducts(String productId) {
    List<ProductDTO> relatedProducts = new ArrayList<>();
    String sql = "SELECT TOP 4 * FROM Products WHERE categoryid = (SELECT categoryid FROM Products WHERE id = ?) AND id != ?";
    try (Connection conn = DBUtils.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, productId);
        stmt.setString(2, productId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ProductDTO product = new ProductDTO();
            product.setId(rs.getInt("id"));
            product.setProductName(rs.getString("productname"));
            product.setCategoryId(rs.getInt("categoryid"));
            product.setDescription(rs.getString("description"));
            product.setStock(rs.getInt("stock"));
            product.setImages(rs.getString("images"));
            product.setDiscount(rs.getFloat("discount"));
            product.setPrice(rs.getDouble("price"));
            relatedProducts.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return relatedProducts;
}

}
