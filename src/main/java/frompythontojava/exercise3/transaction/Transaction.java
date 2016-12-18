package frompythontojava.exercise3.transaction;

import frompythontojava.exercise3.exceptions.Cancelled;
import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Receipt;

import java.util.Currency;
import java.util.UUID;

/**
 * Created by Cerianth on 2016.12.18..
 */
public abstract class Transaction {
    private UUID id;
    private float amount;
    private Currency currency;

    {
        id = UUID.randomUUID();
    }

    Transaction(float amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    float getAmount() {
        return amount;
    }

    Currency getCurrency() {
        return currency;
    }

    abstract Receipt complete() throws Cancelled;

    @Override
    public String toString() {
        return "\n<<<<<<<<<<<<<<<\nTransaction\n" +
                "id: " + id + "\n" +
                "amount: " + amount + "\n" +
                "currency: " + currency +
                "\n>>>>>>>>>>>>>>>";
    }
}
