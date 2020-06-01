package ru.ezhov.dddexception.user.domain.model;

public class NewUser {
    private final UserGuid userGuid;
    private final NewUsername newUsername;

    private NewUser(UserGuid userGuid, NewUsername newUsername) {
        this.userGuid = userGuid;
        this.newUsername = newUsername;
    }

    public static NewUser create(UserGuid userGuid, NewUsername newUsername) {
        return new NewUser(userGuid, newUsername);
    }

    public UserGuid guid() {
        return userGuid;
    }

    public NewUsername username() {
        return newUsername;
    }
}
