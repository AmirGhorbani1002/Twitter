package repository.user.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.user.User;
import jakarta.persistence.EntityManager;
import repository.user.UserRepository;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

    EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

}
