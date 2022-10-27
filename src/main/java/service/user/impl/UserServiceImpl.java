package service.user.impl;

import base.service.impl.BaseServiceImpl;
import entity.user.User;
import entity.user.UserDTO;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryImpl;
import service.user.UserService;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {


    private final UserRepository userRepository = new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public Optional<User> findUser(String username) {
        try {
            return userRepository.findUser(username);
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    @Override
    public Optional<User> findUser(String username, String password) {
        try {
            return userRepository.findUser(username, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<UserDTO> searchByUsername(String username) {
        return userRepository.searchByUsername(username);
    }
}
