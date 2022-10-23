package service.user;

import base.service.impl.BaseServiceImpl;
import entity.user.User;
import repository.user.UserRepository;
import repository.user.UserRepositoryImpl;

public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService{


    private UserRepositoryImpl userRepositoryImpl;

    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }
}
