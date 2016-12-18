package frompythontojava.exercise3.transaction;

import frompythontojava.exercise3.exceptions.Cancelled;
import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Account;
import frompythontojava.exercise3.model.Receipt;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Deposit extends Transaction {
    private Account from;

    public Deposit(Account from, float amount, Currency currency) {
        super(amount, currency);
        this.from = from;
    }

    public Receipt complete() throws Cancelled {
        try {
            from.increase(getAmount(), getCurrency());
        } catch (InvalidCurrency invalidCurrency) {
            throw new Cancelled("Invalid currency");
        }

        return makeReceipt();
    }

    private Receipt makeReceipt() {
        Receipt receipt = new Receipt();
        receipt.addDetails("#deposit#");
        receipt.addDetails("Amount: " + getAmount());
        receipt.addDetails("Currency: " + getCurrency());
        receipt.addDetails("New balance: " + from.getBalance());
        return receipt;
    }
}
