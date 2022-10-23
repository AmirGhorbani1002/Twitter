package service.user;

import entity.user.User;

public interface UserService {

    User save(User user);

    User findById(Long id);

}
