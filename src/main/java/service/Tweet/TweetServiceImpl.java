package service.Tweet;

import base.service.impl.BaseServiceImpl;
import entity.tweet.Tweet;
import repository.Tweet.TweetRepository;

public class TweetServiceImpl extends BaseServiceImpl<Tweet, TweetRepository> implements TweetService{

    public TweetServiceImpl(TweetRepository repository) {
        super(repository);
    }
}
