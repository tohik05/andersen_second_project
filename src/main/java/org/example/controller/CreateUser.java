package org.example.controller;

import org.example.service.UserDtoCreate;
import org.example.service.UserDtoFull;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/create")
public class CreateUser extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/createUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDtoFull userDtoFull = userService.create(getUserDtoCreate(request));
        request.setAttribute("user", userDtoFull);
        request.getRequestDispatcher("/WEB-INF/pages/getUser.jsp").forward(request, response);
    }

    private UserDtoCreate getUserDtoCreate(HttpServletRequest request) {
        return new UserDtoCreate(
                request.getParameter("name"),
                request.getParameter("lastname"),
                Integer.parseInt(request.getParameter("age"))
        );
    }
}
