package menu;

import entity.user.User;
import util.Validation;

import java.util.Objects;
import java.util.Scanner;

public class InformationMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(User user) {
        while (true) {
            System.out.println("1- Change username");
            System.out.println("2- Change password");
            System.out.println("3- Exit");
            System.out.print("Enter your command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                System.out.print("Enter your new username: ");
                Validation validation = new Validation();
                validation.changeUsername(user);
            } else if (Objects.equals(command, "2")) {
                System.out.print("Enter your old password: ");
                Validation validation = new Validation();
                validation.changePassword(user);
            } else if (Objects.equals(command, "3")) {
                break;
            } else {

            }
        }
    }

}
