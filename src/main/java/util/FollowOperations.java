package util;

import entity.user.User;
import entity.user.UserDTO;
import repository.follow.impl.FollowRepositoryImpl;
import service.follow.FollowService;
import service.follow.impl.FollowServiceImpl;

import java.util.List;

public class FollowOperations {

    private final FollowService followService = new FollowServiceImpl(new FollowRepositoryImpl(Hibernate.getEntityManager()));

    public void showFollower(User user) {
        List<UserDTO> followers = followService.showFollowers(user.getId());
        System.out.println(followers);
    }

    public void showFollowing(User user) {
        List<UserDTO> followers = followService.showFollowing(user.getId());
        System.out.println(followers);
    }

}
