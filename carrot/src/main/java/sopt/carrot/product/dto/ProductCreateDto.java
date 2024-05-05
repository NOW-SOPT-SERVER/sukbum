package sopt.carrot.product.dto;

import sopt.carrot.product.domain.TransactionMethod;

public record ProductCreateDto(
        String title,
        int price,
        String description,
        String location,
        TransactionMethod transactionMethod
) {
}
