package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        int time = getIntParameterOrDefault(request,"time",1);
        response.setContentType("text/html; charset=UTF-8");
        if (key == null || key.isBlank() || value == null || value.isBlank() || time == 0) {
            response.getWriter().append("<h3>Wypełnij dane dla ciasteczka</h3>");
        } else {
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(time * 3600);
            cookie.setHttpOnly(true);
            cookie.setSecure(false);
            cookie.setAttribute("SameSite", "Lax");
            response.addCookie(cookie);
            response.getWriter().append("<h3>Ciasteczko " + key + " zostało zapisane bezpiecznie!</h3>");
        }
    }
    private int getIntParameterOrDefault(HttpServletRequest request, String paramName, int defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue; // Jeśli użytkownik wpisał tekst zamiast liczby, bezpiecznie zwracamy domyślną wartość!
        }
    }
}
