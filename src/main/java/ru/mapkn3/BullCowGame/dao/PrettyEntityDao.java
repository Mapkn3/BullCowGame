package ru.mapkn3.BullCowGame.dao;

import ru.mapkn3.BullCowGame.model.PrettyEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Интерфейс для взаимодействия с хранилищем данных
 *
 * @author Arthur Kogan
 */
public interface PrettyEntityDao {
    /**
     * Сохранение объекта в хранилище данных
     *
     * @param entity - объект типа {@link PrettyEntity} для сохранения
     * @return присвоенных id для сохраненного объекта
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    Serializable save(PrettyEntity entity);

    /**
     * Поиск объекта по его id в хранилище данных
     *
     * @param entityClass - тип искомого объекта, наследуемый от {@link PrettyEntity}
     * @param id          - id искомого объекта
     * @return искомый объект
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    <E extends PrettyEntity> E findById(Class<E> entityClass, Serializable id);

    /**
     * Получения списка всех объектов заданного типа из хранилища данных
     *
     * @param entityClass - тип объектов для поиска, наследуемый от {@link PrettyEntity}
     * @return список объектов заданного типа
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    <E extends PrettyEntity> List getAll(Class<E> entityClass);

    /**
     * Обновление объекта в хранилище данных
     *
     * @param entity - обновляемый объект типа, наследуемого от {@link PrettyEntity}
     * @return обновленный объект
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    <E extends PrettyEntity> E update(E entity);

    /**
     * Удаление объекта из хранилища данных
     *
     * @param entity - удаляемый объект типа {@link PrettyEntity}
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    void delete(PrettyEntity entity);
}
