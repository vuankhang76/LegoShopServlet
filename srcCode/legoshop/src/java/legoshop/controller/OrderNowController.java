/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import legoshop.dao.OrderDAO;
import legoshop.dao.ProductDAO;
import legoshop.model.OrderDTO;
import legoshop.model.UserDTO;
import legoshop.utils.DBUtils;


@WebServlet(name = "OrderNowController", urlPatterns = {"/ordernow"})
public class OrderNowController extends HttpServlet {

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
            Date date = new Date();

            UserDTO usersession = (UserDTO) request.getSession().getAttribute("usersession");

            if (usersession != null) {
                String productIdStr = request.getParameter("id");
                String productQuantityStr = request.getParameter("quantity");

                if (productIdStr != null && productQuantityStr != null) {
                    try {
                        int productId = Integer.parseInt(productIdStr);
                        int productQuantity = Integer.parseInt(productQuantityStr);

                        if (productQuantity <= 0) {
                            productQuantity = 1;
                        }

                        try (Connection conn = DBUtils.getConnection()) {
                            ProductDAO productDao = new ProductDAO(conn);
                            double productPrice = productDao.getProductPrice(productId);
                            double totalPrice = productPrice * productQuantity;

                            OrderDTO orderModel = new OrderDTO();
                            orderModel.setOrderDate(date);
                            orderModel.setTotalPrice(totalPrice);
                            orderModel.setQuantity(productQuantity);
                            orderModel.setPaymentId(1);
                            orderModel.setUsername(usersession.getUserName());

                            OrderDAO orderDao = new OrderDAO(conn);
                            boolean result = orderDao.insertOrder(orderModel);

                            if (result) {
                                double totalOrderPrice = orderDao.getTotalOrderPrice();
                                request.setAttribute("totalOrderPrice", totalOrderPrice);
                                response.sendRedirect("orders.jsp");
                            } else {
                                out.println("Order failed");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                            out.println("Order failed due to database error.");
                        }
                    } catch (NumberFormatException e) {
                        out.println("Invalid id or quantity format.");
                    }
                } else {
                    out.println("Product id or quantity not provided.");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

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
