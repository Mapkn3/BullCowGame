package ru.mapkn3.BullCowGame.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс статистики пользователя
 * Реализует интерфейс {@link PrettyEntity}
 *
 * @author Mapkn3
 * @see PrettyEntity
 */
@Entity
@Table(name = "statistics")
public class Statistics implements PrettyEntity {
    private Long id;
    private Double mean;
    private Long attempts;
    private Account account;

    /**
     * Конструктор по умолчанию
     * Инициализирует поля "пустыми" значениями
     *
     * @author Mapkn3
     */
    public Statistics() {
        this(0L, 0.0, 0L);
    }

    /**
     * Конструктор с параметрами
     *
     * @param mean     - значение среднего числа попыток угадать число типа {@link Double}
     * @param attempts - количество сыгранных игр типа {@link Long}
     * @author Mapkn3
     */
    public Statistics(Double mean, Long attempts) {
        this(0L, mean, attempts);
    }

    /**
     * Конструктор с параметрами
     *
     * @param id       - id статистики
     * @param mean     - значение среднего числа попыток угадать число типа {@link Double}
     * @param attempts - количество сыгранных игр типа {@link Long}
     * @author Mapkn3
     */
    public Statistics(Long id, Double mean, Long attempts) {
        this.id = id;
        this.mean = mean;
        this.attempts = attempts;
    }

    /**
     * Получение id статистики
     *
     * @return id статистики типа {@link Long}
     * @author Mapkn3
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    /**
     * Установка значения id статистики
     *
     * @author Mapkn3
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получение значения среднего числа попыток угадать число
     *
     * @return значение среднего числа попыток угадать число
     * @author Mapkn3
     */
    @Basic
    @Column(name = "mean")
    public Double getMean() {
        return mean;
    }

    /**
     * Установка значения среднего числа попыток угадать число
     *
     * @param mean - значение среднего числа попыток угадать число типа {@link Double}
     * @author Mapkn3
     */
    public void setMean(Double mean) {
        this.mean = mean;
    }

    /**
     * Получения количества сыгранных игр
     *
     * @return количество сыгранных игр типа {@link Long}
     * @author Mapkn3
     */
    @Basic
    @Column(name = "attempts")
    public Long getAttempts() {
        return attempts;
    }

    /**
     * Установка количества сыгранных игр
     *
     * @param attempts - количество сыгранных игр типа {@link Long}
     * @author Mapkn3
     */
    public void setAttempts(Long attempts) {
        this.attempts = attempts;
    }

    /**
     * Получение аккаунта, для которого ведётся статистика
     *
     * @return аккаунт, для которого ведётся статистика, типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Account getAccount() {
        return account;
    }

    /**
     * Задание аккаунта, для которого ведётся статистика
     *
     * @param account - аккаунт, для которого ведётся статистика, типа {@link Account}
     * @author Mapkn3
     * @see Account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Получение значения первичного ключа статистики в базе данных
     *
     * @return значение первичного ключа типа {@link Serializable}
     * @author Mapkn3
     */
    @Override
    public Serializable primaryKey() {
        return getId();
    }

    /**
     * Установка значения первичного ключа статистики в базе данных
     *
     * @param primaryKey - значение первичного ключа типа {@link Serializable}
     * @author Mapkn3
     */
    @Override
    public void setPrimaryKey(Serializable primaryKey) {
        this.id = (Long) primaryKey;
    }

    /**
     * Добавление новой попытки угадать число к существующей статистике
     * Происходит перерасчёт текущих значений среднего числа попыток угадать число и количества сыгранных игр
     *
     * @param score - количество попыток угадать число
     * @author Mapkn3
     */
    public void addAttempt(Double score) {
        Double lastScore = this.mean * this.attempts;
        Long currentAttempt = this.attempts + 1;
        this.mean = (lastScore + score) / currentAttempt;
        this.attempts = currentAttempt;
    }

    /**
     * Получение  строкового представления статистики
     *
     * @return строковое представление статистики
     * @author Mapkn3
     */
    @Override
    public String toString() {
        return "Statistics{" + "id=" + id +
                ", mean=" + mean +
                ", attempts=" + attempts +
                ", account=" + account.toString() +
                '}';
    }
}
