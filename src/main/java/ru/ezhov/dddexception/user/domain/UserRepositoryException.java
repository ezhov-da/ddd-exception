package ru.ezhov.dddexception.user.domain;

public class UserRepositoryException extends Exception {
    private final String businessMessage;

    UserRepositoryException(String businessMessage, String detailMessage) {
        super(detailMessage);
        this.businessMessage = businessMessage;
    }

    public String businessMessage() {
        return businessMessage;
    }
}
