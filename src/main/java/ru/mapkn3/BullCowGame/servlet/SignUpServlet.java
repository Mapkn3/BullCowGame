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
 * Сервлет для обработки регистрации в приложении
 * Наследуется от {@link AuthServlet}
 *
 * @author Mapkn3
 * @see AuthServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends AuthServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        req.getRequestDispatcher("pages/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        AccountService accountService = (AccountService) session.getAttribute("accountService");
        Account authData = getAuthData(req);
        if (accountService.getAccountByName(authData.getNickname()) == null) {
            accountService.addNewAccount(authData);
            resp.sendRedirect(req.getContextPath() + "/signin");
        } else {
            req.getRequestDispatcher("pages/signup.jsp?error=Login%20already%20in%20use").forward(req, resp);
        }
    }
}
