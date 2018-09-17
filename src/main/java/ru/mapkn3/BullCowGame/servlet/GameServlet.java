package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.util.BullCowGame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервлет для функционирования игры
 *
 * @author Mapkn3
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private BullCowGame game;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        game = new BullCowGame();
        List score = new ArrayList();
        req.getSession().setAttribute("score", score);
        req.getRequestDispatcher("pages/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("correctStart") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        String number = req.getParameter("number");
        String result = game.compareNumber(number);
        List score = (List) req.getSession().getAttribute("score");
        score.add(new Attempt(number, result));
        if (result.equals("4Б0К")) {
            req.getSession().setAttribute("secretNumber", game.getSecretNumber());
            resp.sendRedirect(req.getContextPath() + "/congratulation");
        } else {
            req.getRequestDispatcher("pages/game.jsp").forward(req, resp);
        }
    }

    /**
     * Класс для хранения информации о попытке пользователя
     *
     * @author Mapkn3
     */
    public class Attempt {
        private String number;
        private String result;

        public Attempt(String number, String result) {
            this.number = number;
            this.result = result;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
