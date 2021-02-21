package by.belstu.cherniavsky.main;

import by.belstu.cherniavsky.banks.Belarusbank;
import by.belstu.cherniavsky.banks.Priorbank;
import by.belstu.cherniavsky.users.Admin;
import by.belstu.cherniavsky.users.Client;

public class Main {

    public static void main(String[] args) {

        Priorbank priorbank = new Priorbank("1113-3332-3112-3411", "23-32-12");
        Belarusbank belarusbank = new Belarusbank("1324-1515-2312-5122", "44-41-11");

        Client user1 = new Client("Eugeny", "Cherniavsky", "+375297606925", 2002);
        Admin  user2 = new Admin("Sabina", "Glinskaya", "+375293144231", 2001);
        Client user3 = new Client("Vladimir", "Stankevich", "+375294111223", 2002);
        Client user4 = new Client("Kirill", "Synkevich", "+375294111423", 2002);

        priorbank.add(user1);
        priorbank.add(user2);
        priorbank.add(user3);

        priorbank.setAdmin(user1);
        priorbank.setAdmin(user2);

        priorbank.createCard(user4,"1111 4144 1212 4123");
        priorbank.createCard(user1,"1111 4144 1212 4123");
        belarusbank.createCard(user1, "4141 4141 4141 4141");

        System.out.println(user1.card.getBalance());
        belarusbank.addBalance(user1.card, 23);
        priorbank.addBalance(user1.card, 99);
        System.out.println(user1.card.getBalance());

        //priorbank.showMembers();
    }
}
