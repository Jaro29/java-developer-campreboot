package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        String cookieName = request.getParameter("cookieName");

        Cookie[] cookies = request.getCookies();
        if (cookieName != null && !cookieName.isBlank() && cookies != null) {
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    // Ustawiamy czas życia na 0 i odsyłamy (przeglądarka je usunie)
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
            }
        }
        response.sendRedirect("showAllCookies");
    }
}