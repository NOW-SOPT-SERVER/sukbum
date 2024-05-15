package sopt.carrot.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessgae());
        this.errorMessage = errorMessage;
    }
}
