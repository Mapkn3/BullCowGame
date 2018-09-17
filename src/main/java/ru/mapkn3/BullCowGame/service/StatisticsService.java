package ru.mapkn3.BullCowGame.service;

import ru.mapkn3.BullCowGame.model.Account;
import ru.mapkn3.BullCowGame.model.Statistics;

import java.util.List;

/**
 * Интерфейс для работы с хранилищем статистик типа {@link Statistics}
 *
 * @author Mapkn3
 * @see Statistics
 */
public interface StatisticsService {
    /**
     * Получение статистики из хранилища статистик по id типа {@link Long}
     *
     * @return статистика из хранилища статистик типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    Statistics getStatistics(Long id);

    /**
     * Добавление статистики в хранилище статистик типа {@link Statistics}
     *
     * @param statistics - статистика, добавляемая к хранилищу статистик
     * @return id добавленного аккаунта в хранилище аккаунтов
     * @author Mapkn3
     * @see Statistics
     */
    Long addNewStatistics(Statistics statistics);

    /**
     * Получение списка статистик из хранилища статистик типа {@link Statistics}
     *
     * @return список статистик типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    List<Statistics> getAllStatistics();

    /**
     * Обновление статистики в хранилище статистик типа {@link Statistics}
     *
     * @param statistics - статистика, обновляемая в хранилище статистик
     * @return обновленная статистика типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    Statistics updateStatistics(Statistics statistics);

    /**
     * Удаление статистики из хранилища статистик типа {@link Statistics}
     *
     * @param statistics - аккаунт, удаляемый из хранилища аккаунтов
     * @author Mapkn3
     * @see Statistics
     */
    void deleteStatistics(Statistics statistics);

    /**
     * Получение статистики из хранилища статистик по аккаунту типа {@link Account}
     *
     * @param account - аккаунт типа {@link Account}, для которого нужна статистика
     * @return статистика для данного аккаунта типа {@link Statistics}
     * @author Mapkn3
     * @see Account
     * @see Statistics
     */
    Statistics getStatisticsByAccount(Account account);
}
