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
        System.out.println(infoOfUser(this));
    }

    public void infoOfUser() {
        System.out.println("Info of User: \n" + infoOfUser(this));
    }

    public void transfer(UserAccount transferTo, int sumOfMoneyToTransfer) {
        System.out.println("Command: Attempting to transfer money from account ID: " + this.userId + " to account ID: " + transferTo.userId);
        if (this.deposit <= 0 || sumOfMoneyToTransfer > this.deposit) {
            System.out.println("Error. Not enough money for a transfer.");
        } else {
            transferTo.deposit = transferTo.deposit + sumOfMoneyToTransfer;
            this.deposit = this.deposit - sumOfMoneyToTransfer;
            System.out.println("The transfer was successful.");
        }
    }

    public static String infoOfUser(UserAccount user) {
        return "  Id: " + user.userId + "; Name: " + user.userName + "; Phone number: " + user.userPhone + "; Deposit: " + user.deposit + ".";
    }

    public static UserAccount findUser(int userId) {
        try {
            System.out.println("Command: Trying to find user by userID: " + userId);
            System.out.println("User found:\n" + infoOfUser(users.get(userId)));
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
            System.out.println("1 search match by \"" + userName + "\": \n" + infoOfUser(foundList.get(0)));
            return foundList.get(0);
        } else {
            System.out.println("Error. Several matches were found. Information about all matches is displayed. Please find a user by his ID.");
            for (UserAccount user : foundList) {
                System.out.println(infoOfUser(user));
            }
            Scanner in = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Input a userID: ");
                    int selectedID = in.nextInt();
                    System.out.println("Selected user:\n" + infoOfUser(users.get(selectedID)));
                    return users.get(selectedID);
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Choose an id from the list!");
                }
            }
        }
    }


}
