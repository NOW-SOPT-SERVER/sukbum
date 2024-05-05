package sopt.carrot.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.carrot.common.BaseTimeEntity;
import sopt.carrot.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    List<Product> productList = new ArrayList<>();

    private String location;

    @Builder
    private Member(String name, String phoneNumber, String location){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public static Member create(String name, String phoneNumber, String location) {
        return Member.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .location(location)
                .build();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}
