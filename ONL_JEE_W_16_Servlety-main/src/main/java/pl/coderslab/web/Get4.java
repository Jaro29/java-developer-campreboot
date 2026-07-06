package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get4")
public class Get4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        String company = request.getParameter("company");
        String[] learns = request.getParameterValues("learn");

        // 1. ZABEZPIECZENIE DLA SINGLE STRING (company)
        // Jeśli parametr jest nullem, używamy bezpiecznego tekstu domyślnego
        String companyDisplay = (company != null) ? company : "Brak danych o firmie";

        writer.append("<h3>company:</h3>");
        // Zamienia zwykły <ul> z kropkami na <ul> z myślnikami:
        writer.append("<ul style=\"list-style-type: '- ';\">");
        writer.append("<li>").append("<h3>").append(companyDisplay).append("</h3>").append("</li>").append("</ul>");
        writer.append("<h3>learn:</h3>");

        // 2. ZABEZPIECZENIE DLA TABLICY (learns) - KLUCZOWE!
        // Sprawdzamy, czy tablica w ogóle istnieje (nie jest nullem) oraz czy ma jakieś elementy
        if (learns != null && learns.length > 0) {
            // writer.append("<ul>");
            // Zamiast zwykłego <ul> wklej to:
            writer.append("<ul style=\"list-style-type: '- ';\">");
            for (String learn : learns) {
                writer.append("<li>").append("<h3>").append(learn).append("</h3>").append("</li>");
            }
            writer.append("</ul>");
        } else {
            // Jeśli użytkownik nie przysłał żadnych technologii
            writer.append("<p>Brak wybranych technologii do nauki.</p>");
        }
    }
}
