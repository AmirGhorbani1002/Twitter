package repository.follow.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.follow.Follow;
import entity.user.User;
import entity.user.UserDTO;
import jakarta.persistence.EntityManager;
import repository.follow.FollowRepository;

import java.util.ArrayList;
import java.util.List;

public class FollowRepositoryImpl extends BaseRepositoryImpl<Follow> implements FollowRepository {


    public FollowRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Follow> getEntityClass() {
        return Follow.class;
    }

    @Override
    public List<UserDTO> showFollowers(Long id) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = em.createQuery("select f.follower from Follow f where f.following.id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO(user.getFirstname(),user.getLastname(),user.getUsername());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    @Override
    public List<UserDTO> showFollowing(Long id) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = em.createQuery("select f.follower from Follow f where f.follower.id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO(user.getFirstname(),user.getLastname(),user.getUsername());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }
}
