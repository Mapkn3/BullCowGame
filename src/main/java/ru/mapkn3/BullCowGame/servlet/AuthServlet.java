package ru.mapkn3.BullCowGame.servlet;

import ru.mapkn3.BullCowGame.model.Account;

import javax.activation.URLDataSource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Сервлет для работы с данными аутентофикации
 *
 * @author Mapkn3
 */
public class AuthServlet extends HttpServlet {
    /**
     * Получение объекта аккаунта типа {@link Account} из объекта запроса
     *
     * @author Mapkn3
     */
    public Account getAuthData(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        String nickname = new String(req.getParameter("nickname").getBytes(), StandardCharsets.UTF_8);
        String password = getHashPassword(req.getParameter("password"));
        return new Account(nickname, password);
    }

    /**
     * Вычисление хеша пароля с помощью SHA-256
     *
     * @author Mapkn3
     */
    public String getHashPassword(String password) {
        String hashPassword = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            hashPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashPassword;
    }
}
