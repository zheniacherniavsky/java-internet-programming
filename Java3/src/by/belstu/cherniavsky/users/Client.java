package by.belstu.cherniavsky.users;

import by.belstu.cherniavsky.cards.Card;

public class Client extends User{

    public Card card;

    public void lockCard()
    {

    }

    public Client(String name, String lastname, String phone, int birthday) {
        super(name, lastname, phone, birthday, false);
    }
}
