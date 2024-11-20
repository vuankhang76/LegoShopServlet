/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import legoshop.model.CategoryDTO;
import legoshop.utils.DBUtils;

public class CategoryDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<CategoryDTO> getAllCategory() {
        List<CategoryDTO> list = new ArrayList<>();
        String sql = "SELECT categoryid, categoryname FROM Categories";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int categoryid = rs.getInt("categoryid");
                String categoryname = rs.getString("categoryname");
                CategoryDTO category = new CategoryDTO();
                category.setCid(categoryid);
                category.setCname(categoryname); 
                list.add(category);
            }
            
            System.out.println("number of categories retrived: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
