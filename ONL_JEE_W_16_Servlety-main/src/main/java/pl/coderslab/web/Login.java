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

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final String USER = "admin";
    private static final String PASSWORD = "coderslab";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);

        templateEngine.process("login", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
