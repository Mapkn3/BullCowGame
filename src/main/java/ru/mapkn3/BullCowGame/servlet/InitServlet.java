package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.dao.PrettyEntityDao;
import ru.mapkn3.BullCowGame.dao.PrettyEntityDaoImpl;
import ru.mapkn3.BullCowGame.service.AccountService;
import ru.mapkn3.BullCowGame.service.AccountServiceImpl;
import ru.mapkn3.BullCowGame.service.StatisticsService;
import ru.mapkn3.BullCowGame.service.StatisticsServiceImpl;
import ru.mapkn3.BullCowGame.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет для начальной настройки базы данных и создания служебных объектов
 *
 * @author Mapkn3
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        PrettyEntityDao prettyEntityDao = new PrettyEntityDaoImpl(hibernateUtil.getSessionFactory());
        AccountService accountService = new AccountServiceImpl(prettyEntityDao);
        StatisticsService statisticsService = new StatisticsServiceImpl(prettyEntityDao);
        HttpSession session = req.getSession();
        session.setAttribute("accountService", accountService);
        session.setAttribute("statisticsService", statisticsService);
        session.setAttribute("correctStart", "yes");
        req.getRequestDispatcher("/signin").forward(req, resp);
    }
}
