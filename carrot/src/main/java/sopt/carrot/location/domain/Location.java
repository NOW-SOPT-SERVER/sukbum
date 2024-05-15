package sopt.carrot.location.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.carrot.member.domain.Member;
import sopt.carrot.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "location")
    private List<Member> memberList = new ArrayList<>();
    @OneToMany(mappedBy = "location")
    private List<Product> productList = new ArrayList<>();

    @Builder
    private Location(String name){
        this.name = name;
    }
    public static Location create(String locationName) {
        return Location.builder()
                .name(locationName)
                .build();
    }

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
