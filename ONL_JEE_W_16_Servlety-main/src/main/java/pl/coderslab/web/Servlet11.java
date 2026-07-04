package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet11") // Mapowanie adresu URL
public class Servlet11 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Hello First Servlet"); // Wypisze się w konsoli IntelliJ

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("<h1>Content11</h1>"); // Wypisze się w przeglądarce
    }
}
