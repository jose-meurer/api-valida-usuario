package com.josemeurer.api.valida.usuario.controller;

import com.josemeurer.api.valida.usuario.model.Hello;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Hello hello = new Hello("Exemplo de um servlet usando javaee");

        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World</h1>");
        out.printf("<p>%s</p>", hello);
        out.println("</body>");
        out.println("</html>");
    }
}
