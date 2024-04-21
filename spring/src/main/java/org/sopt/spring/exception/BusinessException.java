package org.sopt.spring.exception;

import org.sopt.spring.common.dto.ErrorMessage;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
