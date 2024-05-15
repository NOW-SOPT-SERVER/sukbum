package sopt.carrot.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    List<Product> productList = new ArrayList<>();

    @Builder
    private Member(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Member create(String name, String phoneNumber) {
        return Member.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}
