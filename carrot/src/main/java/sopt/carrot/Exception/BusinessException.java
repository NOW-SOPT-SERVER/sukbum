package sopt.carrot.Exception;

import lombok.Getter;
import sopt.carrot.Exception.Message.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessgae());
        this.errorMessage = errorMessage;
    }
}
