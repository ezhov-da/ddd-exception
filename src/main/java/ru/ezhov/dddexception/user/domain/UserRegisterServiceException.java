package ru.ezhov.dddexception.user.domain;

public class UserRegisterServiceException extends Exception {
    private final String businessMessage;

    UserRegisterServiceException(String businessMessage, String detailMessage) {
        super(detailMessage);
        this.businessMessage = businessMessage;
    }

    public String businessMessage() {
        return businessMessage;
    }
}
