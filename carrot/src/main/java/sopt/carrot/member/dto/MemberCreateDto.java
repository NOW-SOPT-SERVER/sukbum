package sopt.carrot.member.dto;

public record MemberCreateDto(
        String name,
        String phoneNumber,
        String location
) {
}
