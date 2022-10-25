package util;

import entity.user.User;
import menu.UserMenu;
import repository.user.impl.UserRepositoryImpl;
import service.user.UserService;
import service.user.impl.UserServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class Validation {

    private final Scanner scanner = new Scanner(System.in);

    public void loginMenu() {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManager()));
        Optional<User> optionalUser = userService.findUser(username, password);
        optionalUser.ifPresentOrElse(user -> {
            UserMenu userMenu = new UserMenu();
            userMenu.showMenu(user);
        }, () -> System.out.println("Wrong information"));
    }

    public void signupMenu() {
        System.out.print("Enter your firstname: ");
        String firstname = scanner.next();
        System.out.print("Enter your lastname: ");
        String lastname = scanner.next();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManager()));
        User user = new User(firstname, lastname, username, password);
        userService.save(user);
    }

    public Long validNumber(String number){
        long value = 0;
        try {
            value = Long.parseLong(number);
        }catch (Exception e){
            System.out.println("Wrong number input.");
            validNumber(scanner.next());
        }
        if(value < 0){
            System.out.println("number cant be negative");
            validNumber(scanner.next());
        }
        return value;
    }

}
