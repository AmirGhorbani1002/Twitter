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
            System.out.println("4- Show my comments");
            System.out.println("5- Exit");
            System.out.print("Enter your command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                add(user);
            } else if (Objects.equals(command, "2")) {
                showMyTweet(user);
            } else if ((Objects.equals(command, "3"))) {
                if (showOtherTweet(user)) return;
            } else if ((Objects.equals(command, "4"))) {
                if (showMyComment(user)) return;
            } else if ((Objects.equals(command, "5"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }
        }
    }

    private boolean showOtherTweet(User user) {
        TweetOperations tweetOperations = new TweetOperations();
        tweetOperations.showOther();
        System.out.print("Enter id for select tweet( 0 for exit): ");
        Long id = validation.validNumber(scanner.next());
        if (id == 0) return true;
        Tweet tweet = tweetOperations.showTweet(id);
        if (tweet == null) return true;
        System.out.print("Work with tweet or comment/s ?");
        String workPlace = scanner.next();
        if (workPlace.equalsIgnoreCase("tweet")) {
            workWithTweet(user, tweetOperations, tweet);
        } else if (workPlace.equalsIgnoreCase("comment")) {
            workWithComment(user, tweetOperations);
        } else {
            System.out.println("Wrong work input.");
        }
        return false;
    }

    private void workWithComment(User user, TweetOperations tweetOperations) {
        Long id;
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
    }

    private void workWithTweet(User user, TweetOperations tweetOperations, Tweet tweet) {
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
    }

    private boolean showMyComment(User user) {
        TweetOperations tweetOperations = new TweetOperations();
        tweetOperations.showUserComments(user);
        System.out.print("Enter comment id or enter 0 for exit: ");
        Long id = validation.validNumber(scanner.next());
        if (id == 0)
            return true;
        if (tweetOperations.isCommentForUser(user, id)) {
            System.out.print("Edit or Delete? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("edit")) {
                System.out.print("Enter new message: ");
                scanner.nextLine();
                String message = scanner.nextLine();
                tweetOperations.editComment(id, message);
            } else if (op.equalsIgnoreCase("delete")) {
                tweetOperations.deleteComment(id);
            } else {
                System.out.println("Wrong operation.");
            }
        } else {
            System.out.println("You have not tweet with this id");
        }
        return false;
    }

    private void showMyTweet(User user) {
        TweetOperations tweetOperations = new TweetOperations();
        tweetOperations.showUserTweets(user);
        System.out.print("Enter tweet id or enter 0 for exit: ");
        Long id = validation.validNumber(scanner.next());
        if (id == 0)
            return;
        if (tweetOperations.isTweetForUser(user, id)) {
            System.out.print("Edit or Delete? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("edit")) {
                System.out.print("Enter new message: ");
                scanner.nextLine();
                String message = scanner.nextLine();
                tweetOperations.editTweet(id, message);
            } else if (op.equalsIgnoreCase("delete")) {
                tweetOperations.deleteTweet(id);
            } else {
                System.out.println("Wrong operation.");
            }
        } else {
            System.out.println("You have not tweet with this id");
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
