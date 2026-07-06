package pl.coderslab.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getForm3")
public class Form3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String html = "<html><head><meta charset=\"UTF-8\"></head><body>%s</body></html>";
        List<Integer> totalDividers = new ArrayList<>();
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isBlank()) { // isBlank() chroni przed pustym tekstem i samymi spacjami
            int number = Math.abs(Integer.parseInt(request.getParameter("page")));
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    totalDividers.add(i);
                }
            }
        }
        response.getWriter().append(String.format(html, totalDividers));
    }
}
