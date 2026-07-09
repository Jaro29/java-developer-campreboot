package pl.coderslab.web.filter;

import jakarta.servlet.*;
        import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    private static final String ENCODING = "UTF-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        response.setContentType("text/html; charset=" + ENCODING);

        chain.doFilter(request, response); // przekazanie dalej - do servletu albo następnego filtra
    }
}
