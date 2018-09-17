package ru.mapkn3.BullCowGame.service;

import ru.mapkn3.BullCowGame.model.Account;

import java.util.List;

/**
 * Интерфейс для работы с хранилищем аккаунтов типа {@link Account}
 *
 * @author Mapkn3
 * @see Account
 */
public interface AccountService {
    /**
     * Получение аккаунта из хранилища аккаунтов по id типа {@link Long}
     *
     * @return аккаунт из хранилища аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    Account getAccount(Long id);

    /**
     * Получение объекта из хранилища аккаунтов по имени пользователя типа {@link String}
     *
     * @return аккаунт из хранилища аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    Account getAccountByName(String name);

    /**
     * Добавление аккаунта в хранилище аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, добавляемый к хранилищу аккаунтов
     * @return id добавленного аккаунта в хранилище аккаунтов
     * @author Mapkn3
     * @see Account
     */
    Long addNewAccount(Account account);

    /**
     * Получение списка аккаунтов из хранилища аккаунтов типа {@link Account}
     *
     * @return список аккаунтов типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    List<Account> getAllAccounts();

    /**
     * Обновление аккаунта в хранилище аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, обновляемый в хранилище аккаунтов
     * @return обновленный аккаунт
     * @author Mapkn3
     * @see Account
     */
    Account updateAccount(Account account);

    /**
     * Удаление аккаунта из хранилища аккаунтов типа {@link Account}
     *
     * @param account - аккаунт, удаляемый из хранилища аккаунтов
     * @author Mapkn3
     * @see Account
     */
    void deleteAccount(Account account);
}
