package by.belstu.cherniavsky.users;

import by.belstu.cherniavsky.banks.Bank;

public class Admin extends User {

    public Admin(String name, String lastname, String phone, int birthday) {
        super(name, lastname, phone, birthday, true);
    }

    public void AddMember(Bank bank, Client client)
    {
        if(bank.adminCode == this.adminKey) bank.add(client);
        else System.out.println("Не хватает прав для добавления клиента");
    }

    public void RemoveMember(Bank bank, Client client)
    {
        if(bank.adminCode == this.adminKey) bank.remove(client);
        else System.out.println("Не хватает прав для удаления клиента");
    }
}
