package sopt.carrot.Exception;

import sopt.carrot.Exception.Message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
