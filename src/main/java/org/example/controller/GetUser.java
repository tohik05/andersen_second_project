package org.example.controller;

import org.example.exception.EntityNotFoundException;
import org.example.service.UserDtoFull;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class GetUser extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("id");
        if (param == null) {
            List<UserDtoFull> users = userService.getAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/pages/getAllUsers.jsp").forward(request, response);
        } else {
            Long id = Long.parseLong(param);
            try {
                UserDtoFull user = userService.getById(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/pages/getUser.jsp").forward(request, response);
            } catch (EntityNotFoundException ex) {
                request.setAttribute("userId", id);
                request.getRequestDispatcher("/WEB-INF/pages/notFound.jsp").forward(request, response);
            }
        }
    }

}
