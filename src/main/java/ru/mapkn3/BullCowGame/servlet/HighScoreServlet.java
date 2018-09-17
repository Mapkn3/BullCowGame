package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.model.Statistics;
import ru.mapkn3.BullCowGame.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет для работы с таблицой рекордов
 *
 * @author Mapkn3
 */
@WebServlet("/highScore")
public class HighScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        StatisticsService statisticsService = (StatisticsService) session.getAttribute("statisticsService");
        List<Statistics> highScore = statisticsService.getAllStatistics();
        req.setAttribute("highScore", highScore);
        req.getRequestDispatcher("pages/highScore.jsp").forward(req, resp);
    }
}
