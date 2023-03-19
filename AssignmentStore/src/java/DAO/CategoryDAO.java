/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marshallein
 */
public class CategoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM [dbo].[Category]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("cateID"), rs.getString("cateName"), rs.getString("cateDescription"), rs.getString("cateURL"), rs.getString("cateImageURL")));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;

    }

    public Category getOneCate(String cid) {
        String query = "SELECT * \n"
                + "      \n"
                + "      \n"
                + "  FROM [dbo].[Category]\n"
                + "  where [cateID] = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt("cateID"), rs.getString("cateName"), rs.getString("cateDescription"), rs.getString("cateURL"), rs.getString("cateImageURL"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
