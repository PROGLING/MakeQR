package com.progling.MakeQR.error;

public enum ErrorMessage {
    IS_EMPTY("Can Not Found Object"),
    ANOTHER_ERROR_MESSAGE("Another error occurred");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
