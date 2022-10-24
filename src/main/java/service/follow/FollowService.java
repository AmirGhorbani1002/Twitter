package service.follow;

import base.service.BaseService;
import entity.follow.Follow;
import entity.user.UserDTO;

import java.util.List;

public interface FollowService extends BaseService<Follow> {
    List<UserDTO> showFollowers(Long id);
    List<UserDTO> showFollowing(Long id);
}
