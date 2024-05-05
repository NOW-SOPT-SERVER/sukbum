package sopt.carrot.location.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.location.domain.Location;
import sopt.carrot.location.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional
    public Location checkLocationExists(String locationName) {
        return locationRepository.findByName(locationName)
                .orElseGet(() -> createLocation(locationName));
    }

    private Location createLocation(String locationName) {
        return locationRepository.save(Location.create(locationName));
    }
}
