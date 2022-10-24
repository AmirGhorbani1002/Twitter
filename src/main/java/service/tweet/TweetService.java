package service.tweet;

import base.service.BaseService;
import entity.tweet.Tweet;

import java.util.List;

public interface TweetService extends BaseService<Tweet>{

    public List<Tweet> findUserTweets(Long id);

}
