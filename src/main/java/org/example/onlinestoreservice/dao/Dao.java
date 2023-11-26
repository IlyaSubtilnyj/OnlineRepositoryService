package org.example.onlinestoreservice.dao;

import org.example.onlinestoreservice.beans.AbstractModel;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<AbstractModel> get(long id) throws DaoException;

    List<AbstractModel> getAll() throws DaoException;

    void save(T t) throws DaoException;

    void update(T t, String[] params) throws DaoException;

    void delete(T t) throws DaoException;
}