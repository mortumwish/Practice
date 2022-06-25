package main.java.bank_account;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserAccount {
    public String userName;
    public String userPhone;
    public int userId;
    public int deposit;
    public static int numberOfUsers = 0;
    public static ArrayList<UserAccount> users = new ArrayList<>();

    UserAccount(String userName, String userPhone, int deposit) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.deposit = deposit;
        this.userId = numberOfUsers;
        users.add(this);
        numberOfUsers++;
        infoOfUser();
    }

    public void infoOfUser() {
        System.out.println("Info of User: \n  Id: " + this.userId + "; Name: " + this.userName + "; Phone number: " + this.userPhone + "; Deposit: " + this.deposit + ".");
    }

    public void transfer(UserAccount transferTo, int sumOfMoneyToTransfer) {
        System.out.println("Command: Attempting to transfer money from account ID: " + this.userId + " (" + this.userName + ")"
                                                                + " to account ID: " + transferTo.userId + " (" + transferTo.userName + ")");
        if (this.deposit <= 0 || sumOfMoneyToTransfer > this.deposit) {
            System.out.println("Error. Not enough money for a transfer.");
        } else {
            transferTo.deposit = transferTo.deposit + sumOfMoneyToTransfer;
            this.deposit = this.deposit - sumOfMoneyToTransfer;
            System.out.println("The transfer was successful.");
        }
    }

    public static UserAccount findUser(int userId) {
        try {
            System.out.println("Command: Trying to find user by userID: " + userId);
            System.out.println("User found successfully");
            return users.get(userId);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("There is no user with this id");
            return null;
        }
    }

    public static UserAccount findUser(String userName) {
        System.out.println("Command: Searching user by " + "\"" + userName + "\"");
        ArrayList<UserAccount> foundList = new ArrayList<>();
        for (UserAccount currentUser : users) {
            if (Objects.equals(currentUser.userName, userName)) {
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
            for (UserAccount user : foundList) {
                System.out.println("  Id: " + user.userId + "; Name: " + user.userName + "; Phone number: " + user.userPhone + "; Deposit: " + user.deposit + ".");
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
}