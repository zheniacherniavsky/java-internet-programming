package by.belstu.cherniavsky.banks;

import by.belstu.cherniavsky.users.User;

/** Банк: Беларусбанк
 * Наследуется от абстрактного класса Bank()
 * @see by.belstu.cherniavsky.banks.Bank
 */
public class Belarusbank extends Bank {

    private int id = 1;

    public Belarusbank(String number, String adminKey) {
        super(number, adminKey);
        banks.add(this); // добавляем банк
    }

    @Override
    public void add(User user) {
        if(user == null) return;

        user.setId(id);
        members.add(user);
        id++;
    }

    @Override
    public void remove(User user) {
        if(user == null) return;

        user.setId(-1);
        members.remove(user);
    }
}
