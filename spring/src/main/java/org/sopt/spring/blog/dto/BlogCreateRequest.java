package org.sopt.spring.blog.dto;

public record BlogCreateRequest(
        String title,
        String description
) {
}
