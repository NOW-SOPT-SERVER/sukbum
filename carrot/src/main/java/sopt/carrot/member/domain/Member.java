package sopt.carrot.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.carrot.common.BaseTimeEntity;
import sopt.carrot.location.domain.Location;
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

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Builder
    private Member(String name, String phoneNumber, Location location){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public static Member create(String name, String phoneNumber, Location location) {
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
