package pl.coderslab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import pl.coderslab.util.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/fourth")
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        Cookie cookie = new Cookie("foo", "bar");
        cookie.setMaxAge(24 * 3600);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
        String foo = "foo";
        String bar = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("foo".equals(c.getName())) {
                    bar = c.getValue();
                }
            }
        }

        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);

        ((org.thymeleaf.context.WebContext) context).setVariable("foo", foo);
        ((org.thymeleaf.context.WebContext) context).setVariable("bar", bar);

        // 4. Renderowanie widoku
        templateEngine.process("fourth", context, response.getWriter());
    }
}
