package sopt.carrot.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.location.domain.Location;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom {
    Optional<Location> findByName(String name);
}
