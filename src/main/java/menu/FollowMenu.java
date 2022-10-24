package menu;

import entity.user.User;

import java.util.Objects;
import java.util.Scanner;

public class FollowMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(User user) {
        while (true) {
            System.out.println("1- Show my followers");
            System.out.println("2- Show my following");
            System.out.println("3- Search");
            System.out.println("4- Exit");
            System.out.print("Enter your command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
            } else if (Objects.equals(command, "2")) {
            } else if (Objects.equals(command, "3")) {

            } else if ((Objects.equals(command, "4"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }
        }
    }

}
