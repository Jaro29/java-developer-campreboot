package pl.coderslab.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post1")
public class Form1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");

        // LAYER 1: Walidacja (Sprawdzamy, czy dane nie są nullem lub samymi spacjami)
        if (userName == null || userName.isBlank() || userSurname == null || userSurname.isBlank()) {
            writer.append("<h3 style='color: red;'>Błąd: Wszystkie pola muszą być wypełnione!</h3>");
            return; // Wczesny powrót z metody (nie idziemy dalej)
        }

        // LAYER 2: Ochrona przed XSS (HTML Escaping)
        // Oczyszczamy wpisy za pomocą naszej metody pomocniczej
        String safeName = escapeHtml(userName);
        String safeSurname = escapeHtml(userSurname);

        writer.append("<h3>Witaj, ").append(safeName).append(" ").append(safeSurname).append("</h3>");
    }

    /**
     * Prosty i niezwykle wydajny helper chroniący przed atakami XSS.
     * Zamienia znaki HTML na ich bezpieczne encje tekstowe.
     */
    private String escapeHtml(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}