package repository.Like;

import base.repository.BaseRepository;
import entity.like.Like;
import entity.tweet.Tweet;

import java.util.List;

public interface LikeRepository extends BaseRepository<Like> {
    List<String> findLikedAccounts(Tweet tweet);
}
