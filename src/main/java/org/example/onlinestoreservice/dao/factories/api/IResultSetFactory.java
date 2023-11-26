package org.example.onlinestoreservice.dao.factories.api;

import org.example.onlinestoreservice.beans.AbstractModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface IResultSetFactory {
    Optional<AbstractModel> create(ResultSet resultSet) throws SQLException;
}
