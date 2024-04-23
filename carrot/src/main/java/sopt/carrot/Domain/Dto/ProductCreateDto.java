package sopt.carrot.Domain.Dto;

public record ProductCreateDto(
        String title,
        int price,
        String description,
        String location
) {
}
