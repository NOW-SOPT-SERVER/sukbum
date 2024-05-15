package sopt.carrot.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    PRODUCT_NOT_FOUND_BY_LOCATION_EXCEPTION(HttpStatus.NOT_FOUND.value(), "해당하는 지역에 등록된 상품이 없습니다.")
    ;
    private final int status;
    private final String messgae;
}
