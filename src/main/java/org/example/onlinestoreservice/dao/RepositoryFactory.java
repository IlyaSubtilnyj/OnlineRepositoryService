package org.example.onlinestoreservice.dao;

import org.example.onlinestoreservice.factories.UserFactory;
import org.example.onlinestoreservice.dao.resource_models.UserResourceModel;
import org.example.onlinestoreservice.dao.repositories.UserRepository;

public class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();
    private final UserRepository sqlUserImpl = new UserRepository(new UserResourceModel(), new UserFactory());
    private RepositoryFactory(){}
    public static RepositoryFactory getInstance(){
        return instance;
    }

    public UserRepository getUserDAO(){
        return sqlUserImpl;
    }
}
