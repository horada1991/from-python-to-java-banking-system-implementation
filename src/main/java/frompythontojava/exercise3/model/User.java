package frompythontojava.exercise3.model;

import java.util.UUID;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class User {
    private UUID id;

    {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n<<<<<<<<<<<<<<<\nUser\n" +
                " id: " + id.toString() +
               "\n>>>>>>>>>>>>>>>";
    }
}
