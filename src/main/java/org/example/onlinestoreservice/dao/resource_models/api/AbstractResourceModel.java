package org.example.onlinestoreservice.dao.resource_models.api;

import org.example.onlinestoreservice.dao.Dao;
import org.example.onlinestoreservice.dao.DaoException;
import org.example.onlinestoreservice.dao.connection.ConnectionPool;
import org.example.onlinestoreservice.dao.factories.api.IResultSetFactory;
import org.example.onlinestoreservice.beans.AbstractModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractResourceModel implements Dao<AbstractModel> {
    protected String idFieldName;
    protected String mainTable;

    protected List<String> fields = new ArrayList<>();
    protected IResultSetFactory factory;
    public void _init(String mainTable, String idFieldName, List<String> fields, IResultSetFactory factory) {
        this.mainTable = mainTable;
        this.idFieldName = idFieldName;
        this.fields = fields;
        this.factory = factory;
    }

    public String getIdFieldName() {
        return idFieldName;
    }

    public Optional<AbstractModel> get(long id) throws DaoException {
        String query = generateGetQuery();
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //impl
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Create and return an instance of YourType based on the retrieved data
                    return factory.create(resultSet);
                }
            }
            //impl
            pool.releaseConnection(connection);
        } catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e);
        }
        return Optional.empty(); // Return empty Optional if no object is found
    }

    public List<AbstractModel> getAll() throws DaoException {
        List<AbstractModel> resultList = new ArrayList<>();
        String query = generateGetAllQuery();
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //impl
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Optional<AbstractModel> yourObject = factory.create(resultSet);
                yourObject.ifPresent(resultList::add);
            }
            //impl
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return resultList;
    }

    public abstract void save(AbstractModel model) throws DaoException;

    public void update(AbstractModel model, String[] params) throws DaoException {
        String query = generateUpdateQuery();
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //impl
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i+1, params[i]);
            }
            statement.setLong(params.length, model.getId()); // Assuming t has an ID field
            statement.executeUpdate();
            //impl
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public void delete(AbstractModel model) throws DaoException {
        String query = generateDeleteQuery();
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //impl
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, model.getId());
            statement.executeUpdate();
            //impl
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    protected String generateGetQuery() {
        StringBuilder query = new StringBuilder("SELECT");
        query.append(" * ");
        query.append("FROM");
        query.append(" ");
        query.append(mainTable);
        query.append(" ");
        query.append("WHERE");
        query.append(" ");
        query.append(idFieldName);
        query.append(" = ?");
        return query.toString();
    }
    protected String generateGetAllQuery() {
        StringBuilder query = new StringBuilder("SELECT");
        query.append(" * ");
        query.append("FROM");
        query.append(" ");
        query.append(mainTable);
        return query.toString();
    }

    protected String generateSaveQuery() {
        StringBuilder query = new StringBuilder("INSERT");
        query.append(" ");
        query.append("INTO");
        query.append(" ");
        query.append(mainTable);
        query.append(" (");
        for (String columnName: fields) {
            query.append(columnName);
            query.append(", ");
        }
        query.append(") ");
        query.append("VALUES");
        query.append(" (");
        query.append("?, ".repeat(fields.size()));
        query.append(")");
        return query.toString();
    }
    protected String generateUpdateQuery() {
        StringBuilder query = new StringBuilder("UPDATE");
        query.append(" ");
        query.append(mainTable);
        query.append(" ");
        query.append("SET");
        query.append(" ");
        for (String columnName: fields) {
            query.append(columnName);
            query.append(" = ?, ");
        }
        query.append("WHERE");
        query.append(" ");
        query.append(idFieldName);
        query.append(" = ?");
        return query.toString();
    }

    String query = "DELETE FROM your_table WHERE your_table_id = ?";
    protected String generateDeleteQuery() {
        StringBuilder query = new StringBuilder("DELETE");
        query.append(" ");
        query.append("FROM");
        query.append(" ");
        query.append(mainTable);
        query.append(" ");
        query.append("WHERE");
        query.append(" ");
        query.append(idFieldName);
        query.append(" = ?");
        return query.toString();
    }
}
