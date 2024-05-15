package org.sopt.spring.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.spring.common.BaseTimeEntity;
import org.sopt.spring.blog.dto.BlogCreateRequest;
import org.sopt.spring.blog.dto.BlogTitleUpdateRequest;
import org.sopt.spring.member.domain.Member;
import org.sopt.spring.post.domain.Post;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor

public class Blog extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    private String description;

    @OneToMany(mappedBy = "blog")
    private List<Post> posts = new ArrayList<>();

    @OneToOne(mappedBy = "blog")
    private Member member;

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

    public void addPost(Post post) {
        posts.add(post);
    }
}
