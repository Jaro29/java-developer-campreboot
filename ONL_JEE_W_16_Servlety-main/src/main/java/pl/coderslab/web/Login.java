package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USER.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error=true");
        }
    }
}
