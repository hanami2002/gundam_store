/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marshallein
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAccount(String username, String password) {
        String query = "SELECT        *\n"
                + "FROM            Account\n"
                + "WHERE        (username = ?) AND (password = ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt("accID"), rs.getString("username"), rs.getString("password"), rs.getInt("isSell"), rs.getInt("isAdmin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAccount(Account x) {
        String query = "INSERT [dbo].[Account] ([username], [password], [isSell], [isAdmin]) "
                + "VALUES ( ?"
                + ", ?"
                + ", ?"
                + ", 0)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, x.getUsername());
            ps.setString(2, x.getPassword());
            ps.setInt(3, x.getIsSell());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "SELECT [accID]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[isSell]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [gunplaStore].[dbo].[Account]";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt("accID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Account getAccountbyID(String id) {
        String query = "SELECT [accID]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[isSell]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[Account]\n"
                + "  where accID = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getByte("accID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void editAccount(Account x, int id) {
        String query = "UPDATE [dbo].[Account]\n"
                + "   SET [username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[isSell] = ?\n"
                + "      ,[isAdmin] = ?\n"
                + " WHERE [accID] = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, x.getUsername());
            ps.setString(2, x.getPassword());
            ps.setInt(3, x.getIsSell());
            ps.setInt(4, x.getIsAdmin());
            ps.setInt(5, id);
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAccount(String id) {
        String query = "DELETE FROM [dbo].[Account]\n"
                + "      WHERE accID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
}
