package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get3")
public class Get3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

//        int width = (request.getParameter("width") != null) ?
//                Integer.parseInt(request.getParameter("width")) : 5;
//        int height = (request.getParameter("height") != null) ?
//                Integer.parseInt(request.getParameter("height")) : 10;
        int width = getIntParameterOrDefault(request, "width", 5);
        int height = getIntParameterOrDefault(request, "height", 10);
        writer.append("<table>");
        for (int i = 1; i <= height; i++) {
            writer.append("<tr>"); // Otwieramy wiersz
            for (int j = 1; j <= width; j++) {
                // Poprawnie zamykamy komórkę za pomocą </td>
                writer.append("<td>").append(String.valueOf(i * j)).append("</td>");
            }
            writer.append("</tr>"); // Zamykamy wiersz przed przejściem do następnego!
        }
        writer.append("</table>");
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
