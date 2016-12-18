package frompythontojava.exercise3.transaction;

import frompythontojava.exercise3.exceptions.Cancelled;
import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Account;
import frompythontojava.exercise3.model.Receipt;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Withdrawal extends Transaction {
    private Account from;

    public Withdrawal(Account from, float amount, Currency currency) {
        super(amount, currency);
        this.from = from;
    }

    public Receipt complete() throws Cancelled {
        if (from.getBalance() < getAmount()) throw new Cancelled("Not enough money on the source account");

        try {
            from.decrease(getAmount(), getCurrency());
        } catch (InvalidCurrency invalidCurrency) {
            throw new Cancelled("Not valid currency");
        }

        return makeReceipt();
    }

    private Receipt makeReceipt() {
        Receipt receipt = new Receipt();
        receipt.addDetails("#withdrawal#");
        receipt.addDetails("Amount: " + getAmount());
        receipt.addDetails("Currency: " + getCurrency());
        receipt.addDetails("New balance: " + from.getBalance());
        return receipt;
    }
}
