package main.java.bank_account;

public class Main {
    public static void main(String[] args) {
        UserAccount nikita = new UserAccount("Nikita", "+79532435543", 10000);
        UserAccount danil1 = new UserAccount("Danil", "+788005553535", 8000);
        UserAccount danil2 = new UserAccount("Danil", "+79378893213", 5000); // нужен для демонстрации работы выбора по имени

        UserAccount.findUsersByName("Danil").transfer(UserAccount.findUserById(0), 3500);
    }
}
