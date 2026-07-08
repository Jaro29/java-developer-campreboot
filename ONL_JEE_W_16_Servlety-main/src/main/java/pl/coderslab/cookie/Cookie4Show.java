package pl.coderslab.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.append("<html lang=\"pl\"><head><meta charset=\"UTF-8\">" +
                "<link rel=\"stylesheet\" href=\"style.css\"></head><body><table><tbody>");
        Cookie[] cookies = request.getCookies();

        if (cookies != null) { // KLUCZOWE ZABEZPIECZENIE!
            for (Cookie c : cookies) {
                writer.append("<tr><td>").append(c.getName()).append("</td><td>")
                        .append(c.getValue()).append("</td><td>")
                        .append("<a href=\"removeCookie?cookieName=" + c.getName() +
                                "\">Usuń ciasteczko</a>")
                        .append("</td></tr>");
            }
        }
        writer.append("</tbody></table></body></html>");
    }
}
