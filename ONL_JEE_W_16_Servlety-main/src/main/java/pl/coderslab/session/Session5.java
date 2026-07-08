package pl.coderslab.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * Servlet prezentujący formularz kontaktowy zabezpieczony prostą captchą matematyczną.
 * Captcha jest generowana przy każdym GET i jednorazowa (usuwana z sesji po pierwszej próbie POST).
 */
@WebServlet("/session5")
public class Session5 extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Session5.class);

    private static final String CONTENT_TYPE_HTML_UTF8 = "text/html; charset=UTF-8";
    private static final String SESSION_ATTR_CAPTCHA = "captcha";
    private static final String TEMPLATE_FILE_NAME = "/session5.html";
    private static final int CAPTCHA_MAX_OPERAND = 100;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@" +
                    "[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,})");

    // SecureRandom zamiast Random - captcha to mechanizm bezpieczeństwa, więc lepiej
    // od razu przyzwyczajać się do generatora odpornego na przewidywanie wyników.
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(CONTENT_TYPE_HTML_UTF8);

        int firstOperand = RANDOM.nextInt(CAPTCHA_MAX_OPERAND + 1);
        int secondOperand = RANDOM.nextInt(CAPTCHA_MAX_OPERAND + 1);

        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ATTR_CAPTCHA, firstOperand + secondOperand);

        renderFormTemplate(response, firstOperand, secondOperand);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(CONTENT_TYPE_HTML_UTF8);
        PrintWriter writer = response.getWriter();

        ContactFormData formData = ContactFormData.fromRequest(request);

        if (!formData.isComplete()) {
            sendError(writer, "Błąd: wszystkie pola muszą być wypełnione!");
            return;
        }

        if (!isEmailValid(formData.email())) {
            sendError(writer, "Wpisałeś niepoprawny adres email. Spróbuj jeszcze raz.");
            return;
        }

        CaptchaValidationResult captchaResult = validateCaptcha(request);
        if (!captchaResult.isValid()) {
            sendError(writer, captchaResult.errorMessage());
            return;
        }

        renderSuccess(writer, formData);
    }

    /**
     * Wczytuje szablon HTML z dysku i podmienia w nim placeholdery na wylosowane liczby.
     * Błąd odczytu pliku jest logowany ze stack trace'em, żeby dało się namierzyć przyczynę
     * (np. zły deployment, brak pliku), zamiast tracić tę informację przy printStackTrace.
     */
    private void renderFormTemplate(HttpServletResponse response, int firstOperand, int secondOperand)
            throws IOException {

        String templatePath = getServletContext().getRealPath(TEMPLATE_FILE_NAME);
        PrintWriter writer = response.getWriter();

        try {
            String htmlContent = Files.readString(Path.of(templatePath))
                    .replace("{{num1}}", String.valueOf(firstOperand))
                    .replace("{{num2}}", String.valueOf(secondOperand));

            writer.print(htmlContent);
        } catch (IOException e) {
            writer.print("<h3>Błąd wewnętrzny: nie można załadować formularza.</h3>");
            logger.error("Nie udało się wczytać szablonu HTML: {}", templatePath, e);
        }
    }

    /**
     * Waliduje captchę z sesji przeciwko wartości podanej przez użytkownika.
     * Atrybut sesji jest usuwany od razu po odczycie, niezależnie od wyniku porównania
     * - captcha jest jednorazowa, więc nie może "przeżyć" żadnej próby POST.
     */
    private CaptchaValidationResult validateCaptcha(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer expectedSum = (Integer) session.getAttribute(SESSION_ATTR_CAPTCHA);
        session.removeAttribute(SESSION_ATTR_CAPTCHA);

        if (expectedSum == null) {
            return CaptchaValidationResult.invalid("Sesja wygasła. Odśwież formularz i spróbuj ponownie.");
        }

        String submittedValue = request.getParameter(SESSION_ATTR_CAPTCHA);
        if (submittedValue == null || submittedValue.isBlank()) {
            return CaptchaValidationResult.invalid("Nie wpisałeś wyniku działania. Spróbuj jeszcze raz.");
        }

        int submittedSum;
        try {
            submittedSum = Integer.parseInt(submittedValue.trim());
        } catch (NumberFormatException e) {
            return CaptchaValidationResult.invalid("Wynik musi być liczbą całkowitą. Spróbuj jeszcze raz.");
        }

        if (submittedSum != expectedSum) {
            return CaptchaValidationResult.invalid("Niepoprawny wynik działania. Spróbuj jeszcze raz.");
        }

        return CaptchaValidationResult.valid();
    }

    private void renderSuccess(PrintWriter writer, ContactFormData formData) {
        writer.println("Gratulacje! Dane są poprawne.");
        writer.println("Witaj, " + formData.name() + "!");
        writer.println(String.format("%s %s, %s", formData.name(), formData.surname(), formData.email()));
    }

    private void sendError(PrintWriter writer, String message) {
        writer.println(message);
        writer.println("<a href=\"session5\">Powrót do formularza</a>");
    }

    public static boolean isEmailValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email.trim().toLowerCase()).matches();
    }

    /**
     * Niemodyfikowalny zestaw danych z formularza kontaktowego.
     * Rekord zamiast osobnych zmiennych - grupuje powiązane dane i eliminuje
     * przekazywanie trzech osobnych Stringów między metodami.
     */
    private record ContactFormData(String name, String surname, String email) {

        static ContactFormData fromRequest(HttpServletRequest request) {
            return new ContactFormData(
                    request.getParameter("name"),
                    request.getParameter("surName"),
                    request.getParameter("email")
            );
        }

        boolean isComplete() {
            return isNotBlank(name) && isNotBlank(surname) && isNotBlank(email);
        }

        private static boolean isNotBlank(String value) {
            return value != null && !value.isBlank();
        }
    }

    /**
     * Wynik walidacji captchy - albo sukces, albo porażka z konkretnym komunikatem dla użytkownika.
     * Zastępuje wzorzec "return po sendError" rozproszony po całej metodzie doPost.
     */
    private record CaptchaValidationResult(boolean isValid, String errorMessage) {

        static CaptchaValidationResult valid() {
            return new CaptchaValidationResult(true, null);
        }

        static CaptchaValidationResult invalid(String errorMessage) {
            return new CaptchaValidationResult(false, errorMessage);
        }
    }
}