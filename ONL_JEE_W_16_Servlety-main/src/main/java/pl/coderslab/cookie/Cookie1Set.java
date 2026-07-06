package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class Cookie1Set extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Tworzymy ciasteczko "User" o wartości "CodersLab"
        Cookie cookie = new Cookie("User", "CodersLab");

        // Ważność ciasteczka: 24 godziny (24 * 3600 sekund = 86400 sekund)
        cookie.setMaxAge(24 * 3600);

        // 🛡️ NOWOCZESNE BEZPIECZEŃSTWO (2026):
        // 1. Blokujemy dostęp do ciasteczka skryptom JS (ochrona przed kradzieżą XSS)
        cookie.setHttpOnly(true);

        // 2. Na localhost ustawiamy false, jeśli nie masz skonfigurowanego HTTPS.
        // W produkcji OBOWIĄZKOWO ustawiasz tu true!
        cookie.setSecure(false);

        // 3. SameSite: Zapobiega wysyłaniu ciasteczka przy zewnętrznych przekierowaniach (ochrona przed CSRF)
        cookie.setAttribute("SameSite", "Lax");

        // Dodajemy ciasteczko do odpowiedzi
        response.addCookie(cookie);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<h3>Ciasteczko 'User' zostało zapisane bezpiecznie!</h3>");
    }
}