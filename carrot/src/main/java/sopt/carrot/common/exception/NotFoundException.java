package sopt.carrot.common.exception;

import sopt.carrot.common.exception.BusinessException;
import sopt.carrot.common.exception.Message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
