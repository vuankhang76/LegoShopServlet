package legoshop.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import legoshop.dao.CategoryDAO;
import legoshop.model.UserDTO;
import legoshop.dao.UserDAO;
import legoshop.model.CategoryDTO;

@WebServlet(name = "UserProfileController", urlPatterns = {"/profile"})
public class UserProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("usersession");
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        session.setAttribute("currentPage", "profile");
        UserDAO userDAO = new UserDAO();
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);

            boolean isUpdated = userDAO.updateUser(user);

            if (isUpdated) {
                session.setAttribute("usersession", user);
                request.setAttribute("user", user);
                request.setAttribute("updateSuccess", true);
            } else {
                request.setAttribute("updateFailed", true);
            }
            request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
        } else {
            UserDTO updatedUser = userDAO.getUserById(user.getId());

            if (updatedUser != null) {
                session.setAttribute("usersession", updatedUser);
                request.setAttribute("user", updatedUser);
                request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "User Profile Controller";
    }
}
