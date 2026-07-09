package pl.coderslab.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String userAgent = httpRequest.getHeader("User-Agent");
        System.out.println("User-Agent: " + userAgent);

        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long stopTime = System.currentTimeMillis();
        System.out.println("Czas wykonania żądania: " + (stopTime - startTime) + " ms");
    }
}