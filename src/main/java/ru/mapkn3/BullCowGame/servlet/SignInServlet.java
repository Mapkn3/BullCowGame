package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.model.Account;
import ru.mapkn3.BullCowGame.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет для обработки входа в приложение
 * Наследуется от {@link AuthServlet}
 *
 * @author Mapkn3
 * @see AuthServlet
 */
@WebServlet("/signin")
public class SignInServlet extends AuthServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        req.getRequestDispatcher("pages/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        Account authData = getAuthData(req);
        Account account = ((AccountService) session.getAttribute("accountService")).getAccountByName(authData.getNickname());
        if (account != null && account.getPassword().equals(authData.getPassword())) {
            session.setAttribute("user", account);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.getRequestDispatcher("pages/signin.jsp?error=Incorrect%20login/password").forward(req, resp);
        }
    }
}
