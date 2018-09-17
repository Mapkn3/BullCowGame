package ru.mapkn3.BullCowGame.model;

import java.io.Serializable;

/**
 * Интерфейс для обобщения объектов для работы с Hibernate
 *
 * @author Mapkn3
 */
public interface PrettyEntity {
    /**
     * Получение первичного ключа объекта
     *
     * @return первичный ключ объекта
     * @author Mapkn3
     */
    Serializable primaryKey();

    /**
     * Установка значения первичного ключа объекта
     *
     * @param primaryKey - значение первичного ключа типа {@link Serializable}
     * @author Mapkn3
     */
    void setPrimaryKey(Serializable primaryKey);
}
