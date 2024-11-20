/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import legoshop.dao.CategoryDAO;
import legoshop.dao.ProductDAO;
import legoshop.model.CategoryDTO;
import legoshop.model.ProductDTO;


/**
 *
 * @author ACER
 */
@WebServlet(name = "EditProductController", urlPatterns = {"/EditProductController"})
public class EditProductController extends HttpServlet {

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
            out.println("<title>Servlet EditProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
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
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                ProductDAO productDAO = new ProductDAO();
                ProductDTO product = productDAO.getProductById(id);
                if (product != null) {
                    CategoryDAO categoryDAO = new CategoryDAO();
                    List<CategoryDTO> categoryList = categoryDAO.getAllCategory();
                    System.out.println("Number of categories in controller: " + categoryList.size());
                        
                    request.setAttribute("product", product);
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                    System.out.println("CategoryList attribute set: " + (request.getAttribute("categoryList") != null));
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("managerProduct");
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
        try {
        int id = Integer.parseInt(request.getParameter("id").trim());
        String name = request.getParameter("name").trim();
        String image = request.getParameter("image").trim();
        double price = Double.parseDouble(request.getParameter("price").trim());
        String description = request.getParameter("description").trim();
        int stock = Integer.parseInt(request.getParameter("stock").trim());
        int categoryId = Integer.parseInt(request.getParameter("category").trim());
        float discount = Float.parseFloat(request.getParameter("discount").trim());

        ProductDTO product = new ProductDTO(id, name, categoryId, description, stock, image, discount, price);
        
        ProductDAO productDAO = new ProductDAO();
        productDAO.updateProduct(product);

        response.sendRedirect("managerProduct");
    } catch (NumberFormatException | NullPointerException e) {
        e.printStackTrace();
        request.setAttribute("error", "Invalid input, please check your data and try again.");
        doGet(request, response);
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
