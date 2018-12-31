package servlets;
import forms.SignInForm;
import models.Basket;
import models.User;
import services.BasketService;
import services.UserService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService;
    private BasketService basketService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
        basketService = (BasketService) context.getAttribute("basketService");
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        try {
            request.getServletContext().getRequestDispatcher("/WEB-INF/ftl/pages/signIn.ftl").forward(request, response);
        } catch (ServletException e) {
            throw new IllegalArgumentException("Не удаетcя получить signIn.jsp");
        } catch (IOException e) {
            throw new IllegalArgumentException("НЕ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        String email = request.getParameter("email");
        String checkbox = request.getParameter("checkbox");
        System.out.println(checkbox);
        String password = request.getParameter("password");
        SignInForm signInForm = SignInForm.builder()
                .email(email)
                .password(password)
                .build();
        try {
            if(userService.signIn(signInForm)) {
                String login = userService.getUserByEmail(email).getLogin();
                if(checkbox!= null) {
                    Cookie loginCookie = new Cookie("login", login);
                    String secret = userService.getUUID(login);
                    Cookie secretCookie = new Cookie("secret", secret);
                    response.addCookie(loginCookie);
                    response.addCookie(secretCookie);
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("authorized", true);
                User user = userService.getUserByEmail(email);
                session.setAttribute("user", user);
                Long basketId = user.getBasket().getId();
                Basket basket = basketService.getBasketById(basketId);
                if (basket.getBooks().size() == 1 && basket.getBooks().get(0).getBookName() == null) {
                    basket.getBooks().clear();
                }
                session.setAttribute("basket", basket);
                response.sendRedirect("/profile");
                return;
            }
            else {
                request.setAttribute("checkSignIn", false);
                request.setAttribute("email", email);
                request.getServletContext().getRequestDispatcher("/WEB-INF/frl/pages/signIn.ftl").forward(request, response);

            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Не удается войти");
        }


    }

}
