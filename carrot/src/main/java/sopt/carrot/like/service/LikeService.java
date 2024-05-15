package sopt.carrot.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.common.exception.ErrorMessage;
import sopt.carrot.common.exception.NotFoundException;
import sopt.carrot.like.domain.Like;
import sopt.carrot.like.repository.LikeRepository;
import sopt.carrot.member.domain.Member;
import sopt.carrot.member.repository.MemberRepository;
import sopt.carrot.product.domain.Product;
import sopt.carrot.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void create(Long memberId, Long productId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
                );
        Product product = productRepository.findById(productId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_LOCATION_EXCEPTION)
                );
        likeRepository.save(Like.create(member, product));
    }
}
