import menu.Home;
import util.Hibernate;
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
        Home home = new Home();
        home.showMenu();
    }
}
