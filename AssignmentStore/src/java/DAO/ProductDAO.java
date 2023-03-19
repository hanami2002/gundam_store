/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marshallein
 */
public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,[pname]\n"
                + "      ,[price]\n"
                + "      ,[imageURL]\n"
                + "      ,[description]\n"
                + "      ,[sellID]\n"
                + "      ,[cateID]\n"
                + "  FROM [dbo].[Product]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("pname"), rs.getInt("price"), rs.getString("imageURL"), rs.getString("description"), rs.getInt("sellID"), rs.getInt("cateID")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Product> getProductByCid(String cid) {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("pname"), rs.getInt("price"), rs.getString("imageURL"), rs.getString("description"), rs.getInt("sellID"), rs.getInt("cateID")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProductbySearch(String txt) {
        String query = "select * from Product where [pname] like ?;";
        ArrayList<Product> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getInt("price"),
                        rs.getString("imageURL"),
                        rs.getString("description"),
                        rs.getInt("sellID"),
                        rs.getInt("cateID")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductbyID(String pid) {
        String query = "SELECT [id]\n"
                + "      ,[pname]\n"
                + "      ,[price]\n"
                + "      ,[imageURL]\n"
                + "      ,[description]\n"
                + "      ,[sellID]\n"
                + "      ,[cateID]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where [id] = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("pname"), rs.getInt("price"), rs.getString("imageURL"), rs.getString("description"), rs.getInt("sellID"), rs.getInt("cateID"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Product> getProductBySellID(int sid) {//int cid
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from\n"
                + "product\n"
                + "where sellID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getInt("price"),
                        rs.getString("imageURL"),
                        rs.getString("description"),
                        rs.getInt("sellID"),
                        rs.getInt("cateID")));
            }
        } catch (Exception e) {
        }
        return list;

    }

    public void updateProduct(Product x, int id) {
        String query = "UPDATE [dbo].[Product]\n"
                + "   SET [pname] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[imageURL] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[sellID] = ?\n"
                + "      ,[cateID] = ?\n"
                + " WHERE id = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, x.getPname());
            ps.setInt(2, x.getPrice());
            ps.setString(3, x.getImageURL());
            ps.setString(4, x.getDescription());
            ps.setInt(5, x.getSellID());
            ps.setInt(6, x.getCateID());
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addProduct(Product x) {
        String query = "INSERT [dbo].[Product] "
                + "( [pname]"
                + ", [price]"
                + ", [imageURL]"
                + ", [description]"
                + ", [sellID]"
                + ", [cateID]"
                + ") VALUES ( ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, x.getPname());
            ps.setInt(2, x.getPrice());
            ps.setString(3, x.getImageURL());
            ps.setString(4, x.getDescription());
            ps.setInt(5, x.getSellID());
            ps.setInt(6, x.getCateID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String id) {
        String query = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public int getTotalProduct() {
        String query = "select count(*) from Product ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Product> pagingProduct(int index) {
        String query = "select * from Product\n"
                + "order by id\n"
                + "offset ? rows fetch next 8 rows only";
        ArrayList<Product> list = new ArrayList<>();

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getInt("price"),
                        rs.getString("imageURL"),
                        rs.getString("description"),
                        rs.getInt("sellID"),
                        rs.getInt("cateID"))
                );

            }

        } catch (Exception e) {
        }
        return list;

    }
}
