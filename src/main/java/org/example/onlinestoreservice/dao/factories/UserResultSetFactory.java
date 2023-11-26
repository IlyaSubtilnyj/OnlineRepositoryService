package org.example.onlinestoreservice.dao.factories;

import org.example.onlinestoreservice.beans.AbstractModel;
import org.example.onlinestoreservice.beans.User;
import org.example.onlinestoreservice.dao.factories.api.IResultSetFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserResultSetFactory implements IResultSetFactory {
    @Override
    public Optional<AbstractModel> create(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        return Optional.of(user);
    }
}
