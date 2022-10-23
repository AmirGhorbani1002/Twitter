package service.user.impl;

import base.service.impl.BaseServiceImpl;
import entity.user.User;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryImpl;
import service.user.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {


    private UserRepositoryImpl userRepositoryImpl;

    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }
}
