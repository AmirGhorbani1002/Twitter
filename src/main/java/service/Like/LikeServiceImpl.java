package service.Like;

import base.service.impl.BaseServiceImpl;
import entity.like.Like;
import entity.tweet.Tweet;
import repository.Like.LikeRepository;

import java.util.List;

public class LikeServiceImpl extends BaseServiceImpl<Like, LikeRepository> implements LikeService{
    public LikeServiceImpl(LikeRepository repository) {
        super(repository);
    }

    @Override
    public List<String> findLikedAccounts(Tweet tweet) {
        return repository.findLikedAccounts(tweet);
    }
}
