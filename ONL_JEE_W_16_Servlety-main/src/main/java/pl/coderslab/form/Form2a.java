package pl.coderslab.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@WebServlet("/post2")
public class Form2a extends HttpServlet {

    // 1. Czysta lista wulgaryzmów bez technicznych przedrostków:
    private static final List<String> abuses = List.of("cholera", "pupa", "fuk");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String html = "<html><head><meta charset=\"UTF-8\"></head><body>%s</body></html>";
        String text = request.getParameter("textarea");
        boolean censorChecked = request.getParameter("censor") != null;
        log(String.valueOf(censorChecked));
        PrintWriter writer = response.getWriter();

        if (!censorChecked && text != null) { // Dodany null-check!
            for (String abuse : abuses) {
                // Kompilujemy wzorzec z flagą ignorowania wielkości liter
                Pattern pattern = Pattern.compile(abuse, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(text);

                // NOWOCZESNA JAVA: Zastępujemy każde dopasowanie gwiazdkami o jego DOKŁADNEJ długości!
                text = matcher.replaceAll(matchResult -> "*".repeat(matchResult.group().length()));
            }
        }
        writer.append(String.format(html, text));
    }
}
