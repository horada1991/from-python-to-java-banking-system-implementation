package frompythontojava.exercise3;

import frompythontojava.exercise3.exceptions.Cancelled;
import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Account;
import frompythontojava.exercise3.model.Receipt;
import frompythontojava.exercise3.model.User;
import frompythontojava.exercise3.transaction.Transfer;
import frompythontojava.exercise3.transaction.Withdrawal;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n----------------\nUSER, ACCOUNT");

        User user = new User();
        System.out.println(user);
        Account account = new Account(user, "1", Currency.getInstance("HUF"));
        System.out.println(account);

        System.out.println("\n\n----------------\nINCREASE/DECREASE\n");
        try {
            System.out.println("Increase with valid currency: " + account.increase(20, Currency.getInstance("HUF")));
            System.out.println("Decrease with valid currency: " + account.decrease(10, Currency.getInstance("HUF")));
        } catch (InvalidCurrency invalidCurrency) {
            invalidCurrency.printStackTrace();
        }

        try {
            System.out.println(account.increase(10, Currency.getInstance("USD")));
        } catch (InvalidCurrency invalidCurrency) {
            System.out.println(invalidCurrency);
        }

        try {
            System.out.println(account.decrease(10, Currency.getInstance("USD")));
        } catch (InvalidCurrency invalidCurrency) {
            System.out.println(invalidCurrency);
        }

        System.out.println(account);


        System.out.println("\n\n----------------\nTEST RECEIPT");
        Receipt receipt = new Receipt();
        receipt.addDetails("1st detail");
        receipt.addDetails("2nd detail");
        receipt.addDetails("3rd detail");
        System.out.println(receipt);


        System.out.println("\n\n----------------\nTRANSFERS");
        Account account2 = new Account(user, "2", Currency.getInstance("HUF"));
        Transfer transfer = new Transfer(account, account2, 10, Currency.getInstance("HUF"));
        try {
            System.out.println(transfer.complete());
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }

        // Transfer exceptions:
        try {
            // not enough amount on balance
            // now 0 HUF on balance, after the first transfer on line 56
            transfer.complete();
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }

        // raise balance
        try {
            account.increase(100, Currency.getInstance("HUF"));
        } catch (InvalidCurrency invalidCurrency) {
            invalidCurrency.printStackTrace();
        }

        // not same currency
        Account usdAccount = new Account(user, "3", Currency.getInstance("USD"));
        Transfer transferBadCurrency2 = new Transfer(account, usdAccount, 10, Currency.getInstance("HUF"));
        try {
            transferBadCurrency2.complete();
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }

        // bad given currency
        Transfer transferBadCurrency = new Transfer(account, account2, 10, Currency.getInstance("USD"));
        try {
            transferBadCurrency.complete();
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }


        System.out.println("\n\n----------------\nWITHDRAW");

        Withdrawal withdrawal = new Withdrawal(account, 20, Currency.getInstance("HUF"));
        try {
            System.out.println(withdrawal.complete());
        } catch (Cancelled cancelled) {
            cancelled.printStackTrace();
        }

        // not enough money on account
        Withdrawal withdrawalTooMuchMoney = new Withdrawal(account, 100, Currency.getInstance("HUF"));
        try {
            withdrawalTooMuchMoney.complete();
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }

        // not valid currency
        Withdrawal withdrawalNotValidCurrency = new Withdrawal(account, 20, Currency.getInstance("USD"));
        try {
            withdrawalNotValidCurrency.complete();
        } catch (Cancelled cancelled) {
            System.out.println(cancelled);
        }
    }
}
