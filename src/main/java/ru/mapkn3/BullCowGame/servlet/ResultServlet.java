package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.model.Account;
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
 * Сервлет для подсчёта результатов игры
 *
 * @author Mapkn3
 */
@WebServlet("/congratulation")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        Account user = (Account) session.getAttribute("user");
        List<GameServlet.Attempt> score = (List<GameServlet.Attempt>) session.getAttribute("score");
        double attempts = score.size();
        StatisticsService statisticsService = (StatisticsService) session.getAttribute("statisticsService");
        Statistics statistics = statisticsService.getStatisticsByAccount(user);
        if (statistics == null) {
            statistics = new Statistics();
            statistics.addAttempt(attempts);
            statistics.setAccount(user);
            statisticsService.addNewStatistics(statistics);
        } else {
            statistics.addAttempt(attempts);
            statisticsService.updateStatistics(statistics);
        }
        session.setAttribute("attempts", (int) attempts);
        req.getRequestDispatcher("pages/result.jsp").forward(req, resp);
    }
}