package sopt.carrot.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.product.dto.ProductCreateDto;
import sopt.carrot.member.domain.Member;
import sopt.carrot.product.domain.Product;
import sopt.carrot.common.exception.Message.ErrorMessage;
import sopt.carrot.common.exception.NotFoundException;
import sopt.carrot.member.repository.MemberRepository;
import sopt.carrot.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public String create(Long memberId, ProductCreateDto productCreateDto){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
                );
        Product product = Product.create(productCreateDto.title(),
                productCreateDto.price(),
                productCreateDto.description(),
                member.getLocation(),
                member,
                productCreateDto.transactionMethod());
        member.addProduct(product);
        productRepository.save(product);
        return product.getId().toString();
    }
}
