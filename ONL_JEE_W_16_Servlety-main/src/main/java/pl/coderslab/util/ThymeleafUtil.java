package pl.coderslab.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

public final class ThymeleafUtil {

    private ThymeleafUtil() {}

    public static TemplateEngine buildTemplateEngine(ServletContext servletContext) {
        var webApplication = JakartaServletWebApplication.buildApplication(servletContext);
        var resolver = new WebApplicationTemplateResolver(webApplication);
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);

        var templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }

    public static IContext buildContext(HttpServletRequest request, HttpServletResponse response) {
        var webApplication = JakartaServletWebApplication.buildApplication(request.getServletContext());
        var exchange = webApplication.buildExchange(request, response);
        return new WebContext(exchange);
    }
}