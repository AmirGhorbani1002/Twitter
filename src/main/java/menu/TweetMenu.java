package menu;

import entity.user.User;
import util.TweetOperations;

import java.util.Objects;
import java.util.Scanner;

public class TweetMenu {

    private final Scanner scanner = new Scanner(System.in);

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
                tweetOperations.showOther(user);
            } else if ((Objects.equals(command, "4"))) {
                break;
            }else {
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
