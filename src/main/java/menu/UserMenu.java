package menu;

import entity.user.User;

import java.util.Objects;
import java.util.Scanner;

public class UserMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(User user) {
        while (true) {
            System.out.println("Welcome " + user.getUsername());
            System.out.println("1- Tweet");
            System.out.println("2- User information");
            System.out.println("3- Exit");
            System.out.print("Enter your command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                TweetMenu tweetMenu = new TweetMenu();
                tweetMenu.showMenu(user);
            } else if (Objects.equals(command, "2")) {

            } else if ((Objects.equals(command, "3"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }
        }
    }

}
