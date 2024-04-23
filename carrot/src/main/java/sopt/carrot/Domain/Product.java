package sopt.carrot.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int price;
    private String description;
    private String location;
    private boolean isSell;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Product(String title, int price, String description, String location, Member member) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.location = location;
        this.isSell = false;
        this.member = member;
    }

    public static Product create(String title, int price, String description, String location, Member member) {
        return Product.builder()
                .title(title)
                .price(price)
                .description(description)
                .location(location)
                .member(member)
                .build();
    }
}
