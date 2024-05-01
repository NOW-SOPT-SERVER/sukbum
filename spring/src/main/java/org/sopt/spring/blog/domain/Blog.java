package org.sopt.spring.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.spring.domain.BaseTimeEntity;
import org.sopt.spring.member.domain.Member;
import org.sopt.spring.blog.dto.BlogCreateRequest;
import org.sopt.spring.blog.dto.BlogTitleUpdateRequest;
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

    private Long member_Id;

    @Column(length = 200)
    private String title;

    private String description;

    @OneToMany
    private List<Post> posts = new ArrayList<>();

    private Blog(Long member_Id, String title, String description) {
        this.member_Id = member_Id;
        this.title = title;
        this.description = description;
    }

    public static Blog create(Long member_Id, BlogCreateRequest blogCreateRequest) {
        return new Blog(member_Id, blogCreateRequest.title(), blogCreateRequest.description());
    }
    public void updateBlogTitle(BlogTitleUpdateRequest blogTitleUpdateRequest){
        this.title = blogTitleUpdateRequest.title();
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
