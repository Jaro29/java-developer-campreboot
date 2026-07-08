package pl.coderslab.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/post2a")
public class Form2 extends HttpServlet {

    private static final List<String> abuses = List.of("(?i)cholera", "(?i)pupa", "(?i)fuk");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String html = "<html lang=\"pl\"><head><meta charset=\"UTF-8\"></head><body>%s</body></html>";
        String text = request.getParameter("textarea");
        boolean censorChecked = request.getParameter("censor") != null;
//        log(String.valueOf(censorChecked));
        PrintWriter writer = response.getWriter();
        if (!censorChecked) {
            for (String abuse : abuses) {
                text = text.replaceAll(abuse, "*".repeat(abuse.length() - 4));
            }
        }
        writer.append(String.format(html, text));
    }
}