package service.Like;

import base.service.BaseService;
import entity.like.Like;
import entity.tweet.Tweet;

import java.util.List;

public interface LikeService extends BaseService<Like> {
    List<String> findLikedAccounts(Tweet tweet);

}
