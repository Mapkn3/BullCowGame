package ru.mapkn3.BullCowGame.service;

import org.apache.log4j.Logger;
import ru.mapkn3.BullCowGame.dao.PrettyEntityDao;
import ru.mapkn3.BullCowGame.model.Account;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с базой данных аккаунтов типа {@link Account}
 *
 * @author Mapkn3
 * @see Account
 */
public class AccountServiceImpl implements AccountService {
    private final static Logger logger = Logger.getLogger(AccountServiceImpl.class);

    private PrettyEntityDao accountDao;

    /**
     * Конструктор с параметрами
     *
     * @param accountDao - объект для работы с базой данных типа {@link PrettyEntityDao}
     * @author Mapkn3
     * @see PrettyEntityDao
     */
    public AccountServiceImpl(PrettyEntityDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * Получение аккаунта из базы данных аккаунтов по id типа {@link Long}
     *
     * @return аккаунт из базы данных аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    @Override
    public Account getAccount(Long id) {
        logger.debug("Getting account with id = " + id);
        return accountDao.findById(Account.class, id);
    }

    /**
     * Получение объекта из базы данных аккаунтов по имени пользователя типа {@link String}
     *
     * @return аккаунт из базы данных аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    @Override
    public Account getAccountByName(String name) {
        List<Account> accounts = accountDao.getAll(Account.class);
        logger.debug("Getting account with name = " + name);
        Optional<Account> result = accounts.stream().filter(account -> account.getNickname().equals(name)).findFirst();
        return result.orElse(null);
    }

    /**
     * Добавление аккаунта в базу данных аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, добавляемый к базе данных аккаунтов
     * @return id добавленного аккаунта в базе данных аккаунтов
     * @author Mapkn3
     * @see Account
     */
    @Override
    public Long addNewAccount(Account account) {
        Long id = (Long) accountDao.save(account);
        logger.debug("Id of new Account: " + id);
        return id;
    }

    /**
     * Получение списка аккаунтов из базы данных аккаунтов типа {@link Account}
     *
     * @return список аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountDao.getAll(Account.class);
        logger.debug("Get " + accounts.size() + " accounts:");
        for (Account account : accounts) {
            logger.debug(account.toString());
        }
        return accounts;
    }

    /**
     * Обновление аккаунта в базе данных аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, обновляемый в базе данных аккаунтов
     * @return обновленный аккаунт
     * @author Mapkn3
     * @see Account
     */
    @Override
    public Account updateAccount(Account account) {
        Account oldAccount = accountDao.findById(Account.class, account.primaryKey());
        Account newAccount = accountDao.update(account);
        logger.debug("Old account: " + oldAccount.toString());
        logger.debug("New account: " + newAccount.toString());
        return newAccount;
    }

    /**
     * Удаление аккаунта из базы данных аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, удаляемый из базы данных аккаунтов
     * @author Mapkn3
     * @see Account
     */
    @Override
    public void deleteAccount(Account account) {
        logger.debug("Delete account: " + account.toString());
        accountDao.delete(account);
    }
}
