package frompythontojava.exercise3.exceptions;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class InvalidCurrency extends Throwable {

    public InvalidCurrency() {
    }

    public InvalidCurrency(String message) {
        super(message);
    }
}
