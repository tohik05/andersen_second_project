package org.example.controller;

import org.example.service.UserDtoFull;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/update")
public class UpdateUser extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        UserDtoFull user = userService.getById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDtoFull userDtoFull = userService.update(getUserDtoUpdate(request));
        request.setAttribute("user", userDtoFull);
        request.getRequestDispatcher("/WEB-INF/pages/updatedRedirect.jsp").forward(request, response);

    }

    private UserDtoFull getUserDtoUpdate(HttpServletRequest request) {
        return new UserDtoFull(
                Long.parseLong(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("lastname"),
                Integer.parseInt(request.getParameter("age"))
        );
    }
}
