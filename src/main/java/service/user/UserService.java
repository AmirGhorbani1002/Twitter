package service.user;

import entity.user.User;
import entity.user.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findUser(String username);
    Optional<User> findUser(String username, String password);
    List<UserDTO> searchByUsername(String username);

}
