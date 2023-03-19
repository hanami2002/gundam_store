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
import org.apache.catalina.ha.ClusterSession;

/**
 *
 * @author Marshallein
 */
@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {

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
            out.println("<title>Servlet CartControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartControl at " + request.getContextPath() + "</h1>");
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
        try {
            
            response.setContentType("text/html;charset=UTF-8");
            String pid = request.getParameter("id");
            Product product = prodao.getProductbyID(pid);
            HttpSession session = request.getSession();
            
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
            
            if (listCart == null) {
                listCart = new ArrayList<>();
                listCart.add(new Cart(product.getId(), product.getPname(), product.getPrice(),
                        product.getImageURL(), 1));
            } else {
                boolean checkProductExist = true;
                for (Cart cart : listCart) {
                    if (cart.getId() == Integer.parseInt(pid)) {
                        cart.setAmount(cart.getAmount() + 1);
                        checkProductExist = false;
                        break;
                    }
                    
                }
                if (checkProductExist) {
                    listCart.add(new Cart(product.getId(), product.getPname(), product.getPrice(),
                            product.getImageURL(), 1));
                }
            }
            
            int number = 0;
            double totalMoney = 0;
            for (Cart c : listCart) {
                number += c.getAmount();
                totalMoney += c.getAmount() * c.getPrice();
            }
            
            session.setAttribute("totalProducts", number);
            session.setAttribute("totalMoney", totalMoney);
            session.setAttribute("listCart", listCart);
            request.getRequestDispatcher("home").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
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
