package org.example.onlinestoreservice.dao.repositories;

import org.example.onlinestoreservice.factories.UserFactory;
import org.example.onlinestoreservice.dao.resource_models.UserResourceModel;

public class UserRepository {
    private UserResourceModel userResourceModel;
    private UserFactory userFactory;
    public UserRepository(UserResourceModel resourceModel, UserFactory userFactory) {
        this.userResourceModel = resourceModel;
        this.userFactory = userFactory;
    }
}
