package frompythontojava.exercise3.transaction;

import frompythontojava.exercise3.exceptions.Cancelled;
import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Account;
import frompythontojava.exercise3.model.Receipt;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Transfer extends Transaction {
    private Account from;
    private Account to;

    public Transfer(Account from, Account to, float amount, Currency currency) {
        super(amount, currency);
        this.from = from;
        this.to = to;
    }

    public Receipt complete() throws Cancelled{
        if (from.getBalance() < getAmount()) throw new Cancelled("Not enough money on the source account");
        if (!from.getCurrency().equals(to.getCurrency())) throw new Cancelled("Not the same currency on both accounts");

        try {
            makeTransfer();
        } catch (InvalidCurrency invalidCurrency) {
            throw new Cancelled("Not valid currency");
        }
        return makeReceipt();
    }

    private void makeTransfer() throws InvalidCurrency {
        from.decrease(getAmount(), getCurrency());
        to.increase(getAmount(), getCurrency());
    }

    private Receipt makeReceipt() {
        Receipt receipt = new Receipt();
        receipt.addDetails("From: " + from.getUser().getId() + "; account number: " + from.getAccountNumber());
        receipt.addDetails("To: " + to.getUser().getId() + "; account number: " + to.getAccountNumber());
        receipt.addDetails("Amount: " + getAmount());
        receipt.addDetails("Currency: " + getCurrency());
        receipt.addDetails("New balance: " + from.getBalance());
        return receipt;
    }
}
