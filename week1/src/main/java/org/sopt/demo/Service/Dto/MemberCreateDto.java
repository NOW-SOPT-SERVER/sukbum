package org.sopt.demo.Service.Dto;

import org.sopt.demo.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
