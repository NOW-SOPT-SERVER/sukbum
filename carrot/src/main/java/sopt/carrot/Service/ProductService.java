package sopt.carrot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.Domain.Dto.ProductCreateDto;
import sopt.carrot.Domain.Member;
import sopt.carrot.Domain.Product;
import sopt.carrot.Exception.Message.ErrorMessage;
import sopt.carrot.Exception.NotFoundException;
import sopt.carrot.Repository.MemberRepository;
import sopt.carrot.Repository.ProductRepository;

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
                productCreateDto.location(),
                member,
                productCreateDto.transactionMethod());
        member.addProduct(product);
        productRepository.save(product);
        return product.getId().toString();
    }
}
