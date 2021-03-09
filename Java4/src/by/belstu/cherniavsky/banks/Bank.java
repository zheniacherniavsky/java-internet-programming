package by.belstu.cherniavsky.banks;

import by.belstu.cherniavsky.cards.Card;
import by.belstu.cherniavsky.users.Client;
import by.belstu.cherniavsky.users.User;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Абстрактный класс банка.
 * Хранит в себе индивидуальный счёт банка, массив клиентов банка
 */
public abstract class Bank {

    /** Зарегистрированные банковские системы
     * Служит для добавления информации о созданных банках
     */
    protected static ArrayList<Bank> banks = new ArrayList<>();

    protected final static Logger log4jLogger = LogManager.getLogger(Bank.class);

    /** Уникальный код администратора
     * Присваивается администраторам банка для получения доступа к системе
     */
    public String adminCode;
    String number; // индивидуальный счёт банка
    ArrayList<User> members; // клиенты банка

    public String getNumber() {
        return number;
    }

    /** Конструктор банка
     * @param number индивидуальный счёт банка
     * @param adminKey уникальный код администратора
     */
    public Bank(String number, String adminKey) {
        members = new ArrayList<User>();
        this.number = number;
        this.adminCode = adminKey;
    }

    /** Вывод клиентов банка */
    public void showMembers()
    {
        if(members.isEmpty()) System.out.println("Пусто");
        else
        {
            for(User c: members)
            {
                System.out.println(c);
            }
        }
        log4jLogger.info("Просмотр клиентов банка");
    }

    public void setAdmin(User user)
    {
        if(user.isAdmin && members.contains(user))
        {
            user.adminKey = this.adminCode;
            System.out.println(String.format("Пользователь с id:%d назначен администратором.",
                    user.getId()));
            log4jLogger.info(String.format("Пользователь с id:%d назначен администратором.", user.getId()));
        }
        else System.out.println("Этот пользователь не имеет админ прав!");
    }

    public void createCard(Client client, String cardNumber)
    {
        if(this.getClientById(client.getId()) != null)
        {
            client.card = new Card(cardNumber, this.number, this.adminCode);
            System.out.println("Карта была создана.");
            log4jLogger.info("Была создана карточка для клиента с id: " + client.getId());
        }
        else System.out.println("Данного клиента нет в базе данных банка!");
    }

    public void addBalance(Card card, int sum) {
        if(card.getBankNumber() == number)
        {
            card.addBalance(sum, number);
            log4jLogger.info("На карту " + card.cardNumber + " было зачислено " + sum);
        }
        else System.out.println("Нет прав для добавления денежных средств на карту");
    }

    /** Получить клиента банка по ID
     * @param id идентификатор для поиска клиента банка
     * @return объект клиента, если нашёл совпадение по идентификатору
     */
    public Client getClientById(int id)
    {
        for (User c:members) {
            if(c.getId() == id && c.isAdmin == false) return (Client)c;
        }
        return null;
    }

    /** Получить пользователя банка по ID (Клиент, админ)
     * @param id идентификатор для поиска пользователя банка
     * @return объект пользователя, если нашёл совпадение по идентификатору
     */
    public User getUserById(int id)
    {
        for (User c:members) {
            if(c.getId() == id) return c;
        }
        return null;
    }

    /** Добавление нового клиента в банковскую систему
     * @param user Пользователь, которого нужно зарегистрировать
     */
    public abstract void add(User user);

    /** Удаление клиента из банковской системы
     * @param user Пользователь, которого нужно удалить
     */
    public abstract void remove(User user);
}
