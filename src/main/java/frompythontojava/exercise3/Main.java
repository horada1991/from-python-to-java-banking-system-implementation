package frompythontojava.exercise3;

import frompythontojava.exercise3.exceptions.InvalidCurrency;
import frompythontojava.exercise3.model.Account;
import frompythontojava.exercise3.model.User;

import java.util.Currency;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user);

        Account account = new Account(user, "1", Currency.getInstance("HUF"));
        System.out.println(account);

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
    }
}
