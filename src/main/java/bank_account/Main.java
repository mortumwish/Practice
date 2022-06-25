package main.java.bank_account;

public class Main {
    public static void main(String[] args) {
        System.out.println("All users:");
        UserAccount nikita = new UserAccount("Nikita", "+79631233172", 10000);
        UserAccount danil1 = new UserAccount("Danil", "+79178996899", 8000);
        UserAccount danil2 = new UserAccount("Danil", "+79378893213", 5000);

        //Перевод денежных средств и последующая информация об аккаунтах пользователей:
        nikita.transfer(danil1, 3500); //Никита дал в долг Данилу 3500
        nikita.infoOfUser();
        danil1.infoOfUser();

        System.out.println("///");

        //Попытка поиска аккаунтов по различным критериям:
        UserAccount.findUser(0).infoOfUser();
        UserAccount.findUser("Danil").infoOfUser();
        UserAccount.findUser("Danil").transfer(UserAccount.findUser("Nikita"), 3500);

                                                                                             //После запроса ввести айди,
                                                                                             // находим по балансу того Данила, кто у нас занимал
                                                                                             // 3500. Данил вернул долг Никите)
        nikita.infoOfUser();
        danil1.infoOfUser();
    }
}
