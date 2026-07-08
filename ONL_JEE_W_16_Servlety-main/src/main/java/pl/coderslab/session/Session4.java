package pl.coderslab.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pl.coderslab.model.CartItem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
@SuppressWarnings("unchecked")
public class Session4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        List<CartItem> cart = new ArrayList<>();
        if (session.getAttribute("cart") != null) {
            cart = (List<CartItem>) session.getAttribute("cart");
        }
        writer.append("<html lang=\"pl\"><head><meta charset=\"UTF-8\">" +
                "<link rel=\"stylesheet\" href=\"style.css\"></head><body><table><tbody>");
        double cartTotal = 0;

        String html = "<tr><td>%s</td><td>%d × %.2f zł</td><td>=</td><td>%.2f zł</td></tr>";
        for (CartItem item : cart) {
            writer.append(String.format(html, item.getName(), item.getQuantity(),
                    item.getPrice(), item.getQuantity() * item.getPrice()));
            cartTotal += item.getQuantity() * item.getPrice();
        }
        writer.append(String.format("<tr><td colspan=\"3\" >SUMA:</td><td >%.2f zł</td></tr>", cartTotal));

        writer.append("</tbody></table><a href=\"session4.html\" >Powrót do formularza</a></body></html>");
    }
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quantityParam = request.getParameter("quantity");
        String priceParam = request.getParameter("price");
        String nameParam = request.getParameter("name");
        CartItem cartItem;
        double price;
        int quantity;
        if (!checkParameter(request, "quantity") || !checkParameter(request, "price") || !checkParameter(request, "name")) {
            sendError(response, "Błąd: Wszystkie pola muszą być uzupełnione.");
            return; // Wczesne wyjście z metody!
        }
        try {
            quantity = Integer.parseInt(quantityParam);
        } catch (NumberFormatException e) {
            sendError(response, "Błąd: niepoprawna wartość liczbowa.");
            return;
        }
        try {
            price = Double.parseDouble(priceParam.replace(',', '.'));
        } catch (NumberFormatException e) {
            sendError(response, "Niepoprawna wartość ceny.");
            return;
        }
        if (quantity <= 0 || price <= 0) {
            sendError(response, "Cena i ilość nie mogą być mniejsze lub równe 0");
            return;
        }
        cartItem = new CartItem(nameParam, quantity, price);

        HttpSession session = request.getSession();

        List<CartItem> cart = ((List<CartItem>) session.getAttribute("cart"));
        if (cart == null) {
            cart = new ArrayList<>(); // Inicjalizujemy pustą listę tylko, jeśli jeszcze nie istnieje
        }
        cart.add(cartItem);
        session.setAttribute("cart", cart);
        response.sendRedirect("session4");
    }

    private static void sendError(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(message);
        response.getWriter().println("<a href=\"session4.html\" >Powrót do formularza</a>");
    }

    private boolean checkParameter(HttpServletRequest request, String param) {
        return request.getParameter(param) != null && !request.getParameter(param).isBlank();
    }
}
