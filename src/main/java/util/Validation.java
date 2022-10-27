package util;

import entity.user.User;
import menu.UserMenu;
import repository.user.impl.UserRepositoryImpl;
import service.user.UserService;
import service.user.impl.UserServiceImpl;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Validation {

    private final Scanner scanner = new Scanner(System.in);

    public void loginMenu() {
        System.out.print("Enter your username: ");
        String username = validName(scanner.next());
        System.out.print("Enter your password: ");
        String password = scanner.next();
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        Optional<User> optionalUser = userService.findUser(username, password);
        optionalUser.ifPresentOrElse(user -> {
            UserMenu userMenu = new UserMenu();
            userMenu.showMenu(user);
        }, () -> System.out.println("Wrong information"));
    }

    public void signupMenu() {
        System.out.print("Enter your firstname: ");
        String firstname = validName(scanner.next());
        System.out.print("Enter your lastname: ");
        String lastname = validName(scanner.next());
        System.out.print("Enter your username: ");
        String username = checkExistUsername(validName(scanner.next()));
        System.out.print("Enter your password: ");
        String password = scanner.next();
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        User user = new User(firstname, lastname, username, password);
        userService.save(user);
    }

    public Long validNumber(String number) {
        long value;
        while (true) {
            try {
                value = Long.parseLong(number);
                if (value < 0) {
                    System.out.println("number cant be negative");
                    number = scanner.next();
                    continue;
                }
            } catch (Exception e) {
                System.out.print("Wrong number input. Enter again: ");
                number = scanner.next();
                continue;
            }
            break;
        }
        System.out.println(value);
        return value;
    }

    public void changeUsername(User user){
        String username = checkExistUsername(validName(scanner.next()));
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        user.setUsername(username);
        userService.update(user);
    }

    public void changePassword(User user){
        while (true){
            String oldPassword = scanner.next();
            if(Objects.equals(user.getPassword(), oldPassword)){
                System.out.print("Enter new password: ");
                String newPassword = scanner.next();
                user.setPassword(newPassword);
                UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
                userService.update(user);
                break;
            } else{
                System.out.print("Wrong old password. Enter again: ");
            }
        }
    }

    private String validName(String name) {
        boolean check;
        while (true) {
            if (name.length() < 3 || name.length() > 15) {
                System.out.print("Name must between 3 and 15 character. Enter again: ");
                name = scanner.next();
                continue;
            }
            check = false;
            for (Character character : name.toCharArray()) {
                if (Character.isDigit(character)) {
                    System.out.print("Name cant have number. Enter again: ");
                    name = scanner.next();
                    check = true;
                    break;
                }
            }
            if (!check) return name;
        }
    }

    private String checkExistUsername(String username) {
        while (true) {
            UserService userService = new UserServiceImpl(new UserRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
            Optional<User> optionalUser = userService.findUser(username);
            if (optionalUser.isPresent()) {
                System.out.print("This username exist. choose another one: ");
                username = scanner.next();
            } else {
                return username;
            }
        }
    }

}
