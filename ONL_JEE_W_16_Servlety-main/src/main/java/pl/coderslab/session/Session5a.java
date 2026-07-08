package pl.coderslab.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.regex.Pattern;

@WebServlet("/session5a")
public class Session5a extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Session5a.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        // 1. Losujemy liczby i zapisujemy sumę w sesji
        Random random = new Random();
        int num1 = random.nextInt(101);
        int num2 = random.nextInt(101);

        HttpSession session = request.getSession();
        session.setAttribute("captcha", num1 + num2); // Suma trafia do sesji

        // 2. Pobieramy fizyczną ścieżkę do Twojego pliku session5.html na dysku
        String htmlPath = getServletContext().getRealPath("/session5.html");

        try {
            // 3. Wczytujemy całą zawartość Twojego pliku HTML jako jeden String
            String htmlContent = Files.readString(Path.of(htmlPath));

            // 4. Podmieniamy nasze znaczniki {{num1}} i {{num2}} na wylosowane liczby!
            htmlContent = htmlContent.replace("{{num1}}", String.valueOf(num1))
                    .replace("{{num2}}", String.valueOf(num2));

            // 5. Wysyłamy zmodyfikowany HTML do przeglądarki
            writer.print(htmlContent);

        } catch (IOException e) {
            writer.print("<h3>Błąd wewnętrzny: Nie można załadować szablonu HTML.</h3>");
            logger.error("Nie udało się wczytać pliku HTML: {}", htmlPath, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("name");
        String userSurname = request.getParameter("surName");
        String email = request.getParameter("email");

        PrintWriter writer = response.getWriter();

        if (userName == null || userName.isBlank() || userSurname == null ||
                userSurname.isBlank() || email == null || email.isBlank()) {
            sendError(writer,"<h3 style='color: red;'>Błąd: Wszystkie pola muszą być wypełnione!</h3>");
            return;
        }

        if (!verifyEmail(email.trim().toLowerCase())) {
            sendError(writer,"Wpisałeś niepoprawny email. Spróbuj jeszcze raz");
            return;
        }

        HttpSession session = request.getSession();
        Integer captchaCheck = (Integer) session.getAttribute("captcha");
        if (captchaCheck == null) {
            sendError(writer,"Sesja wygasła. Spróbuj załadować formularz ponownie.");
            return;
        }
        session.removeAttribute("captcha");

        int captcha;
        String captchaParam = request.getParameter("captcha");

        if (captchaParam == null || captchaParam.isBlank()) {
            sendError(writer,"Nie wpisałeś wyniku - spróbuj jeszcze raz.");
            return;
        }

        try {
            captcha = Integer.parseInt(captchaParam.trim());
        } catch (NumberFormatException e) {
            sendError(writer,"Nie wpisałeś poprawnego wyniku liczbowego - spróbuj jeszcze raz.");
            return;
        }

        if (captcha != captchaCheck) {
            sendError(writer,"Nie wpisałeś poprawnego wyniku liczbowego - spróbuj jeszcze raz.");
            return;
        }
        writer.println("Gratulacje! Dane są poprawne.");
        writer.println("Witaj człowieku!");
        writer.println(String.format("%s %s, %s", userName, userSurname, email));
    }

    private static void sendError(PrintWriter writer, String message) throws IOException {
        writer.println(message);
        writer.println("<a href=\"session5a\" >Powrót do formularza</a>");
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@" +
                    "[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,})");

    public static boolean verifyEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
