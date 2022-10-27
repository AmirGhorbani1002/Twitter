package menu;

import entity.tweet.Tweet;
import entity.user.User;
import util.TweetOperations;
import util.Validation;

import java.util.Objects;
import java.util.Scanner;

public class TweetMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final Validation validation = new Validation();

    public void showMenu(User user) {
        while (true) {
            System.out.println("1- Add new tweet");
            System.out.println("2- Show my tweets");
            System.out.println("3- Show other tweets");
            System.out.println("4- Exit");
            System.out.print("Enter your command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                add(user);
            } else if (Objects.equals(command, "2")) {
                showMy(user);
            } else if ((Objects.equals(command, "3"))) {
                TweetOperations tweetOperations = new TweetOperations();
                tweetOperations.showOther();
                System.out.print("Enter id for select tweet( 0 for exit): ");
                Long id = validation.validNumber(scanner.next());
                if (id == 0) return;
                Tweet tweet = tweetOperations.showTweet(id);
                if (tweet == null) return;
                System.out.print("Work with tweet or comment/s ?");
                String workPlace = scanner.next();
                if (workPlace.equalsIgnoreCase("tweet")) {
                    System.out.print("like(dislike if you like it) or comment? ");
                    String work = scanner.next();
                    if (work.equalsIgnoreCase("like")) {
                        tweetOperations.likeForTweet(user, tweet);
                    } else if (work.equalsIgnoreCase("comment")) {
                        System.out.print("Enter message: ");
                        scanner.nextLine();
                        String message = scanner.nextLine();
                        tweetOperations.commentForTweet(user, tweet, message);
                    } else {
                        System.out.println("Wrong work input.");
                    }
                } else if (workPlace.equalsIgnoreCase("comment")) {
                    System.out.print("Enter comment id: ");
                    id = validation.validNumber(scanner.next());
                    System.out.print("like or reply? ");
                    String work = scanner.next();
                    if (work.equalsIgnoreCase("like")) {
                        tweetOperations.likeForComment(user, id);
                    } else if (work.equalsIgnoreCase("reply")) {
                        System.out.print("Enter message: ");
                        scanner.nextLine();
                        String message = scanner.nextLine();
                        tweetOperations.replyForComment(user, id, message);
                    } else {
                        System.out.println("Wrong work input.");
                    }
                } else {

                }
            } else if ((Objects.equals(command, "4"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }
        }
    }

    private void showMy(User user) {
        TweetOperations tweetOperations = new TweetOperations();
        tweetOperations.showUser(user);
        System.out.print("Enter tweet id or enter 0 for exit: ");
        Long id = scanner.nextLong();
        System.out.print("Edit or Delete? ");
        String op = scanner.next();
        if (op.equalsIgnoreCase("edit")) {
            System.out.print("Enter new message: ");
            scanner.nextLine();
            String message = scanner.nextLine();
            tweetOperations.edit(id, message);
        } else if (op.equalsIgnoreCase("delete")) {
            tweetOperations.delete(id);
        } else {
            System.out.println("Wrong operation.");
        }
    }

    private void add(User user) {
        System.out.print("Enter message: ");
        scanner.nextLine();
        String message = scanner.nextLine();
        TweetOperations tweetOperations = new TweetOperations();
        tweetOperations.add(user, message);
    }

}
