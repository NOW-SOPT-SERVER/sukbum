package sopt.carrot.location.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = 543811331L;

    public static final QLocation location = new QLocation("location");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<sopt.carrot.member.domain.Member, sopt.carrot.member.domain.QMember> memberList = this.<sopt.carrot.member.domain.Member, sopt.carrot.member.domain.QMember>createList("memberList", sopt.carrot.member.domain.Member.class, sopt.carrot.member.domain.QMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<sopt.carrot.product.domain.Product, sopt.carrot.product.domain.QProduct> productList = this.<sopt.carrot.product.domain.Product, sopt.carrot.product.domain.QProduct>createList("productList", sopt.carrot.product.domain.Product.class, sopt.carrot.product.domain.QProduct.class, PathInits.DIRECT2);

    public QLocation(String variable) {
        super(Location.class, forVariable(variable));
    }

    public QLocation(Path<? extends Location> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocation(PathMetadata metadata) {
        super(Location.class, metadata);
    }

}

