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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fifth")
public class FifthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        response.setContentType("text/html; charset=UTF-8");

        List<Book> books = new ArrayList<>();
        books.add(new Book("Potop","Henryk Sienkiewicz","123476-1382745"));
        books.add(new Book("Urwisko","Remigiusz Mróz","123476-134578"));
        books.add(new Book("Lód","Jacek Dukaj","123476-13879045"));
        books.add(new Book("Chłopcy","Jakub Ćwiek","123476-35871246"));

//        books.reversed();

        TemplateEngine templateEngine = ThymeleafUtil.buildTemplateEngine(getServletContext());
        IContext context = ThymeleafUtil.buildContext(request, response);

        ((org.thymeleaf.context.WebContext) context).setVariable("books", books.reversed());

        templateEngine.process("fifth", context, response.getWriter());
    }

    private record Book(String title, String author, String isbn){
    }
}
