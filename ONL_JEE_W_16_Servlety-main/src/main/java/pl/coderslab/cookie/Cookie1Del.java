package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        Cookie[] cookies = request.getCookies();
        boolean foundAndDeleted = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("User".equals(c.getName())) {
                    // Ustawiamy czas życia na 0 i odsyłamy (przeglądarka je usunie)
                    c.setMaxAge(0);
                    response.addCookie(c);
                    foundAndDeleted = true;
                    break;
                }
            }
        }

        if (foundAndDeleted) {
            writer.append("<h3>Ciasteczko 'User' zostało pomyślnie usunięte!</h3>");
        } else {
            writer.append("<h3>BRAK</h3>");
        }
    }
}