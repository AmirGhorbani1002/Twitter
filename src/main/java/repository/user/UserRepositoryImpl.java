package repository.user;

import base.repository.impl.BaseRepositoryImpl;
import entity.user.User;
import jakarta.persistence.EntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository{

    EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

}
