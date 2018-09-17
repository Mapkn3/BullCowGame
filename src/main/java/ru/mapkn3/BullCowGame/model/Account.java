package ru.mapkn3.BullCowGame.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Класс аккаунта пользователя
 * Реализует интерфейс {@link PrettyEntity}
 *
 * @author Mapkn3
 * @see PrettyEntity
 */
@Entity
@Table(name = "account")
public class Account implements PrettyEntity {
    private Long id;
    @Size(max = 30, message = "Max length of nickname: 30")
    @Pattern(regexp = "^[A-Za-z0-9_\\-]+$", message = "Letters, digits, '_' and '-' only")
    private String nickname;
    @Size(max = 64, message = "Max length of password: 64")
    private String password;

    /**
     * Конструктор по умолчанию
     * Инициализирует поля "пустыми" значениями
     *
     * @author Mapkn3
     */
    public Account() {
        this(0L, "", "");
    }

    /**
     * Конструктор с параметрами
     *
     * @param nickname - имя пользователя
     * @param password - пароль
     * @author Mapkn3
     */
    public Account(String nickname, String password) {
        this(0L, nickname, password);
    }

    /**
     * Конструктор с параметрами
     *
     * @param id       - id аккаунта
     * @param nickname - имя пользователя
     * @param password - пароль
     * @author Mapkn3
     */
    public Account(Long id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    /**
     * Получение id аккаунта
     *
     * @return id аккаунта типа {@link Long}
     * @author Mapkn3
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    /**
     * Установка значения id аккаунта
     *
     * @author Mapkn3
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получение имени пользователя
     *
     * @return имя пользователя типа {@link String}
     * @author Mapkn3
     */
    @Basic
    @Column(name = "nickname", length = 30, unique = true)
    public String getNickname() {
        return nickname;
    }

    /**
     * Задание имени пользователя
     *
     * @param nickname - имя пользователя типа {@link String}
     * @author Mapkn3
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Получение пароля аккаунта
     *
     * @return пароль аккаунта типа {@link String}
     * @author Mapkn3
     */
    @Basic
    @Column(name = "password", length = 64)
    public String getPassword() {
        return password;
    }

    /**
     * Задание пароля аккаунта
     *
     * @param password - пароль типа {@link String}
     * @author Mapkn3
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Получение значения первичного ключа аккаунта в базе данных
     *
     * @return значение первичного ключа типа {@link Serializable}
     * @author Mapkn3
     */
    @Override
    public Serializable primaryKey() {
        return getId();
    }

    /**
     * Установка значения первичного ключа аккаунта в базе данных
     *
     * @param primaryKey - значение первичного ключа типа {@link Serializable}
     * @author Mapkn3
     */
    @Override
    public void setPrimaryKey(Serializable primaryKey) {
        this.id = (Long) primaryKey;
    }

    /**
     * Получение строкового представления аккаунта
     *
     * @return строковое представление аккаунта
     * @author Mapkn3
     */
    @Override
    public String toString() {
        return "Account{" + "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Сравнение двух аккаунтов
     *
     * @param obj - объект аккаунта типа {@link Object}
     * @return возвращает {@code true}, если текущий объект и {@code obj} имеют одинаковые значения полей, иначе {@code false}
     * @author Mapkn3
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account tmp = (Account) obj;
            return tmp.id.equals(this.id) && tmp.nickname.equals(this.nickname) && tmp.password.equals(this.password);
        } else {
            return false;
        }
    }
}
