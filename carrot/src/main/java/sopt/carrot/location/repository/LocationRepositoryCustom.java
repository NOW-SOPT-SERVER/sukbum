package sopt.carrot.location.repository;

import sopt.carrot.location.domain.Location;

import java.util.Optional;

public interface LocationRepositoryCustom {
    Optional<Location> findLocationByName(String name);
}
