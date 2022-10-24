package service.user.impl;

import base.service.impl.BaseServiceImpl;
import entity.user.User;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryImpl;
import service.user.UserService;
import util.Hibernate;

import java.util.Optional;

public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {


    private final UserRepository userRepository = new UserRepositoryImpl(Hibernate.getEntityManager());

    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public Optional<User> findUser(String username) {
        return userRepository.findUser(username);
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        return userRepository.findUser(username, password);
    }
}
