package util;

import entity.tweet.Tweet;
import entity.user.User;
import repository.tweet.impl.TweetRepositoryImpl;
import service.tweet.TweetService;
import service.tweet.impl.TweetServiceImpl;

import java.util.List;
import java.util.Optional;

public class TweetOperations {

    private final TweetService tweetService = new TweetServiceImpl(new TweetRepositoryImpl(Hibernate.getEntityManager()));

    public void add(User user, String message) {
        Tweet tweet = new Tweet(message);
        tweet.setUser(user);
        tweetService.save(tweet);
    }

    public void showUser(User user) {
        List<Tweet> tweets = tweetService.findUser(user.getId());
        tweets.forEach(tweet -> {
            System.out.println(tweet.getId() + "- message:  " + tweet.getMessage()
                    + " number of likes: " + tweet.getLikes().size());
            tweet.getComments().forEach(comment -> System.out.println("comment: " + comment.getUser().getUsername()
                    + " say: " + comment.getMessage()));
        });
    }

    public void edit(Long id, String message) {
        Optional<Tweet> optionalTweet = tweetService.findById(id);
        optionalTweet.ifPresent(tweet -> {
            tweet.setMessage(message);
            tweetService.update(tweet);
        });
    }

    public void delete(Long id) {
        Optional<Tweet> optionalTweet = tweetService.findById(id);
        optionalTweet.ifPresent(tweetService::delete);
    }

    public void showOther(User user) {
        List<Tweet> tweets = tweetService.findOther(user.getId());
        tweets.forEach(tweet -> {
            System.out.println("Tweet by " + tweet.getUser().getUsername() + " with id " + tweet.getId() + "- message:  "
                    + tweet.getMessage() + ". number of likes: " + tweet.getLikes().size());
            tweet.getComments().forEach(comment -> System.out.println("comment: " + comment.getUser().getUsername()
                    + " say: " + comment.getMessage()));
        });
    }

}
