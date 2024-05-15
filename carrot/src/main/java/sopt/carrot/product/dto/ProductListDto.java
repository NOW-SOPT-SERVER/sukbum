package sopt.carrot.product.dto;
import sopt.carrot.location.domain.Location;
import sopt.carrot.member.domain.Member;
import sopt.carrot.product.domain.TransactionMethod;

public record ProductListDto(
        String title,
        int price,
        String description,
        String location,
        boolean isSell,
        TransactionMethod transactionMethod,
        String memberName
) {
}
