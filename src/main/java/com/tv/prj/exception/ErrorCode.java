package com.tv.prj.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_MESSAGE(1001, "Invalid key message"),
    USER_EXISTED(1002, "User existed"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    USER_NOT_FOUND(1005, "User not found"),
    UNAUTHENTICATED(1006, "Unauthenticated!")
    ;
    private final int code;
    private final String message;

}
