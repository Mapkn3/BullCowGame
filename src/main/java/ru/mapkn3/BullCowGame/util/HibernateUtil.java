package ru.mapkn3.BullCowGame.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Класс для работы с Hibernate
 *
 * @author Mapkn3
 */
public class HibernateUtil {
    private final SessionFactory sessionFactory;

    /**
     * Конструктор по умолчанию
     * Настраивает соединение с базой данных по файлу {@code hibernate.cfg.xml} и создает фабрику сессий типа {@link SessionFactory}
     *
     * @author Mapkn3
     * @see SessionFactory
     */
    public HibernateUtil() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Получение текущей фабрики сессий
     *
     * @return объект фабрики сессий типа {@link SessionFactory}
     * @author Mapkn3
     * @see SessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Открытие новой сессиии для работы с базой данных
     *
     * @return объект сессии типа {@link Session}
     * @author Mapkn3
     * @see Session
     */
    public Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
