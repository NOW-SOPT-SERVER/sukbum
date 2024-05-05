package sopt.carrot.product.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.carrot.common.BaseTimeEntity;
import sopt.carrot.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int price;
    private String description;
    private String location;
    private boolean isSell;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Product(String title, int price, String description, String location, Member member, TransactionMethod transactionMethod) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.location = location;
        this.isSell = false;
        this.member = member;
        this.transactionMethod = transactionMethod;
    }

    public static Product create(String title, int price, String description, String location, Member member, TransactionMethod transactionMethod) {
        return Product.builder()
                .title(title)
                .price(price)
                .description(description)
                .location(location)
                .member(member)
                .transactionMethod(transactionMethod)
                .build();
    }
}
