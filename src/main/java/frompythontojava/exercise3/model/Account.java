package frompythontojava.exercise3.model;

import frompythontojava.exercise3.exceptions.InvalidCurrency;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Account {
    private User user;
    private String accountNumber;
    private Currency currency;
    private float balance;

    public Account() {
        super();
    }

    public Account(User user, String accountNumber, Currency currency) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getBalance() {
        return balance;
    }

    public boolean increase(float amount, Currency currency) throws InvalidCurrency {
        if (!currency.equals(this.currency)) throw new InvalidCurrency("Not valid currency");
        this.balance += amount;
        return true;
    }

    public boolean decrease(float amount, Currency currency) throws InvalidCurrency {
        if (!currency.equals(this.currency)) throw new InvalidCurrency("Not valid currency");
        this.balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "\n<<<<<<<<<<<<<<<\nAccount\n" +
                " user: " + user + "\n" +
                " accountNumber: " + accountNumber + "\n" +
                " currency: " + currency + "\n" +
                " balance: " + balance +
                "\n>>>>>>>>>>>>>>>";
    }
}
