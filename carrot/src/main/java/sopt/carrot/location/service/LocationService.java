package sopt.carrot.location.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.common.exception.ErrorMessage;
import sopt.carrot.common.exception.NotFoundException;
import sopt.carrot.location.domain.Location;
import sopt.carrot.location.repository.LocationRepository;
import sopt.carrot.product.dto.ProductListDto;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<ProductListDto> getProductList(String locationName){
        Location findLocation = locationRepository.findByName(locationName)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_LOCATION_EXCEPTION)
                );
        return findLocation.getProductList().stream()
                .map(product -> new ProductListDto(
                        product.getTitle(),
                        product.getPrice(),
                        product.getDescription(),
                        findLocation.getName(),
                        product.isSell(),
                        product.getTransactionMethod(),
                        product.getMember().getName()
                ))
                .collect(Collectors.toList());
    }
}
