package ru.ezhov.dddexception.user.domain.model;

public class NewUsernameException extends Exception {
    private final String businessMessage;

    NewUsernameException(String businessMessage, String detailMessage) {
        super(detailMessage);
        this.businessMessage = businessMessage;
    }

    public String businessMessage() {
        return businessMessage;
    }
}
