/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marshallein
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void generateOrder(Order x) {
        String query = "INSERT INTO [dbo].[Order]\n"
                + "           (\n"
                + "           [accID]\n"
                + "           ,[listOfOrder]\n"
                + "           ,[totalMoney]\n"
                + "           ,[address]\n"
                + "           ,[Phone]\n"
                + "           ,[note]\n"
                + "           ,[customer]"
                + "           ,[date]\n"
                + "           ,[status])"
                + "     VALUES\n"
                + "           (\n"
                + "           ?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "		   ,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, x.getAccID());
            ps.setString(2, x.getListOfOrder());
            ps.setDouble(3, x.getTotalMoney());
            ps.setString(4, x.getAddress());
            ps.setInt(5, x.getPhone());
            ps.setString(6, x.getNote());
            ps.setString(7, x.getCustomer());
            ps.setString(8, x.getDate());
            ps.setString(9, x.getStatus());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Order> getAllOrders() {
        String query = "SELECT [orderID]\n"
                + "      ,[accID]\n"
                + "      ,[listOfOrder]\n"
                + "      ,[totalMoney]\n"
                + "      ,[address]\n"
                + "      ,[Phone]\n"
                + "      ,[note]\n"
                + "      ,[customer]\n"
                + "      ,[date]\n"
                + "      ,[status]\n"
                + "  FROM [dbo].[Order]";
        ArrayList<Order> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateStatus(String ordID, String status) {
        String query = "UPDATE [dbo].[Order]\n"
                + "   SET [status] = ?\n"
                + " WHERE orderID = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, ordID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
