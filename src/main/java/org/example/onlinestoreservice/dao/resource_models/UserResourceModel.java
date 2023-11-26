package org.example.onlinestoreservice.dao.resource_models;

import org.example.onlinestoreservice.dao.DaoException;
import org.example.onlinestoreservice.dao.connection.ConnectionPool;
import org.example.onlinestoreservice.dao.factories.UserResultSetFactory;
import org.example.onlinestoreservice.beans.AbstractModel;
import org.example.onlinestoreservice.beans.User;
import org.example.onlinestoreservice.dao.repositories.api.IUserRepository;
import org.example.onlinestoreservice.dao.resource_models.api.AbstractResourceModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResourceModel extends AbstractResourceModel implements IUserRepository {

    public UserResourceModel() {
        _init("user", "user_id", new ArrayList<String>(List.of("name")), new UserResultSetFactory());
    }

    @Override
    public void save(AbstractModel model) throws DaoException {
        User user = (User)model;
        String query = generateSaveQuery();
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //impl
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.executeUpdate();
            //impl
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
