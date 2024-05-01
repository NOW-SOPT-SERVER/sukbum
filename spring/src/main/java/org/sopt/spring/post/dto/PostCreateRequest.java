package org.sopt.spring.post.dto;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequest(
    String title,
    @NotBlank(message = "내용을 반드시 입력해야 합니다.")
    String content
) {
}
