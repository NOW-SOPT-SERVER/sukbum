package sopt.carrot.like.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.carrot.member.domain.Member;
import sopt.carrot.product.domain.Product;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "Likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    private Like(Member member, Product product) {
        this.member = member;
        this.product = product;
    }

    public static Like create(Member member, Product product) {
        return Like.builder()
                .member(member)
                .product(product)
                .build();
    }
}
