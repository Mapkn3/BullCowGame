package ru.mapkn3.BullCowGame.service;

import org.apache.log4j.Logger;
import ru.mapkn3.BullCowGame.dao.PrettyEntityDao;
import ru.mapkn3.BullCowGame.model.Account;
import ru.mapkn3.BullCowGame.model.Statistics;

import java.util.List;

/**
 * Интерфейс для работы с базой данных статистик типа {@link Statistics}
 *
 * @author Mapkn3
 * @see Statistics
 */
public class StatisticsServiceImpl implements StatisticsService {
    private final static Logger logger = Logger.getLogger(StatisticsServiceImpl.class);

    private PrettyEntityDao statisticsDao;

    /**
     * Конструктор с параметрами
     *
     * @param statisticsDao - объект для работы с базой данных типа {@link PrettyEntityDao}
     * @author Mapkn3
     * @see PrettyEntityDao
     */
    public StatisticsServiceImpl(PrettyEntityDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }

    /**
     * Получение статистики из базы данных статистик по id типа {@link Long}
     *
     * @return статистика из базы данных статистик типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    @Override
    public Statistics getStatistics(Long id) {
        logger.debug("Getting statistics with id = " + id);
        return statisticsDao.findById(Statistics.class, id);
    }

    /**
     * Добавление статистики в базу данных статистик типа {@link Statistics}
     *
     * @param statistics - статистика, добавляемая к базе данных статистик
     * @return id добавленного аккаунта в базу данных аккаунтов
     * @author Mapkn3
     * @see Statistics
     */
    @Override
    public Long addNewStatistics(Statistics statistics) {
        Long id = (Long) statisticsDao.save(statistics);
        logger.debug("Id of new statistics: " + id);
        return id;
    }

    /**
     * Получение списка статистик из базы данных статистик типа {@link Statistics}
     *
     * @return список статистик типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    @Override
    public List<Statistics> getAllStatistics() {
        List<Statistics> statistics = statisticsDao.getAll(Statistics.class);
        logger.debug("Get " + statistics.size() + " statistics:");
        for (Statistics statistic : statistics) {
            logger.debug(statistic.toString());
        }
        return statistics;
    }

    /**
     * Обновление статистики в базе данных статистик типа {@link Statistics}
     *
     * @param statistics - статистика, обновляемая в базе данных статистик
     * @return обновленная статистика типа {@link Statistics}
     * @author Mapkn3
     * @see Statistics
     */
    @Override
    public Statistics updateStatistics(Statistics statistics) {
        Statistics oldStatistics = statisticsDao.findById(Statistics.class, statistics.primaryKey());
        Statistics newStatistics = statisticsDao.update(statistics);
        logger.debug("Old statistics: " + oldStatistics.toString());
        logger.debug("New statistics: " + newStatistics.toString());
        return newStatistics;
    }

    /**
     * Удаление статистики из базы данных статистик типа {@link Statistics}
     *
     * @param statistics - аккаунт, удаляемый из базы данных аккаунтов
     * @author Mapkn3
     * @see Statistics
     */
    @Override
    public void deleteStatistics(Statistics statistics) {
        logger.debug("Delete Statistics: " + statistics.toString());
        statisticsDao.delete(statistics);
    }

    /**
     * Получение статистики из базы данных статистик по аккаунту типа {@link Account}
     *
     * @param account - аккаунт типа {@link Account}, для которого нужна статистика
     * @return статистика для данного аккаунта типа {@link Statistics}
     * @author Mapkn3
     * @see Account
     * @see Statistics
     */
    @Override
    public Statistics getStatisticsByAccount(Account account) {
        return getAllStatistics().stream().filter((s) -> s.getAccount().equals(account)).findFirst().orElse(null);
    }
}
