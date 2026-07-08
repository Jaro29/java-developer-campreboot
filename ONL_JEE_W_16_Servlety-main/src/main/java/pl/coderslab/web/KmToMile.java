package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import pl.coderslab.util.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/km-to-mile")
public class KmToMile extends HttpServlet {

    private static final double KM_TO_MILE_RATIO = 0.62;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        // 1. Pobranie i bezpieczne sparsowanie parametru km
        String kmParam = request.getParameter("km");
        Double miles = null;
        String kmDisplay = "brak danych";

        if (kmParam != null && !kmParam.isBlank()) {
            try {
                double km = Double.parseDouble(kmParam);
                miles = km * KM_TO_MILE_RATIO;
                kmDisplay = kmParam;
            } catch (NumberFormatException e) {
                // kmParam nie był liczbą - miles zostaje null, obsłużymy to w widoku
            }
        }

        // 2. Budowa silnika Thymeleaf i kontekstu (namiastka "modelu" z MVC)
        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);

        // 3. Przekazanie danych do widoku (odpowiednik request.setAttribute z JSP)
        ((org.thymeleaf.context.WebContext) context).setVariable("km", kmDisplay);
        ((org.thymeleaf.context.WebContext) context).setVariable("miles", miles);

        // 4. Renderowanie widoku
        templateEngine.process("first", context, response.getWriter());
    }
}