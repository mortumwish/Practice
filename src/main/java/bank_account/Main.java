package main.java.bank_account;

public class Main {
    public static void main(String[] args) {
        User nikita = new User("Nikita", "+79532435543", 10000);
        User danil1 = new User("Danil", "+788005553535", 8000);
        User danil2 = new User("Danil", "+79378893213", 5000); // нужен для демонстрации работы выбора по имени

        User.findUsersByName("Danil").transfer(User.findUserById(0), 3500);

    }
}
