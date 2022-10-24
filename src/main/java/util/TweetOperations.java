package util;

import entity.tweet.Tweet;
import entity.user.User;
import repository.tweet.impl.TweetRepositoryImpl;
import service.tweet.TweetService;
import service.tweet.impl.TweetServiceImpl;

import java.util.List;

public class TweetOperations {

    private final TweetService tweetService = new TweetServiceImpl(new TweetRepositoryImpl(Hibernate.getEntityManager()));

    public void add(User user, String message) {
        Tweet tweet = new Tweet(message);
        tweet.setUser(user);
        tweetService.save(tweet);
    }

    public void showUserTweets(User user) {
        List<Tweet> tweets = tweetService.findUserTweets(user.getId());
        tweets.forEach(tweet -> {
            System.out.println(tweet.getId() + "- message:  " + tweet.getMessage()
                    + " number of likes: " + tweet.getLikes().size());
            tweet.getComments().forEach(comment -> System.out.println("comment: " + comment.getUser().getUsername()
                    + " say: " + comment.getMessage()));
        });
    }

    public void edit(Long id, String message) {
        Tweet tweet = tweetService.findById(id);
        tweet.setMessage(message);
        tweetService.update(tweet);
    }

    public void delete(Long id) {
        Tweet tweet = tweetService.findById(id);
        tweetService.delete(tweet);
    }

}
