package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import pl.coderslab.util.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/admin")
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);
        ((WebContext) context).setVariable("username", username);
        templateEngine.process("admin", context, response.getWriter());
    }
}