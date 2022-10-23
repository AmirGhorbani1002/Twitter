package service.follow;

import base.service.BaseService;
import entity.follow.Follow;

import java.util.List;

public interface FollowService extends BaseService<Follow> {
    List<String> showFollowers(Long id);
    List<String> showFollowing(Long id);
}
