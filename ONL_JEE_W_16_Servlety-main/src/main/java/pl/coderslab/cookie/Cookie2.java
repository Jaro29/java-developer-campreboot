package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 3600);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<h3>Ciasteczko " + key + "zostało zapisane bezpiecznie!</h3>");
    }
}
