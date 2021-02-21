package by.belstu.cherniavsky.cards;

public class Card {

    public String cardNumber;
    private String bankNumber;
    private String adminKey;
    private int balance;
    private boolean isLocked = false;

    // TODO изменить лок карточки
    public void setLocked(boolean locked, String adminKey) {
        if(this.adminKey == adminKey)
            isLocked = locked;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance, String bankNumber) {
        if(this.bankNumber == bankNumber)
            this.balance = balance;
    }

    public Card(String cardNumber, String bankNumber, String adminKey) {
        this.cardNumber = cardNumber;
        this.bankNumber = bankNumber;
        this.adminKey = adminKey;
    }
}
