package main.java.bank_account;

public class Main {
    public static void main(String[] args) {
        System.out.println("All users:");
        UserAccount nikita = new UserAccount("Nikita", "+79631233172", 10000);
        UserAccount danil1 = new UserAccount("Danil", "+79178996899", 8000);
        UserAccount danil2 = new UserAccount("Danil", "+79378893213", 5000); // нужен для демонстрации работы выбора по имени

        //Перевод денежных средств и последующая информация об аккаунтах пользователей:
        nikita.transfer(danil1, 3500); //Никита дал в долг Данилу 3500
        nikita.infoOfUser();
        danil1.infoOfUser();

        System.out.println("///");

        //Поиск аккаунтов по различным критериям и перевод долга в размере 3500 обратно Никите:
        UserAccount.findUser("Danil").transfer(UserAccount.findUser(0), 3500);
        // После запроса ввести айди, находим по балансу того Данила, кто у нас занимал 3500, вводим его айди, т.е.
        // единицу, в консоль. Данил вернул долг Никите)
        nikita.infoOfUser();
        danil1.infoOfUser();
    }
}
