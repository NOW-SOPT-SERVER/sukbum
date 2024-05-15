package sopt.carrot.Domain.Dto;

import sopt.carrot.Domain.TransactionMethod;

public record ProductCreateDto(
        String title,
        int price,
        String description,
        String location,
        TransactionMethod transactionMethod
) {
}
