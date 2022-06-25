package main.java.bank_account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Bank {
    protected static List<UserAccount> users = new ArrayList<>();

    public static UserAccount findUserById(int userId) {
        try {
            System.out.println("Command: Trying to find user by userID: " + userId);
            UserAccount foundUser = users.get(userId);
            System.out.println("User found successfully");
            return foundUser;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("There is no user with this id");
            return null;
        }
    }

    public static UserAccount findUsersByName(String userName) {
        System.out.println("Command: Searching user by " + "\"" + userName + "\"");
        ArrayList<UserAccount> foundList = new ArrayList<>();
        for (UserAccount currentUser : users) {
            if (Objects.equals(currentUser.name, userName)) {
                foundList.add(currentUser);
            }
        }
        if (foundList.size() == 0) {
            System.out.println("No Matches");
            return null;
        } else if (foundList.size() == 1) {
            System.out.println("1 search match by \"" + userName + "\". The search was successful.");
            return foundList.get(0);
        } else {
            System.out.println("Error. Several matches were found. Information about all matches is displayed. Please find a user by his ID.");
            return getUserByIdFromScanner(foundList);
        }
    }

    public static UserAccount getUserByIdFromScanner(ArrayList<UserAccount> foundList) {
        for (UserAccount user : foundList) {
            System.out.println("  Id: " + user.id + "; Name: " + user.name + "; Phone number: " + user.phone + "; Deposit: " + user.deposit + ".");
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Input a userID: ");
                return users.get(in.nextInt());
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Choose an id from the list!");
            }
        }
    }
}


class UserAccount extends Bank {
    int id;
    String phone;
    String name;
    int deposit;

    UserAccount(String userName, String userPhone, int deposit) {
        this.id = users.size();
        this.phone = userPhone;
        this.name = userName;
        this.deposit = deposit;
        users.add(this);
    }

    public void showUserInfo() {
        System.out.println("Info of User: \n  Id: " + this.id + "; Name: " + this.name + "; Phone number: " + this.phone + "; Deposit: " + this.deposit + ".");
    }

    public void transfer(UserAccount transferTo, int sumOfMoneyToTransfer) {
        System.out.println("Command: Attempting to transfer money from account ID: " + this.id + " (" + this.name + ")"
                + " to account ID: " + transferTo.id + " (" + transferTo.name + ")");
        if (this.deposit <= 0 || sumOfMoneyToTransfer > this.deposit) {
            System.out.println("Error. Not enough money for a transfer.");
        } else {
            transferTo.deposit += sumOfMoneyToTransfer;
            this.deposit -= sumOfMoneyToTransfer;
            System.out.println("The transfer was successful.");
        }
    }
}