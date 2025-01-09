package com.josemeurer.api.valida.usuario.controller;

import com.josemeurer.api.valida.usuario.repository.imp.UserRepositoryImp;
import com.josemeurer.api.valida.usuario.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/validator")
public class UserController extends HttpServlet {


    private UserService userService = new UserService();

    private UserRepositoryImp userRepositoryImp = new UserRepositoryImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.addUser(req.getParameter("email"));
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("Recurso criado com sucesso.");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userRepositoryImp.createTable();
    }
}
