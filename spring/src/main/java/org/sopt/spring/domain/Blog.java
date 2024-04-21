package org.sopt.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.spring.service.dto.BlogCreateRequest;
import org.sopt.spring.service.dto.BlogTitleUpdateRequest;
import org.springframework.context.annotation.Configuration;

@Entity
@Getter
@NoArgsConstructor

public class Blog extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    private Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(Member member, BlogCreateRequest blogCreateRequest) {
        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
    }
    public void updateBlogTitle(BlogTitleUpdateRequest blogTitleUpdateRequest){
        this.title = blogTitleUpdateRequest.title();
    }
}
