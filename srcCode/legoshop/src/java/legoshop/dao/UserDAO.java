/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.dao;

import legoshop.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import legoshop.utils.DBUtils;
import legoshop.model.UserDTO;

/**
 *
 * @author LEGION
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public UserDTO login(String username, String password) {
        UserDTO user = null;
        String sql = "SELECT id, firstname, lastname, email, avatar, username, password, address, phone, roleID FROM users WHERE username = ? AND password = ? ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs != null) {
                if (rs.next()) {

                    user = new UserDTO();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("firstname"));
                    user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setUserName(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setPhone(rs.getString("phone"));
                    user.setRoleID(rs.getInt("roleID"));
                }
            }
        } catch (Exception e) {

        }
        return user;
    }

    public UserDTO checkAccountExist(String userOrEmail) {
        String sql = "SELECT * FROM Users WHERE username = ? OR email = ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userOrEmail);
            stmt.setString(2, userOrEmail);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new UserDTO(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("avatar"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("roleid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void signup(String user, String pass, String email) {
        String sql = "INSERT INTO Users (firstname, lastname, email, avatar, username, password, address, phone, roleid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, "");
            stmt.setString(2, "");
            stmt.setString(3, email);
            stmt.setString(4, "");
            stmt.setString(5, user);
            stmt.setString(6, pass);
            stmt.setString(7, "");
            stmt.setString(8, "");
            stmt.setInt(9, 0);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserDTO getUserById(int id) {
        UserDTO user = null;
        String sql = "SELECT id, firstname, lastname, email, avatar, username, password, address, phone, roleID FROM users WHERE id = ?";
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserDTO(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("avatar"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("roleID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    
    public boolean updateUser(UserDTO user) {
        boolean isUpdated = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE Users SET firstName=?, lastName=?, email=?, address=?, phone=? WHERE id=?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }

        return isUpdated;
    }
}
