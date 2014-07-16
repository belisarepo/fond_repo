package by.belisa.dao;

import java.io.Serializable;
import java.util.List;

import by.belisa.exception.DaoException;

public interface Dao<T, PK extends Serializable> {
    /**
     * Get all persisted objects
     *
     * @throws DaoException
     *
     */
    List<T> getAll() throws DaoException;
    /**
     * Get persisted object using primary key
     *
     * @throws DaoException
     */
    T get(PK id) throws DaoException;

    /**
     * Persist the new instance object
     *
     * @throws DaoException
     */
    T add(T object) throws DaoException;

    /**
     * Save changes made to a transient object.
     *
     * @throws DaoException
     */
    void update(T object) throws DaoException;

    /**
     * Remove an object
     *
     * @throws DaoException
     */
    void delete(T object) throws DaoException;
}
