package org.sopt.spring.blog.service;

import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.exception.ErrorMessage;
import org.sopt.spring.blog.domain.Blog;
import org.sopt.spring.member.domain.Member;
import org.sopt.spring.common.exception.NotFoundException;
import org.sopt.spring.blog.repository.BlogRepository;
import org.sopt.spring.blog.dto.BlogCreateRequest;
import org.sopt.spring.blog.dto.BlogTitleUpdateRequest;
import org.sopt.spring.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    @Transactional
    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        member.setBlog(blog);
        return blog.getId().toString();
    }
    @Transactional(readOnly = true)
    public Blog findByBlogId(Long blogId){
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND));
    }
    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findByBlogId(blogId);
        blog.updateBlogTitle(blogTitleUpdateRequest);
    }
}
