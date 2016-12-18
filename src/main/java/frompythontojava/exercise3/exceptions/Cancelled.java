package frompythontojava.exercise3.exceptions;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Cancelled extends Exception {

    public Cancelled() {
    }

    public Cancelled(String message) {
        super(message);
    }
}
