package ru.ezhov.dddexception.user.domain.model;

public class User {
    private final Username username;
    private final UserGuid guid;

    private User(Username username, UserGuid guid) {
        this.username = username;
        this.guid = guid;
    }

    public static User create(Username username, UserGuid guid) {
        return new User(username, guid);
    }

    public Username username() {
        return username;
    }

    public UserGuid guid() {
        return guid;
    }
}
