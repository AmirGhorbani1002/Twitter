package menu;

import exception.InvalidNameException;
import exception.InvalidPasswordException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    private final Scanner input = new Scanner(System.in);

    public Integer giveIntegerInput() {
        int inputNumber;
        while (true) {
            try {
                inputNumber = input.nextInt();
                input.nextLine();
                return inputNumber;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print("Just enter number please:");
            }
        }
    }

    public String setFullName(){
        String fullName;
        while(true){
            System.out.print("Enter name(just alpha):");
            try {
                fullName = input.nextLine();
                checkName(fullName);
                return fullName;
            }catch (InvalidNameException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void checkName(String name){
        if(name.length() < 3 )
            throw new InvalidNameException("name should be more than 2 character!");
        for (Character ch:name.toCharArray()
        ) {
            if(Character.isDigit(ch))
                throw new InvalidNameException("name can not have number!");
        }
        for (Character ch:name.toCharArray()
        ) {
            if(!Character.isAlphabetic(ch))
                throw new InvalidNameException("name can't have Sign(!,@,#,%,...)");
        }
    }

    public String setPassword(){
        String password;
        while(true) {
            System.out.print("Enter your password:");
            try {
                password = input.nextLine();
                passwordCheck(password);
                return password;
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void passwordCheck(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,10}$";
        if(!password.matches(passwordRegex))
            throw new InvalidPasswordException("پسورد درست وارد کن");
    }
}
