package ru.mapkn3.BullCowGame.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для главной страницы игры
 *
 * @author Mapkn3
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        req.getRequestDispatcher("/pages/homepage.jsp").forward(req, resp);
    }
}
