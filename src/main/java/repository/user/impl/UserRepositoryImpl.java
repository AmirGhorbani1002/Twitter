package repository.user.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.user.UserRepository;
import util.Hibernate;

import java.util.Optional;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

    EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Optional<User> findUser(String username) {
        String jpql = """
                select u from User u where u.username = :username
                """;
        return Optional.ofNullable(Hibernate.getEntityManager().createQuery(jpql, User.class)
                .setParameter("username", username).getSingleResult());
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        String jpql = """
                select u from User u where u.username = :username and u.password = :password
                """;
        return Optional.ofNullable(Hibernate.getEntityManager().createQuery(jpql, User.class)
                .setParameter("username", username).setParameter("password", password).getSingleResult());
    }
}
