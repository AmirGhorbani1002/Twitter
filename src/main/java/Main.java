import connection.HibernateUtils;
import entity.like.Like;
import entity.tweet.Tweet;
import entity.user.User;
import jakarta.persistence.EntityManager;
import repository.like.impl.LikeRepositoryImpl;
import repository.tweet.impl.TweetRepositoryImpl;
import repository.user.impl.UserRepositoryImpl;
import service.like.LikeService;
import service.like.impl.LikeServiceImpl;
import service.tweet.TweetService;
import service.tweet.impl.TweetServiceImpl;
import service.user.UserService;
import service.user.impl.UserServiceImpl;


public class Main {
    public static void main(String[] args){
        EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();

        User user1 = new User("Taha");
        User user2 = new User("Kazem");
        User user3 = new User("Amir");

        Tweet tweet1 = new Tweet(user1);

        Like like1 = new Like(tweet1, user2);
        Like like2 = new Like(tweet1, user3);


        UserService userService = new UserServiceImpl(new UserRepositoryImpl(em));
        TweetService tweetService = new TweetServiceImpl(new TweetRepositoryImpl(em));
        LikeService likeService = new LikeServiceImpl(new LikeRepositoryImpl(em));

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        tweetService.save(tweet1);
        likeService.save(like1);
        likeService.save(like2);

        likeService.findLikedAccounts(tweet1);
        System.out.println(likeService.findLikedAccounts(tweet1));
    }
}
