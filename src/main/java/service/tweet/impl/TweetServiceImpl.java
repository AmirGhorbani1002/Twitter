package service.tweet.impl;

import base.service.impl.BaseServiceImpl;
import entity.tweet.Tweet;
import repository.tweet.TweetRepository;
import service.tweet.TweetService;

public class TweetServiceImpl extends BaseServiceImpl<Tweet, TweetRepository> implements TweetService {

    public TweetServiceImpl(TweetRepository repository) {
        super(repository);
    }
}
