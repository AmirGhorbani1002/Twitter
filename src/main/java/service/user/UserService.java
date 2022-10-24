package service.user;

import entity.user.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User findById(Long id);

    Optional<User> findUser(String username);
    Optional<User> findUser(String username, String password);

}
