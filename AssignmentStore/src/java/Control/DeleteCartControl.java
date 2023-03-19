/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductDAO;
import Entity.Cart;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeleteCartControl", urlPatterns = {"/remove"})
public class DeleteCartControl extends HttpServlet {

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
            out.println("<title>Servlet DeleteCartControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCartControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    ProductDAO prodao = new ProductDAO();

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
//        processRequest(request, response);

        HttpSession session = request.getSession();
        ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
        String pid = request.getParameter("id");
        Product product = prodao.getProductbyID(pid);

        for (Cart cart : listCart) {
            if (cart.getId() == product.getId()) {
                listCart.remove(cart);
                break;
            }
        }
        int number = 0;
        double totalMoney = 0;
        for (Cart c : listCart) {
            number += c.getAmount();
            totalMoney += c.getAmount() * c.getPrice();
        }
        if (listCart.isEmpty()) {
            session.removeAttribute("listCart");
            session.removeAttribute("totalProducts");
            session.removeAttribute("totalMoney");
            response.sendRedirect("cart.jsp");
        } else {
            session.setAttribute("totalProducts", number);
            session.setAttribute("totalMoney", totalMoney);
            session.setAttribute("listCart", listCart);
            response.sendRedirect("cart.jsp");

        }
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
        processRequest(request, response);
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
