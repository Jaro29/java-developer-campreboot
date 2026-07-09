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

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");

        // 2. Budowa silnika Thymeleaf i kontekstu (namiastka "modelu" z MVC)
        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);

        // 3. Przekazanie danych do widoku (odpowiednik request.setAttribute z JSP)
        ((org.thymeleaf.context.WebContext) context).setVariable("paramA", aParam);
        ((org.thymeleaf.context.WebContext) context).setVariable("paramB", bParam);

        // 4. Renderowanie widoku
        templateEngine.process("third", context, response.getWriter());

    }
}
