package sopt.carrot.common.success;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {
    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED.value(), "회원 생성이 완료되었습니다"),
    PRODUCT_CREATE_SUCCESS(HttpStatus.CREATED.value(), "상품 등록이 완료되었습니다"),
    PRODUCTS_READ_SUCCESS(HttpStatus.OK.value(), "성공적으로 지역별 상품을 불러왔습니다."),
    LIKE_CREATE_SUCCESS(HttpStatus.OK.value(), "좋아요가 성공적으로 등록되었습니다."),
    ;
    private final int status;
    private final String message;
}
