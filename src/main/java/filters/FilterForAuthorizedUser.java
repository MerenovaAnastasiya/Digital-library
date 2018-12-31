package filters;

import services.BookService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/signIn","/signUp"})
public class FilterForAuthorizedUser implements Filter {

        private UserService userService;
//    private BookService bookService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        userService = (UserService) context.getAttribute("userService");
//        userService = (UserService) context.getAttribute("userService");
//        bookService = (BookService) context.getAttribute("bookService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (!session.isNew()) {
            Boolean auth = (Boolean) session.getAttribute("authorized");
            if (auth == null || auth!= true) {
//                filterChain.doFilter(request, response);

            }
            else {
                response.sendRedirect("profile");
                return;
            }
        }
        else {
            System.out.println("сессия новая");
            String cookieValue = "";
            String cookieLoginValue = "";
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for(Cookie cookie: cookies) {
                    if(cookie.getName().equals("secret")) {
                        cookieValue = cookie.getValue();
                    }
                    if(cookie.getName().equals("login")){
                        cookieLoginValue = cookie.getValue();
                    }
                }
            }
            if(userService.getUUID(cookieLoginValue)!= null) {
                if(!cookieValue.equals(userService.getUUID(cookieLoginValue))) {
                    response.sendRedirect("profile");
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
