package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String userValue = null;

        // 🛡️ ZABEZPIECZENIE: Zawsze sprawdzaj, czy tablica nie jest nullem przed pętlą!
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("ciastko".equals(c.getName())) {
                    userValue = c.getValue();
                    break; // Znaleźliśmy, możemy przerwać pętlę
                }
            }
        }

        if (userValue != null) {
            writer.append("<h3>Wartość ciasteczka 'User': ").append(userValue).append("</h3>");
        } else {
            writer.append("<h3>BRAK ciasteczka o nazwie 'User'</h3>");
        }
    }
}