package repository.followRepository;

import base.repository.BaseRepository;
import entity.follow.Follow;

import java.util.List;

public interface FollowRepository extends BaseRepository<Follow> {
    List<String> showFollowers(Long id);
    List<String> showFollowing(Long id);


}
