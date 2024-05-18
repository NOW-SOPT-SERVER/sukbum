package sopt.carrot.location.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import sopt.carrot.location.domain.Location;
import sopt.carrot.location.domain.QLocation;

import java.util.Optional;

public class LocationRepositoryImpl implements LocationRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public LocationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Optional<Location> findLocationByName(String name) {
        QLocation qLocation = QLocation.location;
        Location location = queryFactory.selectFrom(qLocation)
                .where(qLocation.name.eq(name))
                .fetchOne();
        return Optional.ofNullable(location);
    }
}
