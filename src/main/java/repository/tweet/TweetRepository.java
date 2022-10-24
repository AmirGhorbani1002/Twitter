package repository.tweet;

import base.repository.BaseRepository;
import entity.tweet.Tweet;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends BaseRepository<Tweet> {

    List<Tweet> findUserTweets(Long id);

}
