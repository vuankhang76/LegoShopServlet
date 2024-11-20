package legoshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import legoshop.model.OrderDTO;

public class OrderDAO {
    private Connection conn;

    public OrderDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insertOrder(OrderDTO order) {
        boolean result = false;
        String sql = "INSERT INTO Orders (orderdate, totalprice, quantity, paymentid, username) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setDouble(2, order.getTotalPrice());
            stmt.setInt(3, order.getQuantity());
            stmt.setInt(4, order.getPaymentId());
            stmt.setString(5, order.getUsername());
            result = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public double getTotalOrderPrice() throws SQLException {
        double total = 0.0;
        String sql = "SELECT SUM(totalprice) AS total FROM Orders";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        }
        
        return total;
    }
}
