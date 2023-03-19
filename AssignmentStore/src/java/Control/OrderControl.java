/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.OrderDAO;
import Entity.Account;
import Entity.Cart;
import Entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Marshallein
 */
@WebServlet(name = "OrderControl", urlPatterns = {"/ordercheckout"})
public class OrderControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    OrderDAO orddao = new OrderDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
            Account acc = (Account) session.getAttribute("account");
            int accID = acc.getAccID();
            String listoforder = "";
            for (Cart cart : listCart) {
                listoforder = listoforder + "product[" + String.valueOf(cart.getId()) + ",amount = " + String.valueOf(cart.getAmount()) + "],";
            }
            double totalmoney = (Double) session.getAttribute("totalMoney");
            String customer = request.getParameter("name");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            int phone = Integer.parseInt(request.getParameter("mobile"));

            //
            Order order = new Order();
            order.setAccID(accID);
            order.setListOfOrder(listoforder);
            order.setTotalMoney(totalmoney);
            order.setAddress(address);
            order.setPhone(phone);
            order.setNote(note);
            order.setCustomer(customer);
            order.setDate(dtf.format(now));
            order.setStatus("Preparing");
            //
            orddao.generateOrder(order);
            //
            session.removeAttribute("listCart");
            session.removeAttribute("totalProducts");
            session.removeAttribute("totalMoney");
            //
            response.sendRedirect("thanks.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
