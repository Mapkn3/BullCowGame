package ru.mapkn3.BullCowGame.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.mapkn3.BullCowGame.model.PrettyEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Класс для взаимодействия с базой данных
 * <p>
 * Реализует интерфейс {@link PrettyEntityDao}
 *
 * @author Arthur Kogan
 * @see PrettyEntityDao
 */
public class PrettyEntityDaoImpl implements PrettyEntityDao {

    private SessionFactory sessionFactory;

    /**
     * Конструктор с параметрами
     *
     * @param sessionFactory - фабрика сессий Hibernate
     * @author Arthur Kogan
     * @see SessionFactory
     */
    public PrettyEntityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Получение текущей сессии
     * Если в данный момент нет сессии, открвает новую сессию и возвращает её
     *
     * @return объект сессии
     * @author Arthur Kogan
     * @see Session
     */
    protected Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    /**
     * Сохранение объекта в базе данных
     *
     * @param entity - объект типа {@link PrettyEntity} для сохранения
     * @return присвоенных id для сохраненного объекта
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    @Override
    public Serializable save(PrettyEntity entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Serializable id = session.save(entity);
        transaction.commit();
        return id;
    }

    /**
     * Поиск объекта по его id в базе данных
     *
     * @param entityClass - тип искомого объекта, наследуемый от {@link PrettyEntity}
     * @param id          - id искомого объекта
     * @return искомый объект
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    @Override
    public <E extends PrettyEntity> E findById(Class<E> entityClass, final Serializable id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        E entity = session.get(entityClass, id);
        transaction.commit();
        return entity;
    }

    /**
     * Получения списка всех объектов заданного типа из базы данных
     *
     * @param entityClass - тип объектов для поиска, наследуемый от {@link PrettyEntity}
     * @return список объектов заданного типа
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    @Override
    public <E extends PrettyEntity> List getAll(Class<E> entityClass) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From " + entityClass.getSimpleName();
        List entities = session.createQuery(hql).getResultList();
        transaction.commit();
        return entities;
    }

    /**
     * Обновление объета в базе данных
     *
     * @param entity - обновляемый объект типа, наследуемого от {@link PrettyEntity}
     * @return обновленный объект
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    @Override
    public <E extends PrettyEntity> E update(E entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        E updatedEntity = (E) session.merge(entity);
        transaction.commit();
        return updatedEntity;
    }

    /**
     * Удаление объекта из базы данных
     *
     * @param entity - удаляемый объект типа {@link PrettyEntity}
     * @author Arthur Kogan
     * @see PrettyEntity
     */
    @Override
    public void delete(PrettyEntity entity) {
        getSession().delete(entity);
    }
}
