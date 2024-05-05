package sopt.carrot.location.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.carrot.common.success.SuccessMessage;
import sopt.carrot.common.success.SuccessStatusResponse;
import sopt.carrot.location.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/location/{locationName}")
    public ResponseEntity<SuccessStatusResponse> getProducts(
            @PathVariable String locationName
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessStatusResponse.of(SuccessMessage.PRODUCTS_READ_SUCCESS, locationService.getProductList(locationName)));
    }
}
